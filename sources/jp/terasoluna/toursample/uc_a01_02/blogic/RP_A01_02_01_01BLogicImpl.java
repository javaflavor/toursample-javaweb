/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_02.blogic;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.toursample.common.TourUVO;
import jp.terasoluna.toursample.common.util.DateUtil;
import jp.terasoluna.toursample.uc_a01_02.dto.RP_A01_02_01_01Input;
import jp.terasoluna.toursample.uc_a01_02.dto.RP_A01_02_01_01Output;
import jp.terasoluna.toursample.uc_a01_02.dto.SelectReservationInfoInput;
import jp.terasoluna.toursample.uc_a01_02.dto.SelectReservationInfoOutput;

/**
 * ツアー予約情報リスト取得ビジネスロジック。
 * <p>
 * ・データベースから顧客の予約情報を以下の条件で取得する。<br>
 * 　条件：ツアーの出発日がシステム日付以降の予約<br>
 * ・各予約情報でシステム日付が振込期限より前かどうか判定する。<br>
 * また、数値形式のツアー日数を泊日形式に変換する。<br>
 * ・予約情報の予約件数を取得する。<br>
 * ・予約件数よりメッセージを設定する。
 * </p>
 * 
 * 
 * 
 */
public class RP_A01_02_01_01BLogicImpl implements BLogic<RP_A01_02_01_01Input> {

    /**
     * 予約数が0件の場合のメッセージ。
     */
    public static final String INFO_NOT_RESERVED = "info.UC_A01_02.00001";

    /**
     * ログクラス。
     */
    private static final Log log = LogFactory
        .getLog(RP_A01_02_01_01BLogicImpl.class);

    /**
     * 予約数が1件以上の場合のメッセージ。
     */
    public static final String INFO_RESERVED = "info.common.00001";

    /**
     * DAOクラス。<br>
     * Springによりインスタンス生成され設定される。
     */
    protected QueryDAO queryDAO = null;

    /**
     * QueryDAOを設定する。
     * 
     * @param queryDAO
     *            QueryDAO
     */
    public void setQueryDAO(QueryDAO queryDAO) {

        this.queryDAO = queryDAO;
    }

    /**
     * 予約情報リストを取得する。 <BR>
     * ログインしている顧客情報と一致する予約情報を<BR>
     * 予約情報リストとして返却する。
     * 
     * @param param
     *            顧客情報
     * @return 予約情報リスト
     */
    public BLogicResult execute(RP_A01_02_01_01Input param) {

        // 顧客番号を予約一覧情報取得処理の引数に設定する。
        SelectReservationInfoInput reservationInfoInput = 
            new SelectReservationInfoInput();
        TourUVO tourUVO = param.getUSER_VALUE_OBJECT();
        reservationInfoInput.setCustomerCode(tourUVO.getCustomerCode());

        // システム日付を予約一覧情報取得処理の引数に設定する。
        reservationInfoInput.setToday(DateUtil.getTodayDate());

        // データベースから顧客の予約情報を全て取得する。
        SelectReservationInfoOutput[] reservationInfo = 
            queryDAO.executeForObjectArray("UC_A01_02.selectReservationInfo", 
                                           reservationInfoInput, 
                                           SelectReservationInfoOutput.class);

        // 配列の振込期限と泊日を画面に表示用に変換する。
        for (int i = 0; i < reservationInfo.length; i++) {

            // 振込期限を取得する。
            Date paymentTimeLimit = DateUtil.getOneWeekBeforeDate(reservationInfo[i].getDepDay());
            // システム日付と振込期限を比較する
            // システム日付が振込期限より前はfalse、後はtrue
            // 振込期限とシステム日付がイコールの場合は、false
            Date today = DateUtil.getTodayDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(today);
            
            calendar.set(Calendar.HOUR_OF_DAY, 0); 
            calendar.clear(Calendar.MINUTE);
            calendar.clear(Calendar.SECOND);
            calendar.clear(Calendar.MILLISECOND);
            
            reservationInfo[i].setLimitExcessFlag(calendar.getTime().after(paymentTimeLimit));

            // 数値形式のツアー日数を泊日形式に変換する。
            reservationInfo[i].setTourDays(DateUtil
                .convertNightDays(reservationInfo[i].getIntTourDays()));
        }

        // 予約情報の配列長から予約件数を取得する。
        Integer reservationsCount = reservationInfo.length;

        // メッセージを設定する。
        BLogicMessages messages = new BLogicMessages();

        // 予約件数 0件 info.UC_A01_02.00001
        if (reservationsCount == 0) {
            messages.add(this.getClass().getName(),
                         new BLogicMessage(INFO_NOT_RESERVED));

            if (log.isDebugEnabled()) {
                log.debug("予約件数 0件");
            }

            // 予約件数 1件以上 info.common.00001 [0]= reservationsCount
        } else {
            messages.add(this.getClass().getName(),
                         new BLogicMessage(INFO_RESERVED, reservationsCount));

            if (log.isDebugEnabled()) {
                log.debug("予約件数 " + reservationsCount + "件");
            }
        }

        // ツアー予約詳細情報を出力値にセットする。
        RP_A01_02_01_01Output rp_a01_02_01_01BLogicOutput = 
            new RP_A01_02_01_01Output();
        rp_a01_02_01_01BLogicOutput.setReservationInfo(reservationInfo);
        rp_a01_02_01_01BLogicOutput.setReservationsCount(reservationsCount);

        // 結果をセットする。
        BLogicResult result = new BLogicResult();
        result.setResultObject(rp_a01_02_01_01BLogicOutput);
        result.setResultString("success");
        result.setMessages(messages);

        return result;
    }
}