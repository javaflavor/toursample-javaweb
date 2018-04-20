/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_02.blogic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.util.PropertyUtil;
import jp.terasoluna.toursample.common.Constants;
import jp.terasoluna.toursample.common.blogic.PriceCalculateBLogic;
import jp.terasoluna.toursample.common.blogic.ReserveDetailAcquireBLogic;
import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireInput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;
import jp.terasoluna.toursample.common.exception.RecordNotFoundException;
import jp.terasoluna.toursample.uc_a01_02.dto.RP_A01_02_01_02Input;
import jp.terasoluna.toursample.uc_a01_02.dto.RP_A01_02_01_02Output;

/**
 * ツアー予約詳細情報取得ビジネスロジック。
 * <p>
 * ・予約詳細情報を取得する(共通処理CP0006)。<br>
 * ・検索した予約情報がない場合、例外処理を行う。<br>
 * 例外クラス：RecordNotFoundException<BR>
 * ・料金を計算する(共通処理：CP0009)。
 * </p>
 * 
 * 
 * 
 */

public class RP_A01_02_01_02BLogicImpl implements BLogic<RP_A01_02_01_02Input> {

    /**
     * 共通処理実行時Nullが返却された場合のエラーメッセージ。
     */
    public static final String ERROR_NOT_RESERVED = "error.common.00008";

    /**
     * ログクラス。
     */
    private static final Log log = 
        LogFactory.getLog(RP_A01_02_01_02BLogicImpl.class);

    /**
     * 予約詳細情報取得クラス(共通処理CP0006)。 Springによりインスタンス生成され設定される。
     */
    protected ReserveDetailAcquireBLogic reserveDetailAcquireBLogic = null;

    /**
     * 料金計算クラス(共通処理CP0009)。 Springによりインスタンス生成され設定される。
     */
    protected PriceCalculateBLogic priceCalculateBLogic = null;

    /**
     * 料金計算クラスを返す。
     * 
     * @return 料金計算クラス
     */
    public PriceCalculateBLogic getPriceCalculateBLogic() {

        return priceCalculateBLogic;
    }

    /**
     * 料金計算クラスを設定する。
     * 
     * @param priceCalculateBLogic
     *            料金計算クラス
     */
    public void setPriceCalculateBLogic(
            PriceCalculateBLogic priceCalculateBLogic) {

        this.priceCalculateBLogic = priceCalculateBLogic;
    }

    /**
     * 予約詳細情報取得クラスを返す。
     * 
     * @return 予約詳細情報取得クラス
     */
    public ReserveDetailAcquireBLogic getReserveDetailAcquireBLogic() {

        return reserveDetailAcquireBLogic;
    }

    /**
     * 予約詳細情報取得クラスを設定する。
     * 
     * @param reserveDetailAcquireBLogic
     *            予約詳細情報取得クラス
     */
    public void setReserveDetailAcquireBLogic(
            ReserveDetailAcquireBLogic reserveDetailAcquireBLogic) {

        this.reserveDetailAcquireBLogic = reserveDetailAcquireBLogic;
    }

    /**
     * 予約詳細情報を取得する。 <BR>
     * 予約詳細情報の取得条件に一致する予約詳細情報を返却する。
     * 
     * @param param
     *            予約詳細情報取得条件
     * @return 予約詳細情報リスト
     * 
     * @exception
     * jp.terasoluna.toursample.common.exception.RecordNotFoundException
     * データベースから取得した結果がない場合に発生
     */
    public BLogicResult execute(RP_A01_02_01_02Input param) {

        // 実行結果を格納する。
        BLogicResult result = new BLogicResult();

        // 出力情報を格納するクラスを生成する。
        RP_A01_02_01_02Output rp_a01_02_01_02BLogicOutput = 
            new RP_A01_02_01_02Output();

        // 予約詳細情報取得処理の引数のクラスを生成する。
        ReserveDetailAcquireInput reserveDetailAcquireInput = 
            new ReserveDetailAcquireInput();

        // 予約詳細情報取得処理の引数を設定する。
        reserveDetailAcquireInput.setReserveNo(param.getReserveNo());
        reserveDetailAcquireInput.setCustomerCode(param.getUSER_VALUE_OBJECT()
            .getCustomerCode());

        // 予約詳細情報を取得する(共通処理CP0006)。
        ReserveDetailAcquireOutput reserveDetail = 
            reserveDetailAcquireBLogic.execute(reserveDetailAcquireInput);

        // 検索した予約情報がない場合、例外処理を行う。
        // 例外クラス：RecordNotFoundException
        if (reserveDetail == null) {

            if (log.isErrorEnabled()) {
                log.error(ERROR_NOT_RESERVED + ":予約情報が見つかりません。");
            }

            throw new RecordNotFoundException(ERROR_NOT_RESERVED);
        }

        // 料金を計算する(共通処理：CP0009)。
        PriceCalculateOutput price = priceCalculateBLogic.execute(reserveDetail
            .getBasePrice(), reserveDetail.getAdultCount(), reserveDetail
            .getChildCount());

        // ツアー予約詳細情報を出力値にセットする。
        rp_a01_02_01_02BLogicOutput.setReserveDetail(reserveDetail);
        rp_a01_02_01_02BLogicOutput.setPrice(price);
        rp_a01_02_01_02BLogicOutput.setPaymentMethod(PropertyUtil
            .getProperty(Constants.PAYMENT_METHOD));
        rp_a01_02_01_02BLogicOutput.setPaymentCompanyName(PropertyUtil
            .getProperty(Constants.PAYMENT_COMPANY_NAME));
        rp_a01_02_01_02BLogicOutput.setPaymentAccount(PropertyUtil
            .getProperty(Constants.PAYMENT_ACCOUNT));
        rp_a01_02_01_02BLogicOutput.setReferenceName(PropertyUtil
            .getProperty(Constants.COMPANY_NAME));
        rp_a01_02_01_02BLogicOutput.setReferenceEmail(PropertyUtil
            .getProperty(Constants.COMPANY_MAIL));
        rp_a01_02_01_02BLogicOutput.setReferenceTel(PropertyUtil
            .getProperty(Constants.COMPANY_TEL));

        // 結果をセットする。
        result.setResultObject(rp_a01_02_01_02BLogicOutput);
        result.setResultString("success");

        return result;
    }

}
