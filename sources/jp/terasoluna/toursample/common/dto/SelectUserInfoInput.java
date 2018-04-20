package jp.terasoluna.toursample.common.dto;

import java.io.Serializable;

public class SelectUserInfoInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4869711719869633746L;

    /**
     * 顧客コード。
     */
    private String customerCode = null;

    /**
     * 顧客パスワード。
     */
    private String customerPass = null;
    
    /**
     * 顧客コードを返す。
     * 
     * @return 顧客コード
     */

    public String getCustomerCode() {

        return customerCode;
    }

    /**
     * 顧客コードを設定する。
     * 
     * @param customerCode
     *            顧客コード
     */

    public void setCustomerCode(String customerCode) {

        this.customerCode = customerCode;
    }
    
    /**
     * 顧客パスワードを返す。
     * 
     * @return 顧客パスワード
     */

    public String getCustomerPass() {

        return customerPass;
    }

    /**
     * 顧客パスワードを設定する。
     * 
     * @param customerPass
     *            顧客パスワード
     */

    public void setCustomerPass(String customerPass) {

        this.customerPass = customerPass;
    }
}
