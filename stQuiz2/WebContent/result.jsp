<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html:html xhtml="true">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>地名読み結果</title>
		<style>

		body {
				max-width: 100%;
				height: auto;
				text-align: center;
				background-image:url("img/003.jpg");
}
				</style>
	</head>
	<body>
		<p><bean:write name="choice" property="town"/></p>
		<br />
		<p><bean:write name="result"  scope="request"/></p>
		<br />
		<br />
		<html:link action="/Start">「スタートページに戻る」</html:link>
	</body>
</html:html>