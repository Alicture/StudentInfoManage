package com.test;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("username");
		String userpsw = request.getParameter("password");
		String age = request.getParameter("age");
		String sex =request.getParameter("sex");
		String weight =request.getParameter("weight");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/demo";
		
		Connection con1=null;
		Statement stmt1 =null;
		boolean rs1 = true ;
		
		try
		{
			con1 =(Connection) DriverManager.getConnection(url,"root", "lep123518");
			stmt1 = (Statement) con1.createStatement();
			String sql="insert into userInfo (username,userpsw,age,weight,sex) values('"+username+"','"+userpsw+"',"+age+","+weight+",'"+sex+"')";
			
			rs1=stmt1.execute(sql);
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rs1)
		{
			response.sendRedirect("/LoginTest/login.jsp");
		}
		
		
	}

}
