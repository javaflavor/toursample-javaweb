/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_03.blogic;

import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.toursample.common.blogic.ReserveDetailAcquireBLogic;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireInput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;
import jp.terasoluna.toursample.common.exception.RecordNotFoundException;
import jp.terasoluna.toursample.uc_a01_03.dto.RP_A01_03_01_01Input;
import jp.terasoluna.toursample.uc_a01_03.dto.RP_A01_03_01_01Output;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ツアー予約変更情報取得のBLogicクラス。<br>
 * 
 * ・UC_A01_03：ツアー予約変更
 * 
 * 
 */
public class RP_A01_03_01_01BLogicImpl implements BLogic<RP_A01_03_01_01Input> {

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
        LogFactory.getLog(RP_A01_03_01_01BLogicImpl.class);

    /**
     * ツアー予約詳細情報取得ビジネスロジック。<br>
     * 予約詳細情報取得クラス(共通処理CP0006)で予約情報を取得
     * 
     * @param params
     *            ：予約番号、顧客番号
     * @return ツアー予約詳細情報
     * @exception RecordNotFoundException
     *                予約情報がない場合の例外
     */
    public BLogicResult execute(RP_A01_03_01_01Input params) {

        // 出力情報を格納するクラスを生成する。
        RP_A01_03_01_01Output result = new RP_A01_03_01_01Output();

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
        
        // ツアー予約詳細情報を出力値にセットする。
        result.setReserveDetail(reserveDetail);

        // 出力値を生成する。
        BLogicResult bResult = new BLogicResult();
        bResult.setResultObject(result);
        bResult.setResultString("success");

        return bResult;

    }

}