/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * ツアー予約システム 日付ユーティリティクラス
 * 
 * 
 */
public class DateUtil {

    /**
     * 数値の日数を泊日形式の日数に変換する。<br>
     * 日数が1の場合は、｢日帰り｣に変換する。 <br>
     * ・共通処理CP0010：日数変換処理
     * 
     * @param days
     *            数値の日数
     *         
     * @return 泊日形式の日数
     */
    public static String convertNightDays(Integer days) {

        // 日数が1の場合は「日帰り」を返す。
        if (days == 1) {
            return "日帰り";
        }

        // 形式変換を行なう。
        StringBuilder builder = new StringBuilder();

        builder.append(days.intValue() - 1);
        builder.append("泊");
        builder.append(days.intValue());
        builder.append("日");

        return builder.toString();
    }

    /**
     * 今日の日付を返す。<br>
     * 今日のシステム日付を取得し返す。
     * 
     * @return 今日の日付
     */
    public static Date getTodayDate() {

        return new Date();
    }

    /**
     * 年月日が存在するかどうか検証する。
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @param day
     *            日
     * @return true 存在する<br>
     *         false 存在しない<br>
     */
    public static boolean isExists(String year, String month, String day) {

        Calendar calendar = Calendar.getInstance();

        int inputYear = Integer.parseInt(year);
        int inputMonth = Integer.parseInt(month);
        int inputDay = Integer.parseInt(day);

        // カレンダーに日付を設定
        calendar.clear();
        calendar.set(Calendar.YEAR, inputYear);
        calendar.set(Calendar.MONTH, inputMonth - 1);
        calendar.set(Calendar.DAY_OF_MONTH, inputDay);

        // 日付が異なっていたら存在しない日付
        if (inputYear == calendar.get(Calendar.YEAR)
                && (inputMonth - 1) == calendar.get(Calendar.MONTH)
                && inputDay == calendar.get(Calendar.DAY_OF_MONTH)) {
            return true;
        }
        return false;
    }

    /**
     * 入力した日付の一週間前の日付を返す。<br>
     * 
     * @param date
     *            入力した日付
     */
    public static Date getOneWeekBeforeDate(Date date) {

        return getChangedByDaysDate(date, -7);
    }

    /**
     * 入力した日付から日数分変更された日付を返す。<br>
     * 
     * @param date
     *            入力した日付
     * @param days
     *            日数
     */
    public static Date getChangedByDaysDate(Date date, int days) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // 入力した日付から日数分日付を変更する。。
        calendar.add(Calendar.DAY_OF_YEAR, days);

        return calendar.getTime();
    }

}
