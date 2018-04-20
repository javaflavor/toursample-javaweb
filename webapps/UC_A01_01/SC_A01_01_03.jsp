<%--
@(#)SC_A01_01_03.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : ツアー予約登録確認画面を表示する


--%>
<%@page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J" %>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="common"%>

<bean:define id="menuButtonFlag" scope="page" value="false"/>
<bean:define id="loginButtonFlag" scope="page" value="false"/>
<bean:define id="tourDetail" name="_uc_a01_01Form" property="tourDetail"/>
<bean:define id="priceOutput" name="_uc_a01_01Form" property="priceOutput"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html:html locale="true">

<!-- begin header-->
<%@ include file="../SC_A99_00_01.jspf" %>
<!-- end header-->

<!-- begin確認画面body部 -->
<div class="com-body-title-panel">
  <div class="com-body-title-text-panel">
    <h1><span class="com-body-screen-name-text">ツアー予約登録確認画面</span>(画面ID: SC_A01_01_03)</h1>
  </div>
</div>

<div class="com-body-panel" id="default-body-panel">
  <div id="navi-text-panel">
    <font id="navi-text">ツアー検索</font>&nbsp;⇒&nbsp;
    <font id="navi-text">ツアー情報確認</font>&nbsp;⇒&nbsp;
    <font id="navi-present-text">予約内容確認</font>&nbsp;⇒&nbsp;
    <font id="navi-text">完了</font>
  </div>
  <br/>

  <div class="com-message-panel" id="default-message-panel">
    予約内容を確認したら、画面下部の「予約を確定する」ボタンを押して下さい。<br/><br/>
	ご入力いただいた情報は以下のとおりです。
  </div>
  <br/>

<!-- ツアー予約詳細情報テーブル -->
  <table class="com-visible-table" id="tour-table" summary="ツアー予約詳細情報">
    <caption>ツアー予約詳細情報</caption>
    <tr>
      <th>ツアー名</th>
      <td id="tour-name-td" colspan="3">
        <bean:write name="tourDetail" property="tourName" ignore="true" />
      </td>
    </tr>
    <tr>
      <th>出発日</th>
      <td id="tour-starting-date-td">
        <t:date name="tourDetail" property="depDay" ignore="true" pattern="yyyy年MM月dd日" />
      </td>
      <th>日数</th>
      <td id="tour-days-td">
        <bean:write name="tourDetail" property="tourDays" ignore="true" />
      </td>
    </tr>
    <tr>
      <th>出発地</th>
      <td id="tour-starting-point-td">
        <bean:write name="tourDetail" property="depName" ignore="true" />
      </td>
      <th>目的地</th>
      <td id="tour-destination-td">
        <bean:write name="tourDetail" property="arrName" ignore="true" />
      </td>
    </tr>
　　<tr>
      <th>添乗員</th>
      <td id="tour-conductor-td" colspan="3">
        <logic:equal name="tourDetail" property="conductor" value="true">
          有
        </logic:equal>
        <logic:equal name="tourDetail" property="conductor" value="false">
          無
        </logic:equal>
      </td>
    </tr>                    
    <tr>
      <th>宿泊施設</th>
      <td id="tour-accommodations-td">
        <bean:write name="tourDetail" property="accomName" ignore="true" />
      </td>
      <th>連絡先</th>
      <td id="tour-accommodations-tel-td">
        <bean:write name="tourDetail" property="accomTel" ignore="true" />
      </td>
    </tr>
    <tr>
      <th>概要</th>
      <td id="tour-summary-td" colspan="3">
        <t:write name="tourDetail" property="tourAbs" ignore="true" />
      </td>
    </tr>
  </table>
<!-- ツアー予約詳細情報テーブル 終了 -->

  <br/>
  <hr class="com-float-clear"/>
                
<!-- 代表者テーブル -->
  <table class="com-visible-table" id="customer-table" summary="代表者情報">
    <caption>代表者</caption>
    <tr>
      <th colspan="2">会員ID</th>
      <td id="customer-id-td" colspan="3">
        <bean:write name="USER_VALUE_OBJECT" property="customerCode" ignore="true" scope="session"/>
      </td>
    </tr>
    <tr>
      <th colspan="2">フリガナ</th>
      <td id="customer-hurigana-td" colspan="3">
        <bean:write name="USER_VALUE_OBJECT" property="customerKana" ignore="true" scope="session"/>
      </td>
    </tr>
    <tr>
      <th colspan="2">氏名</th>
      <td id="customer-name-td" colspan="3">
        <bean:write name="USER_VALUE_OBJECT" property="customerName" ignore="true" scope="session"/>
      </td>
    </tr>
    <tr>
      <th colspan="2">生年月日</th>
      <td id="customer-birth-td" colspan="3">
        <bean:write name="USER_VALUE_OBJECT" property="customerBirth" format="yyyy年MM月dd日" ignore="true" scope="session"/>
      </td>
    </tr>
    <tr>
      <th colspan="2">職業</th>
      <td id="customer-job-td" colspan="3">
        <bean:write name="USER_VALUE_OBJECT" property="customerJob" ignore="true" scope="session"/>
      </td>
    </tr>
    <tr>
      <th colspan="2">Eメール</th>
      <td colspan="3" id="customer-email-td">
        <bean:write name="USER_VALUE_OBJECT" property="customerMail" ignore="true" scope="session"/>
      </td>
    </tr>
    <tr>
      <th rowspan="3">連絡先</th>
      <th>電話番号</th>
      <td id="customer-tel-td">
        <bean:write name="USER_VALUE_OBJECT" property="customerTel" ignore="true" scope="session"/>
      </td>
    </tr>
    <tr>
      <th>郵便番号</th>
      <td id="customer-postcode-td">
        〒<bean:write name="USER_VALUE_OBJECT" property="customerPost" ignore="true" scope="session"/>
      </td>
    </tr>
    <tr>
      <th>住所</th>
      <td id="customer-address-td">
        <bean:write name="USER_VALUE_OBJECT" property="customerAdd" ignore="true" scope="session"/>
      </td>
    </tr>
  </table>
<!-- 代表者テーブル 終了 -->
                
  <br/>
  <hr class="com-float-clear"/>
                
<!-- 料金明細テーブル -->
  <table class="com-visible-table" id="charge-table" summary="料金明細情報">
    <caption>料金明細</caption>
    <tr><th>年令区分</th><th>単価</th><th>人数</th><th>料金</th></tr>
    <tr>
      <td id="charge-age-td">大人</td>
      <td id="charge-price-td">
        <bean:write name="priceOutput" property="adultUnitPrice" ignore="true" format="###,###円" />
      </td>
      <td id="charge-number-td">
        <bean:write name="priceOutput" property="adultCount" ignore="true" format="#人" />
      </td>
      <td id="charge-charge-td">
        <bean:write name="priceOutput" property="adultPrice" ignore="true" format="###,###円" />
      </td>
    </tr>
    <tr>
      <td id="charge-age-td">子ども</td>
      <td id="charge-price-td">
        <bean:write name="priceOutput" property="childUnitPrice" ignore="true" format="###,###円" />
      </td>
      <td id="charge-number-td">
        <bean:write name="priceOutput" property="childCount" ignore="true" format="#人" />
      </td>
      <td id="charge-charge-td">
        <bean:write name="priceOutput" property="childPrice" ignore="true" format="###,###円" />
      </td>
    </tr>
    <tr>
      <th colspan="3">合計料金</th>
      <td id="charge-total-charge-td">
        <bean:write name="priceOutput" property="sumPrice" ignore="true" format="###,###円" />
      </td>
    </tr>
  </table>
<!-- 料金明細テーブル 終了 -->
                
  <br/>
  <hr class="com-float-clear"/>

<!-- 特記事項 -->
  <table class="com-visible-table" id="special-affairs-table" summary="ご意見ご要望">
    <caption>特記事項</caption>
    <tr>
      <th>ご意見・ご要望</th>
      <td id="special-affairs-note-td">
        <bean:write name="_uc_a01_01Form" property="remarks" ignore="true" />
      </td>
    </tr>
  </table>
<!-- total amount end -->     
  <br/>

  <div id="confirm-button-panel">
    <ts:form method="post" action="/SC_A01_01_03DSP.do" >
      <ts:submit property="forward_returnSC_A01_01_02" value="ツアー詳細画面に戻る" styleClass="com-long-button" tabindex="1"/>
      <ts:submit property="forward_decided" value="予約を確定する" styleClass="com-long-button" tabindex="2"/>
    </ts:form>                
  </div>
  <br/>
  <br/>
</div>
<!-- end body-->
<!-- end確認画面body部 -->

<!-- begin footer-->
<%@ include file="../SC_A99_00_02.jspf" %>
<!-- end footer -->

</html:html>