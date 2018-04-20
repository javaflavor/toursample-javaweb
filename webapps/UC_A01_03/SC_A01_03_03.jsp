<%--
@(#)SC_A01_03_02.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : ツアー予約変更完了画面を表示する


--%>

<%@page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J"%>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="common"%>

<bean:define id="cssFileName" scope="page" value="UC_A01_03/SC_A01_03_03.css" />
<bean:define id="menuButtonFlag" scope="page" value="true" />
<bean:define id="loginButtonFlag" scope="page" value="true" />
<bean:define id="reserveDetail" name="_uc_a01_03Form" property="reserveDetail"/>
<bean:define id="price" name="_uc_a01_03Form" property="price"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html:html locale="true">

<!-- begin header-->
<%@ include file="../SC_A99_00_01.jspf"%>
<!-- end header-->

<div class="com-root-panel">
  <!-- begin title -->
    <div class="com-body-title-panel">
      <div class="com-body-title-text-panel">
        <div class="com-body-screen-name-text">
          <h1><span class="com-body-screen-name-text">ツアー予約変更完了画面</span>(画面ID:SC_A01_03_03)</h1>
        </div>
      </div>
    </div>
  <!-- end title --> 

  <!-- begin body-->
  <div class="com-body-panel">
  <div id="navi-text-panel"><font id="navi-text">変更内容入力</font>
  &nbsp;⇒&nbsp;<font id="navi-text">入力内容確</font>
  &nbsp;⇒&nbsp;<font id="navi-present-text">完了</font>
  </div>
  <br/>
    <!-- begin message -->
    <div class="com-message-panel">
    予約の変更が完了しました。<br/>
    変更された情報は下記のようになっております。ご確認ください。</div>
    <!-- end message -->
    
        <!-- begin postfix -->
    <p>
    支払期限までに、振込口座もしくは窓口まで料金をお支払ください。<br/>
    なお、支払期限までに料金をお支払いいただけない場合は、<br/>
    予約をキャンセルさせていただくことがございますので、<br/>
    あらかじめご了承ください。<br/>
    </p>
    <p>この情報はＰＤＦでダウンロードできます。</p>
    <!-- end postfix --> 
    
     <div class="button">
    <ts:form method="post" action="/SC_A01_03_03DSP.do">
        <!-- 予約番号 -->
        <html:hidden name="_uc_a01_03Form" property="reserveNo"/>
        <!-- PDFをダウンロード -->
        <html:submit property="forward_downloadPDF" value="PDFをダウンロードする" styleClass="com-long-button"/>
    </ts:form>
    </div>
    
    <table class="com-visible-table" id="payment-table" summary="支払情報">
      <caption>支払情報</caption>
      <tr>
        <th id="com-hotel-code-th">支払方法</th>
        <td id="payment-method-td" colspan="3">
          <bean:write name="_uc_a01_03Form" property="paymentMethod" ignore="true"/>
        </td>
      </tr>
      <tr>
        <th id="com-hotel-code-th">振込口座</th>
        <td id="payment-account-td" colspan="3">
          <bean:write name="_uc_a01_03Form" property="paymentCompanyName" ignore="true"/><br/>
          <bean:write name="_uc_a01_03Form" property="paymentAccount" ignore="true"/>
        </td>
      </tr>
      <tr>
        <th id="com-hotel-code-th">支払期限</th>
        <td id="payment-date-td" colspan="3">
          <font id="paymentTimeLimit-text"><t:date name="reserveDetail" property="paymentTimeLimit" pattern="yyyy年MM月dd日" ignore="true"/></font>
        </td>
      </tr>
      <tr>
        <th id="com-hotel-code-th">お問合せ</th>
        <td id="payment-inquiry-td" colspan="3">
          <bean:write name="_uc_a01_03Form" property="referenceName" ignore="true"/><br/>
          <bean:write name="_uc_a01_03Form" property="referenceEmail" ignore="true"/><br/>
          <bean:write name="_uc_a01_03Form" property="referenceTel" ignore="true"/>
        </td>
      </tr>
    </table>
    <br/>
    
    <hr/>
    
    <table class="com-visible-table" id="tour-table" summary="予約明細" >
      <caption>ツアー予約情報</caption>
      <tr>
        <th>予約番号</th>
        <td id="tour-reserve-code-td">
          <bean:write name="_uc_a01_03Form" property="reserveNo" ignore="true"/>
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
        <td id="tour-starting-date-td" colspan="3">
          <t:date name="reserveDetail" property="depDay" pattern="yyyy年MM月dd日" ignore="true"/>
        </td>
      </tr>
      <tr>
        <th>日数</th>
        <td id="tour-days-td" colspan="3">
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
    </table>
    
    <br/>
    <hr/>
    
    <table class="com-visible-table" id="charge-table" summary="料金詳細">
      <caption>料金明細</caption>
      <tr>
        <th id="com-lodging-period-th">年齢区分</th>
        <th id="com-lodging-period-th">単価</th>
        <th id="com-lodging-period-th">人数</th>
        <th id="com-lodging-period-th">料金</th>
      </tr>
      <tr>
        <td id="charge-age-td">大人</td>
        <td id="charge-price-td">
          <bean:write name="price" property="adultUnitPrice" format="###,###円" ignore="true"/>
        </td>
        <td id="charge-number-td">
          <bean:write name="price" property="adultCount" format="###人" ignore="true"/>
        </td>
        <td id="charge-charge-td">
          <bean:write name="price" property="adultPrice" format="###,###円" ignore="true"/>
        </td>
      </tr>
      <tr>
        <td id="charge-age-td">子ども</td>
        <td id="charge-price-td">
          <bean:write name="price" property="childUnitPrice" format="###,###円" ignore="true"/>
        </td>
        <td id="charge-number-td">
          <bean:write name="price" property="childCount" format="###人" ignore="true"/>
        </td>
        <td id="charge-charge-td">
          <bean:write name="price" property="childPrice" format="###,###円" ignore="true"/>
        </td>
      </tr>
      <tr>
        <th colspan="3">合計料金</th>
        <td id="charge-total-charge-td">
          <bean:write name="price" property="sumPrice" format="###,###円" ignore="true"/>
        </td>
      </tr>
    </table>
     
    <br/>
    <hr/>
    
    <table class="com-visible-table" id="special-affairs-table" summary="ご意見ご要望">
      <caption>特記事項</caption>
      <tr>
        <th>ご意見ご要望</th>
        <td id="special-affairs-note-td">
          <bean:write name="reserveDetail" property="remarks" ignore="true"/>
        </td>
      </tr>
    </table>    
    <br/>
    <br/>
    
    <div class="com-message-panel">上記のように予約を変更しました。</div>

    <!-- start button -->
    <div class="button">
      <ts:form method="post" action="/SC_A01_03_03DSP.do">
        <!-- ツアー予約照会画面に遷移 -->
        <html:submit property="forward_reservationList" value="ツアー予約照会画面に戻る" styleClass="com-long-button"/>
        &nbsp;
        <!-- メニュー画面に遷移 -->
        <html:submit property="forward_menu" value="メニュー画面に戻る" styleClass="com-long-button"/>
      </ts:form>
    </div>
  <!-- end button -->
  </div>
</div>
<!-- end body-->
<!-- begin footer-->
<%@ include file="../SC_A99_00_02.jspf"%>
<!-- end footer -->
</html:html>
