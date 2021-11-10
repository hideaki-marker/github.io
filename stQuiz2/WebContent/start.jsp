<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html:html xhtml="true">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>地方読みクイズ</title>
	</head>
	<body>

	<logic:equal name="allSelect" value="">
		<logic:redirect forward="selectPrefAction"/>
	</logic:equal>

		<html:form action="/SelectAreaAction">
		<h1>地方の読み方を当てるクイズです。</h1>
		<h3>地方を選択してください。</h3>
		<html:select property="area" value="北海道">
		<logic:iterate id="data" name="allSelect" property="select" scope="session">
				<html:option value="<%=data.toString() %>"><%=data.toString() %></html:option>
				<br />
			</logic:iterate>
		</html:select>
		<br />
		<br />
		<br />
		<html:submit property="submit" value="決定"/>
		</html:form>
	</body>
</html:html>