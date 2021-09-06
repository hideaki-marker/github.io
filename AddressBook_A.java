package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook_A {
	// 性別、地域、関係のHashMap 入力チェック用
	public static HashMap<Integer, String> genderMap = new HashMap<>();
	public static HashMap<Integer, String> dstMap = new HashMap<>();
	public static HashMap<Integer, String> gnrMap = new HashMap<>();

	public static void main(String[] args) {
		// パターン文字 入力チェック用
		String zipRegex = "^[0-9]{3}-?[0-9]{4}$";				// 郵便番号

		String telRegex = "^\\d{2,4}-?\\d{2,4}-?\\d{4}$";		// 電話番号

		String mailRgex = "^[a-zA-Z0-9_.+-]+[@][a-zA-Z0-9.-]+$";//メールアドレス
		setMap();
		System.out.println("住所録の登録を行います。");
		System.out.println();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String input = "";
			//'q'が入力されるまで繰り返す。
			while(true){
				Adr_book_A adr = new Adr_book_A();
				String adaddress = "";
				//名前の入力
				do{
					System.out.print("名前を入力してください:");
					input = br.readLine();
					adr.setAdb_name(input);
				}while(input.equals(""));
				if(input.equals("q")){
					break;
				}
				//よみがなの入力
				System.out.print("よみがなを入力してください:");
				input = br.readLine();
				adr.setAdb_reading(input);
				if(input.equals("q")){
					break;
				}
				//性別の入力
				do{
					//性別idを表示
					Set<Integer> keys = genderMap.keySet();
					System.out.print("性別番号(");
					for(Integer key :keys){
						System.out.print(key +":" + genderMap.get(key)+ " ");
					}
					System.out.print(")を入力してください:");
					input = br.readLine();
					if(!(input.equals("q"))){
						//整数か確認
						try{
							int gender_id = Integer.parseInt(input);
							//性別HashMapで存在するidかを確認
							if(genderMap.get(gender_id)!=null){
								adr.setGender_id(gender_id);
							}else{
								input = "";
							}
						}catch (NumberFormatException e) {
							input = "";
						}
					}
				}while(input.equals(""));
				if(input.equals("q")){
					break;
				}
				//郵便番号の入力
				do{
					System.out.print("郵便番号を入力してください:");
					input = br.readLine();
					if(!(input.equals("q"))){
						//郵便番号のパターンか確認
						Pattern p = Pattern.compile(zipRegex);
						Matcher m = p.matcher(input);
						if(m.find()){
							//テーブル(yubin)より該当の郵便番号情報を取得して住所を編集する。
							String zipcd = input.replace("-", "");
							Yubin_A yub = Yubin_A.getYubin(zipcd);
							if(yub == null){
								System.out.println("郵便番号:" + input + "に該当する住所はありません");
								input = "";
							}else{
								adr.setAdb_zip(zipcd);
								adaddress = (yub.getTodo()+ " " + yub.getShi() + " " + yub.getCho());
							}
						}else{
							System.out.println("郵便番号の形式ではありません。：" + input );
							input = "";
						}
					}
				}while(input.equals(""));
				if(input.equals("q")){
					break;
				}
				//住所の入力
				System.out.print("住所を入力してください:");
				System.out.print(adaddress);
				input = br.readLine();
				adr.setAdb_address(adaddress + input);
				if(input.equals("q")){
					break;
				}
				//電話番号の入力
				do{
					System.out.print("電話番号を入力してください:");
					input = br.readLine();
					if(!(input.equals("q"))){
						//電話番号のパターンか確認
						Pattern p = Pattern.compile(telRegex);
						Matcher m = p.matcher(input);
						if(m.find()){
							String telno = input.replace("-", "");
							adr.setAdb_phone(telno);
						}else{
							System.out.println("電話番号の形式ではありません。：" + input );
							input = "";
						}
					}
				}while(input.equals(""));
				if(input.equals("q")){
					break;
				}
				//メールアドレスの入力
				do{
					System.out.print("メールアドレスを入力してください:");
					input = br.readLine();
					if(!(input.equals("q"))){
						//メールアドレスのパターンか確認
						Pattern p = Pattern.compile(mailRgex);
						Matcher m = p.matcher(input);
						if(m.find()){
							adr.setAdb_mail(input);
						}else{
							System.out.println("メールアドレスの形式ではありません。：" + input );
							input = "";
						}
					}
				}while(input.equals(""));
				if(input.equals("q")){
					break;
				}
				//地域の入力
				do{
					//地域idを表示
					Set<Integer> keys = dstMap.keySet();
					System.out.print("地域番号(");
					for(Integer key :keys){
						System.out.print(key +":" + dstMap.get(key)+ " ");
					}
					System.out.print(")を入力してください:");
					input = br.readLine();
					if(!(input.equals("q"))){
						//整数か確認
						try{
							int dst_id = Integer.parseInt(input);
							//地域HashMapで存在するidかを確認
							if(dstMap.get(dst_id)!=null){
								adr.setDst_id(dst_id);
							}else{
								input = "";
							}
						}catch (NumberFormatException e) {
							input = "";
						}
					}
				}while(input.equals(""));
				if(input.equals("q")){
					break;
				}
				//関係の入力
				do{
					//関係idを表示
					Set<Integer> keys = gnrMap.keySet();
					System.out.print("関係番号(");
					for(Integer key :keys){
						System.out.print(key +":" + gnrMap.get(key)+ " ");
					}
					System.out.print(")を入力してください:");
					input = br.readLine();
					if(!(input.equals("q"))){
						//整数か確認
						try{
							int gnr_id = Integer.parseInt(input);
							//関係HashMapで存在するidかを確認
							if(gnrMap.get(gnr_id)!=null){
								adr.setGnr_id(gnr_id);
							}else{
								input = "";
							}
						}catch (NumberFormatException e) {
							input = "";
						}
					}
				}while(input.equals(""));
				if(input.equals("q")){
					break;
				}
				//データベースへの登録
				Adr_book_A.adrAdd(adr);
				System.out.println("登録しました。");
				System.out.println();
			}

		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			System.out.println("終了します。");
		}

	}
	//性別、地域、関係のMapを作成する。
	public static void setMap(){
		Connection 			con = null;		//コネクション
		PreparedStatement	pst = null;		//プリペアードステートメント
		ResultSet 			rs 	= null;		//リザルトセット
		String 				sql = null;		//SQL文
		try{
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root","root");
			//性別
			sql = "SELECT * FROM gender";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				genderMap.put(rs.getInt("gender_id"), rs.getString("gender_name"));
			}
			rs.close();
			pst.close();
			//地域
			sql = "SELECT * FROM district";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				dstMap.put(rs.getInt("dst_id"), rs.getString("dst_name"));
			}
			rs.close();
			pst.close();
			//関係
			sql = "SELECT * FROM genre";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				gnrMap.put(rs.getInt("gnr_id"), rs.getString("gnr_name"));
			}

		}catch(SQLException e){
			System.out.println("エラーが発生しました。");
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
	}

}
