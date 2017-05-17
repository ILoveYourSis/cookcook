package com.cookserver.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CookTable.MenuTable;

import Util.DataMgr;

/**
 * 这个是手机端使用的
 * @author sakul
 *
 */
public class GetMenuItemsServlet extends HttpServlet {
	
	public void init()
	{
		//DataMgr.getInstance().registerTable(MenuTable.class);
	}

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6451317284263315872L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		PrintWriter out = response.getWriter();
	}

}
