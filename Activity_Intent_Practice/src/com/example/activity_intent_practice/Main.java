package com.example.activity_intent_practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final EditText uname=(EditText)findViewById(R.id.uname);
		final EditText password=(EditText)findViewById(R.id.password);
		Button submit=(Button)findViewById(R.id.submit);
		
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (uname.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
				{
					Intent intent=new Intent(Main.this, Home.class);
					intent.putExtra("user_name", uname.getText().toString());
					startActivity(intent);
				}
				else
				{
					Toast msg=Toast.makeText(Main.this, "Authentication Failled", Toast.LENGTH_LONG);
					msg.setGravity(Gravity.CENTER, 0, 0);
					msg.show();
				}
			}
		});
	}

}
