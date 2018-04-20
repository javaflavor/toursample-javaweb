<%--
@(#)SC_A99_00_03.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : エラー画面を表示する


--%>

<%@page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J" %>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="common"%>

<bean:define id="cssFileName" scope="page" value="SC_A99_00_03.css"/>
<bean:define id="menuButtonFlag" scope="page" value="true"/>
<bean:define id="loginButtonFlag" scope="page" value="false"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html:html locale="true">
<%@ include file="SC_A99_00_01.jspf" %>

<!-- begin body-->
      <div class="com-body-title-panel">
        <div class="com-body-title-text-panel">
          <h1><span class="com-body-screen-name-text">エラー画面</span>(画面ID: SC_A99_00_03)</h1>
        </div>
		
        <div class="com-body-title-button-panel">
          
        </div>
      </div>
      <div class="com-body-panel" id="error-body-panel">
        <br/><br/>
        <div class="com-error-message-panel" id="default-error-message-panel">
          <html:messages id="msg" message="false">
          <p><bean:write name="msg" ignore="true"/></p>
          </html:messages>
        </div>
		<br/><br/><br/><br/><br/>
        <div id="menu-return-button-panel">
          <p>
          <ts:form action="/SC_A99_01_01SCR.do">
            <ts:submit value="メニュー画面に戻る" styleClass="com-long-button" />
          </ts:form>
          </p>
        </div>
        
      </div>
<!-- end body-->

<%@ include file="SC_A99_00_02.jspf" %>
</html:html>