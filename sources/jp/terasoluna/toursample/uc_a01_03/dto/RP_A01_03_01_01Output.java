/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_03.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;

/**
 * ツアー予約変更情報取得ビジネスロジックの出力クラス。<br>
 * 
 * ・UC_A01_03：ツアー予約変更
 * 
 * 
 */
public class RP_A01_03_01_01Output implements Serializable{

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = 1521148184784284702L;

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
}

