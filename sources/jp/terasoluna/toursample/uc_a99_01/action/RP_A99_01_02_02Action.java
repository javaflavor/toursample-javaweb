/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a99_01.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;

import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.web.struts.actions.AbstractBLogicAction;
import jp.terasoluna.toursample.common.TourUVO;
import jp.terasoluna.toursample.uc_a99_01.blogic.RP_A99_01_02_02BLogic;
import jp.terasoluna.toursample.uc_a99_01.dto.RP_A99_01_02_02Input;
import jp.terasoluna.toursample.uc_a99_01.dto.RP_A99_01_02_02Output;

/**
 * ログイン処理を行うアクションクラス。<br>
 * <br>
 * ・ユースケースUC_A99_01：顧客ログイン<br>
 * <br>
 * 入力された情報(顧客ID、パスワード)を利用しログイン処理を行う。<br>
 * データベースに顧客情報がある場合はUVOを生成しセッションに格納する。<br>
 * ない場合はエラーメッセージを画面に表示する。
 * 
 * 
 * 
 */
public class RP_A99_01_02_02Action extends 
    AbstractBLogicAction<RP_A99_01_02_02Input> {

    /**
     * ログクラス。
     */
    private static final Log log = 
        LogFactory.getLog(RP_A99_01_02_02Action.class);

    /**
     * ログインに失敗した場合のエラーメッセージコード。
     */
    private static final String LOGIN_ERROR = "warn.UC_A99_01.00001";

    /**
     * ログインビジネスロジック。
     */
    private RP_A99_01_02_02BLogic rp_a99_01_02_02BLogic = null;

    /**
     * ログインビジネスロジックを設定する。
     * 
     * @param logic
     *            ログインビジネスロジック
     */
    public void setRp_a99_01_02_02BLogic(RP_A99_01_02_02BLogic logic) {

        rp_a99_01_02_02BLogic = logic;
    }

    /**
     * ログイン処理を行う。<br>
     * <p>
     * ログインビジネスロジック実行し、ログイン可能の場合はUVO(顧客情報)を セッションに格納する。
     * </p>
     * 
     * @param param
     *            BLogic入力情報
     * @return BLogic出力情報
     */
    @Override
    public BLogicResult doExecuteBLogic(RP_A99_01_02_02Input param) {

        BLogicResult result = new BLogicResult();

        // ログイン処理を行う。
        TourUVO uvo = rp_a99_01_02_02BLogic.executeLogin(param
            .getCustomerCode(), param.getCustomerPass());

        // 顧客情報取得可否を確認する。
        if (uvo == null) {
            // 顧客情報が取得できなかった場合（認証失敗時）
            // エラーメッセージを格納し、BLogicResultに設定する
            BLogicMessages errors = new BLogicMessages();
            errors.add(Globals.ERROR_KEY, new BLogicMessage(LOGIN_ERROR));
            result.setErrors(errors);

            result.setResultString("failure");

            // ログを出力する。
            if (log.isWarnEnabled()) {
                log.warn("Login failure： " + param.getCustomerCode());
            }
        } else {
            // 顧客情報が取得できた場合（認証成功時）
            // 出力オブジェクトを生成し、BLogicResultに設定する
            RP_A99_01_02_02Output output = new RP_A99_01_02_02Output();
            output.setUvo(uvo);
            result.setResultObject(output);

            // ログを出力する。
            if (log.isInfoEnabled()) {
                log.info("Login success： " + param.getCustomerCode());
            }

            String returnCode = param.getReturnCode();

            // 遷移元画面IDを確認する。
            if (returnCode == null || "".equals(returnCode)) {
                // 遷移元画面IDがない場合
                result.setResultString("success");
            } else if ("SC_A01_01_02".equals(returnCode)) {
                // 遷移元画面IDがSC_A01_01_02(ツアー詳細画面)の場合
                result.setResultString("returnSC_A01_01_02");
            } else {
                // 想定外の遷移元画面IDの場合
                result.setResultString("default");
            }

        }
        return result;
    }

}
