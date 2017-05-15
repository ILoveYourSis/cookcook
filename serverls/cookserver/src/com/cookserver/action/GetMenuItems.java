package com.cookserver.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;
public class GetMenuItems extends HttpServlet {
	
	private boolean _initSql = false;
	private void initSql()
	{
		Driver driver = null;
		try {
			driver = new com.mysql.jdbc.Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://127.0.0.1:3306/ssh";
		Properties info = new Properties();
		info.put("user", "ls");
		info.put("password", "123456");
		try {
			java.sql.Connection conn = driver.connect(url, info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6451317284263315872L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
        if(!_initSql) 
    	{
	    	initSql();
	    	_initSql = true;
    	}
		
		PrintWriter out = response.getWriter();
		out.write("this data is from server");
	}

}
