package com.example.androidapplicationtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class Display extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		
		TextView name=(TextView)findViewById(R.id.textView1);
		TextView street=(TextView)findViewById(R.id.textView2);
		
		Person person=(Person)getIntent().getExtras().getParcelable("person_details");
		
		name.setText(person.getName());
		street.setText(person.getAddress().getStreet());
	}
}
