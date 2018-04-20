/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_04.form;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;

/**
 * UC_A01_04のアクションフォームクラス。
 * 
 * 
 */
public class UC_A01_04Form extends ValidatorActionFormEx {

    /**
	 * serialVersionUID 。
	 */
	private static final long serialVersionUID = -7306186094608736939L;

	/**
     * 予約番号。
     */
    private String reserveNo = null;

    /**
     * 予約情報。
     */
    private ReserveDetailAcquireOutput reserveDetail = null;

    /**
     * 遷移元画面ID。
     */
    private String returnCode = null;

    /**
     * 料金情報。
     */
    private PriceCalculateOutput price = null;

    /**
     * 予約番号を取得する。
     * 
     * @return reserveNo
     */
    public String getReserveNo() {

        return this.reserveNo;
    }

    /**
     * 予約番号を設定する。
     * 
     * @param reserveNo
     *            reserveNo
     */
    public void setReserveNo(String reserveNo) {

        this.reserveNo = reserveNo;
    }

    /**
     * 予約情報を取得する。
     * 
     * @return reserveDetail
     */
    public ReserveDetailAcquireOutput getReserveDetail() {

        return this.reserveDetail;
    }

    /**
     * 予約情報を設定する。
     * 
     * @param reserveDetail
     *            reserveDetail
     */
    public void setReserveDetail(ReserveDetailAcquireOutput reserveDetail) {

        this.reserveDetail = reserveDetail;
    }

    /**
     * 遷移元画面IDを取得する。
     * 
     * @return returnCode
     */
    public String getReturnCode() {

        return this.returnCode;
    }

    /**
     * 遷移元画面IDを設定する。
     * 
     * @param returnCode
     *            returnCode
     */
    public void setReturnCode(String returnCode) {

        this.returnCode = returnCode;
    }

    /**
     * 料金情報を取得する。
     * 
     * @return price
     */
    public PriceCalculateOutput getPrice() {

        return this.price;
    }

    /**
     * 料金情報を設定する。
     * 
     * @param price
     *            price
     */
    public void setPrice(PriceCalculateOutput price) {

        this.price = price;
    }

}