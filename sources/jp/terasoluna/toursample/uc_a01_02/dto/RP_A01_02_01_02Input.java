/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_02.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.TourUVO;

/**
 * RP_A01_02_01_02BLogic‚Ì“ü—Í’lƒNƒ‰ƒXB
 *
 * 
 */
public class RP_A01_02_01_02Input implements Serializable {
    
    /**
     * serialVersionUIDB
     */
    private static final long serialVersionUID = 6414107453404025742L;

    /**
     * —\–ñ”Ô†B
     */
    private String reserveNo = null;

    /**
     * ŒÚ‹qî•ñB
     */
    private TourUVO USER_VALUE_OBJECT = null;

    
    /**
     * —\–ñ”Ô†‚ğ•Ô‚·B
     * @return —\–ñ”Ô†
     */
    public String getReserveNo() {
    
        return reserveNo;
    }

    
    /**
     * —\–ñ”Ô†‚ğİ’è‚·‚éB
     * @param reserveNo —\–ñ”Ô†
     */
    public void setReserveNo(String reserveNo) {
    
        this.reserveNo = reserveNo;
    }

    
    /**
     * ŒÚ‹qî•ñ‚ğ•Ô‚·B
     * @return ŒÚ‹qî•ñ
     */
    public TourUVO getUSER_VALUE_OBJECT() {
    
        return USER_VALUE_OBJECT;
    }

    
    /**
     * ŒÚ‹qî•ñ‚ğİ’è‚·‚éB
     * @param user_value_object ŒÚ‹qî•ñ
     */
    public void setUSER_VALUE_OBJECT(TourUVO user_value_object) {
    
        USER_VALUE_OBJECT = user_value_object;
    }

}
