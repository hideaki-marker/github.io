<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@ page import="java.sql.*" %>
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
			th#th2{width:100px;}
			th#th3{width:120px;}
			th#th4{width:80px;}
			td#td2{text-align: left; width:100px;}
			td#td4{text-align: left; width:100px;}
			td#td6{background:#7fffd4;}
			table.t2{margin-left: auto; margin-right: auto;}
			td{text-align: center;}
			td#td1{border:1px black solid;}
			p.p1{}

			</style>
			<script type="text/javascript">
		<!-- 
			function newMes(){
			document.frm1.submit();
		}
		
		document.frm1.td1.addEventListener('click', function() {
			 
		    document.frm1.submit();
		 
		});
		
		function updateMes(val){
			document.frm3.num.value=val;
			document.frm3.submit();
		}
		
		
		//-->
		</script>

<body>

<% NumberFormat nf = NumberFormat.getInstance(); %>
<h1><p id="p1" class="p1">===メニューマスターメンテナンス===</p></h1>
 <table>
		<tr>
			<th>コース料理</th>
		</tr>
<% 
				request.setCharacterEncoding("utf-8");
			
				Class.forName("com.mysql.jdbc.Driver");
			
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","haku99");
				String sql = "SELECT * FROM menutype ";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()){
				int num = rs.getInt("t_id");
			%>
			

						<form id="frm1" name="frm1"  action = "NewFile.jsp" >
				<tr onclick="frmCheck()">
						<td id = "td1" name="td1"><a ><%= rs.getString("t_name") %></a></td>
						<td id = "td1"><input type="submit" value="変更"/>
								<input type = "hidden" name = "id"  value="<%= rs.getInt("t_id") %>"/>
							</form>
						</td>
					</tr>
				
					
					<%
			}
			rs.close();
			st.close();
			con.close();
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
			<% 
			String id = request.getParameter("id");
			
				Connection conr = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","haku99");
				String sqll = "SELECT * FROM menu  WHERE t_id =  ? ";
				PreparedStatement pst = conr.prepareStatement(sqll);
				pst.setString(1, id);
				ResultSet rsr = pst.executeQuery();
				int cnt = 1;
				while(rsr.next()){
					cnt = 2;
				
			%>
			
			<% 
			if(cnt == 2){
			
			%>
			<tr>
			<td><%= rsr.getInt("m_id") %></td>

						<td id="td2"><%= rsr.getString("m_Name") %></td>
						<td id="td3"><%= rsr.getString("price") %></td>
						<td id="td4"><%= rsr.getString("detail") %></td>
						<td id="td5">可</td>
				
						<td><input type = "submit" value = "更新" /></td>

								

							
						<td><input type = "submit" value = "削除" /></td>
					</tr>
					<%
			}
				}	
			rs.close();
			st.close();
			con.close();
			%> 
					<td id="td6" colspan="7"><input type="submit" value="新しいメニューの追加" action="insertMenu.jsp"></input></td>
</table>
</body>
</html>