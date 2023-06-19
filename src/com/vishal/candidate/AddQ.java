package com.vishal.candidate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddQ
 */
public class AddQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int qid=0;
		String q=request.getParameter("q");
		String sa=request.getParameter("sa");
		String a=request.getParameter("a");
		String n=request.getParameter("n");
		String d=request.getParameter("d");
		String sd=request.getParameter("sd");
		Connection con=DbConnection.connect();
		PreparedStatement p1;
		try {
			p1 = con.prepareStatement("insert into test values(?,?,?,?,?,?,?)");
			p1.setInt(1, qid);
			p1.setString(2, q);
			p1.setString(3, sa);
			p1.setString(4, a);
			p1.setString(5, n);
			p1.setString(6, d);
			p1.setString(7, sd);
			
			int k=p1.executeUpdate();
			if(k>0)
				response.sendRedirect("adpage.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
