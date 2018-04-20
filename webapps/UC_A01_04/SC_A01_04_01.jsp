<%--
@(#)SC_A01_04_02.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : ツアー予約キャンセル画面を表示する


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
          <h1><span class="com-body-screen-name-text">ツアー予約キャンセル確認画面
          </span>(画面ID: SC_A01_04_01)</h1>
      </div>
	</div>
 </div>

			<div class="com-body-panel" id="default-body-panel">
			<div id="navi-text-panel">
				<font id="navi-present-text">キャンセル内容確認</font>
				&nbsp;⇒&nbsp;<font id="navi-text">完了</font>
			</div>
			<br/>
			 <div class="com-message-panel">
         		 下記のツアーをキャンセルする場合は、画面下の「予約をキャンセルする」ボタンを押してください。
        	</div>	
				<br/>

				<table class="com-visible-table" id="tour-table" summary="ツアー詳細情報">
					<caption>ツアー予約詳細情報</caption>
					<tr>
						<th>予約番号</th>
						<td id="tour-reserve-code-td">
						<bean:write name="_uc_a01_04Form" property="reserveNo"/>
						</td>
						<th>申し込み日</th>
						<td id="tour-offer-day-td">
						<t:date name="_uc_a01_04Form" property="reserveDetail.reservedDay"
								pattern="yyyy年MM月dd日"/>
						</td>
					</tr>
					
					
					<tr>
						<th>ツアー名</th>
						<td id="tour-name-td" colspan="3">
							<bean:write name="_uc_a01_04Form" property="reserveDetail.tourName"/>
						</td>
					</tr>
					<tr>
						<th>出発日</th>
						<td id="tour-starting-date-td">
						<t:date name="_uc_a01_04Form" property="reserveDetail.depDay"
								pattern="yyyy年MM月dd日"/>
						</td>
						<th>日数</th>
						<td id="tour-days-td">
							<bean:write name="_uc_a01_04Form" property="reserveDetail.tourDays"/>
						</td>
					</tr>
					<tr>
						<th>出発地</th>
						<td id="tour-starting-point-td">
							<bean:write name="_uc_a01_04Form" property="reserveDetail.depName"/>
						</td>
						<th>目的地</th>
						<td id="tour-destination-td">
							<bean:write name="_uc_a01_04Form" property="reserveDetail.arrName"/>
						</td>
					</tr>
					<tr>
						<th>添乗員</th>
						<td id="tour-conductor-td" colspan="3">
						<logic:equal name="_uc_a01_04Form" property="reserveDetail.conductor" value="true">
							有
						</logic:equal>
						<logic:equal name="_uc_a01_04Form" property="reserveDetail.conductor" value="false">
							無
						</logic:equal>		
						</td>
					</tr>
					<tr>
						<th>宿泊施設</th>
						<td id="tour-accommodations-td">
							<bean:write name="_uc_a01_04Form" property="reserveDetail.accomName"/>
						</td>
						<th>連絡先</th>
						<td id="tour-accommodations-tel-td">
							<bean:write name="_uc_a01_04Form" property="reserveDetail.accomTel"/>
						</td>
					</tr>
					<tr>
						<th>概要</th>
						<td id="tour-summary-td" colspan="3">
						<t:write name="_uc_a01_04Form" property="reserveDetail.tourAbs" />
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
						<th id="customer-tel-th">電話番号</th>
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
						<t:write name="USER_VALUE_OBJECT" property="customerAdd" scope="session" />
						</td>
					</tr>
				</table>

<%-- representative end --%>
			
			<%-- total amount start --%>
		

			<br/>
			<hr/>
			<table class="com-visible-table" id="charge-table" summary="料金明細">
				<caption>料金明細</caption>
				<tr><th>年令区分</th><th>単価</th><th>人数</th><th>料金</th></tr>
				<tr>
					<td id="charge-age-td">大人</td>
					<td id="charge-price-td">
					<bean:write name="_uc_a01_04Form" property="price.adultUnitPrice" format="###,###円"/>
					</td>
					<td id="charge-number-td">
					<bean:write name="_uc_a01_04Form" property="price.adultCount" format="##人"/>
					</td>
					<td id="charge-charge-td">
					<bean:write name="_uc_a01_04Form" property="price.adultPrice" format="###,###円"/>
					</td>
				</tr>
				<tr>
					<td id="charge-age-td">子ども</td>
					<td id="charge-price-td">
					<bean:write name="_uc_a01_04Form" property="price.childUnitPrice" format="###,###円"/>
					</td>
					<td id="charge-number-td">
					<bean:write name="_uc_a01_04Form" property="price.childCount" format="##人"/>
					</td>
					<td id="charge-charge-td">
					<bean:write name="_uc_a01_04Form" property="price.childPrice" format="###,###円"/>
					</td>
				</tr>
				<tr>
					<th colspan="3" >合計料金</th>
					<td id="charge-total-charge-td">
					<bean:write name="_uc_a01_04Form" property="price.sumPrice"
					 			format="###,###円"/>
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
					<t:write name="_uc_a01_04Form" property="reserveDetail.remarks"/>
					</td>
				</tr>
			</table>
	<div id="return-button-panel">

	<ts:form method="POST" action="/SC_A01_04_01DSP.do">
	<logic:equal name="_uc_a01_04Form" property="returnCode" value="SC_A01_02_01">
		<ts:submit property="forward_backpage1" styleClass="com-long-button" value="前のページに戻る" tabindex="1"/>
	</logic:equal>
	<logic:equal name="_uc_a01_04Form" property="returnCode" value="SC_A01_02_02">		
		<ts:submit property="forward_backpage2" styleClass="com-long-button" value="前のページに戻る" tabindex="1"/>
		</logic:equal>
	<ts:submit property="forward_cancel" styleClass="com-long-button" value="予約をキャンセルする" tabindex="2"/>	
	<html:hidden name="_uc_a01_04Form" property="reserveNo" />
		</ts:form>
	</div>
	<br/>
	<br/>
			
	</div>
	
<!-- end body-->
<%@ include file="../SC_A99_00_02.jspf" %>
</div>
</html:html>



