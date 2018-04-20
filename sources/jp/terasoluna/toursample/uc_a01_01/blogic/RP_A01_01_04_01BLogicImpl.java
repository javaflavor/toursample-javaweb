/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *ac
 */
package jp.terasoluna.toursample.uc_a01_01.blogic;

import java.util.HashMap;
import java.util.Map;

import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;

/**
 * ツアー予約完了画面からツアー検索画面遷移時、検索条件・結果のクリアを行なう
 * ビジネスロジック<br>
 * 
 * ツアー予約完了後ツアー検索画面を表示時、初期状態で表示するための処理である。
 * <br>
 * 
 * 
 */

public class RP_A01_01_04_01BLogicImpl implements BLogic<Object> {

     /**
      * ツアー検索条件と結果のクリア処理を行なう。<br>
      * ツアー登録完了後、ツアー検索画面に遷移するとき、前回の検索内容を
      * クリアするための処理である。
      * 
      * @param param 入力値。
      * @return クリア情報。
      */
     public BLogicResult execute(Object param) {

        // 実行結果を用意する。
        BLogicResult result = new BLogicResult();

        // 出力情報を格納するクラスを生成する。
        Map<String, Object> resultObject = new HashMap<String, Object>();
        
        // クリアするプロパティを設定する。
        resultObject.put("arrCodeCondition", null);
        resultObject.put("depCodeCondition", null);
        resultObject.put("depDayYearCondition", null);
        resultObject.put("depDayMonthCondition", null);
        resultObject.put("depDayDayCondition", null);
        resultObject.put("tourDaysCondition", null);
        resultObject.put("adultCountCondition", null);
        resultObject.put("childCountCondition", null);
        resultObject.put("basePriceCondition", null);
        resultObject.put("tourInfoList", null);
        resultObject.put("allListInfoLineCount", 0);
        
        // 結果をセットする。
        result.setResultObject(resultObject);
        result.setResultString("success");
        return result;
    }
}
