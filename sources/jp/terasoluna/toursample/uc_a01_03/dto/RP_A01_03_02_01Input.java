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
 * ツアー予約変更確定のビジネスロジックの入力クラス。<br>
 * 
 * ・UC_A01_03：ツアー予約変更
 * 
 * 
 */
public class RP_A01_03_02_01Input implements Serializable {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -1002140563277124463L;

    /**
     * 予約番号。
     */
    private String reserveNo = null;
    
    /**
     *ツアーコード。
     */    
    private String tourCode = null;
    
    /**
     * 人数（大人）。
     */
    private Integer adultCount = null; 
    
    /**
     * 人数（子ども）。
     */
    private Integer childCount = null;
    
    /**
     *合計料金。
     */
    private Integer sumPrice = null;
    
    /**
     * ご意見ご要望。
     */
    private String remarks = null;

    /**
     * ツアー詳細情報。
     */    
    private ReserveDetailAcquireOutput reserveDetail = null;

    /**
     * 料金。
     */
    private PriceCalculateOutput price = null;
    
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
    
}
