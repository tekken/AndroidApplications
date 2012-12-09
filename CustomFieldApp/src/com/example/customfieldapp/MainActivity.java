package com.example.customfieldapp;


import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener,OnItemSelectedListener {
	ArrayAdapter<CharSequence> adapter;
	String item="default";
	EditText text=null;
	LinearLayout con;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void display(View view){
		new DropDownBox(this);

//		TextView tv=(TextView)findViewById(R.string.drop_down_text);
//		Toast msg=Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_LONG);
//		msg.setGravity(Gravity.CENTER, 0, 0);
//		msg.show();
	} 
	public void addFieldPrompt(View view){
		Builder alert=new Builder(this);
		alert.setTitle("Create Custom Field");
		con=new LinearLayout(this);
		con.setOrientation(LinearLayout.VERTICAL);
		
		Spinner spinner=new Spinner(this);
		spinner.setPrompt("Select an Option :");
		adapter=ArrayAdapter.createFromResource(this, R.array.optionList, android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		con.addView(spinner);
		alert.setView(con);
		alert.setPositiveButton("Create", this);
		alert.setNegativeButton("Cancel", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {				
			}
		});
		alert.show();
		
	}

	private void addField(String item) {
		LinearLayout container=(LinearLayout)findViewById(R.id.container);

		LinearLayout newContainer=new LinearLayout(this);
		newContainer.setOrientation(LinearLayout.HORIZONTAL);
		
		container.addView(newContainer);
		
		TextView label=new TextView(this);
		label.setText(item);
		label.setWidth(100);
		label.setTextColor(Color.BLACK);		
		newContainer.addView(label);
		
		EditText input=new EditText(this);
		input.setWidth(200);
		newContainer.addView(input);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view,
			int position, long row) {
		item=parent.getItemAtPosition(position).toString();	
		if(position==5){
			TextView label=new TextView(this);
			label.setText("Enter Custom Label");
			label.setTextColor(Color.BLACK);		
			con.addView(label);
			text=new EditText(this);
			con.addView(text);
		}
	}



	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
	if(text==null)
		addField(item);
	else
		{
			addField(text.getText().toString());
			text=null;
		}
	}
}
