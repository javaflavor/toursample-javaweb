<%--
@(#)SC_A01_01_01.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : ツアー検索画面とツアー検索結果を表示する


--%>

<%@page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J" %>

<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/common" prefix="thz"%>

<bean:define id="cssFileName" scope="page" value="UC_A01_01/SC_A01_01_01.css" />
<bean:define id="menuButtonFlag" scope="page" value="false"/>
<bean:define id="loginButtonFlag" scope="page" value="false"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html:html locale="true">

<!-- begin-header -->
<%@ include file="../SC_A99_00_01.jspf" %>
<!-- end-header -->

<!-- begin body-->
<div class="com-root-panel">
  <div class="com-body-title-panel">
    <div class="com-body-title-text-panel">
      <div class="com-body-screen-name-text">
        <h1><span class="com-body-screen-name-text">ツアー検索画面</span>(画面ID: SC_A01_01_01)</h1>
      </div>
    </div>
  </div>

  <div class="com-body-panel" id="default-body-panel">
    <div id="navi-text-panel">
      <font id="navi-present-text">ツアー検索</font>&nbsp;⇒&nbsp;
      <font id="navi-text">ツアー情報確認</font>&nbsp;⇒&nbsp;
      <font id="navi-text">予約内容確認</font>&nbsp;⇒&nbsp;
      <font id="navi-text">完了</font>
    </div>
    <br/>
    
	<div class="entry-message-panel" id="entry-message-panel">
		※登録までの手順
		<ol>
			<li>ツアー検索画面で条件を入力し、ツアーを検索してください。</li>
			<li>検索結果一覧よりツアーを一つ選択してください。</li>
			<li>ツアー詳細画面でツアーの内容を確認し、問題が無ければ次の画面へ進んでください。（まだ予約はされません。）</li>
			<li>予約内容を確認し、問題が無ければ予約を行なってください。</li>
			<li>ツアー予約登録完了画面でツアー詳細情報、会員情報、料金明細、支払情報を確認してください。</li>
		</ol>
	</div>
	<br/><br/>
		
	<div class="com-message-panel" id="default-message-panel">
		条件を指定してツアーを検索し、検索結果よりツアーを選択してください。<br/>
		ツアーはツアー名のリンクを押すことで選択できます。
	</div>
    <br/>
    
    <div class="com-error-message-panel" id="default-error-message-panel">
      <html:messages id="msg" message="false">
        <p><bean:write name="msg" ignore="true" /></p>
      </html:messages>
    </div>

    <ts:form action="/RP_A01_01_01_02BL.do">

      <%-- ツアー検索開始 --%>
      <table class="com-visible-table" summary="ツアー検索条件" id="search-condition-table">
        <caption id="result-caption">ツアー検索条件</caption>
          <tr>
            <%-- 出発日：初期表示--%>
            <th><label for="">出発日</label></th>
            <td id="tour-starting-date-td">
              <logic:empty name="_uc_a01_01Form" property="depDayYearCondition">
                <html:select property="depDayYearCondition" size="1">
                  <thz:currentDateOptions var="year" selected="true" plusDay="7" />
                </html:select>年 
              </logic:empty>
              <logic:empty name="_uc_a01_01Form" property="depDayMonthCondition">
                <html:select property="depDayMonthCondition" size="1">
                  <thz:currentDateOptions var="month" selected="true" plusDay="7" />
                </html:select>月 
              </logic:empty>   
              <logic:empty name="_uc_a01_01Form" property="depDayDayCondition">
                <html:select property="depDayDayCondition" size="1">
                  <thz:currentDateOptions var="day" selected="true" plusDay="7" />
                </html:select>日
              </logic:empty>
              <%-- 出発日：検索結果表示 入力された検索条件を使用する場合 --%>
              <logic:notEmpty name="_uc_a01_01Form" property="depDayYearCondition">
                <html:select property="depDayYearCondition" size="1">
                  <thz:currentDateOptions var="year" selected="false" plusDay="7" />
                </html:select>年 
              </logic:notEmpty>  
              <logic:notEmpty name="_uc_a01_01Form" property="depDayMonthCondition">
                <html:select property="depDayMonthCondition" size="1">
                  <thz:currentDateOptions var="month" selected="false" plusDay="7" />
                </html:select>月 
              </logic:notEmpty>       
              <logic:notEmpty name="_uc_a01_01Form" property="depDayDayCondition">
                <html:select property="depDayDayCondition" size="1">
                  <thz:currentDateOptions var="day" selected="false" plusDay="7" />
                </html:select>日
              </logic:notEmpty>
              <font id="comment-text">
              	(本日から1週間後以降の日付を入力してください)
              </font>
            </td>
            <th><label for="tourDaysCondition">日数</label></th>
            <td id="tour-days-td">
              <t:defineCodeList id="CODE_004" />
              <html:select property="tourDaysCondition">
                <html:options collection="CODE_004" labelProperty="name" property="id" />
              </html:select>
            </td>
          </tr>
          <tr>
            <th><label for="depCodeCondition">出発地</label></th>
            <td id="tour-starting-point-td">
              <t:defineCodeList id="CODE_009" />          
              <html:select name="_uc_a01_01Form" property="depCodeCondition">
                <html:option value="">県名を選択する</html:option>
                <html:options collection="CODE_009" labelProperty="name" property="id" />
              </html:select>
            </td>

            <th><label for="arrCodeCondition">目的地</label></th>
            <td id="tour-destination-td">
              <t:defineCodeList id="CODE_010" />
              <html:select name="_uc_a01_01Form" property="arrCodeCondition">
                <html:option value="">県名を選択する</html:option>
                <html:options collection="CODE_010" labelProperty="name" property="id" />
              </html:select>
            </td>
          </tr>
          <tr>
            <th><label>人数</label></th>
            <td id="search-condition-number">
            大人
              <t:defineCodeList id="CODE_006" />
              <html:select name="_uc_a01_01Form" property="adultCountCondition">
                <html:options collection="CODE_006" labelProperty="name" property="id" />
              </html:select>人&nbsp;&nbsp;
            子ども
              <t:defineCodeList id="CODE_007" />
              <html:select property="childCountCondition">
                <html:options collection="CODE_007" labelProperty="name" property="id" />
              </html:select>人
              <br/>※大人：１２歳以上 子ども：１２歳未満
            </td> 
            <th><label for="basePriceCondition">基本料金</label></th>
            <td id="search-condition-charge">
              <t:defineCodeList id="CODE_005" />
              <html:select property="basePriceCondition">
                <html:options collection="CODE_005" labelProperty="name" property="id" />
              </html:select>
            </td>
          </tr>          
        </table>

        <%-- begin buttons --%>
        <br/>
        <div align="right">  
          <html:hidden property="startIndex" value="0" />
          <ts:submit property="search" value="検索する" styleClass="com-normal-button" />
        </div>
        
    </ts:form> 
    <hr/>
                          
    <%-- ツアー検索結果件数 --%>
    <div class="com-message-panel" id="default-message-panel">
      <html:messages id="message" message="true">
        <p><bean:write name="message" ignore="true"/></p>
      </html:messages>
    </div>
        
    <%--result start --%>
    <%-- tourInfoList一覧表示 --%>    
    <logic:notEqual name="allListInfoLineCount" value="0">
      <logic:notEmpty name="_uc_a01_01Form" property="tourInfoList">
        <%-- ページリンク機能 --%>     
        <ts:pageLinks id="linkValue" action="/RP_A01_01_01_04BL.do" name="_uc_a01_01Form" rowProperty="row"
            totalProperty="allListInfoLineCount" indexProperty="startIndex" totalPageCount="totalPageCount"/>                    

        <div align="right">
          <bean:write name="currentPageIndex" />/<bean:write name="totalPageCount" />ページ    
          <bean:write name="linkValue" filter="false"/>
        </div>
        
        <br/>                 
        <table class="com-visible-table" summary="ツアー検索結果" id="search-result-table">
          <caption id="result-caption">ツアー検索結果&nbsp;&nbsp;
          	<font id="sort-base-text">※日数の多い順、基本料金の高い順</font>
          </caption>
          <tr>
            <th>通番</th>
            <th>ツアー名</th>
            <th>出発日</th>
            <th>日数</th>
            <th>出発地</th>
            <th>目的地</th>
            <th>基本料金</th>
          </tr>
          <logic:iterate id="TourInfo"
              name="_uc_a01_01Form"
              property="tourInfoList" indexId="index">
            <bean:define name="_uc_a01_01Form" property="startIndex" id="startIndex"/>                       
     <%
          int cnt = (Integer)startIndex;
          String tourNameCss = null;
          String noCss = null;
          String basePriceCss = null;
             if(index %2 ==0){   
                 tourNameCss = "tour-name-td-even";
                 noCss = "no-position-td-even";
                 basePriceCss = "basePrice-position-td-even";
             } else{  
                 tourNameCss = "tour-name-td-odd";
                 noCss = "no-position-td-odd";
                 basePriceCss ="basePrice-position-td-odd";
        }
      %>  
     
            <tr>
              <td id="<%=noCss %>" >
                <%= index + cnt + 1 %>
              </td>
              <td id="<%=tourNameCss %>">     
                <ts:link action="/RP_A01_01_01_03BL.do" 
                         paramName="TourInfo"
                         paramProperty="tourCode"
                         paramId="tourCode">
                  <bean:write name="TourInfo" property="tourName" />
                </ts:link>
              </td>
              <td id="<%=tourNameCss %>">
                <bean:write name="TourInfo" property="depDay" format="yyyy年MM月dd日"/>
              </td>
              <td id="<%=tourNameCss %>">
                <bean:write name="TourInfo" property="tourDays" />
              </td>
              <td id="<%=tourNameCss %>">
                <bean:write name="TourInfo" property="depName" />
              </td>
              <td id="<%=tourNameCss %>">
                <bean:write name="TourInfo" property="arrName" />
              </td>
              <td id="<%=basePriceCss %>">
                <bean:write name="TourInfo" property="basePrice" format="###,###円"/>
              </td>
            </tr>
          </logic:iterate>
        </table>
        <br/>
        <div align="right">
          <bean:write name="currentPageIndex" />/<bean:write name="totalPageCount" />ページ    
          <bean:write name="linkValue" filter="false"/>
        </div>      
      </logic:notEmpty>
    </logic:notEqual>
 
  </div>
</div>
<%-- end body--%>

<!-- begin-footer -->
<%@ include file="../SC_A99_00_02.jspf" %>
<!-- end-footer -->

</html:html>