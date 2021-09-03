package chap05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Yubin {
	private String PostCode;
	private String todo;
	private String shi;
	private String cho;

	public String getPostCode() {
		return PostCode;
	}
	public void setPostCode(String number) {
		this.PostCode = number;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public String getCho() {
		return cho;
	}
	public void setCho(String cho) {
		this.cho = cho;
	}

	public Yubin(){

	}

	public Yubin(String number,String todo,String shi,String cho){
		this.PostCode = number;
		this.todo = todo;
		this.shi = shi;
		this.cho = cho;
	}

	public static void address(String PostCode){
		Connection con = null;
		Statement st = null;
		String sql = null;
		ResultSet rs = null;
		try{
			/*コネクションインターフェース型に接続を実装*/
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root","root");
			//事前に骨子となるSQL文を生成
			sql = "SELECT postcode,todo,shi,cho FROM yubin WHERE postcode = " + PostCode;
			//PreparedStatementオブジェクトの生成
			//生成したSQL文をプリコンパイル
			st = con.prepareStatement(sql);
			rs = st.executeQuery(sql);

			while(rs.next()){
			System.out.print("郵便番号:" + rs.getString("postcode") + " ");
			System.out.print(rs.getString("todo") + " ");
			System.out.print(rs.getString("shi") + " ");
			System.out.print(rs.getString("cho"));
			System.out.println();

			}



		}catch(SQLException e){
			System.out.println(st);
			e.printStackTrace();
		}finally{
			try{
				//クローズ処理
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
