package com.example.dynamicedittextviews;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private LinearLayout main;
	private int id = 0;
	private int tvid = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		main = new LinearLayout(this);
	    main.setOrientation(LinearLayout.VERTICAL);

	    Button addButton = new Button(this);
	    addButton.setText("add");
        addButton.setLayoutParams(new LayoutParams(
        			LinearLayout.LayoutParams.WRAP_CONTENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT));
	    addButton.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	            addEditText();
	        }
	    });

	    main.addView(addButton);
	    setContentView(main);
	}
    private void addEditText() {
        LinearLayout editTextLayout = new LinearLayout(this);
        editTextLayout.setOrientation(LinearLayout.HORIZONTAL);
        main.addView(editTextLayout);

        EditText editText = new EditText(this);
        editText.setId(id++);
        editText.setLayoutParams(new LayoutParams(
        			LinearLayout.LayoutParams.WRAP_CONTENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT));
        
        TextView textview= new TextView(this);
        textview.setId(tvid++);
        textview.setLayoutParams(new LayoutParams(
        			LinearLayout.LayoutParams.WRAP_CONTENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT));
        
        editTextLayout.addView(textview);
        editTextLayout.addView(editText);
    }	    

}