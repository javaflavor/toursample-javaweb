/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.blogic;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.util.PropertyUtil;
import jp.terasoluna.toursample.common.Constants;
import jp.terasoluna.toursample.common.blogic.PriceCalculateBLogic;
import jp.terasoluna.toursample.common.blogic.TourDetailAcquireBLogic;
import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.TourDetailAcquireOutput;
import jp.terasoluna.toursample.common.exception.RecordNotFoundException;
import jp.terasoluna.toursample.common.util.DateUtil;
import jp.terasoluna.toursample.uc_a01_01.dto.InsertReserveInput;
import jp.terasoluna.toursample.uc_a01_01.dto.RP_A01_01_03_01Input;
import jp.terasoluna.toursample.uc_a01_01.dto.RP_A01_01_03_01Output;
import jp.terasoluna.toursample.uc_a01_01.exception.ReservationDeadlinePassedException;
import jp.terasoluna.toursample.uc_a01_01.exception.TourMemberOverException;

/**
 * 
 * ツアー予約の登録を行うクラス。
 * 
 * 
 * 
 * 
 */
public class RP_A01_01_03_01BLogicImpl implements BLogic<RP_A01_01_03_01Input> {

    /**
     * 共通処理実行時Nullが返却された場合のエラーメッセージ。
     */
    public static final String ERROR_NOT_TOURCODE = "error.UC_A01_01.00002";
	
    /**
     * 残席数が足りない場合のエラーメッセージ。
     */
    public static final String ERROR_NOT_ENOUGH_SEAT = "warn.UC_A01_01.00001";

    /**
     * ログクラス。
     */
    private static final Log log = 
        LogFactory.getLog(RP_A01_01_03_01BLogicImpl.class);

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
     * DAOクラス。<br>
     * Springによりインスタンス生成され設定される。 queryDAO 。
     */
    private QueryDAO queryDAO = null;

    /**
     * DAOクラス。<br>
     * Springによりインスタンス生成され設定される。 updateDAO 。
     */
    private UpdateDAO updateDAO = null;

    /**
     * queryDAOを取得する。
     * 
     * @return queryDAO
     */
    public QueryDAO getQueryDAO() {

        return queryDAO;
    }

    /**
     * queryDAOを設定する。
     * 
     * @param queryDAO
     */
    public void setQueryDAO(QueryDAO queryDAO) {

        this.queryDAO = queryDAO;
    }

    /**
     * updateDAOを取得する。
     * 
     * @return updateDAO
     */
    public UpdateDAO getUpdateDAO() {

        return updateDAO;
    }

    /**
     * updateDAOを設定する。
     * 
     * @param updateDAO
     */
    public void setUpdateDAO(UpdateDAO updateDAO) {

        this.updateDAO = updateDAO;
    }

    /**
     * 残席数の確認をし、足りなければ例外処理を行う。<br>
     * ツアーの予約を行う。<br>
     * 
     * @exception TourMemberOverException
     * @param rp_a01_01_03_01Input
     * @return ビジネスロジックの実行結果、BLogicResultインスタンス。
     */
    public BLogicResult execute(RP_A01_01_03_01Input rp_a01_01_03_01Input) {

        //入力値を取得する
    	int adultCount = rp_a01_01_03_01Input.getPriceOutput().getAdultCount();
    	int childCount = rp_a01_01_03_01Input.getPriceOutput().getChildCount();
    	
    	// 結果を格納する。
        BLogicResult result = new BLogicResult();

        // ツアー詳細情報の取得
        TourDetailAcquireOutput tourDetail = tourDetailAcquireBLogic
            .execute(rp_a01_01_03_01Input.getTourCode());

        // ツアー詳細情報が取得できない場合、例外処理を行う。       
        if (tourDetail == null) {
            if (log.isErrorEnabled()) {
                log.error(ERROR_NOT_TOURCODE
                          + ":ツアー詳細情報が取得できませんでした。");
            }
            throw new RecordNotFoundException(ERROR_NOT_TOURCODE);
        }
        
        //現在の日付を取得する。
        Date today = DateUtil.getTodayDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        
        calendar.set(Calendar.HOUR_OF_DAY, 0); 
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        
        //出発日を取得する。
        Date depDay = tourDetail.getDepDay();
        
        //出発日が現在の日付から7日以内の場合はエラー画面へ遷移する
        if(calendar.getTime().after(DateUtil.getChangedByDaysDate(depDay, -7))){
            if (log.isWarnEnabled()) {
                log.warn("warn.UC_A01_01.00002:出発日が現在の日付から7日以上ではありません。");
            }
            throw new ReservationDeadlinePassedException("warn.UC_A01_01.00002");
        }
        
        // 料金の計算 共通処理を利用してツアー基本料金、人数より単価、料金などを取得する
        PriceCalculateOutput priceOutput = priceCalculateBLogic
            .execute(tourDetail.getBasePrice(), adultCount, childCount);
        
        // 予約人数。
        int reserveMember = 0;

        // 予約人数を設定する。
        reserveMember = adultCount + childCount;

        // ツアーの最大催行人数を取得する。
        Integer aveRecMax = queryDAO.executeForObject(
                "UC_A01_01.selectAveRecMaxForUpdate", rp_a01_01_03_01Input,
                Integer.class);

        // ツアーの最大催行人数がnullの場合。
        if (aveRecMax == null) {

            if (log.isErrorEnabled()) {
                log.error("error.UC_A01_01.00002:ツアー最大催行人数が取得できません。");
            }

            throw new RecordNotFoundException(ERROR_NOT_TOURCODE);
        }

        // 現在の予約人数の合計数を取得する。
        Integer sumCount = 
            queryDAO.executeForObject("UC_A01_01.selectSumCount", 
                                      rp_a01_01_03_01Input, 
                                      Integer.class);

        // ツアーに予約がない時。
        if (sumCount == null) {

            sumCount = 0;

        }

        // 現在の予約可能人数。
        int vacantCount = aveRecMax - sumCount;

        // 予約可能人数より予約人数が多いとき例外処理を行う。
        if (vacantCount < reserveMember) {

            if (log.isWarnEnabled()) {
                log.warn(ERROR_NOT_ENOUGH_SEAT + ":残席数が足りません。");
            }

            throw new TourMemberOverException(ERROR_NOT_ENOUGH_SEAT);

        }

        // 予約日を取得する。
        Date reservedDay = DateUtil.getTodayDate();

        // 予約番号を取得する。
        String reserveNo = 
            queryDAO.executeForObject("UC_A01_01.selectReserveNo", 
                                      rp_a01_01_03_01Input, 
                                      String.class);

        // 予約をするためのクラスの生成。
        InsertReserveInput input = new InsertReserveInput();

        // 挿入項目をセットする。
        input.setReserveNo(reserveNo);
        input.setReservedDay(reservedDay);
        input.setUSER_VALUE_OBJECT(rp_a01_01_03_01Input.getUSER_VALUE_OBJECT());
        input.setAdultCount(adultCount);
        input.setChildCount(childCount);
        input.setRemarks(rp_a01_01_03_01Input.getRemarks());
        input.setTourCode(rp_a01_01_03_01Input.getTourCode());
        input.setSumPrice(priceOutput.getSumPrice());

        // 予約を行う。
        updateDAO.execute("UC_A01_01.insertReserve", input);

        // 出力クラスを生成する。
        RP_A01_01_03_01Output rp_a01_01_03_01Output = new RP_A01_01_03_01Output();

        // 支払期限を算出する。
        Date paymentTimeLimit = DateUtil
                .getOneWeekBeforeDate(depDay);

        // 出力値の設定。
        rp_a01_01_03_01Output.setTourDetail(tourDetail);
        rp_a01_01_03_01Output.setPriceOutput(priceOutput);
        rp_a01_01_03_01Output.setReserveNo(reserveNo);
        rp_a01_01_03_01Output.setReservedDay(reservedDay);
        rp_a01_01_03_01Output.setPaymentMethod(PropertyUtil
                .getProperty(Constants.PAYMENT_METHOD));
        rp_a01_01_03_01Output.setPaymentAccount(PropertyUtil
                .getProperty(Constants.PAYMENT_ACCOUNT));
        rp_a01_01_03_01Output.setPaymentCompanyName(PropertyUtil
                .getProperty(Constants.PAYMENT_COMPANY_NAME));
        rp_a01_01_03_01Output.setReferenceName(PropertyUtil
                .getProperty(Constants.COMPANY_NAME));
        rp_a01_01_03_01Output.setReferenceTel(PropertyUtil
                .getProperty(Constants.COMPANY_TEL));
        rp_a01_01_03_01Output.setReferenceEmail(PropertyUtil
                .getProperty(Constants.COMPANY_MAIL));
        rp_a01_01_03_01Output.setPaymentTimeLimit(paymentTimeLimit);

        // 結果をセットする。
        result.setResultObject(rp_a01_01_03_01Output);
        result.setResultString("success");

        return result;
    }

}
