/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a99_01.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.TourUVO;

/**
 * RP_A99_01_02_02Action出力値クラス
 * 
 * 
 *
 */
public class RP_A99_01_02_02Output implements Serializable {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = 8097338159970602909L;

    /**
     * 顧客情報。
     */
    private TourUVO uvo = null;

    /**
     * 顧客情報を返す。
     * 
     * @return 顧客情報
     */
    public TourUVO getUvo() {

        return uvo;
    }

    /**
     * 顧客情報を設定する。
     * 
     * @param uvo
     *            顧客情報
     */
    public void setUvo(TourUVO uvo) {

        this.uvo = uvo;
    }

}
