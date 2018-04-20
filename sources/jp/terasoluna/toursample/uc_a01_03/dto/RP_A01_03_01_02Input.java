/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_03.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.TourUVO;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;

/**
 * ツアー予約変更確認のビジネスロジックの入力クラス。<br>
 * 
 * ・UC_A01_03：ツアー予約変更
 * 
 * 
 */
public class RP_A01_03_01_02Input implements Serializable {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -6379953862933443502L;
       
    /**
     * ツアー詳細情報。
     */    
    private ReserveDetailAcquireOutput reserveDetail = null;
    
    /**
     *予約番号。
     */
    private String reserveNo = null;
    
    /**
     * 顧客情報。
     */
    private TourUVO USER_VALUE_OBJECT = null;
    
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
     * 顧客情報を返す。
     * @return 顧客情報
     */
    public TourUVO getUSER_VALUE_OBJECT() {
        return USER_VALUE_OBJECT;
    }

    /**
     * 顧客情報を設定する。
     * @param user_value_object 顧客情報
     */
    public void setUSER_VALUE_OBJECT(TourUVO user_value_object) {
        USER_VALUE_OBJECT = user_value_object;
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
    
}
