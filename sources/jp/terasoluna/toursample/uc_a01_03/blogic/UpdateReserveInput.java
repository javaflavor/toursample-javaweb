package jp.terasoluna.toursample.uc_a01_03.blogic;

import java.io.Serializable;

public class UpdateReserveInput implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = -6113309330672265182L;

	/**
     * 予約番号。
     */
    private String reserveNo = null;
       
    /**
     * 人数（大人）。
     */
    private Integer adultCount = null; 
    
    /**
     * 人数（子ども）。
     */
    private Integer childCount = null;
    
    /**
     *合計料金。
     */
    private Integer sumPrice = null;
    
    /**
     * ご意見ご要望。
     */
    private String remarks = null;

    /**
     * 人数（大人）を返す。
     * @return 人数（大人）
     */
    public Integer getAdultCount() {
        return adultCount;
    }
    
    /**
     * 人数（大人）を設定する。
     * @param adultCount 人数（大人）
     */
    public void setAdultCount(Integer adultCount) {
        this.adultCount = adultCount;
    }
    
    /**
     * 人数（子ども）を返す。
     * @return 人数（子ども）
     */
    public Integer getChildCount() {
        return childCount;
    }
    
    /**
     * 人数（子ども）を設定する。
     * @param childCount 人数（子ども）
     */
    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }
    
    /**
     * ご意見ご要望を返す。
     * @return ご意見ご要望
     */
    public String getRemarks() {
        return remarks;
    }
    
    /**
     * ご意見ご要望を設定する。
     * @param remarks ご意見ご要望
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
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

    /**
     * 合計料金を返す。
     * @return 合計料金
     */
    public Integer getSumPrice() {
        return sumPrice;
    }

    /**
     * 合計料金を設定する。
     * @param sumPrice 合計料金
     */
    public void setSumPrice(Integer sumPrice) {
        this.sumPrice = sumPrice;
    }
    
}

