/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a99_01.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.toursample.common.TourUVO;
import jp.terasoluna.toursample.common.dto.SelectUserInfoInput;

/**
 * ログイン処理を行うビジネスロジッククラス。<br>
 * <br>
 * ・ユースケースUC_A99_01：顧客ログイン<br>
 * <br>
 * 入力された顧客IDとパスワードを利用しログイン処理を行う。<br>
 * ログイン可能の場合はUVO(顧客情報)を生成し返す。<br>
 * ログイン不可能の場合はnullを返す。
 * 
 * @see jp.terasoluna.toursample.common.TourUVO
 * 
 */
public class RP_A99_01_02_02BLogicImpl implements RP_A99_01_02_02BLogic {

    /**
     * DAOクラス。 Springによりインスタンス生成され設定される。
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
     * ログイン処理を行う。<br>
     * ログイン処理の結果としてUVOインスタンスを返す。
     * 
     * @param customerCode
     *            入力された顧客ID
     * @param customerPass
     *            入力されたパスワード
     * 
     * @return 顧客情報
     */
    public TourUVO executeLogin(String customerCode, String customerPass) {

        // 顧客IDとパスワードを利用し、データベースから顧客情報を取得する。
    	SelectUserInfoInput userInfo = new SelectUserInfoInput();
    	userInfo.setCustomerCode(customerCode);
    	userInfo.setCustomerPass(customerPass);
        TourUVO output = queryDAO
            .executeForObject("common.selectUserInfo", userInfo,
                              TourUVO.class);

        // 顧客情報(UVO)を返す。
        // 顧客IDに対応する顧客情報が存在しない場合、nullを返す。
        return output;
    }
}
