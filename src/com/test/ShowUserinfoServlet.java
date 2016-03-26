package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.test.dao.StudentBean;

/**
 * Servlet implementation class ShowUserinfoServlet
 */
@WebServlet("/ShowUserinfoServlet")
public class ShowUserinfoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowUserinfoServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ArrayList<StudentBean> list = new ArrayList();

		

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/demo";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = (Connection) DriverManager.getConnection(url,"root","lep123518");

			stmt = (Statement) con.createStatement();

			String sql = "select * from userInfo";
			rs = (ResultSet) stmt.executeQuery(sql);
			while (rs.next())
			{
				int id=rs.getInt("id");
				String username=rs.getString("username");
				String userpsw=rs.getString("userpsw");
				int age = rs.getInt("age");
				int weight=rs.getInt("weight");
				String sex=rs.getString("sex");
				StudentBean student = new StudentBean(id, username, userpsw, age, weight, sex);
				list.add(student);
				
			}
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/showdata.jsp").forward(request, response);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
