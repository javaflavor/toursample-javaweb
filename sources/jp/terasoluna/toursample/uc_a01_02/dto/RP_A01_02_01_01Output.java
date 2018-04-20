/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_02.dto;

import java.io.Serializable;

/**
 * RP_A01_02_01_01BLogicの出力値クラス。
 *
 * 
 */
public class RP_A01_02_01_01Output implements Serializable {
    
    /**
     * serialVersionUID。
     */
    private static final long serialVersionUID = -5294130490486913518L;

    /**
     * ツアー予約情報リスト。
     */
    private SelectReservationInfoOutput[] reservationInfo = null;
    
    /**
     * 予約件数。
     */
    private Integer reservationsCount = null;

    
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
        
}
