/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.exception;

/**
 * データベースから取得した結果がない場合に発生する例外クラス。<br>
 *
 * <p>
 * 業務ロジック上、データベースから取得した結果がない場合発生する例外クラス。<br>
 * 本クラスにはメッセージキーとメッセージ置換文字列を設定することができる。
 * 但し、メッセージ取得、及びプレースホルダの置換は別のクラスで実行し、
 * 再度 {@link #setMessage(String)} を実行してメッセージを設定する必要がある。
 * メッセージが設定されていない状態で、{@link #getMessage()}
 * メソッドを用いてメッセージを取得するとメッセージキーが返却される。
 * 従って、メッセージ置換が行えないような状況で本クラスを使用する場合は、
 * コンストラクタのerrorCodeに、メッセージキーではなくエラーコードや
 * エラーメッセージを直接設定すること。
 * </p>
 * 
 * @see ApplicationException
 * @see ApplicationExceptionHandler
 * 
 */
public class RecordNotFoundException extends ApplicationException {

    /**
     * シリアルバージョンID。
     */
    private static final long serialVersionUID = -8552491938681652508L;

    /**
     * コンストラクタ。
     *
     * @param errorCode エラーコード
     */
    public RecordNotFoundException(String errorCode) {
        super(errorCode);
    }

    /**
     * コンストラクタ。
     *
     * @param errorCode エラーコード
     * @param optionStrings メッセージ中の{n}を置換する文字列の配列
     */
    public RecordNotFoundException(String errorCode,
                                 String[] optionStrings) {
        super(errorCode,optionStrings);
    }

    /**
     * コンストラクタ。
     *
     * @param errorCode エラーコード
     * @param s0 エラーメッセージ中の{0}を置換する文字列
     */
    public RecordNotFoundException(String errorCode,
                                 String s0) {
        super(errorCode, s0);
    }

    /**
     * コンストラクタ。
     *
     * @param errorCode エラーコード
     * @param s0 エラーメッセージ中の{0}を置換する文字列
     * @param s1 エラーメッセージ中の{1}を置換する文字列
     */
    public RecordNotFoundException(String errorCode,
                                 String s0,
                                 String s1) {
        super(errorCode, s0, s1);
    }

    /**
     * コンストラクタ。
     *
     * @param errorCode エラーコード
     * @param s0 エラーメッセージ中の{0}を置換する文字列
     * @param s1 エラーメッセージ中の{1}を置換する文字列
     * @param s2 エラーメッセージ中の{2}を置換する文字列
     */
    public RecordNotFoundException(String errorCode,
                                 String s0,
                                 String s1,
                                 String s2) {
        super(errorCode, s0, s1, s2);
    }

    /**
     * コンストラクタ。
     *
     * @param errorCode エラーコード
     * @param s0 エラーメッセージ中の{0}を置換する文字列
     * @param s1 エラーメッセージ中の{1}を置換する文字列
     * @param s2 エラーメッセージ中の{2}を置換する文字列
     * @param s3 エラーメッセージ中の{3}を置換する文字列
     */
    public RecordNotFoundException(String errorCode,
                                 String s0,
                                 String s1,
                                 String s2,
                                 String s3) {
        super(errorCode, s0, s1, s2, s3);
    }

    /**
     * コンストラクタ。
     *
     * @param cause 原因となった例外
     */
    public RecordNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * コンストラクタ。
     *
     * @param cause 原因となった例外
     * @param errorCode エラーコード
     */
    public RecordNotFoundException(Throwable cause,
                            String errorCode) {
        super(cause, errorCode);
    }

    /**
     * コンストラクタ。
     *
     * @param cause 原因となった例外
     * @param errorCode エラーコード
     * @param optionStrings メッセージ中の{n}を置換する文字列の配列
     */
    public RecordNotFoundException(Throwable cause,
                                 String errorCode,
                                 String[] optionStrings) {
        super(cause, errorCode, optionStrings);
    }

    /**
     * コンストラクタ。
     *
     * @param cause 原因となった例外
     * @param errorCode エラーコード
     * @param s0 エラーメッセージ中の{0}を置換する文字列
     */
    public RecordNotFoundException(Throwable cause,
                                 String errorCode,
                                 String s0) {
        super(cause, errorCode, s0);
    }

    /**
     * コンストラクタ。
     *
     * @param cause 原因となった例外
     * @param errorCode エラーコード
     * @param s0 エラーメッセージ中の{0}を置換する文字列
     * @param s1 エラーメッセージ中の{1}を置換する文字列
     */
    public RecordNotFoundException(Throwable cause,
                                 String errorCode,
                                 String s0,
                                 String s1) {
        super(cause, errorCode, s0, s1);
    }

    /**
     * コンストラクタ。
     *
     * @param cause 原因となった例外
     * @param errorCode エラーコード
     * @param s0 エラーメッセージ中の{0}を置換する文字列
     * @param s1 エラーメッセージ中の{1}を置換する文字列
     * @param s2 エラーメッセージ中の{2}を置換する文字列
     */
    public RecordNotFoundException(Throwable cause,
                                 String errorCode,
                                 String s0,
                                 String s1,
                                 String s2) {
        super(cause, errorCode, s0, s1, s2);
    }

    /**
     * コンストラクタ。
     *
     * @param cause 原因となった例外
     * @param errorCode エラーコード
     * @param s0 エラーメッセージ中の{0}を置換する文字列
     * @param s1 エラーメッセージ中の{1}を置換する文字列
     * @param s2 エラーメッセージ中の{2}を置換する文字列
     * @param s3 エラーメッセージ中の{3}を置換する文字列
     */
    public RecordNotFoundException(Throwable cause,
                                 String errorCode,
                                 String s0,
                                 String s1,
                                 String s2,
                                 String s3) {
        super(cause, errorCode, s0, s1, s2, s3);
    }

}
