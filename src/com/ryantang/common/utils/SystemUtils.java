package com.ryantang.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.inputmethod.InputMethodManager;

public class SystemUtils {

	/**
	 * Get current time by format
	 * @param format
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getCurrentTime(String format) {
		SimpleDateFormat dateformat1 = new SimpleDateFormat(format);
		String time = dateformat1.format(new Date());
		return time;
	}
	
	public String getDate() {
		Calendar c = Calendar.getInstance();

		String year = String.valueOf(c.get(Calendar.YEAR));
		String month = String.valueOf(c.get(Calendar.MONTH));
		String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + 1);
		String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		String mins = String.valueOf(c.get(Calendar.MINUTE));

		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append(year + "-" + month + "-" + day + " " + hour + ":"
				+ mins);

		return sbBuffer.toString();
	}
	
	/**
	 * 返回当前日期之后或之前几天的日期
	 * @param day
	 * day为正整数则往后退，为负整数则往前推
	 * @return
	 */
	public static String getDateAfter(int day) {
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, day);
		date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
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
	public static boolean isWifiConnect(Context context){
		ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Activity.CONNECTIVITY_SERVICE);
		boolean wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
		if (wifi) {
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
	
	/**
	 * Check service state
	 * @param context
	 * @param className
	 * @return
	 */
	public static boolean isServiceRunning(Context context,String className){
	     ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
	     List<RunningServiceInfo> list = am.getRunningServices(30);
	     for(RunningServiceInfo info : list){
	         if(info.service.getClassName().equals(className)){
	        	 return true;
	         }
	    }
	    return false;
	}
	
	
}
