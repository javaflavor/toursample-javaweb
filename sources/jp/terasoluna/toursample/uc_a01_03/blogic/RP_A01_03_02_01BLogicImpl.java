/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_03.blogic;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.toursample.common.exception.RecordNotFoundException;
import jp.terasoluna.toursample.common.util.DateUtil;
import jp.terasoluna.toursample.uc_a01_03.dto.RP_A01_03_02_01Input;
import jp.terasoluna.toursample.uc_a01_03.exception.CannotEditException;
import jp.terasoluna.toursample.uc_a01_03.exception.TourMemberOverException;

/**
 * ツアー予約変更確定のBLogicクラス。 <br>
 * ・UC_A01_03：ツアー予約変更
 * 
 * 
 * 
 */
public class RP_A01_03_02_01BLogicImpl implements BLogic<RP_A01_03_02_01Input> {

    /**
     * 共通処理実行時Nullが返却された場合のエラーメッセージ。
     */
    public static final String ERROR_NOT_RESERVED = "error.common.00008";

    /**
     * DAOクラス。<br>
     * Springによりインスタンス生成され設定される。
     */
    private QueryDAO queryDAO = null;

    /**
     * DAOクラス。<br>
     * Springによりインスタンス生成され設定される。
     */
    private UpdateDAO updateDAO = null;

    /**
     * 残席数が足りない場合のエラーメッセージ。
     */
    public static final String ERROR_NOT_ENOUGH_SEAT = "warn.UC_A01_03.00001";

    /**
     * ログクラス。
     */
    private static final Log log = LogFactory
            .getLog(RP_A01_03_02_01BLogicImpl.class);

    /**
     * QueryDAOを設定する。
     * 
     * @param queryDAO
     *            設定するQueryDAO
     */
    public void setQueryDAO(QueryDAO queryDAO) {

        this.queryDAO = queryDAO;
    }

    /**
     * UpdateDAOを設定する。
     * 
     * @param updateDAO
     *            設定するUpdateDAO
     */
    public void setUpdateDAO(UpdateDAO updateDAO) {

        this.updateDAO = updateDAO;
    }

    /**
     * ツアー予約変更ビジネスロジック。<br>
     * 残席数の確認し、ツアー予約を変更する
     * 
     * @param params
     *            ツアー予約変更情報保持用クラス
     * @exception TourMemberOverException
     *                残席数がない場合の例外
     */
    public BLogicResult execute(RP_A01_03_02_01Input params) {

        // ツアー予約の振込フラグを検索する。
        Boolean transfer = queryDAO.executeForObject(
                "UC_A01_03.selectTransfer", params, Boolean.class);

        // 検索した予約情報がない場合、例外処理を行う。
        // 例外クラス：RecordNotFoundException
        if (transfer == null) {

            if (log.isErrorEnabled()) {
                log.error(ERROR_NOT_RESERVED + ":予約情報が見つかりません。");
            }

            throw new RecordNotFoundException(ERROR_NOT_RESERVED);
        }

        // 検索した振込フラグが振込済みの場合例外処理を行う。
        if (transfer) {

            if (log.isWarnEnabled()) {
                log.warn("warn.UC_A01_03.00002:支払い済みのため予約を変更できない。");
            }

            throw new CannotEditException("warn.UC_A01_03.00002");
        }

        // 振込期限を取得する。
        Date paymentTimeLimit = DateUtil.getOneWeekBeforeDate(params
                .getReserveDetail().getDepDay());
        // システム日付と振込期限を比較し
        // 振込期限を過ぎていた場合、業務エラー画面へ遷移させる。
        Date today = DateUtil.getTodayDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);

        if (calendar.getTime().after(paymentTimeLimit)) {
            if (log.isWarnEnabled()) {
                log.warn("warn.UC_A01_03.00002:振込期限を過ぎているため予約を変更できない。");
            }           
            throw new CannotEditException("warn.UC_A01_03.00002");
        }

        // 業務入力クラスよりデータの取得
        String tourCode = params.getReserveDetail().getTourCode();
        String reserveNo = params.getReserveNo();
        Integer adultCount = params.getPrice().getAdultCount();
        Integer childCount = params.getPrice().getChildCount();
        Integer sumPrice = params.getPrice().getSumPrice();
        String remarks = params.getReserveDetail().getRemarks();

        // 最大催行人数を取得。
        SelectNumberOfPersonInput numberOfPerson = new SelectNumberOfPersonInput();
        numberOfPerson.setTourCode(tourCode);
        Integer avaRecMax = queryDAO.executeForObject(
                "UC_A01_03.selectAvaRecMaxForUpdate", numberOfPerson,
                Integer.class);

        // 変更したい予約以外の予約人数を取得
        numberOfPerson.setReserveNo(reserveNo);
        Integer totalReserveCount = queryDAO.executeForObject(
                "UC_A01_03.selectTotalReserveCount", numberOfPerson,
                Integer.class);

        // 変更したい予約以外の予約人数がない場合(null)0で初期化する
        if (totalReserveCount == null) {
            totalReserveCount = Integer.valueOf(0);
        }

        // 残席数をチェック
        // 『ツアー最大催行人数』<
        // 『予約人数』 + 入力値『人数（大人）』 + 入力値『人数（子ども）』
        if (avaRecMax.intValue() < (totalReserveCount.intValue()
                + adultCount.intValue() + childCount.intValue())) {

            if (log.isWarnEnabled()) {
                log.warn(ERROR_NOT_ENOUGH_SEAT + ":残席数が足りません。");
            }

            throw new TourMemberOverException(ERROR_NOT_ENOUGH_SEAT);
        }

        // 予約情報を更新する
        UpdateReserveInput reserveInput = new UpdateReserveInput();
        reserveInput.setReserveNo(reserveNo);
        reserveInput.setAdultCount(adultCount);
        reserveInput.setChildCount(childCount);
        reserveInput.setRemarks(remarks);
        reserveInput.setSumPrice(sumPrice);

        params.setSumPrice(params.getPrice().getSumPrice());
        updateDAO.execute("UC_A01_03.updateReserve", reserveInput);

        // 出力値を生成する。
        BLogicResult bResult = new BLogicResult();
        bResult.setResultString("success");

        return bResult;
    }

}
