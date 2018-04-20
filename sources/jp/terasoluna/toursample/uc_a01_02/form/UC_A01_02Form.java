/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_02.form;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;
import jp.terasoluna.toursample.uc_a01_02.dto.SelectReservationInfoOutput;

/**
 * ツアー予約照会用のActionForm。<br>
 * 
 * ・UC_A01_02：ツアー予約照会
 * 
 * 
 */
public class UC_A01_02Form  extends ValidatorActionFormEx {


    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2156362709861308598L;

    /**
     * ツアー予約情報リスト。
     */
    private SelectReservationInfoOutput[] reservationInfo = null;
    
    /**
     * 予約件数。
     */
    private Integer reservationsCount = null;
    
    /**
     * 予約番号。
     */
    private String reserveNo = null;

    /**
     * 予約詳細情報。
     */
    private ReserveDetailAcquireOutput reserveDetail = new ReserveDetailAcquireOutput();

    /**
     * 料金情報。
     */
    private PriceCalculateOutput price = null;
    
    /**
     * 支払方法。
     */
    private String paymentMethod = null;
    
    /**
     * 銀行名。
     */
    private String paymentCompanyName = null;
    
    /**
     * 銀行口座。
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
     * 振込期限超過フラグ。
     */
    private boolean limitExcessFlag = false;

    
    /**
     * 振込期限超過フラグを返す。
     * @return 振込期限超過フラグ
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
     * 銀行口座を返す。
     * @return 銀行口座
     */
    public String getPaymentAccount() {
    
        return paymentAccount;
    }

    
    /**
     * 銀行口座を設定する。
     * @param paymentAccount 銀行口座
     */
    public void setPaymentAccount(String paymentAccount) {
    
        this.paymentAccount = paymentAccount;
    }

    
    /**
     * 銀行名を返す。
     * @return 銀行名
     */
    public String getPaymentCompanyName() {
    
        return paymentCompanyName;
    }

    
    /**
     * 銀行名を設定する。
     * @param paymentCompanyName 銀行名
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
     * 料金情報を返す。
     * @return 料金情報
     */
    public PriceCalculateOutput getPrice() {
    
        return price;
    }

    
    /**
     * 料金情報を設定する。
     * @param price 料金情報
     */
    public void setPrice(PriceCalculateOutput price) {
    
        this.price = price;
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

    
    /**
     * ツアー予約情報リストを返す。
     * @return ツアー予約情報リスト
     */
    public SelectReservationInfoOutput[] getReservationInfo() {
    	return reservationInfo;
    }     



    
    /**
     * ツアー予約情報リストを設定する。
     * @param reservationInfo ツアー予約情報リスト
     */
    public void setReservationInfo(SelectReservationInfoOutput[] reservationInfo) {
    
        this.reservationInfo = reservationInfo;
    }

    
    /**
     * 予約件数を返す。
     * @return 予約件数
     */
    public Integer getReservationsCount() {
    
        return reservationsCount;
    }

    
    /**
     * 予約件数を設定する。
     * @param reservationsCount 予約件数
     */
    public void setReservationsCount(Integer reservationsCount) {
    
        this.reservationsCount = reservationsCount;
    }

    
    /**
     * 予約詳細情報を返す。
     * @return 予約詳細情報
     */
    public ReserveDetailAcquireOutput getReserveDetail() {
        
        return reserveDetail;
    }

    
    /**
     * 予約詳細情報を設定する。
     * @param reserveDetail 予約詳細情報
     */
    public void setReserveDetail(ReserveDetailAcquireOutput reserveDetail) {
    
        this.reserveDetail = reserveDetail;
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
}
