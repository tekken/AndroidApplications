package com.example.explicit_intents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		TextView text=(TextView)findViewById(R.id.display);
		text.setText(getIntent().getExtras().getString("data"));
	}
}
