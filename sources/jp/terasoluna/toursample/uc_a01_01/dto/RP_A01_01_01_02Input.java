/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;

/**
 * RP_A01_01_01_02BLogicの入力値クラス。
 *
 * 
 */
public class RP_A01_01_01_02Input implements Serializable {

    /**
     * シリアルバージョンUID。
     */
	private static final long serialVersionUID = 430989495912837712L;

	/**
     * 目的地条件。
     */
    private String arrCodeCondition = null;
    
    /**
     * 出発地条件。
     */
    private String depCodeCondition = null;

    /**
     * 出発日(年)条件。
     */
    private String depDayYearCondition = null;

    /**
     * 出発日(月)条件。
     */
    private String depDayMonthCondition = null;
    
    /**
     * 出発日(日)条件。
     */
    private String depDayDayCondition = null;
    
    /**
     * 日数条件。
     */
    private String tourDaysCondition = null;

    /**
     * 人数(大人)条件。
     */
    private String adultCountCondition = null;

    /**
     * 人数(子ども)条件。
     */
    private String childCountCondition = null;

    /**
     * 基本料金条件。
     */
    private String basePriceCondition = null;

    /**
     * 開始インデックス。
    */
    private Integer startIndex = null;
    
    /**
     * 表示行数。
     */
    private Integer row = 10;
    
    /**
     * 開始インデックスを取得する。
     * @return startIndex
     */
    public Integer getStartIndex() {
        return startIndex;
    }

    /**
     * 開始インデックスを設定する。
     * @param startIndex 
    */
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

	/**
     * 人数(大人)条件を取得する。
     * @return adultCountCondition
     */
    public String getAdultCountCondition() {
        return adultCountCondition;
    }

    /**
     * 人数(大人)条件を設定する。
     * @param adultCountCondition
     */
    public void setAdultCountCondition(String adultCountCondition) {
        this.adultCountCondition = adultCountCondition;
    }

    /**
     * 目的地条件を取得する。
     * @return arrCodeCondition
     */
    public String getArrCodeCondition() {
        return arrCodeCondition;
    }

    /**
     * 目的地条件を設定する。
     * @param arrCodeCondition
     */
    public void setArrCodeCondition(String arrCodeCondition) {
        this.arrCodeCondition = arrCodeCondition;
    }

    /**
     * 基本料金条件を取得する。
     * @return basePriceCondition
     */
    public String getBasePriceCondition() {
        return basePriceCondition;
    }

    /**
     * 基本料金条件を設定する。
     * @param basePriceCondition
     */
    public void setBasePriceCondition(String basePriceCondition) {
        this.basePriceCondition = basePriceCondition;
    }

    /**
     * 人数(子ども)条件を取得する。
     * @return childCountCondition
     */
    public String getChildCountCondition() {
        return childCountCondition;
    }

    /**
     * 人数(子ども)条件を設定する。
     * @param childCountCondition
     */
    public void setChildCountCondition(String childCountCondition) {
        this.childCountCondition = childCountCondition;
    }

    /**
     * 出発地条件を取得する。
     * @return depCodeCondition
     */
    public String getDepCodeCondition() {
        return depCodeCondition;
    }

    /**
     * 出発地条件を設定する。
     * @param depCodeCondition
     */
    public void setDepCodeCondition(String depCodeCondition) {
        this.depCodeCondition = depCodeCondition;
    }

    /**
     * 出発日(日)条件を取得する。
     * @return depDayDayCondition
     */
    public String getDepDayDayCondition() {
        return depDayDayCondition;
    }

    /**
     * 出発日(日)条件を設定する。
     * @param depDayDayCondition
     */
    public void setDepDayDayCondition(String depDayDayCondition) {
        this.depDayDayCondition = depDayDayCondition;
    }

    /**
     * 出発日(月)条件を取得する。
     * @return depDayMonthCondition
     */
    public String getDepDayMonthCondition() {
        return depDayMonthCondition;
    }

    /**
     * 出発日(月)条件を設定する。
     * @param depDayMonthCondition
     */
    public void setDepDayMonthCondition(String depDayMonthCondition) {
        this.depDayMonthCondition = depDayMonthCondition;
    }

    /**
     * 出発日(年)条件を取得する。
     * @return depDayYearCondition
     */
    public String getDepDayYearCondition() {
        return depDayYearCondition;
    }

    /**
     * 出発日(年)条件を設定する。
     * @param depDayYearCondition
     */
    public void setDepDayYearCondition(String depDayYearCondition) {
        this.depDayYearCondition = depDayYearCondition;
    }

    /**
     * 日数条件を取得する。
     * @return tourDaysCondition
     */
    public String getTourDaysCondition() {
        return tourDaysCondition;
    }

    /**
     * 日数条件を設定する。
     * @param tourDaysCondition
     */
    public void setTourDaysCondition(String tourDaysCondition) {
        this.tourDaysCondition = tourDaysCondition;
    }

    /**
     * 表示行数を取得する。
     * @return row
    */
    public Integer getRow() {
        return row;
    }

    /**
     * 表示行数を設定する。
     * @param row 設定する row
    */
    public void setRow(Integer row) {
        this.row = row;
    }

}