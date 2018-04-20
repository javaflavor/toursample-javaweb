/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_04.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;

/**
 * 検索した予約情報を格納する出力クラス。
 * 
 * 
 */
public class RP_A01_04_01_01Output implements Serializable {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -4823038142885388304L;

    /**
     * 予約情報。
     */
    private ReserveDetailAcquireOutput reserveDetail = null;

    /**
     * 料金情報。
     */
    private PriceCalculateOutput price = null;

    /**
     * 予約情報を取得する。
     * 
     * @return reserveDetail
     */
    public ReserveDetailAcquireOutput getReserveDetail() {

        return this.reserveDetail;
    }

    /**
     * 予約情報を設定する。
     * 
     * @param reserveDetail
     */
    public void setReserveDetail(ReserveDetailAcquireOutput reserveDetail) {

        this.reserveDetail = reserveDetail;
    }

    /**
     * 料金情報を取得する。
     * 
     * @return price
     */
    public PriceCalculateOutput getPrice() {

        return this.price;
    }

    /**
     * 料金情報を設定する。
     * 
     * @param price
     */
    public void setPrice(PriceCalculateOutput price) {

        this.price = price;
    }

}