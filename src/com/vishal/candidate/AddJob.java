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
 * Servlet implementation class AddJob
 */
public class AddJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJob() {
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
		String title=request.getParameter("title");
		String desc=request.getParameter("desc");
		String sal=request.getParameter("sal");
		int exper =Integer.parseInt(request.getParameter("exper"));
		int id=0;
		String qua="";
		
		boolean o,c,e,a,n;
		
		
			try{
			if(request.getParameter("o").equals("openness"))
			{
				qua+=("openness,");
			}
			}
			catch(java.lang.NullPointerException ne)
			{
				o=false;
			}
			try{
			if(request.getParameter("c").equals("Conscientiousness"))
			{
				qua+=("Conscientiousness,");
			}
			}catch(java.lang.NullPointerException ne)
			{
				c=false;
			}
			try{
			if(request.getParameter("e").equals("Extraversion"))
			{
				qua+=("Extraversion,");
			}
			}catch(java.lang.NullPointerException ne)
			{
				e=false;
			}
			try{
			if(request.getParameter("a").equals("Agreeableness"))
			{
				qua+=("Agreeableness,");
			}
			}catch(java.lang.NullPointerException ne)
			{
				a=false;
			}
			try{
			if(request.getParameter("n").equals("Neuroticism"))
			{
				qua+=("Neuroticism,");
			}
			}catch(java.lang.NullPointerException ne)
			{
				n=false;
			}
		Connection con =DbConnection.connect();
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into job values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, desc);
			pstmt.setString(4, sal);
			pstmt.setInt(5, exper);
			pstmt.setString(6, qua);
			pstmt.setInt(7,Values.getHid());
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("Hrpage.html");
			}
			else
			{
				response.sendRedirect("addjob.html");
			}
			} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		
		}
	}
		
	


