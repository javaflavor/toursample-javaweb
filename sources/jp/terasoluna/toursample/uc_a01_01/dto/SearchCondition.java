/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;

/**
 * ツアー検索条件をセッションに保持するクラス。
 *
 * 
 */
public class SearchCondition implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4936333578640796651L;

    /**
     * ツアーコード。
     */
    private String tourCode = null;
    
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
    private Integer row = null;
    
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
     * 目的地条件を返す。
     * @return 目的地条件
     */
    public String getArrCodeCondition() {
    
        return arrCodeCondition;
    }

    
    /**
     * 目的地条件を設定する。
     * @param arrCodeCondition 目的地条件
     */
    public void setArrCodeCondition(String arrCodeCondition) {
    
        this.arrCodeCondition = arrCodeCondition;
    }

    
    /**
     * 基本料金条件を返す。
     * @return 基本料金条件
     */
    public String getBasePriceCondition() {
    
        return basePriceCondition;
    }

    
    /**
     * 基本料金条件を設定する。
     * @param basePriceCondition 基本料金条件
     */
    public void setBasePriceCondition(String basePriceCondition) {
    
        this.basePriceCondition = basePriceCondition;
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

    
    /**
     * 出発地条件を返す。
     * @return 出発地条件
     */
    public String getDepCodeCondition() {
    
        return depCodeCondition;
    }

    
    /**
     * 出発地条件を設定する。
     * @param depCodeCondition 出発地条件
     */
    public void setDepCodeCondition(String depCodeCondition) {
    
        this.depCodeCondition = depCodeCondition;
    }

    
    /**
     * 出発日(日)条件を返す。
     * @return 出発日(日)条件
     */
    public String getDepDayDayCondition() {
    
        return depDayDayCondition;
    }

    
    /**
     * 出発日(日)条件を設定する。
     * @param depDayDayCondition 出発日(日)条件
     */
    public void setDepDayDayCondition(String depDayDayCondition) {
    
        this.depDayDayCondition = depDayDayCondition;
    }

    
    /**
     * 出発日(月)条件を返す。
     * @return 出発日(月)条件
     */
    public String getDepDayMonthCondition() {
    
        return depDayMonthCondition;
    }

    
    /**
     * 出発日(月)条件を設定する。
     * @param depDayMonthCondition 出発日(月)条件
     */
    public void setDepDayMonthCondition(String depDayMonthCondition) {
    
        this.depDayMonthCondition = depDayMonthCondition;
    }

    
    /**
     * 出発日(年)条件を返す。
     * @return 出発日(年)条件
     */
    public String getDepDayYearCondition() {
    
        return depDayYearCondition;
    }

    
    /**
     * 出発日(年)条件を設定する。
     * @param depDayYearCondition 出発日(年)条件
     */
    public void setDepDayYearCondition(String depDayYearCondition) {
    
        this.depDayYearCondition = depDayYearCondition;
    }

    
    /**
     * ツアーコードを返す。
     * @return ツアーコード
     */
    public String getTourCode() {
    
        return tourCode;
    }

    
    /**
     * ツアーコードを設定する。
     * @param tourCode ツアーコード
     */
    public void setTourCode(String tourCode) {
    
        this.tourCode = tourCode;
    }

    
    /**
     * 日数条件を返す。
     * @return 日数条件
     */
    public String getTourDaysCondition() {
    
        return tourDaysCondition;
    }

    
    /**
     * 日数条件を設定する。
     * @param tourDaysCondition 日数条件
     */
    public void setTourDaysCondition(String tourDaysCondition) {
    
        this.tourDaysCondition = tourDaysCondition;
    }
    
    /**
     * 表示行数を返却する。
     * 
     * @return 保持する表示行数
     */
    public Integer getRow() {
    
        return row;
    }
    
    /**
     * 表示行数を設定する。
     * 
     * @param row 設定する表示行数
     */
    public void setRow(Integer row) {
    
        this.row = row;
    }
    
    /**
     * 開始インデックスを返却する。
     * 
     * @return 保持する開始インデックス
     */
    public Integer getStartIndex() {
    
        return startIndex;
    }
    
    /**
     * 開始インデックスを設定する。
     * 
     * @param startIndex 設定する開始インデックス
     */
    public void setStartIndex(Integer startIndex) {
    
        this.startIndex = startIndex;
    }
    
}
