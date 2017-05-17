package CookTable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.RecordBase.RecordState;
import Util.DataMgr;
import Util.TableBase;

public class MenuTable extends TableBase<MenuRecord>
{
	@Override
	public void readFromDb()
	{
		java.sql.Connection conn = DataMgr.getInstance().newConnection();
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement)conn.prepareStatement("select * from menurecords");
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		ResultSet rs = null;
		try 
		{
			rs = ps.executeQuery();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		try 
		{
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String info = rs.getString(3);
				_records.add(new MenuRecord(id, name, info, RecordState.New));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(rs != null) rs.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	public ArrayList<MenuRecord> getAllRecords()
	{
		return _records;
	}
	
	@Override
	public void saveAll()
	{
	}
	
	public void updateRecord(MenuRecord record)
	{
		super.updateRecord(record);
	}
}
