/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.blogic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.toursample.common.util.DateUtil;
import jp.terasoluna.toursample.uc_a01_01.dto.RP_A01_01_01_02Input;
import jp.terasoluna.toursample.uc_a01_01.dto.RP_A01_01_01_02Output;
import jp.terasoluna.toursample.uc_a01_01.dto.SelectTourInfoInput;
import jp.terasoluna.toursample.uc_a01_01.dto.TourInfo;

/**
 * <p>
 * ツアー検索情報取得ビジネスロジック。
 * ツアー予約登録検索リクエストとツアー予約ページリンク遷移リクエストを<br>
 * 合わせたクラス。
 * </p>
 * 
 * 
 * 
 */
public class RP_A01_01_01_02BLogicImpl 
    implements BLogic<RP_A01_01_01_02Input> {

    /**
     * 検索結果レコード数が0件の場合のメッセージ。
     */
    public static final String INFO_NOT_TOUR = "info.UC_A01_01.00003";

    /**
     * 検索結果レコード数が1件以上の場合のメッセージ。
     */
    public static final String INFO_TOUR = "info.common.00001";

    /**
     * ログクラス。
     */
    private static final Log log = 
        LogFactory.getLog(RP_A01_01_01_02BLogicImpl.class);

    /**
     * DAOクラス。 Springによりインスタンス生成され設定される。
     */
    protected QueryDAO queryDAO = null;

    /**
     * 日数条件のコードを変換したMap。
     */
    private Map<String, Integer> daysMap = null;

    /**
     * 基本料金のコードを変換したMap。
     */
    private Map<String, Integer> priceMap = null;

    /**
     * QueryDAOを設定する。
     * 
     * @param queryDAO 設定するQueryDAO
     */
    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }

    /**
     * 日数条件のコードを変換したMapを返却する。
     * 
     * @return 日数条件のコードを変換したMap
     */
    public Map<String, Integer> getDaysMap() {
        return daysMap;
    }

    /**
     * 日数条件のコードを変換したMapを設定する。
     * 
     * @param daysMap 設定する日数条件のコードを変換したMap
     */
    public void setDaysMap(Map<String, Integer> daysMap) {
        this.daysMap = daysMap;
    }

    /**
     * 基本料金のコードを変換したMapを返却する。
     * 
     * @return 基本料金のコードを変換したMap
     */
    public Map<String, Integer> getPriceMap() {
        return priceMap;
    }

    /**
     * 基本料金のコードを変換したMapを設定する。
     * 
     * @param priceMap 設定する基本料金のコードを変換したMap
     */
    public void setPriceMap(Map<String, Integer> priceMap) {
        this.priceMap = priceMap;
    }

    /**
     * 1:入力情報とコードリスト情報から検索条件を生成して、検索情報を取得する。
     * <br>
     * 2:ページリンク機能も実装する。
     * 
     * @param param 検索条件を保持したDtoクラス
     * @return 検索結果。
     */
    public BLogicResult execute(RP_A01_01_01_02Input param) {

        // 実行結果を用意する。
        BLogicResult result = new BLogicResult();

        // ツアー検索するためのクラスを生成する。
        SelectTourInfoInput selectInput = new SelectTourInfoInput();

        // 日数条件を変換する。
        Integer days = daysMap.get(param.getTourDaysCondition());

        // 基本料金を変換する。
        Integer price = priceMap.get(param.getBasePriceCondition());

        // 検索条件をセットする。
        // (出発地条件,目的地条件,ツアー出発日,日数条件,基本料金,)
        selectInput.setDepCodeCondition(param.getDepCodeCondition());
        selectInput.setArrCodeCondition(param.getArrCodeCondition());
        String jointDepDay = 
            param.getDepDayYearCondition() + "/" + 
            param.getDepDayMonthCondition() + "/" + 
            param.getDepDayDayCondition();
        selectInput.setDepDayCondition(jointDepDay);
        selectInput.setTourDays(days);
        selectInput.setAdultCountCondition(param.getAdultCountCondition());
        selectInput.setChildCountCondition(param.getChildCountCondition());
        selectInput.setBasePrice(price);

        // 出力情報を格納するクラスを生成する。
        RP_A01_01_01_02Output rp_a01_01_01_02Output = 
            new RP_A01_01_01_02Output();

        // データベースからツアー検索情報から10件を取得する。
        Integer startIndex = param.getStartIndex();
        Integer row = param.getRow();

        // 10件ずつツアーの検索と実行する
        TourInfo[] tourInfo = 
            queryDAO.executeForObjectArray("UC_A01_01.selectTourInfo", 
                    selectInput, TourInfo.class, startIndex, row);

        // ツアー検索結果総件数を取得する。
        Integer tourCount = 
            queryDAO.executeForObject("UC_A01_01.selectTourInfoCount", 
                    selectInput, Integer.class);

        // メッセージを設定する。
        BLogicMessages messages = new BLogicMessages();

        // 検索結果0件処理
        if (tourCount == 0) {
            messages.add(this.getClass().getName(), 
                    new BLogicMessage(INFO_NOT_TOUR));

            if (log.isDebugEnabled()) {
                log.debug(INFO_NOT_TOUR + "ツアー検索結果 0件");
            }

        } else {

            // 日数変換処理。
            for (int i = 0; i < tourInfo.length; i++) {
                tourInfo[i].setTourDays(DateUtil.convertNightDays(tourInfo[i]
                        .getTourIntDays()));
            }

            messages.add(this.getClass().getName(), 
                    new BLogicMessage(INFO_TOUR, tourCount));

            if (log.isDebugEnabled()) {
                log.debug(INFO_TOUR + "ツアー検索結果" + tourCount + "件");
            }

        }

        // ツアー検索情報を出力値にセットする。
        rp_a01_01_01_02Output.setTourInfoList(tourInfo);
        rp_a01_01_01_02Output.setAllListInfoLineCount(tourCount);

        // 結果をセットする。
        result.setMessages(messages);
        result.setResultObject(rp_a01_01_01_02Output);
        result.setResultString("success");

        return result;
    }

}