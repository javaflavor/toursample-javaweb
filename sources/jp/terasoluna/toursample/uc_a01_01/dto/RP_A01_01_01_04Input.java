/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;

/**
 * 
 * ページ遷移するときの入力値クラス。
 * 
 *
 */
public class RP_A01_01_01_04Input implements Serializable {

	/**
	 * シリアルバージョンUID。
	 */
	private static final long serialVersionUID = 8878398219213889139L;
	
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
	private String depDay = null;
	
	/**
	 * 日数条件。
	 */
	private String tourDaysCondition = null;
	
	/**
	 * 基本料金条件。
	 */
	private String basePriceCondition = null;
	
	/**
	 * 一覧情報全行数。
	 */
	private Integer allListInfoLineCount = null;
	
	/**
	 * 開始インデックス。
	 */
    private Integer startIndex = null;
    
    /**
     * ツアー日数
     */
    private String tourDays = null;

	/**
	 * @return tourDays
	 */
	public String getTourDays() {
		return tourDays;
	}

	/**
	 * @param tourDays 設定する tourDays
	 */
	public void setTourDays(String tourDays) {
		this.tourDays = tourDays;
	}

	/**
	 * 一覧情報全行数を取得する。
	 * 
	 * @return allListInfoLineCount
	 */
	public Integer getAllListInfoLineCount() {
		return allListInfoLineCount;
	}

	/**
	 * 一覧情報全行数を設定する。
	 * 
	 * @param allListInfoLineCount
	 */
	public void setAllListInfoLineCount(Integer allListInfoLineCount) {
		this.allListInfoLineCount = allListInfoLineCount;
	}

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
	 * @param arrCodeCondition
	 */
	public void setArrCodeCondition(String arrCodeCondition) {
		this.arrCodeCondition = arrCodeCondition;
	}

	/**
	 * 基本料金条件を取得する。
	 * 
	 * @return basePriceCondition
	 */
	public String getBasePriceCondition() {
		return basePriceCondition;
	}

	/**
	 * 基本料金条件を設定する。
	 * 
	 * @param basePriceCondition
	 */
	public void setBasePriceCondition(String basePriceCondition) {
		this.basePriceCondition = basePriceCondition;
	}

	/**
	 * 日数条件を取得する。
	 * 
	 * @return dayCondition
	 */
	public String getTourDaysCondition() {
		return tourDaysCondition;
	}

	/**
	 * 日数条件を設定する。
	 * 
	 * @param tourDaysCondition
	 */
	public void setTourDaysCondition(String tourDaysCondition) {
		this.tourDaysCondition = tourDaysCondition;
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
	 * @param depCodeCondition
	 */
	public void setDepCodeCondition(String depCodeCondition) {
		this.depCodeCondition = depCodeCondition;
	}

	/**
	 * 出発日を取得する。
	 * 
	 * @return depDay
	 */
	public String getDepDay() {
		return depDay;
	}

	/**
	 * 出発日を設定する。
	 * 
	 * @param depDay
	 */
	public void setDepDay(String depDay) {
		this.depDay = depDay;
	}

	/**
	 * 開始インデックスを取得する。
	 * 
	 * @return startIndex
	 */
	public Integer getStartIndex() {
		return startIndex;
	}

	/**
	 * 開始インデックスを設定する。
	 * 
	 * @param startIndex
	 */
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

}
