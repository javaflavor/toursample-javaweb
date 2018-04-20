/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a99_03.dto;

import java.io.Serializable;

/**
 * 顧客登録ビジネスロジックの出力情報保持クラス。<br>
 * 
 * ・UC_A99_03：顧客登録
 * 
 * 
 */
public class RP_A99_03_02_01Output implements Serializable {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = 3822549983670186061L;

    /**
     *新規顧客ID。
     */
    private String customerCode = null;

    
    /**
     * 新規顧客IDを返す。
     * @return 新規顧客ID
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * 新規顧客IDを設定する。
     * @param customerCode 新規顧客ID
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

}