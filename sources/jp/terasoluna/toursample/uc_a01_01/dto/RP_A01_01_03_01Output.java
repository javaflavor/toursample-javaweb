/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;
import java.util.Date;

import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.TourDetailAcquireOutput;

/**
 * 
 * 予約登録するときの出力値クラス。
 * 
 * 
 * 
 */
public class RP_A01_01_03_01Output implements Serializable {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = 6752822955881180226L;

    /**
     * 予約番号。
     */
    private String reserveNo = null;

    /**
     * 申し込み日。
     */
    private Date reservedDay = null;

    /**
     * 支払い方法。
     */
    private String paymentMethod = null;

    /**
     * 振込口座。
     */
    private String paymentAccount = null;

    /**
     * 振込先。
     */
    private String paymentCompanyName = null;

    /**
     * 問合せ先名。
     */
    private String referenceName = null;

    /**
     * 問合せ先電話番号。
     */
    private String referenceTel = null;

    /**
     * 問合せ先メールアドレス。
     */
    private String referenceEmail = null;

    /**
     * 支払期限。
     */
    private Date paymentTimeLimit = null;

    /**
     * ツアー詳細情報
     */   
    private TourDetailAcquireOutput tourDetail = null;

    /**
     * ツアー基本料金、人数より単価、料金など
     */     
    private PriceCalculateOutput priceOutput = null;
        
    /**
     * ツアー基本料金、人数より単価、料金などを取得する
     * 
     * @return priceOutput
     */
    public PriceCalculateOutput getPriceOutput() {
		return priceOutput;
	}

	/**
	 * ツアー基本料金、人数より単価、料金などを設定する
	 * 
	 * @param priceOutput
	 */
    public void setPriceOutput(PriceCalculateOutput priceOutput) {

    	this.priceOutput = priceOutput;
	}

    /**
     * ツアー詳細情報を取得する
     * 
     * @return tourDetail
     */    
	public TourDetailAcquireOutput getTourDetail() {

		return tourDetail;
	}
	
	/**
	 * ツアー詳細情報を設定する
	 * 
     * @param tourDetail
     */
	public void setTourDetail(TourDetailAcquireOutput tourDetail) {

		this.tourDetail = tourDetail;
	}
	
    /**
     * 支払期限を取得する。
     * 
     * @return paymentTimeLimit
     */
    public Date getPaymentTimeLimit() {
        return paymentTimeLimit;
    }

    /**
     * 支払期限を設定する。
     * 
     * @param paymentTimeLimit
     */
    public void setPaymentTimeLimit(Date paymentTimeLimit) {
        this.paymentTimeLimit = paymentTimeLimit;
    }

    /**
     * 支払い方法を取得する。
     * 
     * @return paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * 支払い方法を設定する。
     * 
     * @param paymentMethod
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * 問合せ先メールアドレスを取得する。
     * 
     * @return referenceEmail
     */
    public String getReferenceEmail() {
        return referenceEmail;
    }

    /**
     * 問合せ先メールアドレスを設定する。
     * 
     * @param referenceEmail
     */
    public void setReferenceEmail(String referenceEmail) {
        this.referenceEmail = referenceEmail;
    }

    /**
     * 問合せ先名を取得する。
     * 
     * @return referenceName
     */
    public String getReferenceName() {
        return referenceName;
    }

    /**
     * 問合せ先名を設定する。
     * 
     * @param referenceName
     */
    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    /**
     * 問合せ先電話番号を取得する。
     * 
     * @return referenceTel
     */
    public String getReferenceTel() {
        return referenceTel;
    }

    /**
     * 問合せ先電話番号を設定する。
     * 
     * @param referenceTel
     */
    public void setReferenceTel(String referenceTel) {
        this.referenceTel = referenceTel;
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

    /**
     * 予約番号を取得する。
     * 
     * @return reserveNo
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
     * 振込口座を取得する。
     * 
     * @return paymentAccount
     */
    public String getPaymentAccount() {
        return paymentAccount;
    }

    /**
     * 振込口座を設定する。
     * 
     * @param paymentAccount
     */
    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    /**
     * 振込先を取得する。
     * 
     * @return paymentCompanyName
     */
    public String getPaymentCompanyName() {
        return paymentCompanyName;
    }

    /**
     * 振込先を設定する。
     * 
     * @param paymentCompanyName
     */
    public void setPaymentCompanyName(String paymentCompanyName) {
        this.paymentCompanyName = paymentCompanyName;
    }
}
