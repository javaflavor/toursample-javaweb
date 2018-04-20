/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_03.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.TourUVO;

/**
 * ツアー予約変更情報取得ビジネスロジックの入力クラス。<br>
 * 
 * ・UC_A01_03：ツアー予約変更
 * 
 * 
 */
public class RP_A01_03_01_01Input implements Serializable{

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -6461812030190066129L;

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
    
}
