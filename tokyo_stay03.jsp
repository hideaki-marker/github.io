<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Tokyo Stay01</title>
	</head>
	<body>
	<center>
	<% request.setCharacterEncoding("utf-8");
	   String name = request.getParameter("district");
	  %>
	   <p>あなたが選択した区は</p>
	   <p><font size="8"><%= name %></font><font size="4">です。</font></p>

	<p><a href="tokyo_district04_01.jsp">戻る</a></p>
	</center>
	</body>
</html>