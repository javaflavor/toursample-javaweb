<%--
@(#)SC_A99_03_03.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : 顧客登録完了画面を表示する


--%>

<%@page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J"%>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="common"%>

<bean:define id="cssFileName" scope="page" value="UC_A99_03/SC_A99_03_03.css" />
<bean:define id="menuButtonFlag" scope="page" value="true" />
<bean:define id="loginButtonFlag" scope="page" value="false" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html:html locale="true">

<!-- begin header-->
<%@ include file="../SC_A99_00_01.jspf" %>
<!-- end header-->

<!-- begin body-->
<div class="com-root-panel">
  
  <div class="com-body-title-panel">
    <div class="com-body-title-text-panel">
    <h1><span class="com-body-screen-name-text">顧客登録完了画面</span>(画面ID:SC_A99_03_03)</h1>
    </div>
  </div>
  
  <div class="com-body-panel">

    <div ID="navi-text-panel">
      <font ID="navi-text">会員情報入力</font>&nbsp;⇒&nbsp;
      <font ID="navi-text">入力内容確認</font>&nbsp;⇒&nbsp;
      <font ID="navi-present-text">完了</font>
    </div>
    <br/>
  
    <p align="center"><b>会員登録を完了しました。</b></p>
    <p align="center"><b>お客様の会員IDは</b>
    <font id="userid-text">"<bean:write name="_uc_a99_03Form" property="customerCode" ignore="true" />"</font>
    <b>です。</b>
    </p>
  
    <p align="center"><b>ログイン時必要ですので忘れないようご注意ください。</b></p>
  
    <table class="com-visible-table" summary="会員情報">
      <caption>会員情報</caption>
      <tr>
        <th>フリガナ</th>
        <td id="customer-hurigana-td">
          <bean:write name="_uc_a99_03Form" property="customerKana" ignore="true" />
        </td>
      </tr>
      <tr>
        <th>氏名</th>
        <td id="customer-name-td">
          <bean:write name="_uc_a99_03Form" property="customerName" ignore="true" />
        </td>
      </tr>
      <tr>
        <th>生年月日</th>
        <td id="customer-birth-td">
          <bean:write name="_uc_a99_03Form" property="customerBirthYear" ignore="true" />年
          <bean:write name="_uc_a99_03Form" property="customerBirthMonth" ignore="true" />月
          <bean:write name="_uc_a99_03Form" property="customerBirthDay" ignore="true" />日
        </td>
      </tr>
      <tr>
        <th>職業</th>
        <td id="customer-job-td">
          <bean:write name="_uc_a99_03Form" property="customerJob" ignore="true" />
        </td>
      </tr>
      <tr>
        <th>Eメール</th>
        <td id="customer-email-td">
          <bean:write name="_uc_a99_03Form" property="customerMail" ignore="true" />
        </td>
      </tr>
      <tr>        
        <th>電話番号</th>
        <td id="customer-tel-td">
          <bean:write name="_uc_a99_03Form" property="customerTel" ignore="true" />
        </td>
      </tr>
      <tr>
        <th>郵便番号</th>
        <td id="customer-postcode-td">
          〒<bean:write name="_uc_a99_03Form" property="customerPost" ignore="true" />
        </td>
      </tr>
      <tr>
        <th>住所</th>
        <td id="customerAdd-text">
          <bean:write name="_uc_a99_03Form" property="customerAdd" ignore="true" />
        </td>
      </tr>
      <tr>
        <th>パスワード</th>
        <td id="password-text">●●●●●●●●</td>
      </tr>
    </table>

    <p/>
    
    <div class="button">
      <ts:form action="/switchAction.do?prefix=&amp;page=/SC_A99_01_01SCR.do" styleClass="com-header-button-form">
        <html:submit value="メニュー画面に戻る" styleClass="com-long-button" /> 
      </ts:form>
    </div>
    
  </div>
  
</div>
<!-- end body-->

<!-- begin footer-->
<%@ include file="../SC_A99_00_02.jspf" %>
<!-- end footer -->

</html:html>