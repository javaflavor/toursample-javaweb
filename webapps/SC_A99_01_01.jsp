<%--
@(#)SC_A99_01_01.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : メニュー画面を表示する


--%>

<%@page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J" %>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="common"%>

<bean:define id="cssFileName" scope="page" value="SC_A99_01_01.css"/>
<bean:define id="menuButtonFlag" scope="page" value="true"/>
<bean:define id="loginButtonFlag" scope="page" value="true"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html:html locale="true">
<%@ include file="SC_A99_00_01.jspf" %>

<!-- begin body-->
      <div class="com-body-title-panel">
        <div class="com-body-title-text-panel">
          <h1><span class="com-body-screen-name-text">メニュー画面</span>(画面ID: SC_A99_01_01)</h1>
        </div>
      </div>
      <div class="com-body-panel" id="menu-body-panel">
        <div class="com-error-message-panel" id="default-error-message-panel">
          <html:messages id="message" message="true">
            <p><bean:write name="message" ignore="true"/></p>
          </html:messages>
        </div>
		<ts:form method="post" action="/SC_A99_01_01DSP.do">
          <table class="menu-visible-table">
            <tr>
              <th>
		        <div class="menu-button-panel">
		          <p>
		            <ts:submit property="forward_search" value="ツアーを検索する" styleClass="com-long-button"/>
		          </p>
		        </div>
		      </th>
		      <td>
		        <div class="menu-message-panel">
					条件を指定してツアーを検索できます。<br/>
					検索したツアーの予約もできます。予約にはログインが必要です。
		        </div>
		      </td>
		    </tr>
		  </table>
		  <logic:empty name="USER_VALUE_OBJECT" scope="session">
		  <br/>
		  <table class="menu-visible-table">
		    <tr>
		      <th>
		        <div class="menu-button-panel">
		          <p>
		            <ts:submit property="forward_login" value="ログインする" styleClass="com-long-button"/>
		          </p>
		        </div>
		      </th>
		      <td>
		        <div class="menu-message-panel">
					ログインするとツアーの予約、照会、変更、キャンセルが<br/>
					できるようになります。<br/>
					ログインするためには事前に会員登録が必要です。
		        </div>
		      </td>
		    </tr>
		  </table>
		  <br/>
		  <table class="menu-visible-table">
		    <tr>
		      <th>
		        <div class="menu-button-panel">
		          <p>
		            <ts:submit property="forward_registerUser" value="会員登録をする" styleClass="com-long-button"/>
		          </p>
		        </div>
		      </th>
		      <td>
		        <div class="menu-message-panel">
					お客様の情報を入力し、会員登録します。<br/>
		        </div>
		      </td>
		    </tr>
		  </table>
		  </logic:empty>
		  <logic:notEmpty name="USER_VALUE_OBJECT" scope="session">
		  <br/>
		  <table class="menu-visible-table">
		    <tr>
		      <th>
		        <div class="menu-button-panel">
		          <p>
		            <ts:submit property="forward_reference" value="予約を照会する" styleClass="com-long-button"/>
		          </p>
		        </div>
		      </th>
		      <td>
		        <div class="menu-message-panel">
					ログインしている場合のみ表示されます。予約したツアー情報を<br/>
					照会します。予約の変更、キャンセルもここから行います。
		        </div>
		      </td>
		    </tr>
		  </table>
		  </logic:notEmpty>
		  <br/>
		</ts:form>
        <br/>
      </div>
      

<!-- end body-->

<%@ include file="SC_A99_00_02.jspf" %>
</html:html>