package chap05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Adr_book_A {

	//	フィールド
	private int 	adb_id;		//登録番号
    private String 	adb_name;	//氏名
    private String 	adb_reading;//よみがな
    private int 	gender_id;	//性別
    private String 	gender_name;//性別
    private String 	adb_zip;	//郵便番号
    private String 	adb_address;//住所
    private String 	adb_phone;	//電話番号
    private String 	adb_mail;	//メールアドレス
    private String 	adb_add_day;//登録日時
    private int 	dst_id;		//地域
    private String 	dst_name;	//地域
    private int 	gnr_id;		//関係
    private String 	gnr_name;	//関係
    //アクセスメソッド

	public int getAdb_id() {
		return adb_id;
	}
	public void setAdb_id(int adb_id) {
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
	public int getGender_id() {
		return gender_id;
	}
	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}
	public String getGender_name() {
		return gender_name;
	}
	public void setGender_name(String gender_name) {
		this.gender_name = gender_name;
	}
	public String getAdb_zip() {
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
	public int getDst_id() {
		return dst_id;
	}
	public void setDst_id(int dst_id) {
		this.dst_id = dst_id;
	}
	public String getDst_name() {
		return dst_name;
	}
	public void setDst_name(String dst_name) {
		this.dst_name = dst_name;
	}
	public int getGnr_id() {
		return gnr_id;
	}
	public void setGnr_id(int gnr_id) {
		this.gnr_id = gnr_id;
	}
	public String getGnr_name() {
		return gnr_name;
	}
	public void setGnr_name(String gnr_name) {
		this.gnr_name = gnr_name;
	}
	//住所録情報　登録メソッド
	public static void adrAdd(Adr_book_A adr){
		Connection 			con = null;		//コネクション
		PreparedStatement	pst = null;		//プリペアードステートメント
		String 				sql = null;		//SQL文
		try{
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root","root");
			//makerテーブルにレコードを登録する骨子となるSQL文を生成
			sql = "INSERT INTO adr_book VALUES(null,?,?,?,?,?,?,?,null,?,?)";
			//生成したSQL文をプリコンパイル
			pst = con.prepareStatement(sql);
			//インパラメータを設定
			pst.setString(1,adr.getAdb_name());
			pst.setString(2,adr.getAdb_reading());
			pst.setInt(3,adr.getGender_id());
			pst.setString(4,adr.getAdb_zip());
			pst.setString(5,adr.getAdb_address());
			pst.setString(6,adr.getAdb_phone());
			pst.setString(7,adr.getAdb_mail());
			pst.setInt(8,adr.getDst_id());
			pst.setInt(9,adr.getGnr_id());
			//挿入実行
			pst.executeUpdate();
		}catch(SQLException e){
			System.out.println("エラーが発生しました。(登録処理)");
			e.printStackTrace();
		}finally{
			//クローズ
			try {
				if(pst != null){
					pst.close();
				}
				if(con != null){
					con.close();
				}

			}catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
	//住所録情報　検索メソッド
	public static ArrayList<Adr_book_A> searchAdr(String name){
		ArrayList<Adr_book_A> ary =  new ArrayList<>();
		Connection 			con = null;		//コネクション
		PreparedStatement	pst = null;		//プリペアードステートメント
		ResultSet 			rs 	= null;		//リザルトセット
		String 				sql = null;		//SQL文
		try{
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root","root");
			//骨子となるSQL文を生成
			sql = "SELECT * FROM adr_book JOIN gender USING(gender_id) JOIN district USING(dst_id) JOIN genre USING(gnr_id) WHERE adb_name LIKE(?)";
			//生成したSQL文をプリコンパイル
			pst = con.prepareStatement(sql);
			//インパラメータを設定
			pst.setString(1,"%" + name + "%");
			rs = pst.executeQuery();
			while(rs.next()){ //結果セットの行数がある限り繰り返す
				Adr_book_A adr = new Adr_book_A();
				adr.setAdb_id(rs.getInt("adb_id"));
				adr.setAdb_name(rs.getString("adb_name"));
				adr.setAdb_reading(rs.getString("adb_reading"));
				adr.setGender_id(rs.getInt("gender_id"));
				adr.setGender_name(rs.getString("gender_name"));
				adr.setAdb_zip(rs.getString("adb_zip"));
				adr.setAdb_address(rs.getString("adb_address"));
				adr.setAdb_phone(rs.getString("adb_phone"));
				adr.setAdb_mail(rs.getString("adb_mail"));
				adr.setAdb_add_day(rs.getString("adb_add_day"));
				adr.setDst_id(rs.getInt("dst_id"));
				adr.setDst_name(rs.getString("dst_name"));
				adr.setGnr_id(rs.getInt("gnr_id"));
				adr.setGnr_name(rs.getString("gnr_name"));
				ary.add(adr);
			}
		}catch(SQLException e){
			System.out.println("エラーが発生しました。(検索処理)");
			e.printStackTrace();
		}finally{
			//クローズ
			try {
				if(rs != null){
					rs.close();
				}
				if(pst != null){
					pst.close();
				}
				if(con != null){
					con.close();
				}

			}catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		// 対象情報が0件の時はNULLを返す。
		if(ary.size() > 0){
			return ary;
		}else{
			return null;
		}
	}
	// 住所情報表示メソッド
	public void information(){
		System.out.print(" 登録番号：" + getAdb_id());
		System.out.print(" 名前：" + getAdb_name());
		System.out.print(" よみがな：" + getAdb_reading());
		System.out.print(" 郵便番号：" + getAdb_zip());
		System.out.print(" 住所：" + getAdb_address());
		System.out.print(" 電話：" + getAdb_phone());
		System.out.print(" メール：" + getAdb_mail());
		System.out.print(" 登録日時：" + getAdb_add_day());
		System.out.print(" 地域：" + getDst_name());
		System.out.println(" 関係：" + getGnr_name());
	}
}
