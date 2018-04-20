package jp.terasoluna.toursample.uc_a01_03.blogic;

import java.io.Serializable;

public class SelectNumberOfPersonInput implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8067389430846559432L;

	/**
     * ツアーコード
     */
    private String tourCode = null;
    
    /**
     * 予約番号
     */
    
    private String reserveNo = null;
    /**
     * ツアーコードを取得する。
     * 
     * @return tourCode
     */
    public String getTourCode() {

        return tourCode;
    }

    /**
     * ツアーコードを設定する。
     * 
     * @param tourCode
     */
    public void setTourCode(String tourCode) {

        this.tourCode = tourCode;
    }
    
    /**
     * 予約番号を取得する。
     * 
     * @return reserveNo
     */
    public String getReserveNo() {

        return reserveNo;
    }

    /**
     * 予約番号を設定する。
     * 
     * @param reserveNo
     */
    public void setReserveNo(String reserveNo) {

        this.reserveNo = reserveNo;
    }
}
