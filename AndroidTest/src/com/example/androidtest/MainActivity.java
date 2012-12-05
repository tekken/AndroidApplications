package com.example.androidtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText name=(EditText)findViewById(R.id.fname);
		final EditText email=(EditText)findViewById(R.id.email);
		final EditText contact=(EditText)findViewById(R.id.contact);
		Button next=(Button)findViewById(R.id.next);
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Person person_details=new Person();
				person_details.setName(name.getText().toString());
				person_details.setEmail(email.getText().toString());
				person_details.setContact(contact.getText().toString());
				Intent intent=new Intent(MainActivity.this, Next.class);
				intent.putExtra("person_details", person_details);
				startActivity(intent);
			}
		});
			
	}
}
