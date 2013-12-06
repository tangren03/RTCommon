package com.ryantang.common.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Every Activity should extents this class
 * 
 * @Author Ryan
 * @Create 2013-8-15
 */
public class RTActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Invisible the title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}

	/**
	 * Open a new Activity by class name
	 * 
	 * @param pClass
	 */
	protected void openActivity(Class<?> pClass) {
		openActivity(pClass, null);
	}

	/**
	 * Open a new Activity and bring some parameters by bundle
	 * 
	 * @param pClass
	 * @param bundle
	 */
	protected void openActivity(Class<?> pClass, Bundle bundle) {
		Intent intent = new Intent(this, pClass);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

	/**
	 * Open a new Activity by action string
	 * 
	 * @param action
	 */
	protected void openActivity(String action) {
		openActivity(action, null);
	}

	/**
	 * Open a new Activity by action string and bring some parameters
	 * 
	 * @param action
	 * @param pBundle
	 */
	protected void openActivity(String action, Bundle pBundle) {
		Intent intent = new Intent(action);
		if (pBundle != null) {
			intent.putExtras(pBundle);
		}
		startActivity(intent);
	}

}
