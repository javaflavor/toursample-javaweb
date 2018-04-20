/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.TourUVO;


/**
 * RP_A01_01_01_03BLogicの入力値クラス。
 * 
 * 
 *
 */
public class RP_A01_01_01_03Input implements Serializable {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = -989091065626595412L;

    /**
     * ツアーコード
     */
    private String tourCode = null;
    
    /**
     * UVO
     */
    private TourUVO USER_VALUE_OBJECT = null;
    
    /**
     * 人数条件(大人)
     */
    private String adultCountCondition = null;
    
    /**
     * 人数条件(子ども)
     */
    private String childCountCondition = null;

    /**
     * ツアーコードを取得する
     * @return ツアーコード
     */
    public String getTourCode(){
        return tourCode;
    }
    
    /**
     * ツアーコードを設定する
     * @param tourCode
     */
    public void setTourCode (String tourCode) {
        this.tourCode = tourCode;
    }

    /**
     * 顧客情報を取得する
     * @return 顧客情報
     */
    public TourUVO getUSER_VALUE_OBJECT (){
        return USER_VALUE_OBJECT;
    }

    /**
     * 顧客情報を設定する
     * @param USER_VALUE_OBJECT
     */
    public void setUSER_VALUE_OBJECT (TourUVO USER_VALUE_OBJECT) {
        this.USER_VALUE_OBJECT = USER_VALUE_OBJECT;
    }

    /**
     * 大人料金の検索条件を取得する
     * @return 大人料金の検索条件
     */
    public String getAdultCountCondition(){
        return adultCountCondition;
    }
    
    /**
     * 大人料金の検索条件を設定する
     * @param adultCountCondition
     */
    public void setAdultCountCondition(String adultCountCondition){
        this.adultCountCondition = adultCountCondition;
    }

    /**
     * 子ども料金の条件を取得する
     * @return 子ども料金の検索条件
     */
    public String getChildCountCondition(){
        return childCountCondition;
    }
    
    /**
     * 子ども料金の検索条件を設定する
     * @param childCountCondition
     */
    public void setChildCountCondition(String childCountCondition){
        this.childCountCondition = childCountCondition;
    }
}
