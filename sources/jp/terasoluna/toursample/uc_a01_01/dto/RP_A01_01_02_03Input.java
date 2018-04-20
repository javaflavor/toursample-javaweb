/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;

/**
 * RP_A01_01_02_03BLogicΜόΝlNXB
 *
 * 
 */
public class RP_A01_01_02_03Input implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1934524108139283082L;
    
    /**
     * υπB
     */
    private SearchCondition condition = null;
    
    /**
     * υππΤ·B
     * @return condition
     */
    public SearchCondition getCondition() {
    
        return condition;
    }
    
    /**
     * υππέθ·ιB
     * @param condition υπ
     */
    public void setCondition(SearchCondition condition) {
    
        this.condition = condition;
    }
    
}
