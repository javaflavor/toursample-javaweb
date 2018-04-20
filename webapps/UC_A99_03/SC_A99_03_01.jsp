<%--
@(#)SC_A99_03_01.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : 顧客登録画面を表示する


--%>

<%@page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J"%>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="common"%>

<bean:define id="cssFileName" scope="page" value="UC_A99_03/SC_A99_03_01.css"/>
<bean:define id="menuButtonFlag" scope="page" value="false"/>
<bean:define id="loginButtonFlag" scope="page" value="false"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html:html locale="true">

<!-- begin header-->
<%@ include file="../SC_A99_00_01.jspf" %>
<!-- end header-->

<!-- begin body-->

<div class="com-root-panel">
  <div class="com-body-title-panel">
    <div class="com-body-title-text-panel">
      <h1><span class="com-body-screen-name-text">顧客登録画面</span>(画面ID:SC_A99_03_01)</h1>
    </div>
  </div>

  <div class="com-body-panel">

    <div ID="navi-text-panel">
      <font ID="navi-present-text">会員情報入力</font>&nbsp;⇒&nbsp;
      <font ID="navi-text">入力内容確認</font>&nbsp;⇒&nbsp;
      <font ID="navi-text">完了</font>
    </div>
    <br/>
    
    <div class="com-message-panel">
	  会員登録する情報をご入力ください。<br/>
	  入力が完了しましたら、「登録する」ボタンを押してください。<br/>
	</div>

    <br/>
      
    <div class="com-error-message-panel" id="customer-error-message-panel" align="center">
      <html:messages id="msg" message="false">
        <p><bean:write name="msg" ignore="true" /></p>
      </html:messages>
    </div>

    <br/>
      
    <ts:form action="/SC_A99_03_02SCR.do" method="POST">
      <table class="com-visible-table" summary="会員情報">
          <caption>会員情報</caption>      
          <tr>
            <th>フリガナ<font id="required-text">(必須)</font></th>
            <td id="customer-hurigana-td">
              <html:text name="_uc_a99_03Form" property="customerKana" styleId="customerKana-textbox" /> 
              <font id="comment-text">&nbsp;(全角カタカナのみ)</font>
            </td>
          </tr>
          <tr>
            <th>氏名<font id="required-text">(必須)</font></th>
            <td id="customer-name-td">
              <html:text name="_uc_a99_03Form" property="customerName" styleId="customerName-textbox" /> 
              <font id="comment-text">&nbsp;(全角のみ)</font>
            </td>
          </tr>
          <tr>
            <th>生年月日<font id="required-text">(必須)</font></th>
            <td id="customer-birth-td">
                <t:defineCodeList id="CODE_008" />
                
                <html:select property="customerBirthYear">
                  <html:options collection="CODE_008"
                                labelProperty="name"
                                property="id"/>
                </html:select>年
            
                <t:defineCodeList id="CODE_002" />
                <html:select property="customerBirthMonth">
                   <html:options collection="CODE_002"
                                 labelProperty="name"
                                 property="id"/>
                </html:select>月
            
                <t:defineCodeList id="CODE_003" />
                <html:select property="customerBirthDay">
                   <html:options collection="CODE_003"
                                 labelProperty="name"
                                 property="id"/>
                </html:select>日
            </td>
          </tr>
          <tr>
            <th>職業<font id="required-text">(必須)</font></th>
            <td id="customer-job-td">
              <html:text name="_uc_a99_03Form" property="customerJob" styleId="customerJob-textbox" />
            </td>
          </tr>
          <tr>
            <th>Eメール</th>
            <td id="customer-email-td">
              <html:text name="_uc_a99_03Form" property="customerMail" styleId="customerMail-textbox" />
            </td>
          </tr>
          <tr>	
            <th>電話番号<font id="required-text">(必須)</font></th>
            <td id="customer-tel-td">
                    <html:text name="_uc_a99_03Form" property="customerTel" styleId="customerTel-textbox" />  
              <font id="comment-text">&nbsp;(半角のみ10桁～13桁)&nbsp;例：01-2345-6789</font>
            </td>
          </tr>
          <tr>
            <th>郵便番号<font id="required-text">(必須)</font></th>
            <td id="customer-postcode-td">〒
              <html:text name="_uc_a99_03Form" property="customerPost" styleId="customerPost-textbox" /> 
              <font id="comment-text">&nbsp;(半角のみ)&nbsp;例：262-0002</font>
            </td>
          </tr>
          <tr>
            <th>住所<font id="required-text">(必須)</font></th>
            <td id="customer-address-td">
              <html:text name="_uc_a99_03Form" property="customerAdd" styleId="customerAdd-textbox" />
            </td>
          </tr>
          <tr>
            <th>パスワード<font id="required-text">(必須)</font></th>
            <td id="customer-password-td">
              <html:password property="customerPass" styleId="customerPass-textbox" value="" />
              <font id="comment-text">&nbsp;(半角英数字4桁～20桁)</font>
            </td>
          </tr>
          <tr>
            <th>確認パスワード<font id="required-text">(必須)</font></th>
            <td id="customer-password-td">
              <html:password property="checkPass" styleId="customerPass-textbox" value="" />
            </td>
          </tr>
        </table>

      <br/>
      
      <div align="right">  
        <html:submit property="forward_checkUser" value="登録する" styleClass="com-normal-button" />
      </div>
      
    </ts:form>
       
  </div>

</div>
<!-- end body-->

<!-- begin footer-->
<%@ include file="../SC_A99_00_02.jspf" %>
<!-- end footer -->

</html:html>