/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common;

import java.util.Date;

import jp.terasoluna.fw.web.UserValueObject;

/**
 * ツアー予約システムの顧客情報クラス
 * <p>
 * ログインした顧客の顧客情報を保持する。
 * </p>
 * 
 * @see jp.terasoluna.fw.web.UserValueObject
 */
public class TourUVO extends UserValueObject {
    
    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -2080310363535630863L;

    /**
     * 顧客ID。
     */
    private String customerCode = null;
    
    /**
     * 顧客名。
     */
    private String customerName = null;
    
    /**
     * 顧客フリガナ。
     */
    private String customerKana = null;
    
    /**
     * 顧客生年月日。
     */
    private Date customerBirth = null;
    
    /**
     * 顧客職業。
     */
    private String customerJob = null;
    
    /**
     * 顧客メールアドレス。
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
     * 顧客住所を返す。
     * 
     * @return 顧客住所
     */
    public String getCustomerAdd() {
        return customerAdd;
    }
    
    /**
     * 顧客住所を設定する。
     * 
     * @param customerAdd 顧客住所
     */
    public void setCustomerAdd(String customerAdd) {
        this.customerAdd = customerAdd;
    }
    
    /**
     * 顧客生年月日を返す。
     * 
     * @return 顧客生年月日
     */
    public Date getCustomerBirth() {
        return customerBirth;
    }
    
    /**
     * 顧客生年月日を設定する。
     * 
     * @param customerBirth 顧客生年月日
     */
    public void setCustomerBirth(Date customerBirth) {
        this.customerBirth = customerBirth;
    }
    
    /**
     * 顧客IDを返す。
     * 
     * @return 顧客ID
     */
    public String getCustomerCode() {
        return customerCode;
    }
    
    /**
     * 顧客IDを設定する。
     * 
     * @param customerCode 顧客ID
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
    
    /**
     * 顧客職業を返す。
     * 
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
     * 
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
     * 顧客メールアドレスを返す。
     * 
     * @return 顧客メールアドレス
     */
    public String getCustomerMail() {
        return customerMail;
    }
    
    /**
     * 顧客メールアドレスを設定する。
     * @param customerMail 顧客メールアドレス
     */
    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }
    
    /**
     * 顧客名を返す。
     * 
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
     * 
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
     * 
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
    

}
