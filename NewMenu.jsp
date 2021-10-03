<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*" %>
<%@ page import="chap02.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<style>
			body{text-align:cnter;}
			h1{text-align: center;}
			th{text-align:cnter; background:#7fffd4; color:white;}
			th#th1{width:30px;}
			th#th2{width:200px;}
			th#th3{width:300px;}
			th#th4{width:350px;}
			td#td2{text-align: left; width:100px;}
			td#td4{text-align: left; width:100px;}
			td#td6{background:#7fffd4;}
			table.t1{float:left;}
			table.t2{float:left;}
			td{text-align: center;}
			td#td1{border:1px black solid;}
			p.p1{}
			.tr0{background:#white;}
			.tr1{background:#7fffd4;}
			

			</style>
			<script type="text/javascript">
		<!-- 
			function newMes(){
			document.frm1.submit();
		}
		
		document.getElementById('td1').addEventListener('click',
				  function () {
				    this.style.backgroundColor = "#7fffd4";
				  }
		
		function updateMes(val){
			document.frm3.num.value=val;
			document.frm3.submit();
		}
		
		
		//-->
		</script>

<body>

<% NumberFormat nf = NumberFormat.getInstance(); %>
<h1><p id="p1" class="p1">===メニューマスターメンテナンス===</p></h1>
 <table class="t1">
		
<% 
		
      ArrayList<MenuType> me = MenuType.getAllType();
		for(int i = 0; i < me.size(); i++){
			MenuType m = me.get(i);
			%>
			

						<form id="frm1" name="frm1"  action = "NewFile.jsp" >
				<tr onclick="frmCheck()">
						<td id = "td1" name="td1"><a ><%= m.getTypeName() %></a></td>
						<td id = "td1"><input type="submit" value="変更"/>
								<input type = "hidden" name = "id"  value="<%= m.getTypeID() %>"/>
								<input type = "hidden" name = "name"  value="<%= m.getTypeName() %>"/>
							</form>
						</td>
					</tr>
				
					
					<%
			}
			%>
							
					
</table>
<table class="t2">

			<tr id = "head">
				<th id = "th1">ID</th>
				<th id = "th2">メニュー</th>
				<th id = "th3">価格</th>
				<th id = "th4">コメント</th>
				<th id = "th5">オーダー</th>
				<th colspan="2" id = "th6">&nbsp;</th>
				
			</tr>
			<tr><h1>--<%= request.getParameter("name") %>--</h1></tr>
			<% 
			
			int id = 100;
			
			if(request.getParameter("id") != null){
			id = Integer.parseInt(request.getParameter("id"));
			}
			ArrayList<Menu> mm = Menu.getMenu(id);
			if(mm != null){
			
			for(int i = 0; i < mm.size(); i++){
				Menu m = mm.get(i);
				
			%>
			
			<tr class="tr<%= m.getMenuID() % 2 %>">
			<td><%= m.getMenuID() %></td>

						<td id="td2"><%= m.getMenuName() %></td>
						<td id="td3"><%= m.getPrice() %></td>
						<td id="td4"><%= m.getDetail() %></td>
						<td id="td5">可</td>
				
						<td><input type = "submit" value = "更新" action="updateMenu.jsp"/></td>

								

							
						<td><input type = "submit" value = "削除" action="deleteMenu.jsp"/></td>
					</tr>
					
			<% } 
			}else{ %>
				<tr><td>メニューなし</td></tr>
			<% }%> 
					<td id="td6" colspan="7"><input type="submit" value="新しいメニューの追加" action="insertMenu.jsp"></input></td>
</table>
</body>
</html>