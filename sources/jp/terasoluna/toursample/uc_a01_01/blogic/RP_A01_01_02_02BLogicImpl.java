/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.blogic;

import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.toursample.uc_a01_01.dto.RP_A01_01_02_02Input;
import jp.terasoluna.toursample.uc_a01_01.dto.RP_A01_01_02_02Output;
import jp.terasoluna.toursample.uc_a01_01.dto.SearchCondition;


/**
 * ツアー予約登録条件格納ビジネスロジック。
 * <p>
 * </p>
 * 
 * 
 * 
 */
public class RP_A01_01_02_02BLogicImpl implements BLogic<RP_A01_01_02_02Input> {

    /**
     * 検索条件をセッションに格納するオブジェクトに <BR>
     * 設定する。
     * 
     * @param param
     *            検索条件
     * @return 条件格納オブジェクト
     */
    public BLogicResult execute(RP_A01_01_02_02Input param) {

        // 検索条件をセッションに入れる型にセットする。
        SearchCondition condition = new SearchCondition();
        condition.setAdultCountCondition(param.getAdultCountCondition());
        condition.setArrCodeCondition(param.getArrCodeCondition());
        condition.setBasePriceCondition(param.getBasePriceCondition());
        condition.setChildCountCondition(param.getChildCountCondition());
        condition.setDepCodeCondition(param.getDepCodeCondition());
        condition.setDepDayDayCondition(param.getDepDayDayCondition());
        condition.setDepDayMonthCondition(param.getDepDayMonthCondition());
        condition.setDepDayYearCondition(param.getDepDayYearCondition());
        condition.setTourCode(param.getTourCode());
        condition.setTourDaysCondition(param.getTourDaysCondition());
        condition.setStartIndex(param.getStartIndex());
        condition.setRow(param.getRow());

        // 検索条件を出力値のセットをする。
        RP_A01_01_02_02Output output = new RP_A01_01_02_02Output();
        
        output.setCondition(condition);

        // 返却値に設定する。
        BLogicResult result = new BLogicResult();
        result.setResultString("success");
        result.setResultObject(output);
        return result;
    }

}
