/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_04.blogic;

import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.toursample.common.TourUVO;
import jp.terasoluna.toursample.common.blogic.PriceCalculateBLogic;
import jp.terasoluna.toursample.common.blogic.ReserveDetailAcquireBLogic;
import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireInput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;
import jp.terasoluna.toursample.common.exception.RecordNotFoundException;
import jp.terasoluna.toursample.uc_a01_04.dto.RP_A01_04_01_01Input;
import jp.terasoluna.toursample.uc_a01_04.dto.RP_A01_04_01_01Output;
import jp.terasoluna.toursample.uc_a01_04.exception.CannotCancelException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 予約情報取得処理クラス。<br>
 * 
 * 
 */
public class RP_A01_04_01_01BLogicImpl implements BLogic<RP_A01_04_01_01Input> {

    /**
     * 料金算出クラス。
     */
    private PriceCalculateBLogic priceCalculateBLogic = null;

    /**
     * 予約情報取得クラス 。
     */
    private ReserveDetailAcquireBLogic reserveDetailAcquireBLogic = null;

    /**
     * 料金算出クラスを取得する。
     * 
     * @return priceCalculateBLogic
     */
    public PriceCalculateBLogic getPriceCalculateBLogic() {

        return this.priceCalculateBLogic;
    }

    /**
     * 料金算出クラスを設定する。
     * 
     * @param priceCalculateBLogic
     */
    public void setPriceCalculateBLogic(
            PriceCalculateBLogic priceCalculateBLogic) {

        this.priceCalculateBLogic = priceCalculateBLogic;
    }

    /**
     * 予約情報取得クラスを取得する。
     * 
     * @return reserveDetailAcquireBLogic
     */
    public ReserveDetailAcquireBLogic getReserveDetailAcquireBLogic() {

        return this.reserveDetailAcquireBLogic;
    }

    /**
     * 予約情報取得クラスを設定する。
     * 
     * @param reserveDetailAcquireBLogic
     */
    public void setReserveDetailAcquireBLogic(
            ReserveDetailAcquireBLogic reserveDetailAcquireBLogic) {

        this.reserveDetailAcquireBLogic = reserveDetailAcquireBLogic;
    }

    /**
     * ログクラス。
     */
    private static final Log log = 
        LogFactory.getLog(RP_A01_04_01_01BLogicImpl.class);

    /**
     * 予約情報、料金情報を共通処理より取得する。<br>
     * 取得した情報を出力値にセットする。<br>
     * 
     * @exception RecordNotFoundException
     *                検索した予約情報がない場合。
     * @exception CannotCancelException
     *                料金が振込済みの場合。
     * @param rp_a01_04_01_01Input
     * @return ビジネスロジックの実行結果、BLogicResultインスタンス。
     */
    public BLogicResult execute(RP_A01_04_01_01Input rp_a01_04_01_01Input) {

        // 実行結果を格納する。
        BLogicResult result = new BLogicResult();

        // 出力情報を格納するクラスを生成する。
        RP_A01_04_01_01Output rp_A01_04_01_01Output = new RP_A01_04_01_01Output();

        // 予約情報を検索する引数のクラスを生成する。
        ReserveDetailAcquireInput input = new ReserveDetailAcquireInput();

        // ReserveDetailAcquireInputに予約番号を格納する。
        input.setReserveNo(rp_a01_04_01_01Input.getReserveNo());

        // 顧客情報を格納する。
        TourUVO uvo = rp_a01_04_01_01Input.getUSER_VALUE_OBJECT();

        // ReserveDetailAcquireInputに顧客番号を格納する。
        input.setCustomerCode(uvo.getCustomerCode());

        // 共通処理より予約情報を取得する。
        ReserveDetailAcquireOutput reserveDetail = reserveDetailAcquireBLogic
                .execute(input);

        // 検索した予約情報がない場合、例外処理を行う。
        if (reserveDetail == null) {

            if (log.isErrorEnabled()) {
                log.error("error.common.00008:予約情報が見つかりません。");
            }

            throw new RecordNotFoundException("error.common.00008");
        }

        // ツアーの基本料金。
        int basePrice = reserveDetail.getBasePrice();

        // 大人の予約人数。
        int adultCount = reserveDetail.getAdultCount();

        // 子どもの予約人数。
        int childCount = reserveDetail.getChildCount();

        // 共通処理より料金情報を取得し、算出する。
        PriceCalculateOutput price = priceCalculateBLogic.execute(basePrice,
                adultCount, childCount);

        // 予約情報、料金情報を出力値にセットする。
        rp_A01_04_01_01Output.setReserveDetail(reserveDetail);
        rp_A01_04_01_01Output.setPrice(price);

        // 結果をセットする。
        result.setResultObject(rp_A01_04_01_01Output);
        result.setResultString("success");

        return result;
    }
}