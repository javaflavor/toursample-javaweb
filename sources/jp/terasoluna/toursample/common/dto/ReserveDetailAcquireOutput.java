/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 予約詳細情報を格納するクラス。
 * <br>
 * ・共通処理CP0006：予約詳細取得
 * 
 * 
 */
public class ReserveDetailAcquireOutput implements Serializable {
    
    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = 3418316001953789728L;
    
    /**
     * 申し込み日。
     */
    private Date reservedDay = null;

    /**
     * ツアーコード。
     */
    private String tourCode = null;
    
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
     * 添乗員オプション。
     */
    private boolean conductor = false;

    /**
     * 宿泊施設。
     */
    private String accomName = null;

    /**
     * 連絡先。
     */
    private String accomTel = null;

    /**
     * 概要。
     */
    private String tourAbs = null;

    /**
     * ご意見ご要望。
     */
    private String remarks = null;

    /**
     * 基本料金。
     */
    private Integer basePrice = null;

    /**
     * 人数(大人)。
     */
    private Integer adultCount = null;

    /**
     * 人数(子ども)。
     */
    private Integer childCount = null;

    /**
     * 振込フラグ。
     */
    private boolean transfer = false;

    /**
     * 振込期限。
     */
    private Date paymentTimeLimit = null;

    /**
     * 宿泊施設を返す。
     * @return 宿泊施設
     */
    public String getAccomName() {
        return accomName;
    }

    /**
     * 宿泊施設を設定する。
     * @param accomName 宿泊施設
     */
    public void setAccomName(String accomName) {
        this.accomName = accomName;
    }

    /**
     * 連絡先を返す。
     * @return 連絡先
     */
    public String getAccomTel() {
        return accomTel;
    }

    /**
     * 連絡先を設定する。
     * @param accomTel 連絡先
     */
    public void setAccomTel(String accomTel) {
        this.accomTel = accomTel;
    }

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
     * 基本料金を返す。
     * @return 基本料金
     */
    public Integer getBasePrice() {
        return basePrice;
    }

    /**
     * 基本料金を設定する。
     * @param basePrice 基本料金
     */
    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
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
     * 添乗員オプションを返す。
     * @return 添乗員オプション
     */
    public boolean getConductor() {
        return conductor;
    }

    /**
     * 添乗員オプションを設定する。
     * @param conductor 添乗員オプション
     */
    public void setConductor(boolean conductor) {
        this.conductor = conductor;
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
     * ご意見ご要望を返す。
     * @return ご意見ご要望
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * ご意見ご要望を設定する。
     * @param remarks ご意見ご要望
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 申し込み日を返す。
     * @return 申し込み日
     */
    public Date getReservedDay() {
        return reservedDay;
    }

    /**
     * 申し込み日を設定する。
     * @param reservedDay 申し込み日
     */
    public void setReservedDay(Date reservedDay) {
        this.reservedDay = reservedDay;
    }

    /**
     * 概要を返す。
     * @return 概要
     */
    public String getTourAbs() {
        return tourAbs;
    }

    /**
     * 概要を設定する。
     * @param tourAbs 概要
     */
    public void setTourAbs(String tourAbs) {
        this.tourAbs = tourAbs;
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

    
    /**
     * 振込期限を返す。
     * @return 振込期限
     */
    
    public Date getPaymentTimeLimit() {
    
        return paymentTimeLimit;
    }

    
    /**
     * 振込期限を設定する。
     * @param paymentTimeLimit 振込期限
     */
    
    public void setPaymentTimeLimit(Date paymentTimeLimit) {
    
        this.paymentTimeLimit = paymentTimeLimit;
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

}
