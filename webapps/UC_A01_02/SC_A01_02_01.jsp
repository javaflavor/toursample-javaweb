<%--
@(#)SC_A01_02_01.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : ツアー予約照会画面を表示する


--%>

<%@page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J" %>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="common"%>

<bean:define id="cssFileName" scope="page" value="UC_A01_02/SC_A01_02_01.css"/>
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
        <h1><span class="com-body-screen-name-text">ツアー予約照会画面
            </span>(画面ID: SC_A01_02_01)</h1>
      </div>
	</div>
  </div>
  <div class="com-body-panel" id="default-body-panel">
    <div id="navi-text-panel">
      <font id="navi-present-text">予約一覧を確認</font>&nbsp;⇒&nbsp;
      <font id="navi-text">予約の詳細を確認</font>
    </div>
  <br/>
  <logic:notEqual name="_uc_a01_02Form" property="reservationsCount" value="0">  
  <div class="com-message-panel">
    現在、ご予約いただいているツアーの詳細閲覧、変更、キャンセルは<br/>
   「予約詳細を見る」「予約を変更する」「予約をキャンセルする」<br/>
    をそれぞれ押下してください。<br/>
    <br/>
  </div>
    ツアー料金支払済み、または支払期限の過ぎたツアーの場合は、<br/>
    ウェブからツアーの変更、キャンセルはできません。<br/>
	電話(01-2345-6789)、または窓口にてお問合せください。
	<br/><br/>
  </logic:notEqual>
  <%-- 予約件数 --%>
  <div class="com-message-panel" id="default-message-panel">
    <html:messages id="message" message="true">
      <p><bean:write name="message" ignore="true"/></p>
    </html:messages>
  </div>
  
  <%-- 予約一覧表示 --%>  
  <logic:notEqual name="_uc_a01_02Form" property="reservationsCount" value="0">
	<table class="com-visible-table" summary="予約一覧" id="search-result-table">
		<caption id="result-caption">予約一覧&nbsp;&nbsp;
		<font id="sortrule-text">　※出発日の早い順、予約番号の小さい順</font>
		</caption>
		<tr>
			<th id="result-tour-4words">予約番号</th>
			<th>ツアー名</th>
			<th id="result-tour-date">出発日</th>
			<th id="result-tour-4words">日数</th>
			<th id="result-tour-3words">出発地</th>
			<th id="result-tour-3words">目的地</th>
			<th id="result-tour-5words">人数</th>
			<th id="result-tour-4words">支払状況</th>
			<th id="result-tour-4words">合計料金</th>
			<th id="result-button"></th>
		</tr>
		
    	<%-- reservationInfo --%>
		<logic:iterate id="reservationInfo" name="_uc_a01_02Form"
		               property="reservationInfo" indexId="index">
			<%
				index++ ;
				String indexTdCss = null;
				String sumPriceCss = null;
            	if(index %2 ==0){   
                	indexTdCss = "index-td-odd";
                	sumPriceCss = "sum-price-odd";
                } else{  
                	indexTdCss = "index-td-even";
                	sumPriceCss = "sum-price-even";
                }
			%> 
		<tr>
			<td id="<%=indexTdCss %>">
				<bean:write name="reservationInfo" property="reserveNo" />
			</td>
			<td id="<%=indexTdCss %>">
				<bean:write name="reservationInfo" property="tourName" />
			</td>
			<td id="<%=indexTdCss %>">
				<t:date name="reservationInfo" property="depDay" pattern="yyyy年MM月dd日"/>
			</td>
			<td id="<%=indexTdCss %>">
				<bean:write name="reservationInfo" property="tourDays" />
			</td>
			<td id="<%=indexTdCss %>">
				<bean:write name="reservationInfo" property="depName" />
			</td>
			<td id="<%=indexTdCss %>">
				<bean:write name="reservationInfo" property="arrName" />
			</td>
			<td id="<%=indexTdCss %>">
				大人 <bean:write name="reservationInfo" property="adultCount" format="###人"/>
				<br/>
				子ども <bean:write name="reservationInfo" property="childCount" format="###人"/>
			</td>
			<td id="<%=indexTdCss %>">
				<logic:equal name="reservationInfo" property="transfer" value="true">
					支払済
				</logic:equal>
				<logic:equal name="reservationInfo" property="transfer" value="false">
					未払い
				</logic:equal>
			</td>
			<td id="<%=sumPriceCss %>">
				<bean:write name="reservationInfo" property="sumPrice" format="###,###円"/>
			</td>
			<td id="<%=indexTdCss %>">
				<table class="com-button-table" summary="ボタンテーブル">
					<ts:form action="/SC_A01_02_01DSP.do" method="POST">
						<html:hidden property="returnCode" value="SC_A01_02_01"/>
						<html:hidden name="reservationInfo" property="reserveNo"/>
						<html:hidden name="reservationInfo" property="limitExcessFlag"/>
							<tr><td id="<%=indexTdCss %>">
								<ts:submit property="forward_details" styleClass="com-long-button" value="予約詳細を見る" tabindex="1"/>
							</td></tr>
						<logic:equal name="reservationInfo" property="limitExcessFlag" value="false">
						<logic:equal name="reservationInfo" property="transfer" value="false">
							<tr><td id="<%=indexTdCss %>">
								<ts:submit property="forward_change" styleClass="com-long-button" value="予約を変更する" tabindex="2"/>
							</td></tr>
							<tr><td id="<%=indexTdCss %>">
								<ts:submit property="forward_cancel" styleClass="com-long-button" value="予約をキャンセルする" tabindex="3"/>
							</td></tr>
						</logic:equal>
						</logic:equal>
					</ts:form>
				</table>
			</td>
		</tr>
		</logic:iterate>
	</table>
	
	<br/>
	

  </logic:notEqual>
  </div>
  </div>

<!-- end body-->
<%@ include file="../SC_A99_00_02.jspf" %>
</html:html>
