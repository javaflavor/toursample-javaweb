/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_05.form;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;

/**
 * ツアー情報出力用のActionForm。<br>
 * 
 * ・UC_A01_05：ツアー情報出力
 * 
 * 
 */
public class UC_A01_05Form extends ValidatorActionFormEx {

    /**
     * serialVersionUID。
     */
    private static final long serialVersionUID = 9149389442234864994L;

    /**
     * 予約番号。
     */
    private String reserveNo = null;
    
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
}