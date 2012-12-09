package com.example.customfieldapp;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MyCustomView implements OnClickListener{
	Activity activity;
	LinearLayout container;
	
	LinearLayout layout;
	DropDownBox d;
	EditText e;
	Button add,remove;

	
	public MyCustomView(Activity mainActivity, LinearLayout container) {
		activity=mainActivity;
		this.container=container;
		String[] itemList={"India","Australia","Canada","Custom"};
		
		d=new DropDownBox(activity, itemList);
		
		e=new EditText(activity);
		e.setWidth(200);
		
		add=new Button(activity);
		add.setText("+");
		add.setWidth(100);
		add.setHeight(5);
		add.setOnClickListener(this);
		
		remove=new Button(activity);
		remove.setText("-");
		remove.setWidth(100);
		remove.setHeight(5);
		remove.setOnClickListener(this);
		
		layout=new LinearLayout(activity);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.addView(d.getDropDown());
		layout.addView(e);
		
		LinearLayout controls=new LinearLayout(activity);
		controls.setOrientation(LinearLayout.VERTICAL);
		controls.addView(add);
		controls.addView(remove);
		
		layout.addView(controls);
		container.addView(layout);
	}


	@Override
	public void onClick(View v) {
		if(v==add){
			new MyCustomView(activity, container);
		}
		else if(v==remove){
			layout.setVisibility(View.GONE);
		}
	}

}
