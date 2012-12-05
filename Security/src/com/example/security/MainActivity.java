package com.example.security;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ConnectivityManager conman=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		TextView tv=(TextView) findViewById(R.id.textview);
		boolean wifi=conman.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected();
		boolean mobile=conman.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected();
		
		if(wifi||mobile)
			tv.setText("Wifi on");
		else
			tv.setText("Wifi off");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
