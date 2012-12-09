package com.example.customfieldapp;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author David Vaz : PresentSoft Technologies Limited.
 * @dateCreated 9th December 2012
 * @lastModified 9th December 2012
 * 
 * Purpose : A Custom DropDownBox widget.
 */

public class DropDownBox implements OnClickListener,AnimationListener {
	private static final int _NUMBER_OF_OPTIONS = 4;
	
	static int counter=_NUMBER_OF_OPTIONS; 
	private int id=0;
	private TextView drop_down_text;
	private LinearLayout flyout_menu; 
	private Activity activity;
	private TextView[] optionList=new TextView[_NUMBER_OF_OPTIONS];
	private LinearLayout dropDown;
	
	@SuppressWarnings("deprecation")
	public DropDownBox(Activity mainActivity, String[] itemList) {
		counter++;
		activity=mainActivity;
		drop_down_text=new TextView(activity);
		id=counter;
		drop_down_text.setId(id);
		drop_down_text.setWidth(160);
		drop_down_text.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.dropdown_background));
		drop_down_text.setText("Select an option :");
		drop_down_text.setPadding(10, 10, 10, 10);
		drop_down_text.setOnClickListener(this);
		drop_down_text.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icn_dropdown_open, 0);

		
		flyout_menu=new LinearLayout(activity);
		flyout_menu.setId(R.string.dropdown_menu);
		flyout_menu.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);
		flyout_menu.setMinimumHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
		flyout_menu.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.dropdown_background));
		flyout_menu.setOrientation(LinearLayout.VERTICAL);
		flyout_menu.setPadding(10, 10, 10, 10);
		flyout_menu.setVisibility(View.GONE);
		
		dropDown=new LinearLayout(activity);
		dropDown.setOrientation(LinearLayout.VERTICAL);
		dropDown.addView(drop_down_text);
		dropDown.addView(flyout_menu);
		
		for (int i = 0; i < _NUMBER_OF_OPTIONS; i++) {
			optionList[i]=createOption(i, itemList[i]);
		}
	}

	public LinearLayout getDropDown() {
		return dropDown;
	}

	private TextView createOption(int id,String item) {
		TextView option=new TextView(activity);
		option.setId(id);
		option.setText(item);		
		option.setPadding(10, 10, 10, 10);
		option.setOnClickListener(this);
		flyout_menu.addView(option);
		return option;
	}

	/**
	 * Method : hideDropDownMenu
	 * Action : Creates a scaleAnimation on the flyout_menu that animates it to 
	 * 			appear rolling  up.
	 */
	private void hideDropDownMenu() {
		if(flyout_menu.getVisibility()==View.VISIBLE){
			ScaleAnimation anim=new ScaleAnimation(1, 1, 1, 0);
			anim.setDuration(200);
			anim.setAnimationListener(this);
			flyout_menu.startAnimation(anim);
		}
		
	}

	/**
	 * Method : showDropDownMenu
	 * Action : Creates a scaleAnimation on the flyout_menu that animates it to 
	 * 			appear rolling down.
	 */
	private void showDropDownMenu() {
		if(flyout_menu.getVisibility()==View.GONE)
		{
			ScaleAnimation anim=new ScaleAnimation(1, 1, 0, 1);
			anim.setDuration(200);
			flyout_menu.startAnimation(anim);
			flyout_menu.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==drop_down_text.getId()){
			
			if(flyout_menu.getVisibility()==View.GONE)
				showDropDownMenu();
			else
				hideDropDownMenu();
		}
		else if (v.getId()==optionList[0].getId()) {
			selectOption(optionList[0].getText().toString());
		}	
		else if (v.getId()==optionList[1].getId()) {
			selectOption(optionList[1].getText().toString());
		}
		else if (v.getId()==optionList[2].getId()) {
			selectOption(optionList[2].getText().toString());
		}
		else if (v.getId()==optionList[3].getId()) {
			hideDropDownMenu();
			//display alert
			Builder alert=new Builder(activity);
			alert.setTitle("Create Custom Field");
			final EditText et=new EditText(activity);
			alert.setView(et);
			
			alert.setPositiveButton("Create", new android.app.AlertDialog.OnClickListener(){
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
				TextView v=(TextView)activity.findViewById(id);
				if(v!=null) v.setText(et.getText());
				}
			});
			alert.setNegativeButton("Cancel", new android.app.AlertDialog.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
				}
			});
			alert.show();
		}
	}

	private void selectOption(String option) {
		drop_down_text.setText(option);
		hideDropDownMenu();
	}
	
	@Override
	public void onAnimationEnd(Animation animation) {
		flyout_menu.setVisibility(View.GONE);
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		
	}

	@Override
	public void onAnimationStart(Animation animation) {
		
	}

}
