/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;

/**
 * ツアー検索処理用入力値クラス
 * 
 * 
 * 
 *
 */
public class SelectTourInfoInput implements Serializable{

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -8095447526890897928L;

	/**
	 * 目的地条件。
	 */
	private String arrCodeCondition = null;
	
	/**
	 * 出発地条件。
	 */
	private String depCodeCondition = null;
	
	/**
	 * 出発日。
	 */
	private String depDayCondition = null;
	
	/**
	 * 日数。
	 */
	private Integer tourDays = null;
    
    /**
     * 人数(大人)条件。
     */
    private String adultCountCondition = null;
    
    /**
     * 人数(子ども)条件。
     */
    private String childCountCondition = null; 
	
	/**
	 * 基本料金。
	 */
	private Integer basePrice = null;

	/**
	 * 目的地条件を取得する。
	 * 
	 * @return arrCodeCondition
	 */
	public String getArrCodeCondition() {
		return arrCodeCondition;
	}

	/**
	 * 目的地条件を設定する。
	 * 
	 * @param arrCodeCondition 目的地条件
	 */
	public void setArrCodeCondition(String arrCodeCondition) {
		this.arrCodeCondition = arrCodeCondition;
	}

	/**
	 * 基本料金条件を取得する。
	 * 
	 * @return basePrice
	 */
	public Integer getBasePrice() {
		return basePrice;
	}

	/**
	 * 基本料金条件を設定する。
	 * 
	 * @param basePrice 基本料金条件
	 */
	public void setBasePrice(Integer basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * 日数条件を取得する。
	 * 
	 * @return tourDays
	 */
	public Integer getTourDays() {
		return tourDays;
	}

	/**
	 * 日数条件を設定する。
	 * 
	 * @param tourDays 日数条件
	 */
	public void setTourDays(Integer tourDays) {
		this.tourDays = tourDays;
	}

	/**
	 * 出発地条件を取得する。
	 * 
	 * @return depCodeCondition
	 */
	public String getDepCodeCondition() {
		return depCodeCondition;
	}

	/**
	 * 出発地条件を設定する。
	 * 
	 * @param depCodeCondition 出発地条件
	 */
	public void setDepCodeCondition(String depCodeCondition) {
		this.depCodeCondition = depCodeCondition;
	}

	/**
	 * 出発日を取得する。 
	 * @return depDayCondition
	 */
	public String getDepDayCondition() {
		return depDayCondition;
	}

	/**
	 * 出発日を設定する。
	 * @param depDayCondition 出発日
	 */
	public void setDepDayCondition(String depDayCondition) {
		this.depDayCondition = depDayCondition;
	}

    /**
     * 人数(大人)条件を返す。
     * @return 人数(大人)条件
     */
    public String getAdultCountCondition() {
    
        return adultCountCondition;
    }

    /**
     * 人数(大人)条件を設定する。
     * @param adultCountCondition 人数(大人)条件
     */
    public void setAdultCountCondition(String adultCountCondition) {
    
        this.adultCountCondition = adultCountCondition;
    }

    /**
     * 人数(子ども)条件を返す。
     * @return 人数(子ども)条件
     */
    public String getChildCountCondition() {
    
        return childCountCondition;
    }

    /**
     * 人数(子ども)条件を設定する。
     * @param childCountCondition 人数(子ども)条件
     */
    public void setChildCountCondition(String childCountCondition) {
    
        this.childCountCondition = childCountCondition;
    }

}
