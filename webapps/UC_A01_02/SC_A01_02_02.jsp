<%--
@(#)SC_A01_02_02.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : ツアー予約詳細画面を表示する


--%>

<%@page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J" %>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="common"%>

<bean:define id="menuButtonFlag" scope="page" value="false"/>
<bean:define id="loginButtonFlag" scope="page" value="true"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html:html locale="true">
<%@ include file="../SC_A99_00_01.jspf" %>

<!-- begin body-->
 <div class="com-root-panel">
 <div class="com-body-title-panel">
 	<div class="com-body-title-text-panel">
      <div class="com-body-screen-name-text">
          <h1><span class="com-body-screen-name-text">ツアー予約詳細画面
          </span>(画面ID: SC_A01_02_02)</h1>
      </div>
	</div>
 </div>
  <div class="com-body-panel" id="default-body-panel">
    <div id="navi-text-panel">
      <font id="navi-text">予約一覧を確認</font>&nbsp;⇒&nbsp;
      <font id="navi-present-text">予約の詳細を確認</font>
    </div>
  <br/>
<div class="com-message-panel">
	ご予約いただいたツアーの詳細情報をご確認ください。<br/>
</div>
<logic:equal name="_uc_a01_02Form" property="reserveDetail.transfer" value="false">
<br/>
	支払期限までに、振込口座もしくは窓口まで料金をお支払ください。<br/>
	なお、支払期限までに料金をお支払いいただけない場合は、<br/>
	予約をキャンセルさせていただくことがございますので、<br/>
	あらかじめご了承ください。<br/>
</logic:equal>
<logic:equal name="_uc_a01_02Form" property="reserveDetail.transfer" value="true">
<br/>
  このご予約はすでに料金をお支払いいただいております。<br/>
  大変申し訳ありませんが、ウェブからの変更、キャンセルは承っておりません。<br/>
  お手数ですが変更、キャンセルのお手続きは電話(01-2345-6789)、または窓口にてお問合せください。<br/>
</logic:equal>
<br/>
	この情報はＰＤＦでダウンロードできます。
<br/>
			<div id="return-button-panel">
				<ts:form method="POST" action="/SC_A01_02_02DSP.do">
					<ts:submit property="forward_downloadPDF" 
						   	   styleClass="com-long-button" 
						   	   value="PDFをダウンロードする" 
						   	   tabindex="1"/>
					<html:hidden name="_uc_a01_02Form" property="reserveNo"/>
				</ts:form>
			</div>

<logic:equal name="_uc_a01_02Form" property="reserveDetail.transfer" value="false">
	<table class="com-visible-table" id="payment-table" summary="料金詳細">
		<caption>支払情報</caption>
		<tr>
			<th>支払方法</th>
			<td id="payment-method-td" colspan="3">
			<bean:write name="_uc_a01_02Form" property="paymentMethod"/>
			</td>
		</tr>
		<tr>
			<th>振込口座</th>
			<td id="payment-account-td" colspan="3">
			<bean:write name="_uc_a01_02Form" property="paymentCompanyName"/>
			<br/>
			<bean:write name="_uc_a01_02Form" property="paymentAccount"/>
			</td>
		</tr>
		<tr>
			<th>支払期限</th>
			<td id="payment-date-td" colspan="3">
					<t:date name="_uc_a01_02Form" property="reserveDetail.paymentTimeLimit"
							pattern="yyyy年MM月dd日"/>
			</td>
		</tr>
		<tr>
			<th>お問合せ</th>
			<td id="payment-inquiry-td" colspan="3">
				<bean:write name="_uc_a01_02Form" property="referenceName"/>
				<br/>
				<bean:write name="_uc_a01_02Form" property="referenceEmail"/>
				<br/>
				<bean:write name="_uc_a01_02Form" property="referenceTel"/>
			</td>
		</tr>
	</table>
	<br/>
	
	<hr/>
</logic:equal>
	<table class="com-visible-table" id="tour-table" summary="ホテル情報">
		<caption>ツアー予約詳細情報</caption>
		<tr>
			<th>予約番号</th>
			<td id="tour-name-td">
			<bean:write name="_uc_a01_02Form" property="reserveNo"/>
			</td>
			<th>申し込み日</th>
			<td id="tour-starting-date-td">
			<t:date name="_uc_a01_02Form" property="reserveDetail.reservedDay"
					pattern="yyyy年MM月dd日"/>
			</td>
		</tr>
		
		<tr>
			<th>ツアー名</th>
			<td id="tour-name-td" colspan="3">
				<bean:write name="_uc_a01_02Form" property="reserveDetail.tourName"/>
			</td>
		</tr>
		<tr>
			<th>出発日</th>
			<td id="tour-starting-date-td">
			<t:date name="_uc_a01_02Form" property="reserveDetail.depDay"
					pattern="yyyy年MM月dd日"/>
			</td>
			<th>日数</th>
			<td id="tour-days-td">
				<bean:write name="_uc_a01_02Form" property="reserveDetail.tourDays"/>
			</td>
		</tr>
		<tr>
			<th>出発地</th>
			<td id="tour-starting-point-td">
				<bean:write name="_uc_a01_02Form" property="reserveDetail.depName"/>
			</td>
			<th>目的地</th>
			<td id="tour-destination-td">
				<bean:write name="_uc_a01_02Form" property="reserveDetail.arrName"/>
			</td>
		</tr>
		<tr>
			<th>添乗員</th>
			<td id="tour-conductor-td" colspan="3">
			<logic:equal name="_uc_a01_02Form" property="reserveDetail.conductor" value="true">
				有
			</logic:equal>
			<logic:equal name="_uc_a01_02Form" property="reserveDetail.conductor" value="false">
				無
			</logic:equal>		
			</td>
		</tr>
		<tr>
			<th>宿泊施設</th>
			<td id="tour-accommodations-td">
				<bean:write name="_uc_a01_02Form" property="reserveDetail.accomName"/>
			</td>
			<th>連絡先</th>
			<td id="tour-accommodations-tel-td">
				<bean:write name="_uc_a01_02Form" property="reserveDetail.accomTel"/>
			</td>
		</tr>
		<tr>
			<th>概要</th>
			<td id="tour-summary-td" colspan="3">
			<t:write name="_uc_a01_02Form" property="reserveDetail.tourAbs"/>
			</td>
		</tr>
	</table>
	<br/>

<!-- representative -->
	<hr/>
	<table class="com-visible-table" id="customer-table" summary="代表者情報">
		<caption>代表者</caption>
		<tr>
			<th colspan="2">会員ID</th>
			<td id="customer-id-td" colspan="3">
				<bean:write name="USER_VALUE_OBJECT" property="customerCode" scope="session"/>
			</td>
		</tr>
		<tr>
			<th colspan="2">フリガナ</th>
			<td id="customer-hurigana-td" colspan="3">
			<bean:write name="USER_VALUE_OBJECT" property="customerKana" scope="session"/>
			</td>
		</tr>
		<tr>
			<th colspan="2">氏名</th>
			<td id="customer-name-td" colspan="3">
			<bean:write name="USER_VALUE_OBJECT" property="customerName" scope="session"/>
			</td>
		</tr>
		<tr>
			<th colspan="2">生年月日</th>
			<td id="customer-birth-td" colspan="3">
			<t:date name="USER_VALUE_OBJECT" property="customerBirth" scope="session"
					pattern="yyyy年MM月dd日"/>
			</td>
		</tr>
		<tr>
			<th colspan="2">職業</th>
			<td id="customer-job-td" colspan="3">
			<bean:write name="USER_VALUE_OBJECT" property="customerJob" scope="session"/>
			</td>
		</tr>
		<tr>
			<th colspan="2">Eメール</th>
			<td id="customer-email-td" colspan="3">
			<bean:write name="USER_VALUE_OBJECT" property="customerMail" scope="session"/>
			</td>
		</tr>
		<tr>
			<th rowspan="3">連絡先</th>
			<th >電話番号</th>
			<td id="customer-tel-td">
			<bean:write name="USER_VALUE_OBJECT" property="customerTel" scope="session"/>
			</td>
		</tr>
		<tr>
			<th>郵便番号</th>
			<td id="customer-postcode-td">
			〒<bean:write name="USER_VALUE_OBJECT" property="customerPost" scope="session"/>
			</td>
		</tr>
		<tr>
			<th>住所</th>
			<td id="customer-address-td">
			<bean:write name="USER_VALUE_OBJECT" property="customerAdd" scope="session"/>
			</td>
		</tr>
	</table>

<%-- representative end --%>
			
	<%-- total amount start --%>


	<br/>
	<hr/>
	<table class="com-visible-table" id="charge-table" summary="宿泊明細情報">
		<caption>料金明細</caption>
		<tr><th>年令区分</th><th>単価</th><th>人数</th><th>料金</th></tr>
		<tr>
			<td id="charge-age-td">大人</td>
			<td id="charge-price-td">
			<bean:write name="_uc_a01_02Form" property="price.adultUnitPrice" format="###,###円"/>
			</td>
			<td id="charge-number-td">
			<bean:write name="_uc_a01_02Form" property="price.adultCount" format="###人"/>
			</td>
			<td id="charge-charge-td">
			<bean:write name="_uc_a01_02Form" property="price.adultPrice" format="###,###円"/>
			</td>
		</tr>
		<tr>
			<td id="charge-age-td">小ども</td>
			<td id="charge-price-td">
			<bean:write name="_uc_a01_02Form" property="price.childUnitPrice" format="###,###円"/>
			</td>
			<td id="charge-number-td">
			<bean:write name="_uc_a01_02Form" property="price.childCount" format="###人"/>
			</td>
			<td id="charge-charge-td">
			<bean:write name="_uc_a01_02Form" property="price.childPrice" format="###,###円"/>
			</td>
		</tr>
		<tr>
			<th colspan="3" >合計料金</th>
			<td id="charge-total-charge-td">
			<bean:write name="_uc_a01_02Form" property="price.sumPrice" format="###,###円"/>
			</td>
		</tr>
	</table>
	
		<br/>
	<hr/>
	<table class="com-visible-table" id="tour-table" summary="ご意見ご要望">
		<caption>特記事項</caption>
		<tr>
			<th>ご意見・ご要望</th>
			<td id="special-affairs-note-td">
				<bean:write name="_uc_a01_02Form" property="reserveDetail.remarks"/>
			</td>
		</tr>
	</table>
<!-- comment end -->

	
	
<br/>
<br/>
		
	<div id="return-button-panel">

	<ts:form action="/SC_A01_02_02DSP.do" method="POST">
		<ts:submit property="forward_reservationList" styleClass="com-long-button" value="ツアー予約照会画面に戻る" tabindex="2"/>
		<logic:equal name="_uc_a01_02Form" property="limitExcessFlag" value="false">
		<logic:equal name="_uc_a01_02Form" property="reserveDetail.transfer" value="false">
			<ts:submit property="forward_change" styleClass="com-long-button" value="予約を変更する" tabindex="3"/>
			<ts:submit property="forward_cancel" styleClass="com-long-button" value="予約をキャンセルする" tabindex="4"/>	
		</logic:equal>
		</logic:equal>
	<html:hidden name="_uc_a01_02Form" property="reserveNo"/>
	<html:hidden property="returnCode" value="SC_A01_02_02"/>
	</ts:form>

	</div>
	<br/>
	<br/>
	

</div>
</div>
<!-- end body-->
<%@ include file="../SC_A99_00_02.jspf" %>

</html:html>

