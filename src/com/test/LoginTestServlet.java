package com.test;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class LoginTestServlet
 */
@WebServlet("/LoginTestServlet")
public class LoginTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTestServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String result="";
		
		String username=request.getParameter("username");
		String psw = request.getParameter("password");
		
		if(username==null || username==""||username.length()>20)
		{
			try{
			result="请输入用户名（不超过20个字符）";
			request.setAttribute("message", result);
			response.sendRedirect("/login.jsp");
			return;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(psw==null||psw==""||psw.length()>20)
		{
			try{
			result="请输入密码（不超过20个字符）";
			request.setAttribute("message", result);
			response.sendRedirect("/login.jsp");
			return;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			System.out.print("Class Not Found Exception");
		}
		
		String url = "jdbc:mysql://localhost:3306/demo";
		
		Connection con=null;
		Statement stmt =null;
		ResultSet rs = null;
		
		try
		{
			con =(Connection) DriverManager.getConnection(url, "root", "lep123518");
			stmt=(Statement) con.createStatement();
			String sql = "select * from userInfo where username='"+username+"' and userpsw= '"+psw+"'";
			rs=(ResultSet) stmt.executeQuery(sql);
			System.out.println(rs);
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session =request.getSession();
		session.setAttribute("username", username);
		
		
		try
		{
			if(rs.next())
			{
				session.setAttribute("sex", rs.getString("sex"));
				session.setAttribute("age", rs.getString("age"));
				session.setAttribute("weight", rs.getString("weight"));
				
				response.sendRedirect("/LoginTest/success.jsp");
				return;
			}
			
			else{
				session.setAttribute("message", "用户名与密码不匹配");
				response.sendRedirect("/LoginTest/fail.jsp");
				return;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
