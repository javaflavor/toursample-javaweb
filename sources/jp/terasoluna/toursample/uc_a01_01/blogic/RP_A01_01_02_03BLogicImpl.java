/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.blogic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.toursample.common.exception.TourSystemException;
import jp.terasoluna.toursample.uc_a01_01.dto.RP_A01_01_02_03Input;
import jp.terasoluna.toursample.uc_a01_01.dto.RP_A01_01_02_03Output;
import jp.terasoluna.toursample.uc_a01_01.dto.SearchCondition;


/**
 * ツアー予約登録条件取得ビジネスロジック。<br>
 * RP_A01_01_02_02BLogicでバックアップしたツアー検索条件を取得し、フォームへの
 * 反映を行なう。<br>
 * バックアップしたツアー検索条件の取得に失敗した場合は
 * {@link TourSystemException}が発生される。
 * 
 * 
 * 
 * 
 */
public class RP_A01_01_02_03BLogicImpl
        implements BLogic<RP_A01_01_02_03Input> {

    /**
     * ログクラス。
     */
    private static final Log log = 
        LogFactory.getLog(RP_A01_01_02_03BLogicImpl.class);

    /**
     * セッションからバックアップしたツアー検索条件の取得に失敗した場合の
     * エラーメッセージコード。
     */
    private static final String GET_CONDITION_ERROR =
        "error.UC_A01_01.00003";
    
    /**
     * セッションに設定されていた条件格納オブジェクトから 検索条件を取得し、
     * successを返却する。<br>
     * 取得できなかった場合は{@link TourSystemException}が発生される。
     * 
     * @param param
     *            条件格納オブジェクト
     * @return 検索条件
     * 
     * @throws TourSystemException ツアー検索条件格納オブジェクトの取得に
     *              失敗した場合
     */
    public BLogicResult execute(RP_A01_01_02_03Input param) {

        // 返却値を生成する。
        BLogicResult result = new BLogicResult();

        // セッションに入れるオブジェクトを生成する。
        RP_A01_01_02_03Output output = new RP_A01_01_02_03Output();

        // 条件が取得できなかったときにはエラーを返却する
        if (param.getCondition() == null) {
            if (log.isErrorEnabled()) {
                log.error(GET_CONDITION_ERROR + ": パックアップしたツアー検索"
                            + "条件の取得が失敗しました。");
            }
            throw new TourSystemException(GET_CONDITION_ERROR);
            
        } else {

            // 条件を取得し出力値にセットする。
            SearchCondition condition = param.getCondition();
            output.setAdultCountCondition(condition.getAdultCountCondition());
            output.setArrCodeCondition(condition.getArrCodeCondition());
            output.setBasePriceCondition(condition.getBasePriceCondition());
            output.setChildCountCondition(condition.getChildCountCondition());
            output.setDepCodeCondition(condition.getDepCodeCondition());
            output.setDepDayDayCondition(condition.getDepDayDayCondition());
            output.setDepDayMonthCondition(condition.getDepDayMonthCondition());
            output.setDepDayYearCondition(condition.getDepDayYearCondition());
            output.setTourCode(condition.getTourCode());
            output.setTourDaysCondition(condition.getTourDaysCondition());
            output.setStartIndex(condition.getStartIndex());
            output.setRow(condition.getRow());

            // 返却値に設定する
            result.setResultString("success");
            result.setResultObject(output);
            return result;
        }
    }
}
