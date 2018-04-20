/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_05.blogic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.terasoluna.toursample.common.blogic.PriceCalculateBLogic;
import jp.terasoluna.toursample.common.blogic.ReserveDetailAcquireBLogic;
import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireInput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;
import jp.terasoluna.toursample.common.exception.RecordNotFoundException;
import jp.terasoluna.toursample.common.util.DateUtil;
import jp.terasoluna.toursample.uc_a01_05.dto.RP_A01_05_01_01Input;
import jp.terasoluna.toursample.uc_a01_05.dto.RP_A01_05_01_01Output;

/**
 * 帳票出力情報取得ビジネスロジック。
 * <p>
 * ・予約詳細情報取得ビジネスロジック(共通処理：CP0006)を実行する。<br>
 * ・検索した予約情報がない場合、例外処理を行う。<br>
 * 例外クラス：RecordNotFoundException<br>
 * ・添乗員を文字列に変換する。<br>
 * ・支払期限を文字列に変換する。<br>
 * ・料金を計算するクラス(共通処理：CP0009)を実行する。<br>
 * ・印刷日を設定する。<br>
 * </p>
 * 
 * 
 */
public class RP_A01_05_01_01BLogicImpl implements RP_A01_05_01_01BLogic {

    /**
     * ログクラス。
     */
    private static final Log log = 
        LogFactory.getLog(RP_A01_05_01_01BLogicImpl.class);

    /**
     * 予約詳細情報取得クラス。(共通処理CP0006) Springによりインスタンス生成され設定される。
     */
    protected ReserveDetailAcquireBLogic reserveDetailAcquireBLogic = null;

    /**
     * 料金計算クラス。(共通処理CP0009) Springによりインスタンス生成され設定される。
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
     * 帳票出力情報を取得する。
     * <p>
     * ・予約番号を取得し、共通処理CP0006とCP0009を実行する。<br>
     * ・顧客情報を取得する。<br>
     * ・印刷日を取得する。<br>
     * ・取得した情報を出力値に設定する。
     * </P>
     * 
     * @param param
     *            帳票出力情報取得条件
     * @return 帳票出力情報リスト
     * 
     * @exception
     * jp.terasoluna.toursample.common.exception.RecordNotFoundException
     * データベースから取得した結果がない場合に発生
     */
    public List<RP_A01_05_01_01Output> selectReportData(
            RP_A01_05_01_01Input param) {

        // 予約詳細情報取得ビジネスロジックの出力値クラスを生成する。
        RP_A01_05_01_01Output blogicOutput = new RP_A01_05_01_01Output();

        // 予約詳細情報取得ビジネスロジックの入力値クラスを生成する。
        ReserveDetailAcquireInput reserveDetailAcquireInput = new ReserveDetailAcquireInput();

        // パラメータから予約番号、顧客オブジェクトを取り出す。
        // 予約詳細情報取得ビジネスロジックの入力値クラスに情報を設定する。
        reserveDetailAcquireInput.setReserveNo(param.getReserveNo());
        reserveDetailAcquireInput.setCustomerCode(param.getTourUVO()
            .getCustomerCode());

        // 予約詳細情報取得ビジネスロジック(共通処理：CP0006)を実行する。
        ReserveDetailAcquireOutput reserveDetailResult = reserveDetailAcquireBLogic
            .execute(reserveDetailAcquireInput);

        // 検索した予約情報がない場合、例外処理を行う。
        // 例外クラス：RecordNotFoundException
        if (reserveDetailResult == null) {

            if (log.isErrorEnabled()) {
                log.error("error.common.00008:予約情報が見つかりません。");
            }

            throw new RecordNotFoundException("error.common.00008");
        }

        // 添乗員を文字列に変換する。
        String conductor = null;
        if (reserveDetailResult.getConductor()) {
            conductor = "有";

        } else {
            conductor = "無";
        }
        
        // 支払期限を文字列（"yyyy年MM月dd日"or"支払済み"）に変換する。
        String paymentTimeLimit = null;
        if (reserveDetailResult.isTransfer()){
            paymentTimeLimit = "支払済み";
            
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            paymentTimeLimit = sdf.format(reserveDetailResult.
                                                 getPaymentTimeLimit());
        }

        // 予約情報を出力値に設定する。
        blogicOutput.setReserveNo(param.getReserveNo());
        blogicOutput.setTourName(reserveDetailResult.getTourName());
        blogicOutput.setReservedDay(reserveDetailResult.getReservedDay());
        blogicOutput.setDepDay(reserveDetailResult.getDepDay());
        blogicOutput.setTourDays(reserveDetailResult.getTourDays());
        blogicOutput.setDepName(reserveDetailResult.getDepName());
        blogicOutput.setArrName(reserveDetailResult.getArrName());
        blogicOutput.setConductor(conductor);
        blogicOutput.setAccomName(reserveDetailResult.getAccomName());
        blogicOutput.setAccomTel(reserveDetailResult.getAccomTel());
        blogicOutput.setTourAbs(reserveDetailResult.getTourAbs());
        blogicOutput.setAdultCount(reserveDetailResult.getAdultCount());
        blogicOutput.setChildCount(reserveDetailResult.getChildCount());
        blogicOutput.setRemarks(reserveDetailResult.getRemarks());
        blogicOutput.setPaymentTimeLimit(paymentTimeLimit);

        // 料金を計算するクラス(共通処理：CP0009)を実行する。
        PriceCalculateOutput priceCalcResult = priceCalculateBLogic
            .execute(reserveDetailResult.getBasePrice(), reserveDetailResult
                .getAdultCount(), reserveDetailResult.getChildCount());

        // 料金情報を出力値に設定する。
        blogicOutput.setAdultUnitPrice(priceCalcResult.getAdultUnitPrice());
        blogicOutput.setChildUnitPrice(priceCalcResult.getChildUnitPrice());
        blogicOutput.setAdultPrice(priceCalcResult.getAdultPrice());
        blogicOutput.setChildPrice(priceCalcResult.getChildPrice());
        blogicOutput.setSumPrice(priceCalcResult.getSumPrice());

        // 顧客情報を出力値に設定する。
        blogicOutput.setCustomerCode(param.getTourUVO().getCustomerCode());
        blogicOutput.setCustomerKana(param.getTourUVO().getCustomerKana());
        blogicOutput.setCustomerName(param.getTourUVO().getCustomerName());
        blogicOutput.setCustomerBirth(param.getTourUVO().getCustomerBirth());
        blogicOutput.setCustomerJob(param.getTourUVO().getCustomerJob());
        blogicOutput.setCustomerMail(param.getTourUVO().getCustomerMail());
        blogicOutput.setCustomerTel(param.getTourUVO().getCustomerTel());
        blogicOutput.setCustomerPost(param.getTourUVO().getCustomerPost());
        blogicOutput.setCustomerAdd(param.getTourUVO().getCustomerAdd());

        // 印刷日を出力値に設定する。
        Date printDay = DateUtil.getTodayDate();
        blogicOutput.setPrintDay(printDay);

        // 帳票出力情報リストを生成する。
        List<RP_A01_05_01_01Output> list = new ArrayList<RP_A01_05_01_01Output>();

        // リストに帳票出力を加える。
        list.add(blogicOutput);

        return list;
    }

}