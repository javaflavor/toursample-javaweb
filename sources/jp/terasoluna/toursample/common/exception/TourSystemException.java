/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.exception;

/**
 * 業務ロジックから発生するシステム例外クラス。<br>
 *
 * <p>
 * 業務ロジック上、システム例外として例外を発生したい場合に生成するシステム例外
 * クラスである。<br>
 * 本クラスにはメッセージキーとメッセージ置換文字列を設定することができる。
 * 但し、メッセージ取得、及びプレースホルダの置換は別のクラスで実行し、
 * 再度 {@link #setMessage(String)} を実行してメッセージを設定する必要がある。
 * メッセージが設定されていない状態で、{@link #getMessage()}
 * メソッドを用いてメッセージを取得するとメッセージキーが返却される。
 * 従って、メッセージ置換が行えないような状況で本クラスを使用する場合は、
 * コンストラクタのerrorCodeに、メッセージキーではなくエラーコードや
 * エラーメッセージを直接設定すること。
 * </p>
 * @see ApplicationException
 * @see ApplicationExceptionHandler
 * 
 * 
 */
public class TourSystemException extends ApplicationException {

    /**
     * シリアルバージョンID。
     */
    private static final long serialVersionUID = -7911561953281923358L;

    /**
     * コンストラクタ。
     */
    public TourSystemException() {
        super();
    }

    /**
     * コンストラクタ。
     *
     * @param errorCode エラーコード
     */
    public TourSystemException(String errorCode) {
        super(errorCode);
    }

    /**
     * コンストラクタ。
     *
     * @param errorCode エラーコード
     * @param optionStrings メッセージ中の{n}を置換する文字列の配列
     */
    public TourSystemException(String errorCode,
                                 String[] optionStrings) {
        super(errorCode, optionStrings);
    }

    /**
     * コンストラクタ。
     *
     * @param errorCode エラーコード
     * @param s0 エラーメッセージ中の{0}を置換する文字列
     */
    public TourSystemException(String errorCode,
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
    public TourSystemException(String errorCode,
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
    public TourSystemException(String errorCode,
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
    public TourSystemException(String errorCode,
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
    public TourSystemException(Throwable cause) {
        super(cause);
    }

    /**
     * コンストラクタ。
     *
     * @param cause 原因となった例外
     * @param errorCode エラーコード
     */
    public TourSystemException(Throwable cause,
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
    public TourSystemException(Throwable cause,
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
    public TourSystemException(Throwable cause,
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
    public TourSystemException(Throwable cause,
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
    public TourSystemException(Throwable cause,
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
    public TourSystemException(Throwable cause,
                                 String errorCode,
                                 String s0,
                                 String s1,
                                 String s2,
                                 String s3) {
        super(cause, errorCode, s0, s1, s2, s3);
    }

}
