/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.toursample.common.dto.TourDetailAcquireOutput;
import jp.terasoluna.toursample.common.util.DateUtil;

/**
 * ツアー詳細取得ビジネスロジッククラス。<br>
 * ツアーコードを利用し、データベースからツアー詳細情報を取得する。<br>
 * データベースに数字で登録されている｢日数｣は泊日形式に変換して設定する。 <br>
 * <br>
 * ・共通処理CP0007：ツアー詳細取得
 * 
 * 
 */
public class TourDetailAcquireBLogicImpl implements TourDetailAcquireBLogic {

    /**
     * DAOクラス。<br>
     * Springによりインスタンス生成され設定される。
     */
    protected QueryDAO queryDAO = null;

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
     * ツアー詳細の取得を行なう。<br>
     * 予約詳細の取得が出来なかった場合はnullを返す。
     * 
     * @param tourCode
     *            ツアーコード
     * 
     * @return ツアー詳細
     */
    public TourDetailAcquireOutput execute(String tourCode) {

        // データベースから予約詳細情報を取得する。
        TourDetailAcquireOutput result = 
            queryDAO.executeForObject("common.selectTourDetail", tourCode,
                              TourDetailAcquireOutput.class);

        // 取得結果がない場合、nullを返す。
        if (result == null) {
            return null;
        }

        // 数値形式のツアー日数を泊日形式に変換する。
        String tourDays = DateUtil.convertNightDays(result.getIntTourDays());
        result.setTourDays(tourDays);

        return result;

    }

}
