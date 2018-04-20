/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_05.blogic;

import java.util.List;

import jp.terasoluna.toursample.uc_a01_05.dto.RP_A01_05_01_01Input;
import jp.terasoluna.toursample.uc_a01_05.dto.RP_A01_05_01_01Output;

/**
 * 帳票出力情報取得ビジネスロジックのインターフェイスクラス。
 * 
 * 
 * 
 */
public interface RP_A01_05_01_01BLogic {

    /**
     * 帳票出力情報をリストで取得する。 <BR>
     * 帳票出力情報取得条件と一致するツアー予約詳細情報を返却する。
     * 
     * @param param
     *            帳票出力情報取得条件
     * @return 帳票出力情報リスト
     */
    List<RP_A01_05_01_01Output> selectReportData(RP_A01_05_01_01Input param);

}