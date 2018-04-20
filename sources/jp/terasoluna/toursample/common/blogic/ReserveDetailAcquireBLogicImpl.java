/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireInput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;
import jp.terasoluna.toursample.common.util.DateUtil;

/**
 * 予約詳細取得ビジネスロジッククラス。<br>
 * 予約番号を利用し、データベースから予約詳細情報を取得する。<br>
 * データベースから取得できない｢振込期限｣は出発日の一週間前の日付を設定する。 <br>
 * データベースに数字で登録されている｢ツアー日数｣は泊日形式に変換して設定する。 <br>
 * <br>
 * ・共通処理CP0006：予約詳細取得
 * 
 * 
 */
public class ReserveDetailAcquireBLogicImpl implements
        ReserveDetailAcquireBLogic {

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
     * 予約詳細の取得を行なう。<br>
     * 予約詳細の取得が出来なかった場合はnullを返す。
     * 
     * @param input
     *            検索条件(予約番号、顧客ID)
     * 
     * @return 予約詳細
     */
    public ReserveDetailAcquireOutput execute(ReserveDetailAcquireInput input) {

        // データベースから予約詳細情報を取得する。
        ReserveDetailAcquireOutput result = 
            queryDAO.executeForObject("common.selectReserveDetail", input,
                              ReserveDetailAcquireOutput.class);

        // 取得結果がない場合、nullを返す。
        if (result == null) {
            return null;
        }

        // 振込期限を算出し、予約詳細情報に設定する。
        result.setPaymentTimeLimit(DateUtil.getOneWeekBeforeDate(result
            .getDepDay()));

        // 数値形式のツアー日数を泊日形式に変換する。
        String tourDays = DateUtil.convertNightDays(result.getIntTourDays());
        result.setTourDays(tourDays);

        return result;

    }

}
