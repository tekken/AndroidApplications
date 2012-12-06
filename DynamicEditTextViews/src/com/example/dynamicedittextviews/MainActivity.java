package com.example.dynamicedittextviews;


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

	    
	    Button addButton =new Button(this);
	    addButton.setText("Add Button");
	    addButton.setWidth(100);
        addButton.setLayoutParams(new LayoutParams(
        			LinearLayout.LayoutParams.WRAP_CONTENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT));;
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
    	LinearLayout container=new LinearLayout(MainActivity.this);
        container.setLayoutParams(new LayoutParams(
    			LinearLayout.LayoutParams.FILL_PARENT,
    			LinearLayout.LayoutParams.FILL_PARENT));
    	container.setOrientation(LinearLayout.HORIZONTAL);
    	
    	
        EditText editText = new EditText(this);
        editText.setId(id++);
        editText.setWidth(200);
        editText.setLayoutParams(new LayoutParams(
        			LinearLayout.LayoutParams.WRAP_CONTENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT));
        
        TextView textview= new TextView(this);
        textview.setId(tvid++);
        textview.setWidth(200);
        textview.setText("custom");
        textview.setLayoutParams(new LayoutParams(
        			LinearLayout.LayoutParams.WRAP_CONTENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT));
        
        main.addView(textview);
        main.addView(editText);
    }	    

}