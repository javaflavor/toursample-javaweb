/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * ツアー詳細情報を格納するクラス。
 * <br>
 * ・共通処理CP0007：ツアー詳細取得
 * 
 * 
 */
public class TourDetailAcquireOutput implements Serializable {
    
    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = 1496515916691761128L;

    /**
     * ツアー名。
     */
    private String tourName = null;

    /**
     * 出発日。
     */
    private Date depDay = null;

    /**
     * 日数。
     */
    private String tourDays = null;

    /**
     * 日数(数字)。
     */
    private Integer intTourDays = null;
    
    /**
     * 出発地。
     */
    private String depName = null;

    /**
     * 目的地。
     */
    private String arrName = null;

    /**
     * 添乗員オプション。
     */
    private boolean conductor = false;

    /**
     * 宿泊施設。
     */
    private String accomName = null;

    /**
     * 連絡先。
     */
    private String accomTel = null;

    /**
     * 概要。
     */
    private String tourAbs = null;

    /**
     * 基本料金。
     */
    private Integer basePrice = null;

    /**
     * 宿泊施設を返す。
     * @return 宿泊施設
     */
    public String getAccomName() {
        return accomName;
    }

    /**
     * 宿泊施設を設定する。
     * @param accomName 宿泊施設
     */
    public void setAccomName(String accomName) {
        this.accomName = accomName;
    }

    /**
     * 連絡先を返す。
     * @return 連絡先
     */
    public String getAccomTel() {
        return accomTel;
    }

    /**
     * 連絡先を設定する。
     * @param accomTel 連絡先
     */
    public void setAccomTel(String accomTel) {
        this.accomTel = accomTel;
    }

    /**
     * 目的地を返す。
     * @return 目的地
     */
    public String getArrName() {
        return arrName;
    }

    /**
     * 目的地を設定する。
     * @param arrName 目的地
     */
    public void setArrName(String arrName) {
        this.arrName = arrName;
    }

    /**
     * 基本料金を返す。
     * @return 基本料金
     */
    public Integer getBasePrice() {
        return basePrice;
    }

    /**
     * 基本料金を設定する。
     * @param basePrice 基本料金
     */
    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * 添乗員オプションを返す。
     * @return 添乗員オプション
     */
    public boolean getConductor() {
        return conductor;
    }

    /**
     * 添乗員オプションを設定する。
     * @param conductor 添乗員オプション
     */
    public void setConductor(boolean conductor) {
        this.conductor = conductor;
    }

    /**
     * 出発日を返す。
     * @return 出発日
     */
    public Date getDepDay() {
        return depDay;
    }

    /**
     * 出発日を設定する。
     * @param depDay 出発日
     */
    public void setDepDay(Date depDay) {
        this.depDay = depDay;
    }

    /**
     * 出発地を返す。
     * @return 出発地
     */
    public String getDepName() {
        return depName;
    }

    /**
     * 出発地を設定する。
     * @param depName 出発地
     */
    public void setDepName(String depName) {
        this.depName = depName;
    }

    /**
     * 概要を返す。
     * @return 概要
     */
    public String getTourAbs() {
        return tourAbs;
    }

    /**
     * 概要を設定する。
     * @param tourAbs 概要
     */
    public void setTourAbs(String tourAbs) {
        this.tourAbs = tourAbs;
    }

    /**
     * 日数を返す。
     * @return 日数
     */
    public String getTourDays() {
        return tourDays;
    }

    /**
     * 日数を設定する。
     * @param tourDays 日数
     */
    public void setTourDays(String tourDays) {
        this.tourDays = tourDays;
    }

    /**
     * ツアー名を返す。
     * @return ツアー名
     */
    public String getTourName() {
        return tourName;
    }

    /**
     * ツアー名を設定する。
     * @param tourName ツアー名
     */
    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    /**
     * 日数(数字)を返す。
     * @return 日数(数字)
     */
    public Integer getIntTourDays() {
    
        return intTourDays;
    }

    /**
     * 日数(数字)を設定する。
     * @param intTourDays 日数(数字)
     */
    public void setIntTourDays(Integer intTourDays) {
    
        this.intTourDays = intTourDays;
    }

}
