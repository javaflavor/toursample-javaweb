/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_05.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * RP_A01_05_01_01BLogicの出力値クラス。
 *
 * 
 */
public class RP_A01_05_01_01Output implements Serializable {

    /**
     * serialVersionUID。
     */
    private static final long serialVersionUID = 8484195082751620345L;

    /**
     * 予約番号。
     */
    private String reserveNo = null;

    /**
     * 作成日。
     */
    private Date printDay = null;
    
    /**
     * ツアー名。
     */
    private String tourName = null;
    
    /**
     * 申し込み日。
     */
    private Date reservedDay = null;
    
    /**
     * 出発日。
     */
    private Date depDay = null;
    
    /**
     * 日数。
     */
    private String tourDays = null;
    
    /**
     * 出発地。
     */
    private String depName = null;
    
    /**
     * 目的地。
     */
    private String arrName = null;
    
    /**
     * 添乗員。
     */
    private String conductor = null;
    
    /**
     * 宿泊施設。
     */
    private String accomName = null;
    
    /**
     * 宿泊施設連絡先。
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
     * 顧客番号。
     */
    private String customerCode = null;
    
    /**
     * 顧客フリガナ。
     */
    private String customerKana = null;
    
    /**
     * 顧客名。
     */
    private String customerName = null;
    
    /**
     * 顧客誕生日。
     */
    private Date customerBirth = null;
    
    /**
     * 顧客職業。
     */
    private String customerJob = null;
    
    /**
     * 顧客メール。
     */
    private String customerMail = null;
    
    /**
     * 顧客電話番号。
     */
    private String customerTel = null;
    
    /**
     * 顧客郵便番号。
     */
    private String customerPost = null;
    
    /**
     * 顧客住所。
     */
    private String customerAdd = null;
    
    /**
     * 人数（大人）。
     */
    private Integer adultCount = null;
    
    /**
     * 人数（子ども）。
     */
    private Integer childCount = null;
    
    /**
     * 単価（大人）。
     */
    private Integer adultUnitPrice = null;
    
    /**
     * 単価（子ども）。
     */
    private Integer childUnitPrice = null;

    /**
     * 料金（大人）。
     */
    private Integer adultPrice = null;
    
    /**
     * 料金（子ども）。
     */
    private Integer childPrice = null;
    
    /**
     * 合計料金。
     */
    private Integer sumPrice = null;
    
    /**    
     * 支払期限。
     */
    private String paymentTimeLimit = null;

    
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
     * 宿泊施設連絡先を返す。
     * @return 宿泊施設連絡先
     */
    public String getAccomTel() {
    
        return accomTel;
    }

    
    /**
     * 宿泊施設連絡先を設定する。
     * @param accomTel 宿泊施設連絡先
     */
    public void setAccomTel(String accomTel) {
    
        this.accomTel = accomTel;
    }

    
    /**
     * 人数（大人）を返す。
     * @return 人数（大人）
     */
    public Integer getAdultCount() {
    
        return adultCount;
    }

    
    /**
     * 人数（大人）を設定する。
     * @param adultCount 人数（大人）
     */
    public void setAdultCount(Integer adultCount) {
    
        this.adultCount = adultCount;
    }

    
    /**
     * 料金（大人）を返す。
     * @return 料金（大人）
     */
    public Integer getAdultPrice() {
    
        return adultPrice;
    }

    
    /**
     * 料金（大人）を設定する。
     * @param adultPrice 料金（大人）
     */
    public void setAdultPrice(Integer adultPrice) {
    
        this.adultPrice = adultPrice;
    }

    
    /**
     * 単価（大人）を返す。
     * @return 単価（大人）
     */
    public Integer getAdultUnitPrice() {
    
        return adultUnitPrice;
    }

    
    /**
     * 単価（大人）を設定する。
     * @param adultUnitPrice 単価（大人）
     */
    public void setAdultUnitPrice(Integer adultUnitPrice) {
    
        this.adultUnitPrice = adultUnitPrice;
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
     * 人数（子ども）を返す。
     * @return 人数（子ども）
     */
    public Integer getChildCount() {
    
        return childCount;
    }

    
    /**
     * 人数（子ども）を設定する。
     * @param childCount 人数（子ども）
     */
    public void setChildCount(Integer childCount) {
    
        this.childCount = childCount;
    }

    
    /**
     * 料金（子ども）を返す。
     * @return 料金（子ども）
     */
    public Integer getChildPrice() {
    
        return childPrice;
    }

    
    /**
     * 料金（子ども）を設定する。
     * @param childPrice 料金（子ども）
     */
    public void setChildPrice(Integer childPrice) {
    
        this.childPrice = childPrice;
    }

    
    /**
     * 単価（子ども）を返す。
     * @return 単価（子ども）
     */
    public Integer getChildUnitPrice() {
    
        return childUnitPrice;
    }

    
    /**
     * 単価（子ども）を設定する。
     * @param childUnitPrice 単価（子ども）
     */
    public void setChildUnitPrice(Integer childUnitPrice) {
    
        this.childUnitPrice = childUnitPrice;
    }

    
    /**
     * 添乗員を返す。
     * @return 添乗員
     */
    public String getConductor() {
    
        return conductor;
    }

    
    /**
     * 添乗員を設定する。
     * @param conductor 添乗員
     */
    public void setConductor(String conductor) {
    
        this.conductor = conductor;
    }

    
    /**
     * 顧客住所を返す。
     * @return 顧客住所
     */
    public String getCustomerAdd() {
    
        return customerAdd;
    }

    
    /**
     * 顧客住所を設定する。
     * @param customerAdd 顧客住所
     */
    public void setCustomerAdd(String customerAdd) {
    
        this.customerAdd = customerAdd;
    }

    
    /**
     * 顧客誕生日を返す。
     * @return 顧客誕生日
     */
    public Date getCustomerBirth() {
    
        return customerBirth;
    }

    
    /**
     * 顧客誕生日を設定する。
     * @param customerBirth 顧客誕生日
     */
    public void setCustomerBirth(Date customerBirth) {
    
        this.customerBirth = customerBirth;
    }

    
    /**
     * 顧客番号を返す。
     * @return 顧客番号
     */
    public String getCustomerCode() {
    
        return customerCode;
    }

    
    /**
     * 顧客番号を設定する。
     * @param customerCode 顧客番号
     */
    public void setCustomerCode(String customerCode) {
    
        this.customerCode = customerCode;
    }

    
    /**
     * 顧客職業を返す。
     * @return 顧客職業
     */
    public String getCustomerJob() {
    
        return customerJob;
    }

    
    /**
     * 顧客職業を設定する。
     * @param customerJob 顧客職業
     */
    public void setCustomerJob(String customerJob) {
    
        this.customerJob = customerJob;
    }

    
    /**
     * 顧客フリガナを返す。
     * @return 顧客フリガナ
     */
    public String getCustomerKana() {
    
        return customerKana;
    }

    
    /**
     * 顧客フリガナを設定する。
     * @param customerKana 顧客フリガナ
     */
    public void setCustomerKana(String customerKana) {
    
        this.customerKana = customerKana;
    }

    
    /**
     * 顧客メールを返す。
     * @return 顧客メール
     */
    public String getCustomerMail() {
    
        return customerMail;
    }

    
    /**
     * 顧客メールを設定する。
     * @param customerMail 顧客メール
     */
    public void setCustomerMail(String customerMail) {
    
        this.customerMail = customerMail;
    }

    
    /**
     * 顧客名を返す。
     * @return 顧客名
     */
    public String getCustomerName() {
    
        return customerName;
    }

    
    /**
     * 顧客名を設定する。
     * @param customerName 顧客名
     */
    public void setCustomerName(String customerName) {
    
        this.customerName = customerName;
    }

    
    /**
     * 顧客郵便番号を返す。
     * @return 顧客郵便番号
     */
    public String getCustomerPost() {
    
        return customerPost;
    }

    
    /**
     * 顧客郵便番号を設定する。
     * @param customerPost 顧客郵便番号
     */
    public void setCustomerPost(String customerPost) {
    
        this.customerPost = customerPost;
    }

    
    /**
     * 顧客電話番号を返す。
     * @return 顧客電話番号
     */
    public String getCustomerTel() {
    
        return customerTel;
    }

    
    /**
     * 顧客電話番号を設定する。
     * @param customerTel 顧客電話番号
     */
    public void setCustomerTel(String customerTel) {
    
        this.customerTel = customerTel;
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
     * 支払期限を返す。
     * @return 支払期限
     */
    public String getPaymentTimeLimit() {
    
        return paymentTimeLimit;
    }

    
    /**
     * 支払期限を設定する。
     * @param paymentTimeLimit 支払期限
     */
    public void setPaymentTimeLimit(String paymentTimeLimit) {
    
        this.paymentTimeLimit = paymentTimeLimit;
    }

    
    /**
     * 作成日を返す。
     * @return 作成日
     */
    public Date getPrintDay() {
    
        return printDay;
    }

    
    /**
     * 作成日を設定する。
     * @param printDay 作成日
     */
    public void setPrintDay(Date printDay) {
    
        this.printDay = printDay;
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

    
    /**予約番号
     * reserveNoを返す。
     * @return rese予約番号rveNo
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
    
}
