/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_05.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import jp.terasoluna.fw.util.PropertyUtil;
import jp.terasoluna.fw.web.UserValueObject;
import jp.terasoluna.toursample.common.Constants;
import jp.terasoluna.toursample.common.TourUVO;
import jp.terasoluna.toursample.common.action.AbstractReportAction;
import jp.terasoluna.toursample.uc_a01_05.blogic.RP_A01_05_01_01BLogic;
import jp.terasoluna.toursample.uc_a01_05.dto.RP_A01_05_01_01Input;
import jp.terasoluna.toursample.uc_a01_05.dto.RP_A01_05_01_01Output;
import jp.terasoluna.toursample.uc_a01_05.form.UC_A01_05Form;

/**
 * 帳票出力起動クラス
 * <p>
 * 
 * </p>
 * 
 * 
 * 
 */
public class RP_A01_05_01_01Action extends
        AbstractReportAction<RP_A01_05_01_01Output> {

    /**
     * 実行するビジネスロジッククラス。 Springによりインスタンス生成され設定される。
     */
    private RP_A01_05_01_01BLogic rp_a01_05_01_01BLogic = null;

    /**
     * 実行するビジネスロジッククラスを返す。
     * 
     * @return 実行するビジネスロジッククラス
     */
    public RP_A01_05_01_01BLogic getRp_a01_05_01_01BLogic() {

        return rp_a01_05_01_01BLogic;
    }

    /**
     * 実行するビジネスロジッククラスを設定する。
     * 
     * @param rp_a01_05_01_01BLogic
     *            実行するビジネスロジッククラス
     */
    public void setRp_a01_05_01_01BLogic(
            RP_A01_05_01_01BLogic rp_a01_05_01_01BLogic) {

        this.rp_a01_05_01_01BLogic = rp_a01_05_01_01BLogic;
    }

    /**
     * パラメータマップを返す。<br>
     * パラメータは帳票出力時、全ての帳票に出力される情報である。<br>
     * 
     * @param form
     *            アクションフォーム
     * @param request
     *            リクエスト
     * 
     * @return パラメータマップ
     */
    @Override
    public Map getParameterMap(ActionForm form, HttpServletRequest request) {

        // プロパティファイルから問合せ情報、振込情報を取得する。
        String paymentMethod = PropertyUtil
            .getProperty(Constants.PAYMENT_METHOD);
        String paymentCompanyName = PropertyUtil
            .getProperty(Constants.PAYMENT_COMPANY_NAME);
        String paymentAccount = PropertyUtil
            .getProperty(Constants.PAYMENT_ACCOUNT);
        String referenceName = PropertyUtil.getProperty(Constants.COMPANY_NAME);
        String referenceEmail = PropertyUtil
            .getProperty(Constants.COMPANY_MAIL);
        String referenceTel = PropertyUtil.getProperty(Constants.COMPANY_TEL);

        // 取得した情報をMapへ書き込む。
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("paymentMethod", paymentMethod);
        paramMap.put("paymentCompanyName", paymentCompanyName);
        paramMap.put("paymentAccount", paymentAccount);
        paramMap.put("referenceName", referenceName);
        paramMap.put("referenceEmail", referenceEmail);
        paramMap.put("referenceTel", referenceTel);

        return paramMap;
    }

    /**
     * 帳票出力情報リストを返す。<br>
     * 複数の帳票を出力する場合、その情報をリストとして返す。
     * 
     * @param form
     *            アクションフォーム
     * @param request
     *            リクエスト
     * 
     * @return 帳票出力情報リスト
     */
    @Override
    public List<RP_A01_05_01_01Output> getReportData(ActionForm form,
            HttpServletRequest request) {

        // ビジネスロジックの入力値クラスを生成する。
        RP_A01_05_01_01Input param = new RP_A01_05_01_01Input();

        // フォームの引数をキャストする。
        UC_A01_05Form uc_a01_05Form = (UC_A01_05Form) form;

        // フォームの値をビジネスロジックの入力値クラスにセットする。
        param.setReserveNo(uc_a01_05Form.getReserveNo());

        // セッションからUVOを取得し、入力値クラスにセットする。
        param.setTourUVO((TourUVO) request.getSession()
            .getAttribute(UserValueObject.USER_VALUE_OBJECT_KEY));

        // リスト化された予約情報を取得する。
        List<RP_A01_05_01_01Output> list = rp_a01_05_01_01BLogic
            .selectReportData(param);

        return list;
    }

    /**
     * テンプレートファイルの相対パスを返す。<br>
     * 相対パスはクラスパスのルートを基準として記述する。<br>
     * <br>
     * <p> ※ 注意点：クラスパス上ではないファイルは対応出来ない。<br>
     * また、path値が「/」で始まる場合にClassLoaderによってリソースを取得
     * できない場合が存在する。(Tomcatでは問題ない。Junitでは問題あり)。<br>
     * そのため、パスの先頭は/で始まらないこと。
     * <p>
     * 
     * @param form
     *            アクションフォーム
     * @param request
     *            リクエスト
     * 
     * @return テンプレートファイルの相対パス
     */
    @Override
    public String getTemplatePath(ActionForm form, HttpServletRequest request) {

        // テンプレートファイルのパスを返却する。
        String path = "jp/terasoluna/toursample/uc_a01_05/report"
                + "/terasolunaPdfFormat.jrxml";

        return path;
    }

    /**
     * 生成される帳票のファイル名を返す。<br>
     * 
     * @param form
     *            アクションフォーム
     * @param request
     *            リクエスト
     * 
     * @return ファイル名
     */
    @Override
    public String getFileName(ActionForm form, HttpServletRequest request) {

        // フォームの引数をキャストする。
        UC_A01_05Form uc_a01_05Form = (UC_A01_05Form) form;

        // ファイル名を設定する。
        String fileName = "ReserveDetails(" + uc_a01_05Form.getReserveNo()
                + ").pdf";

        return fileName;
    }
}