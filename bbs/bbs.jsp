<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@  page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-Strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>掲示板</title>
<style type="text/css">
<!--
	*{padding:5px; margin:0px;}
	 body{text-align:center;}
	 table{width:800px; background:white; border:2px black solid; boeder-collapse:collapse;}
	 th{border:1px black solid; background:mediumspringgreen;}
	 td{border:1px black solid;}
-->
</style>
</head>
<body>
<center>
<h1>掲示板</h1>
<p><a href="newMessages.jsp">新規投稿</a></p>
<%
request.setCharacterEncoding("utf-8");
String[] value = {"title","name","message","year","month","day","hour","minute"};
BufferedReader br = new BufferedReader(new FileReader(
												"../messages/messages.txt"));
String rec;
ArrayList<Object> list = new ArrayList<>();
while((rec = br.readLine()) != null){
	String[] strAry = rec.split(",");
	HashMap<String,String> map = new HashMap<>();
	for(int i = 0; i < strAry.length; i++){
		map.put(value[i], strAry[i]);
	}
	list.add(map);
}
for(int i = list.size() - 1; i >= 0; i--){
	HashMap<String,String> map = (HashMap<String,String>)list.get(i);
%>
	<table>
	<tr><th width="40%">タイトル:<%= map.get("title") %></th>
	<th width="25%">投稿者:<%= map.get("title") %></th>
	<th width="35%">投稿日時:<%= map.get("year") %>年<%= map.get("month") %>月<%= map.get("day") %>日
	<%= map.get("hour") %>時<%= map.get("minute") %>分</th></tr>
	<tr><td colspan="3" align="left"><%= map.get("message") %></td></tr>
	</table>
	<br/>
	<% }
		br.close(); %>
</center>
</body>
</html>