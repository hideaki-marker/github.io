<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>掲示板</title>
		<style type="text/css">
			<!--
				*{padding:5px; margin:0px;}
				body{text-align:center;}
				table{width:800px; background:white; border:2px black solid; border-collapse:collapse;}
				th{border:1px black solid; background:#CCCCFF;}
				td{border:1px black solid;}
				td#button{border:1px black solid; text-align:right;}
			-->
		</style>
		<script type="text/javascript">
		<!--
		function newMes(val){
			alert("newMes");
			document.frm1.submit();
		}

		function deleteMes(val){
			document.frm2.num.value=val;
			document.frm2.submit();
		}



		//-->
		</script>
	</head>
	<body>
		<center>
			<h1>掲示板</h1>
			<p><a href="#" onclick="newMes()">新規投稿</a></p>
			<%
			request.setCharacterEncoding("utf-8");
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection con =DriverManager.getConnection
			//	("jdbc:mysql://localhost:3306/test","root","root");
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:comp/env/mysql");
			Connection con = ds.getConnection();
			//Statement st = con.createStatement();
			String sql = "SELECT * FROM bbs ORDER BY bbs_id DESC";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			while(rs.next()){
				int num = rs.getInt("bbs_id");
			%>
			<table>
				<tr><th width="40%">タイトル：<%= rs.getString("bbs_title") %></th>
				<th width="25%">投稿者：<%= rs.getString("bbs_name") %></th>
				<th width="35%">投稿日時：<%= rs.getString("bbs_date") %></th></tr>
				<tr><td colspan="3" align="left"><%= rs.getString("bbs_text") %></td></tr>
				<tr><td colspan="3" id="button"><a href="#" onclick="deleteMes('<%= num %>')">削除</a></td></tr>
			</table>
			<br/>
			<%
			}
			rs.close();
			pst.close();
			con.close();
			%>
			<form id="frm1" name="frm1" method="post" action="newMessagesEx.jsp">
			<input type="hidden" name="mode" value="1"/>
			</form>
			<form id="frm2" name="frm2" method="post" action="deleteMessagesEx.jsp">
			<input type="hidden" name="num"/>
			<input type="hidden" name="mode" value="2"/>
			</form>
		</center>
	</body>
</html>