/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */

package jp.terasoluna.toursample.uc_a01_01.exception;

import jp.terasoluna.toursample.common.exception.ApplicationException;


/**
 * 予約の締め切りを過ぎた場合の例外クラス
 * 
 * 
 * 
 */
public class ReservationDeadlinePassedException extends ApplicationException{
	
    /**
     * シリアルバージョンUID。
     */

	private static final long serialVersionUID = -8690598843622842626L;

	/**
     * コンストラクタ。
     * 
     * @param errorCode
     *            エラーコード
     */
    public ReservationDeadlinePassedException(String errorCode) {

        super(errorCode);
    }

}
