package com.example.customfieldapp;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	LinearLayout container;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		container=(LinearLayout)findViewById(R.id.container);
	}
	
	public void display(View view){
		new MyCustomView(this,container);
	} 
}