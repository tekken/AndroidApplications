package com.example.using_resources;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ImageView iv=(ImageView)findViewById(R.id.imageView1);
		iv.setImageResource(R.drawable.lima);
	}

}
