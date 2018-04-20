/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.TourUVO;
import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;

/**
 * 
 * 予約を登録するための入力値クラス。
 * 
 * 
 * 
 */
public class RP_A01_01_03_01Input implements Serializable {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -4929041083540875979L;

    /**
     * ツアーコード。
     */
    private String tourCode = null;

    /**
     * 顧客情報。
     */
    private TourUVO USER_VALUE_OBJECT = null;

    /**
     * ご意見ご要望。
     */
    private String remarks = null;

    /**
     * ツアー基本料金、人数より単価、料金など
     */     
    private PriceCalculateOutput priceOutput = null;
        
    /**
     * ツアー基本料金、人数より単価、料金などを取得する
     * 
     * @return priceOutput
     */
    public PriceCalculateOutput getPriceOutput() {
		return priceOutput;
	}    
    
	/**
	 * ツアー基本料金、人数より単価、料金などを設定する
	 * 
	 * @param priceOutput
	 */
	public void setPriceOutput(PriceCalculateOutput priceOutput) {
		this.priceOutput = priceOutput;
	}

    /**
     * ご意見ご要望を取得する。
     * 
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * ご意見ご要望を設定する。
     * 
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * ツアーコードを取得する。
     * 
     * @return tourCode
     */
    public String getTourCode() {
        return tourCode;
    }

    /**
     * ツアーコードを設定する。
     * 
     * @param tourCode
     */
    public void setTourCode(String tourCode) {
        this.tourCode = tourCode;
    }

    /**
     * 顧客情報を取得する。
     * 
     * @return USER_VALUE_OBJECT
     */
    public TourUVO getUSER_VALUE_OBJECT() {
        return USER_VALUE_OBJECT;
    }

    /**
     * 顧客情報を設定する。
     * 
     * @param user_value_object
     */
    public void setUSER_VALUE_OBJECT(TourUVO user_value_object) {
        USER_VALUE_OBJECT = user_value_object;
    }

}
