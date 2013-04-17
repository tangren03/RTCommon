package com.ryantang.common.utils;

import android.content.Context;
import android.widget.Toast;
/**
 * Toast utilities
 * @author Ryan
 */
public class ToastUtils {

	/**
	 * Show toast by string message
	 * @param context
	 * @param message
	 */
	public static void showToast(Context context,String message){
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * Show toast by resources id
	 * @param context
	 * @param resourceId
	 */
	public static void showToast(Context context,int resourceId){
		Toast.makeText(context, context.getResources().getString(resourceId), Toast.LENGTH_SHORT).show();
	}
	
}
