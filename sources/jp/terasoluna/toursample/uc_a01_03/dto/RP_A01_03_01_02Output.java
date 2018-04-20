/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_03.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;

/**
 * ツアー予約変更確認のビジネスロジックの出力クラス。<br>
 * 
 * ・UC_A01_03：ツアー予約変更
 * 
 * 
 */
public class RP_A01_03_01_02Output implements Serializable{

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = 8012582821613798288L;
   
    /**
     * 支払方法。
     */
    private String paymentMethod = null;
    
    /**
     * 支払銀行名。
     */
    private String paymentCompanyName = null;
    
    /**
     * 支払口座。
     */
    private String paymentAccount = null;
    
    /**
     * 問合せ先名。
     */
    private String referenceName = null;
    
    /**
     * 問合せ先メール。
     */
    private String referenceEmail = null;
    
    /**
     * 問合せ先電話。
     */
    private String referenceTel = null;

    /**
     * 料金。
     */
    private PriceCalculateOutput price = null;

    /**
     * ツアー詳細情報。
     */    
    private ReserveDetailAcquireOutput reserveDetail = null;
    
    /**
     * ツアー詳細情報を取得
     * 
     * @return reserveDetail
     */
    public ReserveDetailAcquireOutput getReserveDetail() {
        return reserveDetail;
    }

    /**
     * ツアー詳細情報を設定
     * 
     * @param reserveDetail
     */
    public void setReserveDetail(ReserveDetailAcquireOutput reserveDetail) {
        this.reserveDetail = reserveDetail;
    }
    
    /**
     * 料金を取得する。
     * 
     * @return price
     */
    public PriceCalculateOutput getPrice() {
        return price;
    }

    /**
     * 料金を設定する。
     * 
     * @param price
     */
    public void setPrice(PriceCalculateOutput price) {
        this.price = price;
    }

    /**
     * 支払口座を返す。
     * @return 支払口座
     */
    public String getPaymentAccount() {
        return paymentAccount;
    }

    /**
     * 支払口座を設定する。
     * @param paymentAccount 支払口座
     */
    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    /**
     * 支払銀行名を返す。
     * @return 支払銀行名
     */
    public String getPaymentCompanyName() {
        return paymentCompanyName;
    }

    /**
     * 支払銀行名を設定する。
     * @param paymentCompanyName 支払銀行名
     */
    public void setPaymentCompanyName(String paymentCompanyName) {
        this.paymentCompanyName = paymentCompanyName;
    }

    /**
     * 支払方法を返す。
     * @return 支払方法
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * 支払方法を設定する。
     * @param paymentMethod 支払方法
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * 問合せ先メールを返す。
     * @return 問合せ先メール
     */
    public String getReferenceEmail() {
        return referenceEmail;
    }

    /**
     * 問合せ先メールを設定する。
     * @param referenceEmail 問合せ先メール
     */
    public void setReferenceEmail(String referenceEmail) {
        this.referenceEmail = referenceEmail;
    }

    /**
     * 問合せ先名を返す。
     * @return 問合せ先名
     */
    public String getReferenceName() {
        return referenceName;
    }

    /**
     * 問合せ先名を設定する。
     * @param referenceName 問合せ先名
     */
    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    /**
     * 問合せ先電話を返す。
     * @return 問合せ先電話
     */
    public String getReferenceTel() {
        return referenceTel;
    }

    /**
     * 問合せ先電話を設定する。
     * @param referenceTel 問合せ先電話
     */
    public void setReferenceTel(String referenceTel) {
        this.referenceTel = referenceTel;
    }
    
}

