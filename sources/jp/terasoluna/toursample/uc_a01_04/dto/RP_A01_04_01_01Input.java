/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_04.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.TourUVO;

/**
 * 予約情報取得のための入力値クラス。
 * 
 * 
 */
public class RP_A01_04_01_01Input implements Serializable {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -370419235175000734L;

    /**
     * 予約番号。
     */
    private String reserveNo = null;

    /**
     * 顧客情報。
     */
    private TourUVO USER_VALUE_OBJECT = null;

    /**
     * 予約番号を取得する。
     * 
     * @return reserveNo
     */
    public String getReserveNo() {

        return this.reserveNo;
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
     * 顧客情報を取得する。
     * 
     * @return USER_VALUE_OBJECT
     */
    public TourUVO getUSER_VALUE_OBJECT() {

        return this.USER_VALUE_OBJECT;
    }

    /**
     * 顧客情報を設定する。
     * 
     * @param USER_VALUE_OBJECT
     */
    public void setUSER_VALUE_OBJECT(TourUVO USER_VALUE_OBJECT) {

        this.USER_VALUE_OBJECT = USER_VALUE_OBJECT;
    }

}