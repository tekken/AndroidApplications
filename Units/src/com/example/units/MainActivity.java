package com.example.units;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	TextView sum;
	EditText num1;
	EditText num2;
	Button add;
	Button subtract;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sum=(TextView)findViewById(R.id.sum);
		add=(Button)findViewById(R.id.add);
		subtract=(Button)findViewById(R.id.subtract);
		add.setOnClickListener(this);
		subtract.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int sum_total=0;
		num1=(EditText) findViewById(R.id.num1);
		num2=(EditText) findViewById(R.id.num2);
		int num_1=Integer.parseInt(num1.getText().toString());
		int num_2=Integer.parseInt(num2.getText().toString());

		switch(v.getId()){
		case R.id.add : {
			sum_total=num_1+num_2;
			}break;
		case R.id.subtract: {
			sum_total=num_1-num_2;
			}break;
		default:{
			sum_total=0;
			} break;	
		}
		sum.setText("Sum Total = "+sum_total);
	}
	
}
