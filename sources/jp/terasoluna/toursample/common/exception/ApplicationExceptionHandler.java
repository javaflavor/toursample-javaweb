/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import jp.terasoluna.fw.util.ExceptionUtil;
import jp.terasoluna.fw.web.RequestUtil;
import jp.terasoluna.fw.web.struts.action.ExceptionConfigEx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;
import org.apache.struts.util.MessageResources;

/**
 * ApplicationException例外処理クラス。
 *
 * <p>
 * 業務エラー時のログ出力と エラー画面への遷移を行う。<br>
 * アクション実行中に業務エラーが発生したときは、
 * エラー情報をログ出力した上で、当該アクションマッピングに定義されている
 * エラー画面に遷移する。
 * 本機能を利用するためには、Struts設定ファイル(struts-config.xml)に
 * グローバル例外、またはアクションレベル例外ハンドラクラスとして指定する。<br>
 * グローバル例外と、アクションレベル例外が衝突している場合、
 * Strutsの仕様によりアクションレベル例外が優先される。
 * </p>
 * <h5>グローバル例外としてのシステム例外設定例</h5>
 * Struts設定ファイル(struts-config.xml)に以下のように書く。
 * <pre><code>
 * &lt;struts-config&gt;
 *   …
 *   &lt;global-exceptions&gt;
 *     &lt;exception key="some.key"
 *                path="/error"
 *                type="jp.terasoluna.toursample.common.exception.ApplicationException"
 *                className="jp.terasoluna.fw.web.struts.action.ExceptionConfigEx"
 *                handler="jp.terasoluna.toursample.common.exception.ApplicationExceptionHandler"&gt;
 *       &lt;set-property property="module" value=""/&gt;
 *     &lt;/exception&gt;
 *   &lt;/global-exceptions&gt;
 *   …
 * &lt;struts-config&gt;
 * </code></pre>
 * </p>
 * <h5>アクションレベル例外としてのシステム例外設定例</h5>
 * <pre><code>
 * &lt;struts-config&gt;
 *   …
 *   &lt;action path="/start"
 *           type="jp.terasoluna.xxx.SampleAction"
 *           name="_sampleForm"
 *           scope="session"&gt;
 *     &lt;exception key="some.key"
 *                type="jp.terasoluna.toursample.common.exception.ApplicationException"
 *                className="jp.terasoluna.fw.web.struts.action.ExceptionConfigEx"
 *                handler="jp.terasoluna.toursample.common.exception.ApplicationExceptionHandler"
 *                path="/error.do"&gt;
 *       &lt;set-property property="module" value=""/&gt;
 *     &lt;/exception&gt;
 *     &lt;forward name="success" path="/index.jsp"/&gt;
 *   &lt;/action&gt;
 *   …
 * &lt;struts-config&gt;
 * </code></pre>
 * なお、&lt;exception&gt;要素のpath属性で遷移先パスが指定
 * されない場合は、アクションマッピングのinput属性を
 * 転送先リソースとする。
 *
 * @see jp.terasoluna.toursample.common.exception.ApplicationException
 * @see jp.terasoluna.fw.web.struts.action.ExceptionConfigEx
 *
 * 
 * 
 * 
 * 
 */
public class ApplicationExceptionHandler extends ExceptionHandler {

    /**
     * ログクラス。
     */
    private static final Log log = 
        LogFactory.getLog(ApplicationExceptionHandler.class);

    /**
     * ApplicationException例外ハンドラのエントリポイント。
     * 
     * @param ex 例外
     * @param eConfig 例外コンフィグ
     * @param mapping アクションマッピング
     * @param formInstance アクションフォーム
     * @param request HTTPリクエスト
     * @param response HTTPレスポンス
     * 
     * @return エラーメッセージ
     * 
     * @exception ServletException サーブレット例外
     */
    @Override
    public ActionForward execute(Exception ex,
                                 ExceptionConfig eConfig,
                                 ActionMapping mapping,
                                 ActionForm formInstance,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
            throws ServletException {
        // 【フォワード先を設定する】
        // pathによるフォワード先が指定されない場合は、
        // アクションマッピングのinput属性をデフォルトとする。
        String path = null;
        if (eConfig.getPath() != null) {
            path = eConfig.getPath();
        } else {
            path = mapping.getInput();
        }
        ActionForward forward = new ActionForward(path);
        
        // 【遷移先を設定する】
        if (eConfig instanceof ExceptionConfigEx) {
            //遷移先モジュールが設定されているとき、モジュール名を設定する
            forward.setModule(((ExceptionConfigEx) eConfig).getModule());
        }
        
        // 【ApplicationExceptionの場合、エラーキーとエラーメッセージの置換を行う】
        if (ex instanceof ApplicationException) {
            ApplicationException ae = (ApplicationException) ex;

            // 【リクエストからメッセージリソースを取得する。】
            MessageResources resources = null;
            
            // スコープからメッセージリソースを取得する際のバンドルキーを取得する。
            String bundle = eConfig.getBundle();
            if (bundle == null) {
                // struts-config.xmlのmessage-resourcesで
                // bundle属性が指定されていない場合、
                // デフォルトのバンドルキーを設定する
                bundle = Globals.MESSAGES_KEY;
            }

            // リクエスト属性からの取得を試みる。
            resources = (MessageResources) request
                .getAttribute(bundle);
            if (resources == null) {
                // リクエスト属性になければアプリケーション属性からの取得を試みる。
                resources = (MessageResources) RequestUtil
                    .getServletContext(request).getAttribute(bundle);
            }
            
            // 【エラーキーとエラーメッセージの置換を行う】
            // ApplicationExceptionのエラーキーをエラーメッセージに置換する。
            String message = null;
            if (resources == null) {
                // リソース取得できない場合はエラーキーをメッセージとする
                message = ae.getErrorCode();
            } else {
                message = getErrorMessage(request, ae, resources);
            }
            ae.setMessage(message);
            
            // 【画面表示用にActionMessageを設定する】
            String key = eConfig.getKey();
            ActionMessage error = null;
            if (resources != null) {
                String errorMessage =
                    resources.getMessage(request.getLocale(), key);
                if (errorMessage == null) {
                    errorMessage = key;
                }
                error = new ActionMessage(errorMessage, false);
            } else {
                // 画面であってもメッセージリソースが無い場合はエラーキーをメッセージにする
                error = new ActionMessage(key, false);
            }
            super.storeException(request,
                    key,
                    error,
                    forward,
                    eConfig.getScope());
            
            // 変換された例外メッセージ、スタックトレースと
            // セッションハッシュ値をログに出力
            String sessionHash = RequestUtil.getSessionHash(request);
            log.error("sessionHash = " + sessionHash);
            log.error(ExceptionUtil.getStackTrace(ae));

            // 【置換済のApplicationExceptionを設定する】
            // システム例外をJSPエラーページで exception として
            // 取得できるように request に設定する
            request.setAttribute(PageContext.EXCEPTION, ae);
        }

        // ApplicationException時は、アクションマッピングの設定に沿って遷移する。
        return forward;
    }

    /**
     * メッセージリソースに対してメッセージキーを指定することで
     * エラーメッセージを取得する。
     *
     * @param req HTTPリクエスト
     * @param ae ApplicationException
     * @param resources メッセージリソース
     * 
     * @return エラーメッセージ
     */
    private String getErrorMessage(HttpServletRequest req,
                                    ApplicationException ae,
                                    MessageResources resources) {
        String errorCode = ae.getErrorCode();
        // メッセージキーが指定されていないとき、nullを返却する。
        if (errorCode == null) {
            return null;
        }

        String[] options = ae.getOptions();
        if (options == null) {
            return resources.getMessage(req.getLocale(), errorCode);
        }
        return resources.getMessage(req.getLocale(), errorCode, options);
    }
}
