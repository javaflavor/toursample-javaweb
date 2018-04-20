/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.exception;

import jp.terasoluna.toursample.common.exception.ApplicationException;

/**
 * 残席数が足りない場合の例外クラス
 * 
 * 
 * 
 */
public class TourMemberOverException extends ApplicationException {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -403281476564897606L;

    /**
     * コンストラクタ。
     * 
     * @param errorCode
     *            エラーコード
     */
    public TourMemberOverException(String errorCode) {

        super(errorCode);
    }
}
