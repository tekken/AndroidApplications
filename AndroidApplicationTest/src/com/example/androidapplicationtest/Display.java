package com.example.androidapplicationtest;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Display extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		
		TextView name=(TextView)findViewById(R.id.textView1);
		TextView street=(TextView)findViewById(R.id.textView2);
		Button save=(Button)findViewById(R.id.save);
		Person person=(Person)getIntent().getExtras().getParcelable("person_details");
		
		name.setText(person.getName());
		street.setText(person.getAddress().getStreet());
		
		final Builder alert=new Builder(this);
		alert.setTitle("Log In");
		alert.setMessage("Please Login to continue");
		
		// Set an EditText view to get user input 
		final EditText uname = new EditText(this);
		final EditText password = new EditText(this);
		TextView txtuname=new TextView(this);
		txtuname.setText("Username");
		txtuname.setTextSize(20);
		txtuname.setTextColor(Color.WHITE);
		TextView txtpass=new TextView(this);
		txtuname.setTextSize(20);
		txtpass.setText("Password");
		txtpass.setTextColor(Color.WHITE);
		LinearLayout ll=new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);

		ll.addView(txtuname);
		ll.addView(uname);
		ll.addView(txtpass);
		ll.addView(password);
		alert.setView(ll);
		
		alert.setPositiveButton("Login", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(uname.getText().toString().equals("admin")&&password.getText().toString().equals("admin")){
					//success
				}
				else{
					//failure
				}
			}
		});
		alert.setNegativeButton("Later", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		});

		save.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				alert.show();
			}
		});	
	}
}
