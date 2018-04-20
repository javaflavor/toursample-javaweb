<%--
@(#)SC_A01_02_01.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : ツアー詳細画面を表示する


--%>

<%@ page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J" %>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="common"%>

<bean:define id="cssFileName" scope="page" value="UC_A01_01/SC_A01_01_02.css" />
<bean:define id="menuButtonFlag" scope="page" value="false"/>
<bean:define id="loginButtonFlag" scope="page" value="true"/>
<bean:define id="tourDetail" name="_uc_a01_01Form" property="tourDetail"/>
<bean:define id="priceOutput" name="_uc_a01_01Form" property="priceOutput"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html:html locale="true">

<!-- begin-header -->
<%@ include file="../SC_A99_00_01.jspf" %>
<!-- end-header -->

<!-- begin body-->
  <div class="com-root-panel">
  <div class="com-body-title-panel">
    <div class="com-body-title-text-panel">
      <div class="com-body-screen-name-text">
        <h1><span class="com-body-screen-name-text">ツアー詳細画面</span>(画面ID: SC_A01_01_02)</h1>
      </div>
    </div>
  </div>

  <div class="com-body-panel" id="default-body-panel">
  
    <div id="navi-text-panel">
      <font id="navi-text">ツアー検索</font>&nbsp;⇒&nbsp;
      <font id="navi-present-text">ツアー情報確認</font>&nbsp;⇒&nbsp;
      <font id="navi-text">予約内容確認</font>&nbsp;⇒&nbsp;
      <font id="navi-text">完了</font>
    </div>
    <br/>
    
    <logic:empty name="USER_VALUE_OBJECT" scope="session">
      <div class="com-message-panel" id="default-message-panel">
	    予約する場合は、画面下部の「ログインする」ボタンを押して下さい。
      </div>
    </logic:empty>
    
    <logic:notEmpty name="USER_VALUE_OBJECT" scope="session">
      <div class="com-message-panel" id="default-message-panel">
        ツアーの詳細を確認したら、画面下部の「予約する」ボタンを押して下さい。<br/>
		この時、ご意見・ご要望があれば記入してください。
      </div>
    </logic:notEmpty>
    
    <br/>
    <div class="com-error-message-panel" id="default-error-message-panel">
      <html:errors/>
    </div>
    <br/>
    
    <table class="com-visible-table" id="tour-table" summary="ツアー情報">
      <caption>ツアー詳細情報</caption>
      <tr>
        <th>ツアー名</th>
        <td id="tour-name-td" colspan="3"><bean:write name="tourDetail" property="tourName" /></td>
      </tr>
      <tr>
        <th>出発日</th>
        <td id="tour-starting-date-td"><t:date name="tourDetail" property="depDay" pattern="yyyy年MM月dd日"/></td>
        <th>日数</th>
        <td id="tour-days-td"><bean:write name="tourDetail" property="tourDays" /></td>
      </tr>
      <tr>
        <th>出発地</th>
        <td id="tour-starting-point-td"><bean:write name="tourDetail" property="depName" /></td>
        <th>目的地</th>
        <td id="tour-destination-td"><bean:write name="tourDetail" property="arrName" /></td>
      </tr>
      <tr>
        <th>添乗員</th>
        <td id="tour-conductor-td" colspan="3">
          <logic:equal name="tourDetail" property="conductor" value="true">有</logic:equal>
          <logic:equal name="tourDetail" property="conductor" value="false">無</logic:equal>
        </td>
      </tr>
      <tr>
        <th>宿泊施設</th>
        <td id="tour-accommodations-td"><bean:write name="tourDetail" property="accomName" /></td>
        <th>連絡先</th>
        <td id="tour-accommodations-tel-td"><bean:write name="tourDetail" property="accomTel" /></td>
      </tr>
      <tr>
        <th>概要</th>
        <td id="tour-summary-td" colspan="3"><t:write name="tourDetail" property="tourAbs" ignore="true" /></td>
      </tr>
    </table>
    <br/>
<%-- representative --%>
    <logic:notEmpty name="USER_VALUE_OBJECT" scope="session">
      <hr/>
      <table class="com-visible-table" id="customer-table" summary="代表者情報">
        <caption>代表者</caption>
        <tr>
          <th colspan="2">会員ID</th>
          <td id="customer-id-td" colspan="3"><bean:write name="USER_VALUE_OBJECT" property="customerCode" scope="session"/></td>
        </tr>
        <tr>
          <th colspan="2">フリガナ</th>
          <td id="customer-hurigana-td" colspan="3"><bean:write name="USER_VALUE_OBJECT" property="customerKana" scope="session"/></td>
        </tr>
        <tr>
          <th colspan="2">氏名</th>
          <td id="customer-name-td" colspan="3"><bean:write name="USER_VALUE_OBJECT" property="customerName" scope="session"/></td>
        </tr>
        <tr>
          <th colspan="2">生年月日</th>
          <td id="customer-birth-td" colspan="3"><bean:write name="USER_VALUE_OBJECT" property="customerBirth" format="yyyy年MM月dd日" scope="session"/></td>
        </tr>
        <tr>
          <th colspan="2">職業</th>
          <td id="customer-job-td" colspan="3"><bean:write name="USER_VALUE_OBJECT" property="customerJob" scope="session"/></td>
        </tr>
        <tr>
          <th colspan="2">Eメール</th>
          <td id="customer-email-td" colspan="3"><bean:write name="USER_VALUE_OBJECT" property="customerMail" scope="session"/></td>
        </tr>
        <tr>
          <th rowspan="3">連絡先</th>
          <th >電話番号</th>
          <td id="customer-tel-td" colspan="3"><bean:write name="USER_VALUE_OBJECT" property="customerTel" scope="session"/></td>
        </tr>
        <tr>
          <th>郵便番号</th>
          <td id="customer-postcode-td" colspan="3">〒<bean:write name="USER_VALUE_OBJECT" property="customerPost" scope="session"/></td>
        </tr>
        <tr>
          <th>住所</th>
          <td id="customer-address-td" colspan="3"><bean:write name="USER_VALUE_OBJECT" property="customerAdd" scope="session"/></td>
        </tr>
      </table>
    </logic:notEmpty>
<%-- representative end --%>

<%-- total amount start --%>
    <br/>
    <hr/>
    <table class="com-visible-table" id="charge-table" summary="宿泊明細情報">
      <caption>料金明細</caption>
      <tr><th>年令区分</th><th>単価</th><th>人数</th><th>料金</th></tr>
      <tr>
        <td id="charge-age-td">大人</td>
        <td id="charge-price-td"><bean:write name="priceOutput" property="adultUnitPrice" format="###,###円"/></td>
        <td id="charge-number-td"><bean:write name="priceOutput" property="adultCount" format="#人"/></td>
        <td id="charge-charge-td"><bean:write name="priceOutput" property="adultPrice" format="###,###円"/></td>
      </tr>
      <tr>
        <td id="charge-age-td">子ども</td>
        <td id="charge-price-td"><bean:write name="priceOutput" property="childUnitPrice" format="###,###円"/></td>
        <td id="charge-number-td"><bean:write name="priceOutput" property="childCount" format="#人"/></td>
        <td id="charge-charge-td"><bean:write name="priceOutput" property="childPrice" format="###,###円"/></td>
      </tr>
      <tr>
        <th colspan="3" >合計料金</th>
        <td id="charge-total-charge-td"><bean:write name="priceOutput" property="sumPrice" format="###,###円"/></td>
      </tr>
    </table>
    <br/>
<%-- 特記事項 --%>
    <logic:notEmpty name="USER_VALUE_OBJECT" scope="session">
    <ts:form method="POST" action="SC_A01_01_03SCR.do" >
      <hr/>
      <table class="com-visible-table" id="special-affairs-table" summary="ご意見ご要望">
        <caption>特記事項</caption>
        <tr>
          <th>ご意見・ご要望</th>
          <td id="special-affairs-note-td"><html:text name="_uc_a01_01Form" property="remarks" size="120" tabindex="1"/><font id="comment-text">(80文字以下)</font>
          <br/>※ツアーに関するご意見・ご要望などありましたら、ご自由にお書きください</td>
        </tr>
      </table>
      <br/>
<%-- total amount end --%>
<%-- メッセージ2 --%>
    <div class="com-message-panel" id="default-message-panel">
      <html:messages id="message" message="true">
        <p><bean:write name="message" ignore="true"/></p>
      </html:messages>
    </div>
<%-- ボタン --%>
    <br/>
      <table class="button-table" summary="ボタンテーブル">
        <tr><td> </td><td><ts:submit value="予約する" styleClass="long-button" tabindex="2"/>
        </td></tr></table>
    </ts:form>
    
    <table class="button-table" summary="ボタンテーブル">
    <tr><td><ts:form method="POST" action="SC_A01_01_02DSP.do" >
      <ts:submit property="forward_returnSC_A01_01_01"
                 value="ツアー検索画面へ戻る" styleClass="long-button" tabindex="3"/>
    </ts:form>
    </td></tr></table>
    </logic:notEmpty>
    
    <logic:empty name="USER_VALUE_OBJECT" scope="session">
<%-- メッセージ2 --%>
    <div class="com-message-panel" id="default-message-panel">
      <html:messages id="message" message="true">
        <p><bean:write name="message" ignore="true"/></p>
      </html:messages>
    </div>
<%-- ボタン --%>
    <br/>
      <ts:form method="POST" action="SC_A01_01_02DSP.do" >
      <table class="button-table" summary="ボタンテーブル">
        <tr><td> </td><td><ts:submit property="forward_login" 
                   value="ログインする" styleClass="long-button" tabindex="1"/>
        </td></tr></table>
      <table class="button-table" summary="ボタンテーブル">
        <tr><td><ts:submit property="forward_returnSC_A01_01_01" 
                   value="ツアー検索画面へ戻る" styleClass="long-button" tabindex="2"/>
        </td></tr></table>
        <html:hidden property="returnCode" value="SC_A01_01_02"/>
      </ts:form>
    </logic:empty>

  </div>
</div>
<!-- end body-->

<!-- begin-footer -->
<%@ include file="../SC_A99_00_02.jspf" %>
<!-- end-footer -->

</html:html>