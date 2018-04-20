package jp.terasoluna.toursample.uc_a01_02.dto;

import java.io.Serializable;
import java.util.Date;

public class SelectReservationInfoInput implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -6557299851626576485L;

    /**
     * 予約番号。
     */
    private String customerCode = null;

    /**
     * システム日付。
     */
    private Date today = null;

    /**
     * 予約番号を返す。
     * 
     * @return 予約番号
     */
    public String getCustomerCode() {

        return customerCode;
    }

    /**
     * 予約番号を設定する。
     * 
     * @param customerCode
     *            予約番号
     */
    public void setCustomerCode(String customerCode) {

        this.customerCode = customerCode;
    }

    /**
     * システム日付を返す。
     * 
     * @return システム日付
     */
    public Date getToday() {

        return today;
    }

    /**
     * システム日付を設定する。
     * 
     * @param today
     *            システム日付
     */
    public void setToday(Date today) {

        this.today = today;
    }

}
