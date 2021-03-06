/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_03.exception;

import jp.terasoluna.toursample.common.exception.ApplicationException;

/**
 * 予約を変更できない場合の例外クラス。
 * 
 * 
 * 
 */
public class CannotEditException extends ApplicationException {

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
    public CannotEditException(String errorCode) {

        super(errorCode);
    }
}
