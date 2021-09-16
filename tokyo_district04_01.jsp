<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Tokyo District02</title>
		<style type="text/css">
			<!--
				table{width:200px; border-collapse:collapse; text-align:center;}
				caption{color:red; font-size:25;}
				td{border:2px black solid; padding:5px;}
			-->
		</style>

	</head>
	<body>
		<center>
			<%!
				String[] district = {"中央区","千代田区","港区","品川区","大田区","目黒区",
					"渋谷区","世田谷区","新宿区","中野区","杉並区","練馬区","板橋区","豊島区","文京区",
					"台東区","荒川区","北区","足立区","葛飾区","江戸川区","墨田区","江東区"};
			%>
			<h3>滞在してみたい区を選択してください。</h3>
			<table>
				<caption>東京23区一覧</caption>
				<!-- 23区の名称を表示 -->
				<%for(int i = 0; i < district.length ; i++){%>
				     <tr>
				     	<td>
				     		<form action="tokyo_stay03.jsp" method="post">

				     			<input type="hidden" name="district" value="<%= district[i] %>"/>
				     			<input type="submit" value="<%= district[i] %>"/>
				     		</form>
				     	</td>

				     </tr>
				<%} %>
			</table>
		</center>
	</body>
</html>







