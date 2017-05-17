package Util;

import java.sql.ResultSet;
import java.util.ArrayList;

import Util.RecordBase.RecordState;


public abstract class TableBase<T>
{
	protected ArrayList<T> _records = new ArrayList<T>();
	
	/*
	 * 从数据库中读取所有，这个是初始化用的
	 */
	public abstract void readFromDb();
	
	/*
	 * 全部存到数据库中，这个是数据库管理类定期调用的
	 */
	public abstract void saveAll();
	
	/*
	 * 更新一条数据
	 */
	public void updateRecord(RecordBase record)
	{
		record.setRecordState(RecordState.Updated);
	}
	
	public void insertRecord(RecordBase record){}

}
