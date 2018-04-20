/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.form;

import java.util.Date;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.TourDetailAcquireOutput;
import jp.terasoluna.toursample.uc_a01_01.dto.TourInfo;

/**
 * ツアー予約のフォームクラス。
 * 
 * 
 * 
 */
public class UC_A01_01Form extends ValidatorActionFormEx {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1488467514819027464L;

    /**
     * ツアーコード
     */
    private String tourCode = null;
    
    /**
     * ご意見ご要望
     */
    private String remarks = null;

    /**
     * 予約番号
     */
    private String reserveNo = null;

    /**
     * 申し込み日
     */
    private Date reservedDay = null;

    /**
     * 支払方法
     */
    private String paymentMethod = null;

    /**
     * 振込口座
     */
    private String paymentAccount = null;

    /**
     * 振込銀行
     */
    private String paymentCompanyName = null;

    /**
     * 問合せ先名
     */
    private String referenceName = null;

    /**
     * 問合せ先電話番号
     */
    private String referenceTel = null;

    /**
     * 問合せ先メールアドレス
     */
    private String referenceEmail = null;

    /**
     * 支払期限
     */
    private Date paymentTimeLimit = null;

    /**
     * 目的地条件。
     */
    private String arrCodeCondition = null;

    /**
     * 出発地条件。
     */
    private String depCodeCondition = null;

    /**
     * 出発日（年）条件。
     */
    private String depDayYearCondition = null;

    /**
     * 出発日(月）条件。
     */
    private String depDayMonthCondition = null;

    /**
     * 出発日(日）条件。
     */
    private String depDayDayCondition = null;

    /**
     * 日数条件。
     */
    private String tourDaysCondition = null;

    /**
     * 人数(大人)条件。
     */
    private String adultCountCondition = null;

    /**
     * 人数(子ども)条件。
     */
    private String childCountCondition = null;

    /**
     * 基本料金条件。
     */
    private String basePriceCondition = null;

    /**
     * 開始インデックス。
     */
    private Integer startIndex = 0;

    /**
     * 表示行数。
     */
    private Integer row = 10;

    /**
     * ツアー情報一覧。
     */
    private TourInfo[] tourInfoList = null;

    /**
     * 一覧情報全行数。
     */
    private Integer allListInfoLineCount = 0;

    /**
     * 現在ページ表示インデックス。
     */
    private String currentPageIndex = "1";
    
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
     * ツアーコードを取得する。
     * 
     * @return tourCode
     */
    public String getTourCode() {

        return tourCode;
    }

    /**
     * ツアーコードを設定する。
     * 
     * @param tourCode
     */
    public void setTourCode(String tourCode) {

        this.tourCode = tourCode;
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
     * ご意見ご要望を設定する。
     * 
     * @param remarks
     */
    public void setRemarks(String remarks) {

        this.remarks = remarks;
    }

    /**
     * 人数(大人)条件を取得する。
     * 
     * @return adultCountCondition
     */
    public String getAdultCountCondition() {

        return adultCountCondition;
    }

    /**
     * 人数(大人)条件を設定する。
     * 
     * @param adultCountCondition
     */
    public void setAdultCountCondition(String adultCountCondition) {

        this.adultCountCondition = adultCountCondition;
    }

    /**
     * 目的地条件を取得する。
     * 
     * @return arrCodeCondition
     */
    public String getArrCodeCondition() {

        return arrCodeCondition;
    }

    /**
     * 目的地条件を設定する。
     * 
     * @param arrCodeCondition
     */
    public void setArrCodeCondition(String arrCodeCondition) {

        this.arrCodeCondition = arrCodeCondition;
    }

    /**
     * 基本料金条件を取得する。
     * 
     * @return basePriceCondition
     */
    public String getBasePriceCondition() {

        return basePriceCondition;
    }

    /**
     * 基本料金条件を設定する。
     * 
     * @param basePriceCondition
     */
    public void setBasePriceCondition(String basePriceCondition) {

        this.basePriceCondition = basePriceCondition;
    }

    /**
     * 人数(子ども)条件を取得する。
     * 
     * @return childCountCondition
     */
    public String getChildCountCondition() {

        return childCountCondition;
    }

    /**
     * 人数(子ども)条件を設定する。
     * 
     * @param childCountCondition
     */
    public void setChildCountCondition(String childCountCondition) {

        this.childCountCondition = childCountCondition;
    }

    /**
     * 日数条件を取得する。
     * 
     * @return tourDaysCondition
     */
    public String getTourDaysCondition() {

        return tourDaysCondition;
    }

    /**
     * 日数条件を設定する。
     * 
     * @param tourDaysCondition
     */
    public void setTourDaysCondition(String tourDaysCondition) {

        this.tourDaysCondition = tourDaysCondition;
    }

    /**
     * 出発地条件を取得する。
     * 
     * @return depCodeCondition
     */
    public String getDepCodeCondition() {

        return depCodeCondition;
    }

    /**
     * 出発地条件を設定する。
     * 
     * @param depCodeCondition
     */
    public void setDepCodeCondition(String depCodeCondition) {

        this.depCodeCondition = depCodeCondition;
    }

    /**
     * 出発日(日）条件を取得する。
     * 
     * @return depDayDayCondition
     */
    public String getDepDayDayCondition() {

        return depDayDayCondition;
    }

    /**
     * 出発日(日）条件を設定する。
     * 
     * @param depDayDayCondition
     */
    public void setDepDayDayCondition(String depDayDayCondition) {

        this.depDayDayCondition = depDayDayCondition;
    }

    /**
     * 出発日(月）条件を取得する。
     * 
     * @return depDayMonthCondition
     */
    public String getDepDayMonthCondition() {

        return depDayMonthCondition;
    }

    /**
     * 出発日(月）条件を設定する。
     * 
     * @param depDayMonthCondition
     */
    public void setDepDayMonthCondition(String depDayMonthCondition) {

        this.depDayMonthCondition = depDayMonthCondition;
    }

    /**
     * 出発日（年）条件を取得する。
     * 
     * @return depDayYearCondition
     */
    public String getDepDayYearCondition() {

        return depDayYearCondition;
    }

    /**
     * 出発日（年）条件を設定する。
     * 
     * @param depDayYearCondition
     */
    public void setDepDayYearCondition(String depDayYearCondition) {

        this.depDayYearCondition = depDayYearCondition;
    }

    /**
     * 表示行数を取得する。
     * 
     * @return row
     */
    public Integer getRow() {

        return row;
    }

    /**
     * 表示行数を設定する。
     * 
     * @param row
     */
    public void setRow(Integer row) {

        this.row = row;
    }

    /**
     * 開始インデックスを取得する。
     * 
     * @return startIndex
     */
    public Integer getStartIndex() {

        return startIndex;
    }

    /**
     * 開始インデックスを設定する。
     * 
     * @param startIndex
     */
    public void setStartIndex(Integer startIndex) {

        this.startIndex = startIndex;
    }

    /**
     * 一覧情報全行数を取得する。
     * 
     * @return allListInfoLineCount
     */
    public Integer getAllListInfoLineCount() {

        return allListInfoLineCount;
    }

    /**
     * 一覧情報全行数を設定する。
     * 
     * @param allListInfoLineCount
     */
    public void setAllListInfoLineCount(Integer allListInfoLineCount) {

        this.allListInfoLineCount = allListInfoLineCount;
    }

    /**
     * ツアー情報一覧を取得する。
     * 
     * @return tourInfoList
     */
    public TourInfo[] getTourInfoList() {

        return tourInfoList;
    }

    /**
     * ツアー情報一覧を設定する。
     * 
     * @param tourInfoList
     */
    public void setTourInfoList(TourInfo[] tourInfoList) {

        this.tourInfoList = tourInfoList;
    }

    /**
     * 支払方法を取得する。
     * 
     * @return paymentMethod
     */
    public String getPaymentMethod() {

        return paymentMethod;
    }

    /**
     * 支払方法を設定する。
     * 
     * @param paymentMethod
     */
    public void setPaymentMethod(String paymentMethod) {

        this.paymentMethod = paymentMethod;
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
     * 振込銀行を取得する。
     * 
     * @return paymentCompanyName
     */
    public String getPaymentCompanyName() {

        return paymentCompanyName;
    }

    /**
     * 振込銀号を設定する。
     * 
     * @param paymentCompanyName
     */
    public void setPaymentCompanyName(String paymentCompanyName) {

        this.paymentCompanyName = paymentCompanyName;
    }

    /**
     * 現在ページ表示インデックスを取得する。
     * 
     * @return currentPageIndex
     */
    public String getCurrentPageIndex() {

        return currentPageIndex;
    }

    /**
     * 現在ページ表示インデックスを設定する。
     * 
     * @param currentPageIndex
     */
    public void setCurrentPageIndex(String currentPageIndex) {

        this.currentPageIndex = currentPageIndex;
    }

}
