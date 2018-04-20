/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import jp.terasoluna.fw.web.struts.actions.ForwardAction;

/**
 * <p>
 * エラーが発生した場合、エラーメッセージキーを設定して画面遷移を行なう<br>
 * アクションクラス。
 * </p>
 * 
 * @see ForwardAction
 * 
 * 
 * 
 */
public class SetErrorCodeAction extends ForwardAction {

    /**
     * エラーメッセージコード。
     */
    private String messageKey = null;

    /**
     * エラーメッセージコードを返却する。
     * 
     * @return 保持するエラーメッセージコード
     */
    public String getMessageKey() {

        return messageKey;
    }

    /**
     * エラーメッセージコードを設定する。
     * 
     * @param messageKey
     *            設定するエラーメッセージコード
     */
    public void setMessageKey(String messageKey) {

        this.messageKey = messageKey;
    }

    /**
     * <p>
     * エラーに発生時おいて、エラーメッセージコードを設定する。<br>
     * エラーメッセージを設定後、画面遷移を行なう。
     * </p>
     * 
     * @param mapping
     *            アクションマッピング
     * @param form
     *            アクションフォーム
     * @param request
     *            HTTPリクエスト
     * @param response
     *            HTTPレスポンス
     * @return 遷移先のアクションフォワード
     */
    @Override
    public ActionForward doExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        // セッションを取得する。
        HttpSession session = request.getSession();

        // メッセージを生成する。
        ActionMessages errors = new ActionMessages();
        errors.add(Globals.ERROR_KEY, new ActionMessage(messageKey));

        // メッセージを設定する。
        addErrors(session, errors);

        // フォワード処理を行う。
        return super.doExecute(mapping, form, request, response);
    }
}
