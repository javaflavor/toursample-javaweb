/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a99_03.dto;

import java.io.Serializable;

/**
 * 顧客登録ビジネスロジックの入力クラス。<br>
 * 
 * ・UC_A99_03：顧客登録
 * 
 * 
 */
public class RP_A99_03_02_01Input implements Serializable{

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -8660317714060006259L;

    /**
     *フリガナ。
     */
    private String customerKana = null;
    
    /**
     *氏名。
     */
    private String customerName = null;
    
    /**
     *年。
     */
    private String customerBirthYear = null;
    
    /**
     *月。
     */
    private String customerBirthMonth = null;
    
    /**
     *日。
     */
    private String customerBirthDay = null;
   
    /**
     *生年月日。
     */
    private String customerBirth = null;
    
    /**
     *職業。
     */
    private String customerJob = null;
    
    /**
     *Eメール。
     */
    private String customerMail = null;    
    
    /**
     *電話番号。
     */
    private String customerTel = null;
    
    /**
     *郵便番号。
     */
    private String customerPost = null;
    
    /**
     *住所。
     */
    private String customerAdd = null;
    
    /**
     *パスワード。
     */
    private String customerPass = null;
    
    /**
     *顧客ID。
     */
    private String customerCode = null;
    
    /**
     * 住所を返す。
     * @return 住所
     */
    public String getCustomerAdd() {
        return customerAdd;
    }
    
    /**
     * 住所を設定する。
     * @param customerAdd 住所
     */
    public void setCustomerAdd(String customerAdd) {
        this.customerAdd = customerAdd;
    }
    
    /**
     * 日を返す。
     * @return 日
     */
    public String getCustomerBirthDay() {
        return customerBirthDay;
    }
    
    /**
     * 日を設定する。
     * @param customerBirthDay 日
     */
    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }
    
    /**
     * 月を返す。
     * @return 月
     */
    public String getCustomerBirthMonth() {
        return customerBirthMonth;
    }
    
    /**
     * 月を設定する。
     * @param customerBirthMonth 月
     */
    public void setCustomerBirthMonth(String customerBirthMonth) {
        this.customerBirthMonth = customerBirthMonth;
    }
    
    /**
     * 年を返す。
     * @return 年
     */
    public String getCustomerBirthYear() {
        return customerBirthYear;
    }
    
    /**
     * 年を設定する。
     * @param customerBirthYear 年
     */
    public void setCustomerBirthYear(String customerBirthYear) {
        this.customerBirthYear = customerBirthYear;
    }
    
    /**
     * 職業を返す。
     * @return 職業
     */
    public String getCustomerJob() {
        return customerJob;
    }
    
    /**
     * 職業を設定する。
     * @param customerJob 職業
     */
    public void setCustomerJob(String customerJob) {
        this.customerJob = customerJob;
    }
    
    /**
     * フリガナを返す。
     * @return フリガナ
     */
    public String getCustomerKana() {
        return customerKana;
    }
    
    /**
     * フリガナを設定する。
     * @param customerKana フリガナ
     */
    public void setCustomerKana(String customerKana) {
        this.customerKana = customerKana;
    }
    
    /**
     * Eメールを返す。
     * @return Eメール
     */
    public String getCustomerMail() {
        return customerMail;
    }
    
    /**
     * Eメールを設定する。
     * @param customerMail Eメール
     */
    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }
    
    /**
     * 氏名を返す。
     * @return 氏名
     */
    public String getCustomerName() {
        return customerName;
    }
    
    /**
     * 氏名を設定する。
     * @param customerName 氏名
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    /**
     * パスワードを返す。
     * @return パスワード
     */
    public String getCustomerPass() {
        return customerPass;
    }
    
    /**
     * パスワードを設定する。
     * @param customerPass パスワード
     */
    public void setCustomerPass(String customerPass) {
        this.customerPass = customerPass;
    }
    
    /**
     * 郵便番号を返す。
     * @return 郵便番号
     */
    public String getCustomerPost() {
        return customerPost;
    }
    
    /**
     * 郵便番号を設定する。
     * @param customerPost 郵便番号
     */
    public void setCustomerPost(String customerPost) {
        this.customerPost = customerPost;
    }
    
    /**
     * 電話番号を返す。
     * @return 電話番号
     */
    public String getCustomerTel() {
        return customerTel;
    }
    
    /**
     * 電話番号を設定する。
     * @param customerTel 電話番号
     */
    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    /**
     * customerBirthを返す。
     * @return customerBirth
     */
    public String getCustomerBirth() {
        return customerBirth;
    }

    /**
     * customerBirthを設定する。
     * @param customerBirth customerBirth
     */
    public void setCustomerBirth(String customerBirth) {
        this.customerBirth = customerBirth;
    }

    /**
     * customerCodeを返す。
     * @return customerCode
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * customerCodeを設定する。
     * @param customerCode customerCode
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    
}
