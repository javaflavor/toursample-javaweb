/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a99_01.dto;

import java.io.Serializable;

/**
 * RP_A99_01_02_02Action入力値クラス
 * 
 * 
 *
 */
public class RP_A99_01_02_02Input implements Serializable {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = 2746626748190204007L;

    /**
     * 顧客ID。
     */
    private String customerCode = null;

    /**
     * パスワード。
     */
    private String customerPass = null;

    /**
     * 遷移元画面ID。
     */
    private String returnCode = null;

    /**
     * ツアーコード。
     */
    private String tourCode = null;

    /**
     * 顧客IDを返す。
     * 
     * @return 顧客ID
     */

    public String getCustomerCode() {

        return customerCode;
    }

    /**
     * 顧客IDを設定する。
     * 
     * @param customerCode
     *            顧客ID
     */

    public void setCustomerCode(String customerCode) {

        this.customerCode = customerCode;
    }

    /**
     * パスワードを返す。
     * 
     * @return パスワード
     */

    public String getCustomerPass() {

        return customerPass;
    }

    /**
     * パスワードを設定する。
     * 
     * @param customerPass
     *            パスワード
     */

    public void setCustomerPass(String customerPass) {

        this.customerPass = customerPass;
    }

    /**
     * 遷移元画面IDを返す。
     * 
     * @return 遷移元画面ID
     */

    public String getReturnCode() {

        return returnCode;
    }

    /**
     * 遷移元画面IDを設定する。
     * 
     * @param returnCode
     *            遷移元画面ID
     */

    public void setReturnCode(String returnCode) {

        this.returnCode = returnCode;
    }

    /**
     * ツアーコードを返す。
     * 
     * @return ツアーコード
     */

    public String getTourCode() {

        return tourCode;
    }

    /**
     * ツアーコードを設定する。
     * 
     * @param tourCode
     *            ツアーコード
     */

    public void setTourCode(String tourCode) {

        this.tourCode = tourCode;
    }
}
