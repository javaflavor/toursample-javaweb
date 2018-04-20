/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.blogic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;
import jp.terasoluna.toursample.common.exception.TourSystemException;

/**
 * 単価料金算出ビジネスロジッククラス。<br>
 * データベースから大人、子どもの年令区分別割引率を取得し、単価、及び料金を 算出する。<br>
 * データベースには｢大人｣に対する｢年令区分コード｣として｢0｣、｢子ども｣に対する ｢年令区分コード｣として｢1｣が設定されている。<br>
 * もし｢0｣と｢1｣のデータが存在しないと{@link TourSystemException}が発生する。<br>
 * 
 * <br>
 * ・共通処理CP0009：単価料金算出処理 <br>
 * <br>
 * ・計算例<br>
 * &nbsp;&nbsp;- 基本料金：10,000円<br>
 * &nbsp;&nbsp;- 大人数：3名<br>
 * &nbsp;&nbsp;- 子ども数：1名<br>
 * &nbsp;&nbsp;- 大人の年令区分別割引率：100<br>
 * &nbsp;&nbsp;- 子どもの年令区分別割引率：60<br>
 * 
 * ・結果<br>
 * &nbsp;&nbsp;- 大人の単価：基本料金×大人の年令区分別割引率／100＝10,000円 <br>
 * &nbsp;&nbsp;- 子どもの単価：基本料金×子どもの年令区分別割引率／100＝6,000円 <br>
 * &nbsp;&nbsp;- 大人の料金：大人の単価×大人数＝30,000円<br>
 * &nbsp;&nbsp;- 子どもの料金：子どもの単価×子ども数＝6,000円<br>
 * &nbsp;&nbsp;- 合計料金：大人の料金＋子どもの料金＝36,000円<br>
 * <br>
 * 
 * 
 */
public class PriceCalculateBLogicImpl implements PriceCalculateBLogic {

    /**
     * ログクラス。
     */
    private static final Log log = 
        LogFactory.getLog(PriceCalculateBLogicImpl.class);

    /**
     * データベースからの年令区分別割引率取得に失敗した場合の エラーメッセージコード。
     */
    private static final String GET_RATE_ERROR = "error.common.00007";

    /**
     * DAOクラス。<br>
     * Springによりインスタンス生成され設定される。
     */
    protected QueryDAO queryDAO = null;

    /**
     * QueryDAOを設定する。
     * 
     * @param queryDAO
     *            QueryDAO
     */
    public void setQueryDAO(QueryDAO queryDAO) {

        this.queryDAO = queryDAO;
    }

    /**
     * 単価、料金の算出を行なう。
     * 
     * @param basePrice
     *            基本料金
     * @param adultCount
     *            人数(大人)
     * @param childCount
     *            人数(子ども)
     * @return 単価料金算出結果
     * @exception TourSystemException
     *                年令区分別割引率の取得失敗時
     */
    public PriceCalculateOutput execute(Integer basePrice, Integer adultCount,
            Integer childCount) {

        // 処理結果を格納するオブジェクト
        PriceCalculateOutput result = new PriceCalculateOutput();

        Integer adultRate = null;
        Integer childRate = null;

        // 大人の年令区分別割引率を取得する。
        // ｢0｣は｢大人｣に対する｢年令区分コード｣である。
        adultRate = queryDAO.executeForObject("common.selectAgeRate", "0",
                                              Integer.class);

        // 子どもの年令区分別割引率を取得する。
        // ｢1｣は｢子ども｣に対する｢年令区分コード｣である。
        childRate = queryDAO.executeForObject("common.selectAgeRate", "1",
                                              Integer.class);

        // 年令区分別割引率が取得されなかった場合、エラーを発生する。
        if (adultRate == null || childRate == null) {

            if (log.isErrorEnabled()) {
                log
                    .error(GET_RATE_ERROR + ": データベースから年令区分別割引率"
                            + "の取得が失敗しました。");
            }

            throw new TourSystemException(GET_RATE_ERROR);
        }

        // 大人の単価を計算し、処理結果に格納する。
        // 計算結果に小数点が出る場合は切り捨てる。
        int adultUnitPrice = basePrice * adultRate / 100;

        result.setAdultUnitPrice(adultUnitPrice);

        // 大人の料金を計算し、処理結果に格納する。
        int adultPrice = adultCount * adultUnitPrice;
        result.setAdultPrice(adultPrice);

        // 子どもの単価を計算し、処理結果に格納する。
        // 計算結果に小数点が出る場合は切り捨てる。
        int childUnitPrice = basePrice * childRate / 100;

        result.setChildUnitPrice(childUnitPrice);

        // 子どもの料金を計算し、処理結果に格納する。
        int childPrice = childCount * childUnitPrice;
        result.setChildPrice(childPrice);

        // 処理結果に人数(大人)を格納する。
        result.setAdultCount(adultCount);

        // 処理結果に人数(子ども)を格納する。
        result.setChildCount(childCount);

        // 合計料金を計算し、処理結果に格納する。
        result.setSumPrice(adultPrice + childPrice);

        return result;

    }

}
