/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_04.blogic;

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
import jp.terasoluna.toursample.uc_a01_04.dto.RP_A01_04_01_02Input;
import jp.terasoluna.toursample.uc_a01_04.exception.CannotCancelException;

/**
 * 予約キャンセル処理クラス。
 * 
 * 
 */
public class RP_A01_04_01_02BLogicImpl implements BLogic<RP_A01_04_01_02Input> {

    /**
     * 共通処理実行時Nullが返却された場合のエラーメッセージ。
     */
    public static final String ERROR_NOT_RESERVED = "error.common.00008";

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
     * queryDAO を取得する。
     * 
     * @return queryDAO
     */
    public QueryDAO getQueryDAO() {

        return this.queryDAO;
    }

    /**
     * queryDAO を設定する。
     * 
     * @param queryDAO
     *            queryDAO
     */
    public void setQueryDAO(QueryDAO queryDAO) {

        this.queryDAO = queryDAO;
    }

    /**
     * updateDAO を取得する。
     * 
     * @return updateDAO
     */
    public UpdateDAO getUpdateDAO() {

        return this.updateDAO;
    }

    /**
     * updateDAO を設定する。
     * 
     * @param updateDAO
     *            updateDAO
     */
    public void setUpdateDAO(UpdateDAO updateDAO) {

        this.updateDAO = updateDAO;
    }

    /**
     * ログクラス。
     */
    private static final Log log = LogFactory
            .getLog(RP_A01_04_01_02BLogicImpl.class);

    /**
     * 振込済みのチェックをして予約のキャンセルを行う。<br>
     * 
     * @exception NotTransferException
     *                検索した結果がない場合。
     * @exception CannotCancelException
     *                支払い済みの場合。
     * @param rp_a01_04_01_02Input
     * @return ビジネスロジックの実行結果、BLogicResultインスタンス。
     */
    public BLogicResult execute(RP_A01_04_01_02Input rp_a01_04_01_02Input) {

        // 結果を格納する。
        BLogicResult result = new BLogicResult();

        // ツアー予約の振込フラグを検索する。
        Boolean transfer = queryDAO
                .executeForObject("UC_A01_04.selectTransfer",
                        rp_a01_04_01_02Input, Boolean.class);

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
                log.warn("warn.UC_A01_04.00001:支払い済みのため予約をキャンセルできない。");
            }

            throw new CannotCancelException("warn.UC_A01_04.00001");
        }

        // 振込期限を取得する。
        Date paymentTimeLimit = DateUtil.getOneWeekBeforeDate(rp_a01_04_01_02Input.
                getReserveDetail().getDepDay());

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
                log.warn("warn.UC_A01_04.00001:振込期限を過ぎているため予約をキャンセルできない。");
            }
            throw new CannotCancelException("warn.UC_A01_04.00001");
        }

        // 予約をキャンセルする。
        updateDAO.execute("UC_A01_04.deleteReserve", rp_a01_04_01_02Input);

        // 結果をセットする。
        result.setResultString("success");
        return result;
    }

}