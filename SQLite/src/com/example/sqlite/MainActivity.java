package com.example.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SQLiteDatabase db=openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS MyTable(Name VARCHAR,email VARCHAR, Contact INT(11));");
		db.execSQL("INSERT INTO MyTable values('ken','ken@gmail.com',9876543235)");
		db.close();
		db=null;
		db=openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
		Cursor c=db.rawQuery("Select * from MyTable ", null);
		c.moveToFirst();
		Toast msg=Toast.makeText(MainActivity.this,  c.getString(c.getColumnIndex("Name")),Toast.LENGTH_LONG);
		msg.setGravity(Gravity.CENTER,0, 0);
		msg.show();
		db.close();
		
		Button b=(Button)findViewById(R.id.button);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText et=new EditText(MainActivity.this);
				et.setInputType(InputType.TYPE_CLASS_NUMBER);
				et.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
				setContentView(et);				
			}
		});
	}
}