package com.cookserver.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CookTable.MenuRecord;
import CookTable.MenuTable;
import Util.DataMgr;

/*
 * ���������༭record
 */
public class EditRecordsServlet extends HttpServlet
{
	public void init()
	{
		DataMgr.getInstance().registerTable(MenuTable.class);
	}
	
	private static final long serialVersionUID = -1873880994027402552L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
    {
    	try
    	{
    		HttpSession hs = req.getSession();
    		String loginResult = (String)hs.getAttribute("login");
    		if(loginResult == null || !loginResult.equals("OK"))
    		{
    			res.sendRedirect("login.html");
    			return;
    		}
    		MenuTable table = (MenuTable)DataMgr.getInstance().getTable(MenuTable.class);
    		ArrayList<MenuRecord> records = table.getAllRecords();
    		int PAGE_COUNT = 20;
    		int currPage = 0;
    		int recordsSize = records.size();
    		int pageSize = recordsSize % PAGE_COUNT ==0? recordsSize/PAGE_COUNT: recordsSize/PAGE_COUNT +1;
    		
    		PrintWriter writer = res.getWriter();
    		writer.println(req.getParameter("usrname") + "this is EditRecordsPage");
    		writer.println("<table border=1");
    		writer.println("<tr><td>id</th><th>name</th><th>info</th></tr>");
    		for(MenuRecord mr : records)
    		{
    			writer.println("<tr>");
    			writer.println("<td>" + mr.id + "</td>");
    			writer.println("<td>" + mr.name + "</td>");
    			writer.println("<td>" + mr.info + "</td>");
    			writer.println("</tr>");
    		}
    		writer.println("</table>");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public void doPost(HttpServletRequest rq, HttpServletResponse rp)
    {
    	this.doGet(rq, rp);
    }
}
