/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_05.dto;

import java.io.Serializable;

import jp.terasoluna.toursample.common.TourUVO;

/**
 * RP_A01_05_01_01BLogic‚Ì“ü—Í’lƒNƒ‰ƒXB
 *
 * 
 */
public class RP_A01_05_01_01Input implements Serializable {

    /**
     * serialVersionUIDB
     */
    private static final long serialVersionUID = -7823029922697449605L;

    /**
     * —\–ñ”Ô†B
     */
    private String reserveNo = null;
    
    /**
     * ŒÚ‹qî•ñB
     */
    private TourUVO tourUVO = null;

    
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
    public TourUVO getTourUVO() {
    
        return tourUVO;
    }

    
    /**
     * ŒÚ‹qî•ñ‚ğİ’è‚·‚éB
     * @param tourUVO ŒÚ‹qî•ñ
     */
    public void setTourUVO(TourUVO tourUVO) {
    
        this.tourUVO = tourUVO;
    }
}