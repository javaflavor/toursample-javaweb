/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a99_03.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.toursample.uc_a99_03.dto.RP_A99_03_02_01Input;
import jp.terasoluna.toursample.uc_a99_03.dto.RP_A99_03_02_01Output;

/**
 * <p>
 * 顧客登録のBLogicクラス。
 * </p>
 * <ul>
 * <li>UC_A99_03：顧客登録
 * </ul>
 * 
 * 
 */
public class RP_A99_03_02_01BLogicImpl 
    implements BLogic<RP_A99_03_02_01Input> {

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
     * 新規顧客情報を顧客テーブルに登録する。
     * <p>
     * 入力したユーザ情報を登録する 年、月、日を生年月日で一つにまとめる<br>
     * 顧客IDはDBのシーケンスで自動生成する。
     * </p>
     * 
     * @param params
     *            入力値
     * @return 新規顧客ID
     */
    public BLogicResult execute(RP_A99_03_02_01Input params) {

        // 入力値から年、月、日を取得する。
        String customerBirthYear = params.getCustomerBirthYear();
        String customerBirthMonth = params.getCustomerBirthMonth();
        String customerBirthDay = params.getCustomerBirthDay();

        // 年、月、日を生年月日にセットする。
        params.setCustomerBirth(customerBirthYear + "/" + 
                                customerBirthMonth + 
                                "/" + customerBirthDay);

        // 新規顧客IDを自動生成する。
        RP_A99_03_02_01Output result = 
            queryDAO.executeForObject("UC_A99_03.selectCustomerCode", 
                                      null,
                                      RP_A99_03_02_01Output.class);
        params.setCustomerCode(result.getCustomerCode());

        // 新規顧客を登録する。
        updateDAO.execute("UC_A99_03.insertCustomer", params);

        // 出力値を生成する。
        BLogicResult bResult = new BLogicResult();
        bResult.setResultObject(result);
        bResult.setResultString("success");

        return bResult;
    }

    /**
     * queryDAOを設定する。
     * 
     * @param queryDAO
     *            クエリーDAO
     */
    public void setQueryDAO(QueryDAO queryDAO) {

        this.queryDAO = queryDAO;
    }

    /**
     * updateDAOを設定する。
     * 
     * @param updateDAO
     *            アップデートDAO
     */
    public void setUpdateDAO(UpdateDAO updateDAO) {

        this.updateDAO = updateDAO;
    }

}