package jp.struts.stQuiz2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class QuizBean {
	//フィールド
	private String area;
	private String town;
	private String townReading;

	public QuizBean() {
		super();
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getTownReading() {
		return townReading;
	}

	public void setTownReading(String townReading) {
		this.townReading = townReading;
	}

	public void execute() throws Exception{

		//住所情報をランダムで取得する際の乱数オブジェクト
		Random random = new Random();

		InitialContext ic = new InitialContext();
		DataSource ds = (DataSource) ic.lookup("java:comp/env/mysql");
		Connection con = ds.getConnection();
		int firstNo = 0;
		int count = 0;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM yubin WHERE todo = ?  ");
		PreparedStatement pst =  con.prepareStatement(sql.toString());
		pst.setString(1, this.area);
		ResultSet rs = pst.executeQuery();

		while(rs.next()){
			if(rs.isFirst()) firstNo = rs.getInt("no");
			count++;
		}
		System.out.println(firstNo);
		System.out.println(count);
		//都道府県情報の取得
		sql.delete(0, sql.length());
		sql.append("SELECT * FROM yubin WHERE todo = ?  AND no = ?");
		pst =  con.prepareStatement(sql.toString());
		pst.setString(1, this.area);
		//areaの範囲のnoをランダムで取得
		pst.setInt(2, random.nextInt(count - 1) + firstNo);
		try{
		rs = pst.executeQuery();
		//情報の取得
		if(rs.next()){
			String twn = rs.getString("cho");

			//取得したchoの情報に"（"があるかの判定
					if(twn.contains("（")){
						//"（"があったらその位置のインデックスを取得
				int cut =twn.indexOf("（");
				//スタートから”（”のインデックスまでを切り取る
				twn = twn.substring(0, cut);
				//値をセット
				this.town = twn;
					}else{
						//無ければそのままセット
						this.town = twn;
					}
					String twnRead = rs.getString("kana_cho");
					//取得したkana_choの情報に"("があるかの判定
					if(twnRead.contains("(")){
						//"("があったらその位置のインデックスを取得
						int cut =twnRead.indexOf("(");
						//スタートから”（”のインデックスまでを切り取る
						twnRead = twnRead.substring(0, cut);
						//値をセット
						this.townReading = twnRead;
							}else{
								//無ければそのままセット
								this.townReading = twnRead;
							}
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(ic != null) ic.close();
			if(con != null) con.close();
			if(pst != null) pst.close();
		}
	}
}
