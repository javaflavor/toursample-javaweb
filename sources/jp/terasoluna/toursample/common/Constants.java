/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common;

import java.io.Serializable;

/**
 * 定数フィールド値の設定クラス。
 * <p>
 * 　・PAYMENT_METHOD:支払方法<br>
 * 　・PAYMENT_COMPANY_NAME:銀行名<br>
 * 　・PAYMENT_ACCOUNT:銀行口座<br>
 * 　・COMPANY_NAME:問合せ先名<br>
 * 　・COMPANY_MAIL:問合せ先メールアドレス<br>
 * 　・COMPANY_TEL:問合せ先電話番号
 * </p>
 * 
 * 
 *
 */
public class Constants implements Serializable {

    /**
     * serialVersionUID。
     */
    private static final long serialVersionUID = -3092695814650199675L;

    /**
     * プロパティファイルの支払方法。
     */
    public static final String PAYMENT_METHOD = "payment.method";
    
    /**
     * プロパティファイルの銀行名。
     */
    public static final String PAYMENT_COMPANY_NAME = "payment.company.name";
    
    /**
     * プロパティファイルの銀行口座。
     */
    public static final String PAYMENT_ACCOUNT = "payment.account";
    
    /**
     * プロパティファイルの問合せ先名。
     */
    public static final String COMPANY_NAME = "company.name";
    
    /**
     * プロパティファイルの問合せ先メールアドレス。
     */
    public static final String COMPANY_MAIL = "company.mail";
    
    /**
     * プロパティファイルの問合せ先電話番号。
     */
    public static final String COMPANY_TEL = "company.tel";

}