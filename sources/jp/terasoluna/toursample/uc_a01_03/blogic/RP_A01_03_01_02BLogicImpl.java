/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_03.blogic;

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
import jp.terasoluna.toursample.uc_a01_03.dto.RP_A01_03_01_02Input;
import jp.terasoluna.toursample.uc_a01_03.dto.RP_A01_03_01_02Output;

/**
 * ツアー予約変更確認のBLogicクラス。<br>
 * 
 * ・UC_A01_03：ツアー予約変更
 * 
 * 
 */
public class RP_A01_03_01_02BLogicImpl implements BLogic<RP_A01_03_01_02Input> {

    /**
     * 共通処理実行時Nullが返却された場合のエラーメッセージ。
     */
    public static final String ERROR_NOT_RESERVED = "error.common.00008";

    /**
     * 予約詳細情報取得クラス(共通処理CP0006)。 Springによりインスタンス生成され設定される。
     */
    protected ReserveDetailAcquireBLogic reserveDetailAcquireBLogic = null;

    /**
     * 共通処理CP0006を設定する。
     * 
     * @param reserveDetailAcquireBLogic
     *            設定する共通処理CP0006
     */
    public void setReserveDetailAcquireBLogic(
            ReserveDetailAcquireBLogic reserveDetailAcquireBLogic) {

        this.reserveDetailAcquireBLogic = reserveDetailAcquireBLogic;
    }

    /**
     * ログクラス。
     */
    private static final Log log = 
        LogFactory.getLog(RP_A01_03_01_02BLogicImpl.class);
    
    /**
     * 料金計算クラス(共通処理CP0009)。 Springによりインスタンス生成され設定される。
     */
    protected PriceCalculateBLogic priceCalculateBLogic = null;

    /**
     * ツアー予約変更確認ビジネスロジック。<br>
     * ツアーとツアーに参加する人数から単価、合計料金を計算し、 予約内容を確認する。<br>
     * 
     * @param params
     *            料金計算用の情報
     * @return ツアー予約詳細情報
     */
    public BLogicResult execute(RP_A01_03_01_02Input params) {

        // 出力情報を格納するクラスを生成する。
        RP_A01_03_01_02Output result = new RP_A01_03_01_02Output();
        
        // 予約詳細情報取得処理の引数のクラスを生成する。
        ReserveDetailAcquireInput reserveDetailAcquireInput = 
            new ReserveDetailAcquireInput();

        // 予約詳細情報取得処理の引数を設定する。
        reserveDetailAcquireInput.setReserveNo(params.getReserveNo());
        reserveDetailAcquireInput.setCustomerCode(params.getUSER_VALUE_OBJECT()
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
        
        //ご意見ご要望と大人人数、子供人数を設定する
        reserveDetail.setAdultCount(params.getReserveDetail().getAdultCount());
        reserveDetail.setChildCount(params.getReserveDetail().getChildCount());
        reserveDetail.setRemarks(params.getReserveDetail().getRemarks());
        
        // 料金を計算する(共通処理：CP0009)。
        PriceCalculateOutput price = 
            priceCalculateBLogic.execute(reserveDetail.getBasePrice(), 
                                        reserveDetail.getAdultCount(), 
                                        reserveDetail.getChildCount());

        // ツアー予約確認情報を出力値にセットする。
        result.setReserveDetail(reserveDetail);
        result.setPrice(price);
        result.setPaymentMethod(PropertyUtil
            .getProperty(Constants.PAYMENT_METHOD));
        result.setPaymentCompanyName(PropertyUtil
            .getProperty(Constants.PAYMENT_COMPANY_NAME));
        result.setPaymentAccount(PropertyUtil
            .getProperty(Constants.PAYMENT_ACCOUNT));
        result.setReferenceName(PropertyUtil
            .getProperty(Constants.COMPANY_NAME));
        result.setReferenceEmail(PropertyUtil
            .getProperty(Constants.COMPANY_MAIL));
        result.setReferenceTel(PropertyUtil.getProperty(Constants.COMPANY_TEL));

        // 出力値を生成する。
        BLogicResult bResult = new BLogicResult();
        bResult.setResultObject(result);
        bResult.setResultString("success");

        return bResult;
    }

    /**
     * 料金計算クラス(共通処理CP0009)を設定する。
     * 
     * @param priceCalculateBLogic
     *            料金計算クラス(共通処理CP0009)
     */
    public void setPriceCalculateBLogic(
            PriceCalculateBLogic priceCalculateBLogic) {

        this.priceCalculateBLogic = priceCalculateBLogic;
    }

}