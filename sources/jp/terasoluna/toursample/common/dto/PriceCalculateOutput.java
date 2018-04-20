/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.dto;

import java.io.Serializable;

/**
 * 単価料金算出の結果情報を格納するクラス。 <br>
 * ・共通処理CP0009：単価料金算出処理
 * 
 * 
 */
public class PriceCalculateOutput implements Serializable {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = 6982754828396123236L;

    /**
     * 単価(大人)。
     */
    private Integer adultUnitPrice = null;

    /**
     * 単価(子ども)。
     */
    private Integer childUnitPrice = null;

    /**
     * 人数(大人)。
     */
    private Integer adultCount = null;

    /**
     * 人数(子ども)。
     */
    private Integer childCount = null;

    /**
     * 料金(大人)。
     */
    private Integer adultPrice = null;

    /**
     * 料金(子ども)。
     */
    private Integer childPrice = null;

    /**
     * 合計料金。
     */
    private Integer sumPrice = null;

    /**
     * 人数(大人)を返す。
     * 
     * @return 人数(大人)
     */
    public Integer getAdultCount() {

        return adultCount;
    }

    /**
     * 人数(大人)を設定する。
     * 
     * @param adultCount
     *            人数(大人)
     */
    public void setAdultCount(Integer adultCount) {

        this.adultCount = adultCount;
    }

    /**
     * 料金(大人)を返す。
     * 
     * @return 料金(大人)
     */
    public Integer getAdultPrice() {

        return adultPrice;
    }

    /**
     * 料金(大人)を設定する。
     * 
     * @param adultPrice
     *            料金(大人)
     */
    public void setAdultPrice(Integer adultPrice) {

        this.adultPrice = adultPrice;
    }

    /**
     * 単価(大人)を返す。
     * 
     * @return 単価(大人)
     */
    public Integer getAdultUnitPrice() {

        return adultUnitPrice;
    }

    /**
     * 単価(大人)を設定する。
     * 
     * @param adultUnitPrice
     *            単価(大人)
     */
    public void setAdultUnitPrice(Integer adultUnitPrice) {

        this.adultUnitPrice = adultUnitPrice;
    }

    /**
     * 人数(子ども)を返す。
     * 
     * @return 人数(子ども)
     */
    public Integer getChildCount() {

        return childCount;
    }

    /**
     * 人数(子ども)を設定する。
     * 
     * @param childCount
     *            人数(子ども)
     */
    public void setChildCount(Integer childCount) {

        this.childCount = childCount;
    }

    /**
     * 料金(子ども)を返す。
     * 
     * @return 料金(子ども)
     */
    public Integer getChildPrice() {

        return childPrice;
    }

    /**
     * 料金(子ども)を設定する。
     * 
     * @param childPrice
     *            料金(子ども)
     */
    public void setChildPrice(Integer childPrice) {

        this.childPrice = childPrice;
    }

    /**
     * 単価(子ども)を返す。
     * 
     * @return 単価(子ども)
     */
    public Integer getChildUnitPrice() {

        return childUnitPrice;
    }

    /**
     * 単価(子ども)を設定する。
     * 
     * @param childUnitPrice
     *            単価(子ども)
     */
    public void setChildUnitPrice(Integer childUnitPrice) {

        this.childUnitPrice = childUnitPrice;
    }

    /**
     * 合計料金を返す。
     * 
     * @return 合計料金
     */
    public Integer getSumPrice() {

        return sumPrice;
    }

    /**
     * 合計料金を設定する。
     * 
     * @param sumPrice
     *            合計料金
     */
    public void setSumPrice(Integer sumPrice) {

        this.sumPrice = sumPrice;
    }

}
