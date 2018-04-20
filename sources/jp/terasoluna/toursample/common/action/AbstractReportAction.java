/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import jp.terasoluna.fw.web.struts.actions.ActionEx;

/**
 * 帳票出力起動抽象クラス<br>
 * PDF形式の帳票を作成し出力を行なう。<br>
 * 帳票生成用のTemplateはJasperReportを利用する。<br>
 * 以下の４つのメソッドを実装することで帳票の生成が出来る。<br>
 * <li>getParameterMap(ActionForm, HttpServletRequest)<br>
 * &nbsp;&nbsp;- 各帳票に出力される変更可能な固定文字列を取得する。<br>
 * &nbsp;&nbsp;&nbsp; 固定文字のため、取得が出来なくても帳票は生成される。</li>
 * <br><br>
 * <li>getReportData(ActionForm, HttpServletRequest)<br>
 * &nbsp;&nbsp;- 帳票で出力したい情報を取得する。<br>
 * &nbsp;&nbsp;&nbsp; 帳票出力対象のため、取得が出来ない場合は空の帳票が
 * 生成される</li>
 * <br><br>
 * <li>getTemplatePath(ActionForm, HttpServletRequest)<br>
 * &nbsp;&nbsp;- 帳票生成用のTemplateファイルのパスを取得する。</li>
 * <br><br>
 * <li>getFileName(ActionForm, HttpServletRequest)<br>
 * &nbsp;&nbsp;- 生成される帳票ファイルのファイル名を取得する。</li>
 * <br><br>
 * ・共通処理CP0005：帳票出力処理
 * 
 * @see jp.terasoluna.fw.web.struts.actions.ActionEx
 * 
 * 
 * 
 * @param <T> 帳票出力情報オブジェクト
 */
public abstract class AbstractReportAction<T> extends ActionEx {
    
    /**
     * 帳票出力を行なう。<br>
     * <br>
     * 出力される帳票は以下の形式で出力される。<br>
     * ・ファイル形式：PDF形式<br>
     * ・ファイル名：getFileNameの結果<br>
     * 複数の帳票を出力する場合、結果ファイルに複数の帳票が生成される。
     * 
     * @param mapping アクションマッピング
     * @param form アクションフォーム
     * @param request リクエスト
     * @param response レスポンス
     * 
     * @return 遷移処理を行わないため、ヌルを返す。
     * 
     * @exception JRException 帳票作成処理で問題が発生した場合
     * @exception IOException Streamの処理で問題が発生した場合
     */
    @Override
    public ActionForward doExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
        throws JRException, IOException {
        
        // パラメータの生成
        Map paramMap = getParameterMap(form, request);
        
        //Templateファイルのストリームを取得。
        InputStream inputStream = null;
        JasperReport jasperReport = null;
        
        try {
            inputStream = Thread.currentThread().getContextClassLoader().
                    getResourceAsStream(getTemplatePath(form, request));
        
            //Report(Template)の生成
            jasperReport = JasperCompileManager.compileReport(inputStream);
            
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        
        //データベースからの取得値
        List<T> list = getReportData(form, request);
                
        //JavaBean用のConnectionを生成
        JRBeanCollectionDataSource dataSource =
            new JRBeanCollectionDataSource(list);
        
        //Reportにデータを設定
        JasperPrint jasperPrint =
            JasperFillManager.fillReport(jasperReport, paramMap, dataSource);
        
        //ContentTypeの設定
        response.setContentType("application/pdf");
        
        //PDFファイル名を設定
        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + getFileName(form, request) + "\"");
        
        //レスポンスからouputStreamを取得
        ServletOutputStream outputStream = response.getOutputStream();
        
        //OupurtStreamにPDFファイルの内容を設定。
        try {
            JasperExportManager.exportReportToPdfStream(jasperPrint,
                    outputStream);
            outputStream.flush();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }

        //遷移処理を行わないため、ヌルを返す。
        return null;
    }
    
    /**
     * パラメータマップを返す。<br>
     * パラメータは帳票出力時、全ての帳票に出力される情報である。<br>
     * 
     * @param form アクションフォーム
     * @param request リクエスト
     * 
     * @return パラメータマップ
     */
    public abstract Map getParameterMap(ActionForm form,
            HttpServletRequest request);
    
    /**
     * 帳票出力情報リストを返す。<br>
     * 複数の帳票を出力する場合、その情報をリストとして返す。
     * 
     * @param form アクションフォーム
     * @param request リクエスト
     * 
     * @return 帳票出力情報リスト
     */
    public abstract List<T> getReportData(ActionForm form,
            HttpServletRequest request);
    
    /**
     * テンプレートファイルの相対パスを返す。<br>
     * 相対パスはクラスパスのルートを基準として記述する。<br>
     * <br>
     * ※ 注意点：クラスパス上ではないファイルは対応出来ない。
     * 
     * @param form アクションフォーム
     * @param request リクエスト
     * 
     * @return テンプレートファイルの相対パス
     */
    public abstract String getTemplatePath(ActionForm form,
            HttpServletRequest request);

    /**
     * 生成される帳票のファイル名を返す。<br>
     * 
     * @param form アクションフォーム
     * @param request リクエスト
     * 
     * @return ファイル名
     */
    public abstract String getFileName(ActionForm form,
            HttpServletRequest request);
}
