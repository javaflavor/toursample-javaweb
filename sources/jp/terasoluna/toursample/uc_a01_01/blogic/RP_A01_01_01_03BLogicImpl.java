/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.blogic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.toursample.common.blogic.PriceCalculateBLogic;
import jp.terasoluna.toursample.common.blogic.TourDetailAcquireBLogic;
import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.TourDetailAcquireOutput;
import jp.terasoluna.toursample.common.exception.RecordNotFoundException;
import jp.terasoluna.toursample.uc_a01_01.dto.RP_A01_01_01_03Input;
import jp.terasoluna.toursample.uc_a01_01.dto.RP_A01_01_01_03Output;

/**
 * <p>
 * ツアー詳細情報取得ビジネスロジック。<br>
 * 共通機能を利用してツアー詳細情報等を取得し、ツアー詳細画面を表示するための処理を行う。
 * </p>
 * 
 * 
 * 
 */
public class RP_A01_01_01_03BLogicImpl
        implements BLogic<RP_A01_01_01_03Input> {

    /**
     * 共通処理実行時Nullが返却された場合のエラーメッセージ。
     */
    public static final String ERROR_NOT_TOURCODE = "error.UC_A01_01.00002";

    /**
     * ログクラス。
     */
    private static final Log log =
        LogFactory.getLog(RP_A01_01_01_03BLogicImpl.class);

    /**
     * 詳細情報取得ロジック(共通処理)
     */
    protected TourDetailAcquireBLogic tourDetailAcquireBLogic = null;

    /**
     * 詳細情報取得ロジックの初期化
     * 
     * @param tourDetailAcquireBLogic 詳細情報取得ロジック
     */
    public void setTourDetailAcquireBLogic(
            TourDetailAcquireBLogic tourDetailAcquireBLogic) {

        this.tourDetailAcquireBLogic = tourDetailAcquireBLogic;
    }

    /**
     * 料金算出ロジック (共通処理)
     */
    protected PriceCalculateBLogic priceCalculateBLogic = null;

    /**
     * 料金算出ロジックの初期化。
     * 
     * @param priceCalculateBLogic 料金算出ロジック
     */
    public void setPriceCalculateBLogic(
            PriceCalculateBLogic priceCalculateBLogic) {

        this.priceCalculateBLogic = priceCalculateBLogic;
    }

    /**
     * RP_A01_01_01_03 詳細情報取得処理
     * 
     * ツアー詳細情報の取得を行い、指定されたツアー詳細情報の取得に失敗した場合は例外処理を行う。<br>
     *
     * @exception RecordNotFoundException データベースから取得した結果がない場合に発生する例外クラス
     * @param input 検索条件
     * @return ビジネスロジックの実行結果、BLogicResultインスタンス
     *          ResultObject RP_A01_01_01_03Output ツアー詳細情報
     */
    public BLogicResult execute(RP_A01_01_01_03Input input) {

        // 返却値の準備
        BLogicResult result = new BLogicResult();
        RP_A01_01_01_03Output output = new RP_A01_01_01_03Output();
        BLogicMessages messages = new BLogicMessages();


        // ツアー詳細情報の取得
        TourDetailAcquireOutput tourDetail = tourDetailAcquireBLogic
            .execute(input.getTourCode());

        // ツアー詳細情報が取得できない場合、例外処理を行う。
        if (tourDetail == null) {
            if (log.isErrorEnabled()) {
                log.error(ERROR_NOT_TOURCODE
                          + ":ツアー詳細情報が取得できませんでした。");
            }
            throw new RecordNotFoundException(ERROR_NOT_TOURCODE);
        }

        // 料金の計算 共通処理を利用してツアー基本料金、人数より単価、料金などを取得する
        PriceCalculateOutput priceOutput = priceCalculateBLogic
            .execute(tourDetail.getBasePrice(), (Integer.parseInt(input.getAdultCountCondition())),
            		 Integer.parseInt(input.getChildCountCondition()));

        // 返却値の設定
        output.setTourDetail(tourDetail);
        output.setPriceOutput(priceOutput);

        // 代表者情報取得処理 代表者情報が存在しているか確認を行う
        if (input.getUSER_VALUE_OBJECT() == null) {

            messages.add(this.getClass().getName(),
                         new BLogicMessage("info.UC_A01_01.00002"));
            result.setMessages(messages);
        } else {
            messages.add(this.getClass().getName(),
                         new BLogicMessage("info.UC_A01_01.00001"));
            result.setMessages(messages);
        }
        
        // ご意見・ご要望を初期化
        output.setRemarks(null);

        result.setResultObject(output);
        result.setResultString("success");
        return result;
    }
}
