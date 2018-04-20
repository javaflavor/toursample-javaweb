/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * ツアー検索情報保持クラス。<br>
 * 
 * 
 * 
 * 
 */
public class TourInfo implements Serializable {

	/**
	 * シリアルバージョンUID。
	 */
	private static final long serialVersionUID = 1211045869426150198L;
	
	/**
	 * ツアーコード。
	 */
	private String tourCode = null;

	/**
	 * ツアー名称。
	 */
	private String tourName = null;

	/**
	 * ツアー出発日。
	 */
	private Date   depDay = null;

	/**
	 * ツアー日数。
	 */
	private String tourDays = null;

	/**
	 * ツアー日数(int)。
	 */
	private Integer tourIntDays = null;	

	/**
	 * 基本料金。
	 */
	private Integer basePrice = null;

	/**
	 * 出発地名称。
	 */	
	private String depName = null;

	/**
	 * 目的地名称。
	 */	
	private String arrName = null;

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
	 * ツアー名称を取得する。
	 * 
	 * @return tourName
	 */
	public String getTourName() {
		return tourName;
	}
	
	/**
	 * ツアー名称を設定する。
	 * 
	 * @param tourName 設定する
	 */
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	/**
	 * ツアー出発日を取得する。
	 * 
	 * @return depDay
	 */
	public Date getDepDay() {
		return depDay;
	}

	/**
	 * ツアー出発日を設定する。
	 * 
	 * @param depDay
	 */
	public void setDepDay(Date depDay) {
		this.depDay = depDay;
	}

	/**
	 * ツアー日数を取得する。
	 * 
	 * @return tourDays
	 */
	public String getTourDays() {
		return tourDays;
	}

	/**
	 * ツアー日数を設定する。
	 * 
	 * @param tourDays
	 */
	public void setTourDays(String tourDays) {
		this.tourDays = tourDays;
	}

	/**
	 * ツアー日数(int)を取得する。
	 * 
	 * @return tourIntDays
	 */
	public Integer getTourIntDays() {
		return tourIntDays;
	}

	/**
	 * ツアー日数(int)を設定する。
	 * 
	 * @param tourIntDays 設定する
	 */
	public void setTourIntDays(Integer tourIntDays) {
		this.tourIntDays = tourIntDays;
	}

	/**
	 * 基本料金を取得する。
	 * 
	 * @return basePrice
	 */
	public Integer getBasePrice() {
		return basePrice;
	}

	/**
	 * 基本料金を設定する。
	 * 
	 * @param basePrice
	 */
	public void setBasePrice(Integer basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * 出発地名称を取得する。
	 * 
	 * @return depName
	 */
	public String getDepName() {
		return depName;
	}

	/**
	 * 出発地名称を設定する。
	 * 
	 * @param depName
	 */
	public void setDepName(String depName) {
		this.depName = depName;
	}

	/**
	 * 目的地名称を取得する。
	 * 
	 * @return arrName
	 */
	public String getArrName() {
		return arrName;
	}
	
	/**
	 * 目的地名称を設定する。
	 * 
	 * @param arrName
	 */
	public void setArrName(String arrName) {
		this.arrName = arrName;
	}
		
}