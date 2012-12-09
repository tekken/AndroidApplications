package com.example.dropdownbox;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
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
	
	private TextView drop_down_text;
	private LinearLayout flyout_menu; 
	private Activity activity;
	
	public DropDownBox(Activity mainActivity) {
		activity=mainActivity;
		drop_down_text=(TextView)activity.findViewById(R.id.drop_down_text);
		flyout_menu=(LinearLayout)activity.findViewById(R.id.dropdown_menu);
		
		TextView option0=(TextView)activity.findViewById(R.id.option0);
		TextView option1=(TextView)activity.findViewById(R.id.option1);
		TextView option2=(TextView)activity.findViewById(R.id.option2);
				
		option0.setOnClickListener(this);
		option1.setOnClickListener(this);
		option2.setOnClickListener(this);
		drop_down_text.setOnClickListener(this);		
	}

	/**
	 * Method : hideDropDownMenu
	 * Action : Creates a scaleAnimation on the flyout_menu that animates it to 
	 * 			appear rolling  up.
	 */
	private void hideDropDownMenu() {
		if(flyout_menu.getVisibility()==View.VISIBLE){
			ScaleAnimation anim=new ScaleAnimation(1, 1, 1, 0);
			anim.setDuration(activity.getResources().getInteger(R.integer.dropdown_amination_time));
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
			anim.setDuration(activity.getResources().getInteger(R.integer.dropdown_amination_time));
			flyout_menu.startAnimation(anim);
			flyout_menu.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.drop_down_text){
			
			if(flyout_menu.getVisibility()==View.GONE)
				showDropDownMenu();
			else
				hideDropDownMenu();
			
		}
		else if (v.getId()==R.id.option0) {
			selectOption(R.string.option0);
		}
		else if (v.getId()==R.id.option1) {
			selectOption(R.string.option1);
		}
		else if (v.getId()==R.id.option2) {
			selectOption(R.string.option2);
		}		
	}

	private void selectOption(int option) {
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
