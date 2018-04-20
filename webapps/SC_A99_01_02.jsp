<%--
@(#)SC_A99_01_02.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : ログイン画面を表示する


--%>

<%@page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J" %>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="common"%>

<bean:define id="cssFileName" scope="page" value="SC_A99_01_02.css"/>
<bean:define id="menuButtonFlag" scope="page" value="false"/>
<bean:define id="loginButtonFlag" scope="page" value="true"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html:html locale="true">
<%@ include file="SC_A99_00_01.jspf" %>
<html:javascript formName="/RP_A99_01_02_02BL" />

<!-- begin body-->
      <div class="com-body-title-panel">
        <div class="com-body-title-text-panel">
          <h1><span class="com-body-screen-name-text">ログイン画面</span>(画面ID: SC_A99_01_02)</h1>
        </div>
      </div>
      <div class="com-body-panel" id="login-body-panel">
        <div align="center" id="title-panel">
          <span id="title-text"><%= jp.terasoluna.fw.util.PropertyUtil.getProperty("system.name", "ツアー予約システム")%></span>
        </div>
        <div class="com-error-message-panel" id="default-error-message-panel">
          <html:messages id="message" message="false">
            <p><bean:write name="message" ignore="true" /></p>
          </html:messages>
        </div>
        <ts:form method="post" action="/RP_A99_01_02_02BL.do" onsubmit="return validate_commonForm(this);" >
          <table id="login-table" summary="ログインフォームレイアウト用">
            <tr><td><label for="userid-field">会員ID:</label></td><td><html:text property="customerCode" value="" styleId="userid-field" tabindex="1"/></td></tr>
            <tr><td><label for="password-field">パスワード:</label></td><td><html:password property="customerPass" value="" styleId="password-field" tabindex="2"/></td></tr>
            <tr><td colspan="2" id="login-form-button-area">
              <ts:submit value="ログイン" styleClass="com-normal-button" tabindex="3" />
            </td></tr>
          </table>
        </ts:form>
        <br /><br /><br />
        <div class="no-user-message-panel">
          <p>※ 会員IDを持っていないお客様は以下のボタンで会員登録を行って下さい。</p>
        </div>
        <ts:form action="/switchAction.do?prefix=/UC_A99_03&amp;page=/SC_A99_03_01SCR.do">
          <ts:submit value="会員登録をする" styleClass="com-long-button" tabindex="5" />
        </ts:form>

      </div>
<!-- end body-->

<%@ include file="SC_A99_00_02.jspf" %>
</html:html>