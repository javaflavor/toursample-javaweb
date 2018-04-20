/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common;

import java.util.Date;

import jp.terasoluna.fw.web.UserValueObject;

/**
 * ƒcƒA[—\–ñƒVƒXƒeƒ€‚ÌŒÚ‹qî•ñƒNƒ‰ƒX
 * <p>
 * ƒƒOƒCƒ“‚µ‚½ŒÚ‹q‚ÌŒÚ‹qî•ñ‚ğ•Û‚·‚éB
 * </p>
 * 
 * @see jp.terasoluna.fw.web.UserValueObject
 */
public class TourUVO extends UserValueObject {
    
    /**
     * ƒVƒŠƒAƒ‹ƒo[ƒWƒ‡ƒ“UIDB
     */
    private static final long serialVersionUID = -2080310363535630863L;

    /**
     * ŒÚ‹qIDB
     */
    private String customerCode = null;
    
    /**
     * ŒÚ‹q–¼B
     */
    private String customerName = null;
    
    /**
     * ŒÚ‹qƒtƒŠƒKƒiB
     */
    private String customerKana = null;
    
    /**
     * ŒÚ‹q¶”NŒ“úB
     */
    private Date customerBirth = null;
    
    /**
     * ŒÚ‹qE‹ÆB
     */
    private String customerJob = null;
    
    /**
     * ŒÚ‹qƒ[ƒ‹ƒAƒhƒŒƒXB
     */
    private String customerMail = null;
    
    /**
     * ŒÚ‹q“d˜b”Ô†B
     */
    private String customerTel = null;
    
    /**
     * ŒÚ‹q—X•Ö”Ô†B
     */
    private String customerPost = null;
    
    /**
     * ŒÚ‹qZŠB
     */
    private String customerAdd = null;
    
    /** 
     * ŒÚ‹qZŠ‚ğ•Ô‚·B
     * 
     * @return ŒÚ‹qZŠ
     */
    public String getCustomerAdd() {
        return customerAdd;
    }
    
    /**
     * ŒÚ‹qZŠ‚ğİ’è‚·‚éB
     * 
     * @param customerAdd ŒÚ‹qZŠ
     */
    public void setCustomerAdd(String customerAdd) {
        this.customerAdd = customerAdd;
    }
    
    /**
     * ŒÚ‹q¶”NŒ“ú‚ğ•Ô‚·B
     * 
     * @return ŒÚ‹q¶”NŒ“ú
     */
    public Date getCustomerBirth() {
        return customerBirth;
    }
    
    /**
     * ŒÚ‹q¶”NŒ“ú‚ğİ’è‚·‚éB
     * 
     * @param customerBirth ŒÚ‹q¶”NŒ“ú
     */
    public void setCustomerBirth(Date customerBirth) {
        this.customerBirth = customerBirth;
    }
    
    /**
     * ŒÚ‹qID‚ğ•Ô‚·B
     * 
     * @return ŒÚ‹qID
     */
    public String getCustomerCode() {
        return customerCode;
    }
    
    /**
     * ŒÚ‹qID‚ğİ’è‚·‚éB
     * 
     * @param customerCode ŒÚ‹qID
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
    
    /**
     * ŒÚ‹qE‹Æ‚ğ•Ô‚·B
     * 
     * @return ŒÚ‹qE‹Æ
     */
    public String getCustomerJob() {
        return customerJob;
    }
    
    /**
     * ŒÚ‹qE‹Æ‚ğİ’è‚·‚éB
     * @param customerJob ŒÚ‹qE‹Æ
     */
    public void setCustomerJob(String customerJob) {
        this.customerJob = customerJob;
    }
    
    /**
     * ŒÚ‹qƒtƒŠƒKƒi‚ğ•Ô‚·B
     * 
     * @return ŒÚ‹qƒtƒŠƒKƒi
     */
    public String getCustomerKana() {
        return customerKana;
    }
    
    /**
     * ŒÚ‹qƒtƒŠƒKƒi‚ğİ’è‚·‚éB
     * @param customerKana ŒÚ‹qƒtƒŠƒKƒi
     */
    public void setCustomerKana(String customerKana) {
        this.customerKana = customerKana;
    }
    
    /**
     * ŒÚ‹qƒ[ƒ‹ƒAƒhƒŒƒX‚ğ•Ô‚·B
     * 
     * @return ŒÚ‹qƒ[ƒ‹ƒAƒhƒŒƒX
     */
    public String getCustomerMail() {
        return customerMail;
    }
    
    /**
     * ŒÚ‹qƒ[ƒ‹ƒAƒhƒŒƒX‚ğİ’è‚·‚éB
     * @param customerMail ŒÚ‹qƒ[ƒ‹ƒAƒhƒŒƒX
     */
    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }
    
    /**
     * ŒÚ‹q–¼‚ğ•Ô‚·B
     * 
     * @return ŒÚ‹q–¼
     */
    public String getCustomerName() {
        return customerName;
    }
    
    /**
     * ŒÚ‹q–¼‚ğİ’è‚·‚éB
     * @param customerName ŒÚ‹q–¼
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    /**
     * ŒÚ‹q—X•Ö”Ô†‚ğ•Ô‚·B
     * 
     * @return ŒÚ‹q—X•Ö”Ô†
     */
    public String getCustomerPost() {
        return customerPost;
    }
    
    /**
     * ŒÚ‹q—X•Ö”Ô†‚ğİ’è‚·‚éB
     * @param customerPost ŒÚ‹q—X•Ö”Ô†
     */
    public void setCustomerPost(String customerPost) {
        this.customerPost = customerPost;
    }
    
    /**
     * ŒÚ‹q“d˜b”Ô†‚ğ•Ô‚·B
     * 
     * @return ŒÚ‹q“d˜b”Ô†
     */
    public String getCustomerTel() {
        return customerTel;
    }
    
    /**
     * ŒÚ‹q“d˜b”Ô†‚ğİ’è‚·‚éB
     * @param customerTel ŒÚ‹q“d˜b”Ô†
     */
    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }
    

}
