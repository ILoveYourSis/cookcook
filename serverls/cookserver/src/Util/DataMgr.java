package Util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;


import CookTable.MenuTable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class DataMgr 
{
	private final String URL 	  = "jdbc:mysql://127.0.0.1:3306/cookmenu";
	private final String USR_NAME = "ls";
	private final String USR_PSWD = "123456";
	
	private static DataMgr _instance = null;
	public static DataMgr getInstance()
	{
		if(_instance == null) 
		{
			_instance = new DataMgr();
			Logger.log("Data Mgr is instantiated!");
		}
		return _instance;
	}
	
	private Dictionary<Class, Object> _tables;
	@SuppressWarnings("rawtypes")
	public void registerTable(Class tableType)
	{
		if(_tables == null) _tables = new Hashtable<Class, Object>();
		if(_tables.get(tableType) != null) return;
		
		Object tableInstance = null;
		try {
			tableInstance = tableType.newInstance();
			((TableBase)tableInstance).readFromDb();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if(tableInstance == null) Logger.error("shit happens");
		_tables.put(tableType, tableInstance);
	}
	
	@SuppressWarnings("finally")
	public java.sql.Connection newConnection()
	{
		Logger.log("newConnection is called once");
		Driver driver = null;
		try 
		{
		    Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		String url = URL;
		java.sql.Connection conn = null;
		try 
		{
			conn = (Connection)DriverManager.getConnection(URL, USR_NAME, USR_PSWD);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			return conn;
		}
	}

	public Object getTable(Class tableClass)
	{
		return _tables.get(tableClass);
	}
}
