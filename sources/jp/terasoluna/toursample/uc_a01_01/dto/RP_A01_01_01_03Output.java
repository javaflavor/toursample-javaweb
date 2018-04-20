/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.TourDetailAcquireOutput;

/**
 * RP_A01_01_01_03BLogicの出力値クラス。
 * 
 * 
 * 
 */
public class RP_A01_01_01_03Output implements Serializable {


    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = 3270608081338149204L;

    /**
     * ご意見・ご要望初期化フィールド
     */
    private String remarks = null;

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
     * @return remarks
     */
    public String getRemarks() {
    
        return remarks;
    }

    
    /**
     * @param remarks 設定する
     */
    public void setRemarks(String remarks) {
    
        this.remarks = remarks;
    }
}
