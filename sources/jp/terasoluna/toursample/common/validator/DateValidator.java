/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.validator;

import jp.terasoluna.fw.web.struts.form.MultiFieldValidator;
import jp.terasoluna.toursample.common.util.DateUtil;

/**
 * 与えられた年、月、日を組み合わせた日付が、<br>
 * カレンダー上に存在するか チェックするカスタムバリデータ。<br>
 * <br>
 * ・共通処理CP0001：年月日検証
 * 
 * 
 * 
 */
public class DateValidator implements MultiFieldValidator {

    /**
     * 与えられた年、月、日を組み合わせた日付が、<br>
     * カレンダー上に存在するか チェックする。
     * 
     * @param value
     *            年。yyyy形式である
     * @param fields
     *            <br>
     *            [0]: 月。M形式、またはMM形式である<br>
     *            [1]: 日。d形式、またはdd形式である<br>
     * @return 与えられた年月日がカレンダー上に存在する:true<br>
     *         カレンダー上に存在しない: false
     */
    public boolean validate(String value, String[] fields) {

        // 存在可否をチェックする。
        return DateUtil.isExists(value, fields[0], fields[1]);
    }

}
