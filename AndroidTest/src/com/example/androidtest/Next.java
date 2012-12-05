package com.example.androidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Next extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);		
		final Person person=(Person)getIntent().getParcelableExtra("person_details");
		final EditText et_street=(EditText)findViewById(R.id.street);
		final EditText et_city=(EditText)findViewById(R.id.city);
		final EditText et_pincode=(EditText)findViewById(R.id.pincode);
		Button btn_save=(Button)findViewById(R.id.save);
		btn_save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String street=et_street.getText().toString();
				String city=et_city.getText().toString();
				String pincode=et_pincode.getText().toString();
				Address address=new Address();
				address.setStreet(street);
				address.setCity(city);
				address.setPincode(pincode);
				person.setAddress(address);
				
				Intent intent=new Intent(Next.this, Display.class);
				intent.putExtra("person_details", person);
				startActivity(intent);
			}
		});
	}
}

