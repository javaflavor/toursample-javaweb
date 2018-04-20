/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a99_01.blogic;

import jp.terasoluna.toursample.common.TourUVO;

/**
 * ログイン処理を行うビジネスロジックインタフェース。<br>
 * <br>
 * ・ユースケースUC_A99_01：顧客ログイン<br>
 * <br>
 * 入力された顧客IDとパスワードを利用しログイン処理を行う。<br>
 * ログイン可能の場合はUVO(顧客情報)を生成し返す。<br>
 * ログイン不可能の場合はnullを返す。
 * 
 * @see jp.terasoluna.toursample.common.TourUVO
 * 
 */
public interface RP_A99_01_02_02BLogic {

    /**
     * ログイン処理を行う。<br>
     * ログイン処理の結果としてUVOインスタンスを返す。
     * 
     * @param customerCode
     *            入力された顧客ID
     * @param customerPass
     *            入力されたパスワード
     * 
     * @return 顧客情報
     */
    public TourUVO executeLogin(String customerCode, String customerPass);
}
