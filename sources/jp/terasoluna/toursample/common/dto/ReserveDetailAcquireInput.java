/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.dto;

import java.io.Serializable;

/**
 * —\–ñÚ×î•ñ‚ÌŒŸõğŒ‚ğŠi”[‚·‚éƒNƒ‰ƒXB
 * <br>
 * E‹¤’Êˆ—CP0006F—\–ñÚ×æ“¾
 * 
 * 
 */
public class ReserveDetailAcquireInput implements Serializable {
    
    /**
     * ƒVƒŠƒAƒ‹ƒo[ƒWƒ‡ƒ“UIDB
     */
    private static final long serialVersionUID = -4602719187723119151L;

    /**
     * —\–ñ”Ô†B
     */
    private String reserveNo = null;

    /**
     * ŒÚ‹qIDB
     */
    private String customerCode = null;

    /**
     * ŒÚ‹qID‚ğ•Ô‚·B
     * @return ŒÚ‹qID
     */
    
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * ŒÚ‹qID‚ğİ’è‚·‚éB
     * @param customerCode ŒÚ‹qID
     */
    
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

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
    
    

}
