<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>郵便番号検索</title>
		<style type="text/css">
			<!--
				p{font-size:35px;}
			-->
		</style>
		<!-- 郵便番号入力入力確認 -->
		<script type="text/javascript">
			<!--
				function frmCheck(){
				var checkYubin = document.frm1.yubin.value;
				if(!checkYubin.match(/^[0-9])+$/)){
					alert("数字を入力してください");
					document.frm1.yubin.focus();
					return false;
				}else if(!checkYubin.match(/^{7})$/)){
					alert("数字を7桁入力してください");
					document.frm1.yubin.focus();
					return false;
				}else{
				//return true;

				}
			}

			//-->
		</script>
	</head>
	<body>
		<!-- データベース（yubin）よりパラメータの郵便番号に該当する住所情報を取得する -->
		<%
			String yubin 	= "";		// 郵便番号（リクエスト・パラメータ）
			String pCode 	= "";		// 郵便番号（データベース・yubin）
			String todo 	= "";		// 都道府県名
			String shi 		= "";		// 区市町村名
			String cho 		= "";		// 町域名
			int    cnt 		= 0;		// 検索フラグ  0:未処理　1:該当なし　2:該当あり

			if(request.getParameter("yubin") != null){
				yubin = request.getParameter("yubin");


			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root","root");

			Statement st = con.createStatement();
			String sql = "SELECT * FROM yubin WHERE postcode = '" + yubin + "'";
			ResultSet 	rs = st.executeQuery(sql);

			cnt = 1;
			while(rs.next()){ //結果セットの行数がある限り繰り返す
				//第二のコンストラクターでオブジェクトの作成
				pCode = rs.getString("postcode");
						         todo = rs.getString("todo");
						         shi = rs.getString("shi");
						         cho = rs.getString("cho");
						         cnt = 2;
			}
			rs.close();
			st.close();
			con.close();

			}
		%>
		<!-- 検索郵便番号　入力フォーム -->
		<form id="frm1" name="frm1" method="post" action="yubin_search.jsp" onsubmit="return frmCheck()">
			<h1>検索したい郵便番号を入力してください。</h1>
			郵便番号<input type="text" name="yubin" />
					<input type="submit" value="検索" />
		</form>
		<!-- 検索結果表示 -->
		<% if(cnt == 2){ %>
			<p>郵便番号：<%= pCode %>
				住所：<%= todo %><%= shi %><%= cho %></p>
		<% }else if(cnt == 1){ %>
			<p>一致する郵便番号がありませんでした。</p>
		<% } %>
	</body>
</html>