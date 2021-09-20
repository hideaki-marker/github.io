package chap02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PostMessages
 */
@WebServlet("/chap02/PostMessages")
public class PostMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PostMessages() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("../bbs.jps");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			String reqTitle = request.getParameter("title");
			String reqName = request.getParameter("name");
			String reqMessages = request.getParameter("messages");
			
			
			reqMessages = reqMessages.replace(System.lineSeparator(), "<br/>");
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DATE);
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int minute = cal.get(Calendar.MINUTE);
			
			try(BufferedWriter bw = new BufferedWriter(
											new FileWriter("../messages/messages.txt",true))){
				StringBuffer rec = new StringBuffer(reqTitle);
				rec.append(",");
				rec.append(reqName);
				rec.append(",");
				rec.append(reqMessages);
				rec.append(",");
				rec.append(year);
				rec.append(",");
				rec.append(month);
				rec.append(",");
				rec.append(day);
				rec.append(",");
				rec.append(hour);
				rec.append(",");
				rec.append(minute);
				bw.write(rec.toString());
				bw.write(System.lineSeparator());
			}
			response.sendRedirect("../bbs.jsp");
		}
		// TODO Auto-generated method stub
		
		
	}


