package jp.struts.stQuiz2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Select {

	private static final long serialVersionUID = 1L;
	private ArrayList<String> select; // 都道府県名

		public ArrayList<String> getSelect() {
		return select;
	}

	public void setSelect(ArrayList<String> prefName) {
		this.select = prefName;
	}

		public void   distinct(){
			InitialContext ic =null;
			Connection con = null;
			PreparedStatement pst = null;
			try{
				select = new ArrayList<>();
				ic = new InitialContext();
				DataSource ds = (DataSource) ic.lookup("java:comp/env/mysql");
				con = ds.getConnection();


				StringBuffer sql = new StringBuffer();
				//都道府県情報の取得
				sql.append("SELECT * FROM yubin ");
				pst =  con.prepareStatement(sql.toString());
				ResultSet rs = pst.executeQuery();

				ArrayList<String> dst = new ArrayList<>();
				while(rs.next()){

					String dis = rs.getString("todo");
					dst.add(dis);
				}
				select = (ArrayList<String>) dst.stream()
								.distinct()
								.collect(Collectors.toList());
				//select.forEach(System.out::println);

			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(ic != null)
					try {
						ic.close();
						if(con != null) con.close();
						if(pst != null) pst.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}
		}



