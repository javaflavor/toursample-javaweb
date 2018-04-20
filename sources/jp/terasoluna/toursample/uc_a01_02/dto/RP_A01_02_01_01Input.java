/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_02.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.TourUVO;

/**
 * RP_A01_02_01_01BLogicの入力値クラス。
 *
 * 
 */
public class RP_A01_02_01_01Input implements Serializable {

    /**
     * serialVersionUID。
     */
    private static final long serialVersionUID = 6503390942302165024L;
    
    /**
     * 顧客情報。
     */
    private TourUVO USER_VALUE_OBJECT = null;

    
    /**
     * 顧客情報を返す。
     * @return 顧客情報
     */
    public TourUVO getUSER_VALUE_OBJECT() {
    
        return USER_VALUE_OBJECT;
    }

    
    /**
     * 顧客情報を設定する。
     * @param user_value_object 顧客情報
     */
    public void setUSER_VALUE_OBJECT(TourUVO user_value_object) {
    
        USER_VALUE_OBJECT = user_value_object;
    }

}
