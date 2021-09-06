package chap05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Yubin_A {
	// フィールド
	private String postcode;
	private String todo;
	private String shi;
	private String cho;
	// コンストラクター
	public Yubin_A(){}
	public Yubin_A(String postcode,String todo,String shi,String cho){
		this.postcode 	= postcode;
		this.todo 		= todo;
		this.shi 		= shi;
		this.cho 		= cho;
	}
	// アクセスメソッド
	public String getPostcode() {
		return postcode;
	}
	public String getTodo() {
		return todo;
	}
	public String getShi() {
		return shi;
	}
	public String getCho() {
		return cho;
	}
	/*	引数(郵便番号)でデータベース郵便テーブル(yubin)
		より、郵便情報（都道府県、市区町村、町域を持つ
		Yubinクラスのオブジェクト）を返す。
	*/
	public static Yubin_A getYubin(String postcode){
		Yubin_A 				yub = null;
		Connection 			con = null;
		PreparedStatement 	pst = null;
		ResultSet 			rs 	= null;
		String 				sql = "SELECT * FROM yubin WHERE postcode = ?";
		try{
			/*コネクションインターフェース型に接続を実装*/
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root","root");
			//SQL文の送信、結果のやり取りを行うオブジェクトの生成
			pst = con.prepareStatement(sql);
			pst.setString(1, postcode); //第二引数は代入する値
			//SQL文を実行してDBから結果セットを得る
			rs = pst.executeQuery();
			while(rs.next()){ //結果セットの行数がある限り繰り返す
				yub = new  Yubin_A(rs.getString("postcode"),
						         rs.getString("todo"),
						         rs.getString("shi"),
						         rs.getString("cho"));
			}
		}catch(SQLException e){
			System.out.println("郵便番号検索中に障害が発生しました！");
			System.out.println(sql);
			e.printStackTrace();
		}finally{
			try{
				//クローズ処理
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return yub;
	}
}
