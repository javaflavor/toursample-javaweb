/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_03.exception;

import jp.terasoluna.toursample.common.exception.ApplicationException;

/**
 * 残席数が足りない場合の例外クラス<br>
 * 
 * ・UC_A01_03：ツアー予約変
 * 
 * 
 */
public class TourMemberOverException extends ApplicationException {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -2001295056875560430L;

    /**
     * コンストラクタ。
     * 
     * @param errorCode エラーコード
     */
    public TourMemberOverException(String errorCode) {
        super(errorCode);
    }

}