<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="chap06.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
			<title>menuMaintenance</title>
			<style>
			body{text-align:cnter;}
			h1{text-align: center;}
			th{text-align:cnter; background:#7fffd4; color:white;}
			th#th1{width:30px;}
			th#th2{width:100px;}
			th#th3{width:120px;}
			th#th4{width:80px;}
			td#td2{text-align: left; width:100px;}
			td#td4{text-align: left; width:100px;}
			td#td6{background:#7fffd4;}
			table.t2{margin-left: auto; margin-right: auto;}
			td{text-align: center;}
			p.p1{background:#7fffd4; color:white;}
			
			</style>
			<script type="text/Javascript">
			<!--
			function newMes(){
				document.frm1.submit();
			}
			
			function deleteMes(let){
				document.frm2.num.value=let;
				document.frm2.submit();
			}
			
			function updateMes(let){
				document.frm3.num.value=let;
				document.frm3.submit();
			}
				function check(id){
				let l = id;
				document.frm1.id.value = l;
				document.frm1.submit();

			}
				document.getElementById('p1').addEventListener('click',
						  function () {
						    this.style.backgroundColor = "#7fffd4";
						  }

			
			//-->

		</script>
		</head>
	<body>
	<% NumberFormat nf = NumberFormat.getInstance(); %>
		<h1><p class="p1">===メニューマスターメンテナンス===</p></h1>

		<table>
		<tr>
			<th>コース料理</th>
		</tr>
		<%
				//MenuType一覧の取得 MenyTypeクラスのgetAll()メソッド
				ArrayList<MenuType> menu = (ArrayList<MenuType>)request.getAttribute("menu");
			if(menu == null){
				response.sendRedirect("MenuController");
				return;
			}
				//取得したMenuType一覧を表にして表示
				for(int i = 0 ; i < menu.size() ; i++){
					MenuType m = menu.get(i);
			%>
							<form id="frm1" name="frm1" action = "CityController" method = "post">
				<tr >
						<td id = "td1"><a onclick="check(<%= m.getOneMenu() %>)"><%= m.getTypeName() %></a></td>
						<td id = "td1">
								<input type = "hidden" name = "id" value = "<%= m.getOneMenu() %>" />
							</form>
						</td>
					</tr>
					<% } %>
		</table>

			//クリックされたら表示するメニュー表
		<jsp:useBean id="Menu" class="chap06.Menu" scope="request"/>
		<table class="t2">

			<tr id = "head">
				<th id = "th1">ID</th>
				<th id = "th2">メニュー</th>
				<th id = "th3">価格</th>
				<th id = "th4">コメント</th>
				<th id = "th5">オーダー</th>
				<th colspan="2" id = "th6">&nbsp;</th>

			</tr>
		<tr id = "tr<%=  2 %>">
						<td id="td1"><jsp:getProperty property="m_id" name="city2"/></td>

						<td id="td1"><jsp:getProperty property="m_Name" name="city2"/></td>
						<td id="td2"><jsp:getProperty property="price" name="city2"/></td>
						<td id="td3"><jsp:getProperty property="detail" name="city2"/></td>
						<td id="td4"><jsp:getProperty property="orderFlg" name="city2"/></td>
							<form id="frm2" name="frm2" action = "MenuController" method = "post">
						<td id="td5"><input type = "submit" value = "更新" /></td>

								<input type = "hidden" name = "id" value = "<%= m.getOneMenu() %>" />

							</form>
						</td>
					</tr>
					<td id="td6" colspan="7"><input type="submit" value="新しいメニューの追加" action="insertMenu.jsp"></input></td>
		</table>
	</body>
</html>