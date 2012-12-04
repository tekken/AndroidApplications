package com.example.activity_intent_practice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		TextView display=(TextView)findViewById(R.id.display);
		display.setText("Welcome "+getIntent().getExtras().getString("user_name"));
		
	}
}
