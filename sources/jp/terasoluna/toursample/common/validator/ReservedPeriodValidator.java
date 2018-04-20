/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.validator;

import java.util.Calendar;
import java.util.GregorianCalendar;

import jp.terasoluna.fw.web.struts.form.MultiFieldValidator;

/**
 * 予約可能期間か判定するカスタムバリデータ。<br>
 * <br>
 * ・共通処理CP0008：予約可能日付検証
 * 
 * 
 * 
 */
public class ReservedPeriodValidator implements MultiFieldValidator {

    /**
     * 与えられた年、月、日が予約可能期間であるか検証する。<br>
     * 現在年月日＋7日 <= 与えられた年月日 であればtrue、そうでなければfalseを返す。
     * @param value
     *            年。yyyy形式である
     * @param fields
     *            <br>
     *            [0]: 月。M形式、またはMM形式である<br>
     *            [1]: 日。d形式、またはdd形式である<br>
     * @return 予約可能期間である: true<br>
     *         予約可能期間ではない: false<br>
     */
    public boolean validate(String value, String[] fields) {

        // 入力された年、月、日を日付型に変換する。
        Calendar input = new GregorianCalendar(Integer.parseInt(value), Integer
            .parseInt(fields[0]) - 1, Integer.parseInt(fields[1]));

        // 本日の日付を取得する。
        Calendar calendar = Calendar.getInstance();

        // 予約不可能期間の境界値を取得する。
        calendar.add(Calendar.DAY_OF_YEAR, 6);

        // 入力された日付が予約可能期間かチェックする。
        return input.after(calendar);
    }

}
