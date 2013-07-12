package com.ryantang.common.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * 所有Activity需集成本类
 * 
 * @author Ryan
 * 
 */
public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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

	protected void openActivity(Class<?> pClass) {
		openActivity(pClass, null);
	}

	protected void openActivity(Class<?> pClass, Bundle bundle) {
		Intent intent = new Intent(this, pClass);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

	protected void openActivity(String action) {
		openActivity(action, null);
	}

	protected void openActivity(String action, Bundle pBundle) {
		Intent intent = new Intent(action);
		if (pBundle != null) {
			intent.putExtras(pBundle);
		}
		startActivity(intent);
	}

	protected void finishActivity() {
		super.finish();
	}
}
