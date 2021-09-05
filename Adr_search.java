package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Adr_search extends Adr_book{

	public Adr_search() {
		super();
	}

	public Adr_search(String name) {
		
	}

	public static ArrayList<Adr_book> searchAdr(String name){
		Connection con = null;
		PreparedStatement pst = null;
		String sql = null;
		ResultSet rs = null;
		Adr_book a = null;
		ArrayList ad = new ArrayList<Adr_book>();
		try{
			/*コネクションインターフェース型に接続を実装*/
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root","haku99");
			//事前に骨子となるSQL文を生成
			sql = "SELECT * FROM 	adr_book\n"
					+ "LEFT JOIN gender USING(gender_id)\n"
					+ "LEFT JOIN district USING(dst_id)\n"
					+ "LEFT JOIN genre USING(gnr_id)"
					+ "  WHERE adb_name like " + "'%" + name + "%'\n"
							;
			//PreparedStatementオブジェクトの生成
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			//生成したSQL文をプリコンパイル
			
			while(rs.next()) {
				 a = new Adr_book();
				 
				 
				 a.setAdb_id(Integer.toString(rs.getInt("adb_id")));
				 a.setAdb_name(rs.getString("adb_name"));
				 a.setAdb_reading(rs.getString("adb_reading"));
				 a.setGender_id(Integer.toString(rs.getInt("gender_id")));
				 a.setGender_name(rs.getString("gender_name"));
				 a.setAdb_zip(rs.getString("adb_zip"));
				 a.setAdb_address(rs.getString("adb_address"));
				 a.setAdb_phone(rs.getString("adb_phone"));
				 a.setAdb_mail(rs.getString("adb_mail"));
				 a.setAdb_add_day(rs.getString("adb_add_day"));
				 a.setDst_id(Integer.toString(rs.getInt("dst_id")));
				 a.setDst_name(rs.getString("dst_name"));
				 a.setGnr_id(Integer.toString(rs.getInt("gnr_id")));
				 a.setGnr_name(rs.getString("gnr_name"));
				 
					/*
					 * if(a.getAdb_address() == null) { a.setAdb_address("不明"); }
					 */
				 ad.add(a);
			}

			
			 
		}catch(SQLException e){
			System.out.println(pst);
			System.out.println("郵便番号がありません。");
		}finally{
			try{
				//クローズ処理
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			}catch(final SQLException e){
				e.printStackTrace();
			}
	
	}
		return ad;
	}
	
	public void infomation() {
		
	}
}
