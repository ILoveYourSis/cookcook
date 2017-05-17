package CookTable;

import Util.RecordBase;

public class MenuRecord  extends RecordBase
{
	public int id;
	public String name;
	public String info;
	
	public MenuRecord(int id, String name, String info, RecordState state)
	{
		this.id = id;
		this.name = name;
		this.info = info;
		this._recordState = state;
	}

}
