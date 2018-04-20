/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *ac
 */
package jp.terasoluna.toursample.uc_a01_01.blogic;

import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.toursample.uc_a01_01.dto.RP_A01_01_01_02Output;

/**
 * <p>
 * ツアー検索入力エラー時の結果クリア処理を行なうビジネスロジック
 * </p>
 * 
 * 
 */

public class RP_A01_01_01_02_01BLogicImpl implements BLogic<Object> {

     /**
      * 結果クリア処理を行なう。<br>
      * <br>
      * 1:入力情報とコードリスト情報から検索条件を生成して、検索情報を取得する。
      * <br>
      * 2:入力エラーにつき、検索結果の出力クラスに入る結果は初期状態のまま。 
      * <br>
      * 3:ページリンク機能も実装する。
      * 
      * @param param 入力値。
      * @return クリアされた検索結果。
      */
     public BLogicResult execute(Object param) {

        // 実行結果を用意する。
        BLogicResult result = new BLogicResult();

        // 出力情報を格納するクラスを生成する。
        RP_A01_01_01_02Output rp_a01_01_01_02Output = 
            new RP_A01_01_01_02Output();
        
        // 結果をセットする。
        result.setResultObject(rp_a01_01_01_02Output);
        result.setResultString("success");
        return result;
    }
}
