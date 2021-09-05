package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class Adr_book {
		private String adb_id;
		private String adb_name;
		private String adb_reading;
		private String gender_id;
		private String gender_name;
		private String adb_zip;
		private String adb_address = "";
		private String adb_phone;
		private String adb_mail;
		private String adb_add_day;
		private String dst_id;
		private String dst_name;
		private String gnr_id;
		private String gnr_name;
		public String getAdb_id() {
			return adb_id;
		}
		public void setAdb_id(String adb_id) {
			this.adb_id = adb_id;
		}
		public String getAdb_name() {
			return adb_name;
		}
		public void setAdb_name(String adb_name) {
			this.adb_name = adb_name;
		}
		public String getAdb_reading() {
			return adb_reading;
		}
		public void setAdb_reading(String adb_reading) {
			this.adb_reading = adb_reading;
		}
		public String getGender_id() {
			return gender_id;
		}
		public void setGender_id(String gender_id) {
			this.gender_id = gender_id;
		}
		public String getGender_name() {
			return gender_name;
		}
		public void setGender_name(String gender_name) {
			this.gender_name = gender_name;
		}
		public String getAdb_zip() {
			if(adb_zip == null) {
				adb_zip = "不明";
			}
			return adb_zip;
		}
		public void setAdb_zip(String adb_zip) {
			this.adb_zip = adb_zip;
		}
		public String getAdb_address() {
			return adb_address;
		}
		public void setAdb_address(String adb_address) {
			this.adb_address = adb_address;
		}
		public String getAdb_phone() {
			return adb_phone;
		}
		public void setAdb_phone(String adb_phone) {
			this.adb_phone = adb_phone;
		}
		public String getAdb_mail() {
			return adb_mail;
		}
		public void setAdb_mail(String adb_mail) {
			this.adb_mail = adb_mail;
		}
		public String getAdb_add_day() {
			return adb_add_day;
		}
		public void setAdb_add_day(String adb_add_day) {
			this.adb_add_day = adb_add_day;
		}
		public String getDst_id() {
			return dst_id;
		}
		public void setDst_id(String dst_id) {
			this.dst_id = dst_id;
		}
		public String getDst_name() {
			return dst_name;
		}
		public void setDst_name(String dst_name) {
			this.dst_name = dst_name;
		}
		public String getGnr_id() {
			return gnr_id;
		}
		public void setGnr_id(String gnr_id) {
			this.gnr_id = gnr_id;
		}
		public String getGnr_name() {
			return gnr_name;
		}
		public void setGnr_name(String gnr_name) {
			this.gnr_name = gnr_name;
		}
		
		public static void adrAdd(Object Adr_book) {
			Connection con = null;
			PreparedStatement pst = null;
			String sql = null;
			ResultSet rs = null;
			try{
				/*コネクションインターフェース型に接続を実装*/
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/test", "root","haku99");
				//事前に骨子となるSQL文を生成
				sql = "INSERT INTO adr_book\n"
						+ "		VALUES(?,?,?,?,?,?,?,?,?,?,?)";
				//PreparedStatementオブジェクトの生成
				//生成したSQL文をプリコンパイル
				pst = con.prepareStatement(sql);
				
				pst.setInt(1, 0);
				pst.setString(2, ((DB.Adr_book) Adr_book).getAdb_name());
				pst.setString(3, ((DB.Adr_book) Adr_book).getAdb_reading());
				pst.setInt(4, Integer.parseInt(((DB.Adr_book) Adr_book).getGender_id()));
				pst.setString(5, ((DB.Adr_book) Adr_book).getAdb_zip());
				pst.setString(6, ((DB.Adr_book) Adr_book).getAdb_address());
				pst.setString(7, ((DB.Adr_book) Adr_book).getAdb_phone());
				pst.setString(8, ((DB.Adr_book) Adr_book).getAdb_mail());
				pst.setString(9, ((DB.Adr_book) Adr_book).getAdb_add_day());
				pst.setInt(10, Integer.parseInt(((DB.Adr_book) Adr_book).getDst_id()));
				pst.setInt(11, Integer.parseInt(((DB.Adr_book) Adr_book).getGnr_id()));
				
				pst.executeUpdate(sql);
				
				System.out.println("登録しました。");



			}catch(SQLException e){
				System.out.println(pst);
				System.out.println("郵便番号がありません。");
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
			}
		
		
}
