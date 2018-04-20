<%--
@(#)SC_A01_03_01.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : ツアー予約変更画面を表示する


--%>

<%@page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J"%>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="common"%>

<bean:define id="cssFileName" scope="page" value="UC_A01_03/SC_A01_03_01.css" />
<bean:define id="menuButtonFlag" scope="page" value="false" />
<bean:define id="loginButtonFlag" scope="page" value="true" />
<bean:define id="reserveDetail" name="_uc_a01_03Form" property="reserveDetail"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html:html locale="true">

<!-- begin header-->
<%@ include file="../SC_A99_00_01.jspf"%>
<!-- end header-->
  
<!-- begin body-->
<div class="com-root-panel">
  <!-- begin title -->
  <div class="com-body-title-panel">
    <div class="com-body-title-text-panel">
      <div class="com-body-screen-name-text">
        <h1><span class="com-body-screen-name-text">ツアー予約変更画面</span>(画面ID:SC_A01_03_01)</h1>
      </div>
    </div>
  </div>
  <!-- end title -->

  <!-- begin main -->
  <div class="com-body-panel">
	<div id="navi-text-panel"><font id="navi-present-text">変更内容入力</font>
	&nbsp;⇒&nbsp;<font id="navi-text">入力内容確認</font>
	&nbsp;⇒&nbsp;<font id="navi-text">完了</font>
	</div>
	<br/>
    <!-- begin message -->
    <div class="com-message-panel">
      予約内容を変更後、画面下の「予約を変更する」ボタンを押してください。
      <div class="com-error-message-panel">
        <html:messages id="msg" message="false">
          <p><bean:write name="msg" ignore="true"/></p>
        </html:messages>
      </div>&nbsp;
    </div>
    <!-- end message -->
  
    <ts:form action="/SC_A01_03_01DSP.do" method="POST">
      <table class="com-visible-table" id="tour-table" summary="ツアー予約情報">
        <caption>ツアー予約情報</caption>
        <tr>
          <th>予約番号</th>
          <td id="tour-reserve-code-td">
            <bean:write name="_uc_a01_03Form" property="reserveNo" ignore="ture"/>
          </td>
          <th>申し込み日</th>
          <td id="tour-offer-day-td">
            <t:date name="reserveDetail" property="reservedDay" pattern="yyyy年MM月dd日" ignore="true"/>
          </td>
        </tr>
        <tr>
          <th>ツアー名</th>
          <td id="tour-name-td" colspan="3">
            <bean:write name="reserveDetail" property="tourName" ignore="true"/>
          </td>
        </tr>
        <tr>
          <th>出発日</th>
          <td id="tour-starting-date-td">
            <t:date name="reserveDetail" property="depDay" pattern="yyyy年MM月dd日" ignore="true"/>
          </td>
          <th>日数</th>
          <td id="tour-days-td">
            <bean:write name="reserveDetail" property="tourDays" ignore="true"/>
          </td>
        </tr>
        <tr>
          <th>出発地</th>
          <td id="tour-starting-point-td">
            <bean:write name="reserveDetail" property="depName" ignore="true"/>
          </td>
          <th>目的地</th>
          <td id="tour-destination-td">
            <bean:write name="reserveDetail" property="arrName" ignore="true"/>
          </td>
        </tr>
        <tr>
          <th>人数</th>
          <td id="tour-starting-point-td" colspan="3">
            大人 
                <t:defineCodeList id="CODE_006" />        
                <html:select name="_uc_a01_03Form" property="reserveDetail.adultCount">
                  <html:options collection="CODE_006"
                                labelProperty="name"
                                property="id"/>
                </html:select> 人&nbsp;&nbsp;
            子ども
                <t:defineCodeList id="CODE_007" />
                <html:select name="_uc_a01_03Form" property="reserveDetail.childCount">
                  <html:options collection="CODE_007"
                                labelProperty="name"
                                property="id"/>
                </html:select> 人
          </td>
        </tr>
      </table>
 
      <!-- tour-info end --> 
      <br/>
      <hr/>
      <br/>

      <!-- note start -->
      <table class="com-visible-table" id="special-affairs-table" summary="ご意見ご要望">
        <caption>特記事項</caption>
        <tr>
          <th>ご意見・ご要望</th>
          <td id="special-affairs-note-td" colspan="3">
            <html:text name="_uc_a01_03Form" property="reserveDetail.remarks" size="120"/>
            <font id="comment-text">(80文字以下)</font>
            <br/>
            ※ツアーに関するご意見・ご要望などありましたら、ご自由にお書きください。
          </td>
        </tr>
        
        <!-- 予約番号 -->
        <html:hidden name="_uc_a01_03Form" property="reserveNo"/>
      </table>
      <br/>
      <!-- note end -->
  
      <!-- begin buttons -->
      <div class="button">
        <!-- ツアー予約照会画面に遷移 -->
        <logic:match name="_uc_a01_03Form" property="returnCode" value="SC_A01_02_01"> 
          <html:submit property="forward_backpage1" value="前のページに戻る" styleClass="com-long-button"/>
        </logic:match>
        <!-- ツアー予約詳細画面に遷移 -->
        <logic:match name="_uc_a01_03Form" property="returnCode" value="SC_A01_02_02" >
          <html:submit property="forward_backpage2" value="前のページに戻る" styleClass="com-long-button"/>
        </logic:match>
        &nbsp;
        <!-- ツアー予約変更確認画面に遷移 -->
        <html:submit property="forward_change" value="予約を変更する" styleClass="com-long-button"/>
      </div>
      <!-- end buttons -->

    </ts:form>
    
  </div>

</div>

<!-- end body-->

<!-- begin footer-->
<%@ include file="../SC_A99_00_02.jspf" %>
<!-- end footer -->

</html:html>