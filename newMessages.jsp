<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-Strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新規投稿</title>
<style type="text/css">
<!--
	*{padding:5px; margin:0px;}
	 body{text-align:center;}
	 table{width:800px; background:white; border:2px black solid; border-collapse:collapse;}
	 th{border:1px black solid; background:mediumspringgreen;}
	 td{border:1px black solid; text-align:left;}
	 td#button{border:1px black solid; text-align:center;}
-->
</style>
</head>
<body>
<center>
<h1>新規投稿</h1>
<form id="frm1" name="frm1" method="post" action="/Tomcat8/chap02/PostMessages">
<table>
<tr><th>タイトル</th><td><input type="text" name="title" maxlength="50" size="50"/></td></tr>
<tr><th>名前</th><td><input type="text" name="name" maxlength="20" size="30"/></td></tr>
<tr><th>内容</th><td><textarea name="messages" cols="70" rows="20"/></textarea></td></tr>
<tr><td colspan="2" id="button"><input type="submit" value="新規投稿"/>
<input type="reset" value="消去"/></td></tr>
</table>
</form>
</center>
</body>
</html>