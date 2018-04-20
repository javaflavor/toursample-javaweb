/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;

/**
 * RP_A01_01_02_03BLogicの入力値クラス。
 *
 * 
 */
public class RP_A01_01_02_03Input implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1934524108139283082L;
    
    /**
     * 検索条件。
     */
    private SearchCondition condition = null;
    
    /**
     * 検索条件を返す。
     * @return condition
     */
    public SearchCondition getCondition() {
    
        return condition;
    }
    
    /**
     * 検索条件を設定する。
     * @param condition 検索条件
     */
    public void setCondition(SearchCondition condition) {
    
        this.condition = condition;
    }
    
}
