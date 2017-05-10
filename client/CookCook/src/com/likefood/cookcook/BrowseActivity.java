package com.likefood.cookcook;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class BrowseActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browse_activity);
		((Button)findViewById(R.id.searchBtn)).setOnClickListener(this);
	}

	@Override
	public void onClick(View view)
	{
		if(view.getId() == R.id.searchBtn) onSearchClicked();
	}
	
	private EditText _searchTxt = null;
	private void onSearchClicked()
	{
		if(_searchTxt == null) _searchTxt = (EditText) findViewById(R.id.searchTxt);
		String txt = _searchTxt.getText().toString();
		if(txt == "") return;
		System.out.println("search" + txt);
	}
	
}