/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a99_03.dto;

import java.io.Serializable;

/**
 * Úqo^rWlXWbNÌoÍîñÛNXB<br>
 * 
 * EUC_A99_03FÚqo^
 * 
 * 
 */
public class RP_A99_03_02_01Output implements Serializable {

    /**
     * VAo[WUIDB
     */
    private static final long serialVersionUID = 3822549983670186061L;

    /**
     *VKÚqIDB
     */
    private String customerCode = null;

    
    /**
     * VKÚqIDðÔ·B
     * @return VKÚqID
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * VKÚqIDðÝè·éB
     * @param customerCode VKÚqID
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

}