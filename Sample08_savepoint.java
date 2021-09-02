package chap05;
import java.sql.*;
public class Sample08_savepoint {
	public static void main(String[] args){

		Connection con = null;
		Statement st = null;
		String sql = null;
		Savepoint sp1 =null;//セーブポイント

		try{
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root","root");
					st = con.createStatement();
			con.setAutoCommit(false); //オートコミットを拒否
			//"H社"を追加
			sql = "INSERT INTO maker VALUES(8,'H社')";
			int ret = st.executeUpdate(sql);
			System.out.println("\n" + ret + "件処理しました。");
			//セーブポイントを設定
			sp1 = con.setSavepoint();
			//"I社"を追加
			sql = "INSERT INTO maker VALUES(9,'I社')";
			ret = st.executeUpdate(sql);
			System.out.println("\n" + ret + "件処理しました。");
			//"J社"を追加（主キーが重複している）
			sql = "INSERT INTO maker VALUES(9,'J社')";
			ret = st.executeUpdate(sql);
			System.out.println("\n" + ret + "件処理しました。");


		}catch(SQLException e){
			System.out.println("エラーが発生しました。主キーの値を確認してください。");
			//ロールバック
			try {
				con.rollback(sp1);
				System.out.println("セーブポイント移行のロールバックを行いました。");
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}finally{
			//コミット
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			//クローズ
			try {
				if(st != null){
					st.close();
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
