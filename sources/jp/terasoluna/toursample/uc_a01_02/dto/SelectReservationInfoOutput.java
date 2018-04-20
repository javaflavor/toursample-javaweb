/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_02.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * ツアー予約情報クラス。
 *
 * 
 */
public class SelectReservationInfoOutput implements Serializable {

    /**
     * serialVersionUID。
     */
    private static final long serialVersionUID = 1503502910183145807L;

    /**
     * 予約番号。
     */
    private String reserveNo = null;
    
    /**
     * ツアー名。
     */
    private String tourName = null;

    /**
     * 出発日。
     */
    private Date depDay = null;

    /**
     * 日数。
     */
    private String tourDays = null;

    /**
     * 日数(数字)。
     */
    private Integer intTourDays = null;
    
    /**
     * 出発地。
     */
    private String depName = null;

    /**
     * 目的地。
     */
    private String arrName = null;

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
     * 振込フラグ。
     */
    private boolean transfer = false;

    /**
     * 振込期限超過フラグ。
     */
    private boolean limitExcessFlag = false;

    
    /**
     * 人数(大人)を返す。
     * @return 人数(大人)
     */
    public Integer getAdultCount() {
    
        return adultCount;
    }

    
    /**
     * 人数(大人)を設定する。
     * @param adultCount 人数(大人)
     */
    public void setAdultCount(Integer adultCount) {
    
        this.adultCount = adultCount;
    }

    
    /**
     * 目的地を返す。
     * @return 目的地
     */
    public String getArrName() {
    
        return arrName;
    }

    
    /**
     * 目的地を設定する。
     * @param arrName 目的地
     */
    public void setArrName(String arrName) {
    
        this.arrName = arrName;
    }

    
    /**
     * 人数(子ども)を返す。
     * @return 人数(子ども)
     */
    public Integer getChildCount() {
    
        return childCount;
    }

    
    /**
     * 人数(子ども)を設定する。
     * @param childCount 人数(子ども)
     */
    public void setChildCount(Integer childCount) {
    
        this.childCount = childCount;
    }

    
    /**
     * 出発日を返す。
     * @return 出発日
     */
    public Date getDepDay() {
    
        return depDay;
    }

    
    /**
     * 出発日を設定する。
     * @param depDay 出発日
     */
    public void setDepDay(Date depDay) {
    
        this.depDay = depDay;
    }

    
    /**
     * 出発地を返す。
     * @return 出発地
     */
    public String getDepName() {
    
        return depName;
    }

    
    /**
     * 出発地を設定する。
     * @param depName 出発地
     */
    public void setDepName(String depName) {
    
        this.depName = depName;
    }

    
    /**
     * 日数(数字)を返す。
     * @return 日数(数字)
     */
    public Integer getIntTourDays() {
    
        return intTourDays;
    }

    
    /**
     * 日数(数字)を設定する。
     * @param intTourDays 日数(数字)
     */
    public void setIntTourDays(Integer intTourDays) {
    
        this.intTourDays = intTourDays;
    }

    
    /**
     * 振込期限超過フラグを返す。
     * @return 振込期限フラグ
     */
    public boolean isLimitExcessFlag() {
    
        return limitExcessFlag;
    }

    
    /**
     * 振込期限超過フラグを設定する。
     * @param limitExcessFlag 振込期限超過フラグ
     */
    public void setLimitExcessFlag(boolean limitExcessFlag) {
    
        this.limitExcessFlag = limitExcessFlag;
    }

    
    /**
     * 予約番号を返す。
     * @return 予約番号
     */
    public String getReserveNo() {
    
        return reserveNo;
    }

    
    /**
     * 予約番号を設定する。
     * @param reserveNo 予約番号
     */
    public void setReserveNo(String reserveNo) {
    
        this.reserveNo = reserveNo;
    }

    
    /**
     * 合計料金を返す。
     * @return 合計料金
     */
    public Integer getSumPrice() {
    
        return sumPrice;
    }

    
    /**
     * 合計料金を設定する。
     * @param sumPrice 合計料金
     */
    public void setSumPrice(Integer sumPrice) {
    
        this.sumPrice = sumPrice;
    }

    
    /**
     * 日数を返す。
     * @return 日数
     */
    public String getTourDays() {
    
        return tourDays;
    }

    
    /**
     * 日数を設定する。
     * @param tourDays 日数
     */
    public void setTourDays(String tourDays) {
    
        this.tourDays = tourDays;
    }

    
    /**
     * ツアー名を返す。
     * @return ツアー名
     */
    public String getTourName() {
    
        return tourName;
    }

    
    /**
     * ツアー名を設定する。
     * @param tourName ツアー名
     */
    public void setTourName(String tourName) {
    
        this.tourName = tourName;
    }

    
    /**
     * 振込フラグを返す。
     * @return 振込フラグ
     */
    public boolean isTransfer() {
    
        return transfer;
    }

    
    /**
     * 振込フラグを設定する。
     * @param transfer 振込フラグ
     */
    public void setTransfer(boolean transfer) {
    
        this.transfer = transfer;
    }
}
