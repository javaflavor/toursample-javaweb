/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.taglib;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.html.Constants;
import org.apache.struts.taglib.html.SelectTag;

/**
 * 年,月,日のOptionタグを出力するタグクラス。<br>
 * <br>
 * ・共通処理CP0004：日付リストボックスoptionタグ生成処理
 * <br>
 * <br><code>selected="true"</code>とした場合、現在年月日＋plusDayの年月日に
 * selectedを指定するOptionタグを出力する。
 * <br>年の出力範囲は現在年月日+plusDayの年から始めて2年とする。
 * <br><code>selected="false"</code>とした場合、Formの年月日をselected指定する。
 * Formに情報がない場合はselected指定はせず、現在年、1月、1日が表示されること
 * になる。<br>
 * 年,月,日のどれを出力するかは、<code>var ="day"</code>のように指定する。
 * （必須）<br>
 * 注意：セレクトタグの値を参照するため、＜html:select＞の内部で使用すること。
 * <br>
 * 注意：30日までの月、うるう年計算は行わず、動的に日が変わるような動作は
 * しない。<br>
 * 使用例：
 * <pre>
 * <code>
 * &lt;html:select property=&quot;checkinYear&quot;&gt;
 *   &lt;thz:currentDateOptions var =&quot;year&quot; selected=&quot;true&quot; plusDay=&quot;1&quot;/&gt;
 * &lt;/html:select&gt;年
 *
 * &lt;html:select property=&quot;checkinMonth&quot;&gt;
 *   &lt;thz:currentDateOptions var =&quot;month&quot; selected=&quot;true&quot; plusDay=&quot;1&quot;/&gt;
 * &lt;/html:select&gt;月
 * &lt;html:select property=&quot;checkinDay&quot; &gt;
 *   &lt;thz:currentDateOptions var =&quot;day&quot; selected=&quot;true&quot; plusDay=&quot;1&quot;/&gt;
 * &lt;/html:select&gt;日
 *</code>
 *</pre>
 *翌日の年月日がselected指定されるセレクトボックスが出力される。
 *
 * 
 * 
 */
public class CurrentDateOptionsTag extends TagSupport {

    /**
     * シリアルバージョンUID。
     */
    private static final long serialVersionUID = -4412220224778697609L;

    /**
     * 年月日種別。
     * どのフィールドを出力するかを決定する。
     * year, month, day を指定する。デフォルトはmonth。
     */
    private String var = null;

    /**
     * 何日後を設定するかの日数。
     */
    private String plusDay = null;

    /**
     * selectedを追加するかどうか。
     */
    private boolean selected = true;

    /**
     * 年月日種別を設定する。
     * month,day を指定する。デフォルトはmonth。
     * 
     * @param var 年月日種別。yearかmonthかdayをとる
     */
    public void setVar(String var) {
        this.var = var;
    }

    /**
     * 何日後かを設定する。
     * 
     * @param plusDay 何日後か
     */
    public void setPlusDay(String plusDay) {
        this.plusDay = plusDay;
    }

    /**
     * セレクト状態を設定する。
     * 
     * @param selected セレクトされていれば真
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    /**
     * タグ評価開始時に呼ばれるメソッド。
     *
     * @return 処理制御指示。常に <code>SKIP_BODY</code>
     * @exception JspException JSP例外
     */
    public int doStartTag() throws JspException {

        //出力する文字列
        StringBuilder result = new StringBuilder("");

        //selected指定する日付まで進める日数
        int plus = 0;

        if (!"".equals(plusDay) && (plusDay != null)) {
            plus = Integer.parseInt(plusDay);
        }

        Calendar calendar = Calendar.getInstance();
        //進めた先の日付を取得
        calendar.add(Calendar.DATE, plus);
        
        if (var != null && !"".equals(var)) {
            
            //年月日のどれを出力するか
            //月指定の場合
            if ("month".equals(var)) {

                for (int i = 1; i < 13; i++) {
                    //Optionタグ(value属性)の出力
                    result.append("\n<option value= \"" + String.valueOf(i)
                            + "\"");
                    //selected指定されている場合、現在年月日+plusDayの月にselectedを付与する
                    //指定されていない場合、フォーム内と同じ月にselectedを
                    //付与する
                    if ((selected && i == calendar.get(Calendar.MONTH) + 1)
                            || (!selected && this.selectTag().isMatched(
                                    String.valueOf(i)))) {
                        //selected属性の出力
                        result.append(" selected=\"selected\"");
                    }
                    //Optionタグ(ボディ部)の出力。
                    //HTMLを出力するため、閉じタグはなし。
                    result.append(">");
                    result.append(String.valueOf(i));
                    //Optionタグを閉じる。
                    result.append("</option>");
                }
                //日指定の場合
            } else if ("day".equals(var)) {
                //日を指定数分、進める
                for (int i = 1; i < 32; i++) {
                    result.append("\n<option value= \"" + String.valueOf(i)
                            + "\"");
                    //selected指定されている場合、現在年月日+plusDayの日にselectedを付与する
                    //指定されていない場合、フォーム内と同じ日にselectedを
                    //付与する
                    if ((selected && i == calendar.get(Calendar.DATE))
                            || (!selected && this.selectTag().isMatched(
                                    String.valueOf(i)))) {
                        //selected属性の出力
                        result.append(" selected=\"selected\"");
                    }
                    //Optionタグ(ボディ部)の出力。
                    //HTMLを出力するため、閉じタグはなし。
                    result.append(">");
                    result.append(String.valueOf(i));
                    //Optionタグを閉じる。
                    result.append("</option>");
                }
                //年指定の場合                
            } else if ("year".equals(var)){
                //年を指定数分、進める
                for (int i = 0; i < 2; i++) {
                    result.append("\n<option value= \"" +
                            String.valueOf(i + calendar.get(Calendar.YEAR))
                            + "\"");
                    //selected指定されている場合、現在年月日+plusDayの年にselectedを付与する
                    //指定されていない場合、フォーム内と同じ年にselectedを
                    //付与する
                    if ((selected && i == 0)||
                       (!selected && this.selectTag().isMatched(
                                    String.valueOf(i + calendar.
                                            get(Calendar.YEAR))))) {
                        //selected属性の出力
                        result.append(" selected=\"selected\"");
                    }
                    //Optionタグ(ボディ部)の出力。
                    result.append(">");
                    result.append(
                            String.valueOf(i + calendar.get(Calendar.YEAR)));
                    //Optionタグを閉じる。
                    result.append("</option>");
                }
            }
            
        }

        try {
            //生成したタグの出力
            pageContext.getOut().print(result.toString());
        } catch (Exception ex) {
            throw new JspException(ex);
        }
        //スキップボディを返却
        return SKIP_BODY;
    }

    /**
     * ページコンテキストのセレクトタグの参照を取得する。
     */
    private SelectTag selectTag() throws JspException {
        SelectTag selectTag = (SelectTag) pageContext
                .getAttribute(Constants.SELECT_KEY);

        if (selectTag == null) {
            throw new JspException();
        }

        return selectTag;
    }
}