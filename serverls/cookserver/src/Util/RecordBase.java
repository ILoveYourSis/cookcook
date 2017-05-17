package Util;

public class RecordBase {
	
	public enum RecordState {New, Updated, Saved, None}
    protected RecordState _recordState = RecordState.None;
    public RecordState getRecordState(){return _recordState;}
    public void setRecordState(RecordState recordState){ _recordState = recordState;}
}
