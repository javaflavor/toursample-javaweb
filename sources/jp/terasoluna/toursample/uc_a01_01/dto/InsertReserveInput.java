/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;
import java.util.Date;

import jp.terasoluna.toursample.common.TourUVO;

/**
 * 予約をするための入力クラス。
 * 
 * 
 * 
 */
public class InsertReserveInput implements Serializable {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -814234513258971804L;

    /**
     * 予約番号。
     */
    private String reserveNo = null;

    /**
     * 申し込み日。
     */
    private Date reservedDay = null;

    /**
     * 顧客情報。
     */
    private TourUVO USER_VALUE_OBJECT = null;

    /**
     * ツアーコード。
     */
    private String tourCode = null;

    /**
     * 人数(大人)。
     */
    private Integer adultCount = null;

    /**
     * 人数(子ども)。
     */
    private Integer childCount = null;

    /**
     * 合計料金。
     */
    private Integer sumPrice = null;

    /**
     * ご意見ご要望。
     */
    private String remarks = null;

    /**
     * @return 人数(大人)。
     */
    public Integer getAdultCount() {
        return adultCount;
    }

    /**
     * 人数(大人)を設定する。
     * 
     * @param adultCount
     */
    public void setAdultCount(Integer adultCount) {
        this.adultCount = adultCount;
    }

    /**
     * 人数(大人)を取得する。
     * 
     * @return childCount
     */
    public Integer getChildCount() {
        return childCount;
    }

    /**
     * 人数(子ども)を設定する。
     * 
     * @param childCount
     */
    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
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
     * ご意見ご要望設定する。
     * 
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 合計料金を取得する。
     * 
     * @return sumPrice
     */
    public Integer getSumPrice() {
        return sumPrice;
    }

    /**
     * 合計料金を設定する。
     * 
     * @param sumPrice
     */
    public void setSumPrice(Integer sumPrice) {
        this.sumPrice = sumPrice;
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
     * ツアーコード設定する。
     * 
     * @param tourCode
     */
    public void setTourCode(String tourCode) {
        this.tourCode = tourCode;
    }

    /**
     * 予約番号を取得する。
     * 
     * @return reverseNo
     */
    public String getReserveNo() {
        return reserveNo;
    }

    /**
     * 予約番号を設定する。
     * 
     * @param reserveNo
     */
    public void setReserveNo(String reserveNo) {
        this.reserveNo = reserveNo;
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
     * @param USER_VALUE_OBJECT
     */
    public void setUSER_VALUE_OBJECT(TourUVO USER_VALUE_OBJECT) {
        this.USER_VALUE_OBJECT = USER_VALUE_OBJECT;
    }

    /**
     * 申し込み日を取得する。
     * 
     * @return reservedDay
     */
    public Date getReservedDay() {
        return reservedDay;
    }

    /**
     * 申し込み日を設定する。
     * 
     * @param reservedDay
     */
    public void setReservedDay(Date reservedDay) {
        this.reservedDay = reservedDay;
    }

}
