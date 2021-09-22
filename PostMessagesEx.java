package chap03;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
/**
 * Servlet implementation class PostMessages2
 */
@WebServlet("/chap03/PostMessagesEx")
public class PostMessagesEx extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostMessagesEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("bbsEx.jsp"); //直接呼ばれたときの処理
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//パラメーターの取得
		String reqTitle = request.getParameter("title");
		String reqName = request.getParameter("name");
		String reqMessages = request.getParameter("messages");
		String reqPass = request.getParameter("pass");
		//bbs_idを取得(パラメーター)
		int num =0;
		try{
			num = Integer.parseInt(request.getParameter("num"));
}catch(Exception e){
	e.printStackTrace();
	num = 0;
}
		int mode =0;
				try{
					mode = Integer.parseInt(request.getParameter("mode"));

		}catch(Exception e){
			e.printStackTrace();
			mode = 0;
		}
				if(reqMessages != null){
		reqMessages = reqMessages.replaceAll(System.lineSeparator(), "<br/>");
				}

		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		//Statement st = null;
		PreparedStatement pst = null;
		String sql   = "";
		try{

			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			switch(mode){
			//新規投稿
			case 1:
				sql = "INSERT INTO bbs(bbs_name,bbs_title,bbs_text,bbs_pw) "
						+ "VALUES(?,?,?,?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, reqName);
				pst.setString(2, reqTitle);
				pst.setString(3, reqMessages);
				pst.setString(4, reqPass);
				break;
				//削除
			case 2:
				sql = "DELETE FROM bbs WHERE bbs_id = ?";
				pst = con.prepareStatement(sql);
				pst.setInt(1,num);
				break;
				default:
					break;
			}


			pst.executeUpdate();
			RequestDispatcher rd = request.getRequestDispatcher("/chap03/bbsEx.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			System.out.println(pst);
			e.printStackTrace();
		}finally{
			try{
				pst.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
