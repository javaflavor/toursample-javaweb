/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.validator;

import jp.terasoluna.fw.web.struts.form.MultiFieldValidator;

/**
 * 比較元と比較対象が一致するか判定するカスタムバリデータ。<br>
 * <br>
 * ・共通処理CP0003：一致検証
 * 
 * 
 * 
 */
public class MatchValidator implements MultiFieldValidator {

    /**
     * 与えられた比較元と比較対象を比較し、一致するかチェックする。
     * 
     * @param value
     *            比較元
     * @param fields
     *            <br>
     *            [0]: 比較対象
     * @return 一致する: true 一致しない: false
     */
    public boolean validate(String value, String[] fields) {

        // 文字列比較を行なう。
        return value.equals(fields[0]);
    }

}
