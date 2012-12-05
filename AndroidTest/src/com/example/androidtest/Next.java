package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Next extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);
		TextView tv=(TextView)findViewById(R.id.textView1);
		
		Person person=(Person)getIntent().getParcelableExtra("person_details");
		tv.setText(person.getName());
	}
}

