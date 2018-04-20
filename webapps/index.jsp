<%--
@(#)index.jsp
Copyright (C) 2007, 2010 NTT DATA Corporation. All Rights Reserved.:
Description : welcome画面に遷移する。


--%>

<%@ page contentType="text/html; charset=Windows-31J" language="java" pageEncoding="Windows-31J" %>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html:html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=shift_jis"/>
    <title>-</title>
  </head>
  <body>

    <logic:redirect forward="welcome"/>

  </body>
</html:html>