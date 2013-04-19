package com.ryantang.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.inputmethod.InputMethodManager;

public class SystemUtils {

	public static String getCurrentTime(String format) {
		SimpleDateFormat dateformat1 = new SimpleDateFormat(format);
		String time = dateformat1.format(new Date());
		return time;
	}

	/**
	 * Check the network
	 * 
	 * @param context
	 * @return
	 */
	public static boolean checkNetwork(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = connectivityManager.getActiveNetworkInfo();
		if (info == null || !info.isAvailable()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Judge if wifi or internect is connected
	 * @param context
	 * @return
	 */
	public boolean isWifiConnect(Context context){
		ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Activity.CONNECTIVITY_SERVICE);
		boolean wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
		boolean internet = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
		if (wifi | internet) {
			return true;
		}
		return false;
	}

	/**
	 * Toggle keyboard If the keyboard is visible,then hidden it,if it's
	 * invisible,then show it
	 * 
	 * @param context
	 */
	public static void toggleKeyboard(Context context) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm.isActive()) {
			imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}
}
