package com.ryantang.common.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Every Activity should extents this class
 * 
 * @Author Ryan
 * @Create 2013-8-15 上午9:33:22
 */
public class RTActivity extends Activity {
	
	public RTActivityManager MyActivityManager = RTActivityManager.getActivityManager();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Invisible the title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}

	@Override
	protected void onPause() {
		super.onPause();

	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	/**
	 * Open new activity
	 * 
	 * @param pClass
	 */
	protected void openActivity(Class<?> pClass) {
		openActivity(pClass, null);
	}

	/**
	 * Open new activity and bring some params
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
	 * Open new activity by action string
	 * 
	 * @param action
	 */
	protected void openActivity(String action) {
		openActivity(action, null);
	}

	/**
	 * Open new activity by action string and bring some params
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

	/**
	 * Close current activity
	 */
	protected void closeActivity() {
		super.finish();
	}
}
