package com.ryantang.common.utils;

import java.util.HashMap;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * SharedPreferences Utilities
 * 
 * @author Ryan
 */
public final class SharedPreferenceUtils {

	/**
	 * The name of SharedPreferences
	 */
	private static final String PREFERENCE_NAME = "sharedpreference";

	/**
	 * Get the instance of SharedPreferences
	 * 
	 * @param context
	 * @return
	 */
	public static SharedPreferences getSharedPreferences(Context context) {
		return context.getSharedPreferences(PREFERENCE_NAME,
				Context.MODE_WORLD_WRITEABLE);
	}

	/**
	 * Save Single String preference
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean saveStringValue(Context context, String key,
			String value) {
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		return editor.commit();
	}

	/**
	 * Get string value through key
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static String getStringValue(Context context, String key) {
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		return sharedPreferences.getString(key, "");
	}

	/**
	 * Save map String preference
	 * 
	 * @param context
	 * @param valuesMap
	 * @return
	 */
	public static boolean saveStringValues(Context context,
			HashMap<String, String> valuesMap) {
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		Editor editor = sharedPreferences.edit();
		String value = "";
		for (String key : valuesMap.keySet()) {
			value = valuesMap.get(key);
			editor.putString(key, value);
		}
		return editor.commit();
	}

	/**
	 * Save single boolean preference
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean saveBooleanValue(Context context, String key,
			boolean value) {
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(key, value);
		return editor.commit();
	}

	/**
	 * Get boolean value through key
	 * 
	 * @param context
	 * @param key
	 * @param defFlag
	 * @return
	 */
	public static boolean getBooleanValue(Context context, String key,
			boolean defaultValue) {
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		return sharedPreferences.getBoolean(key, defaultValue);
	}

	/**
	 * Clean the SharedPreferences
	 * 
	 * @param context
	 */
	public static void cleanSharedPreference(Context context) {
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		Editor editor = sharedPreferences.edit();
		editor.clear();
		editor.commit();
	}

	/**
	 * Save int value
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean saveIntValue(Context context, String key, int value) {
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		Editor editor = sharedPreferences.edit();
		editor.putInt(key, value);
		return editor.commit();
	}

	/**
	 * Get int value
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static int getIntValue(Context context, String key, int defaultValue) {
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		return sharedPreferences.getInt(key, defaultValue);
	}

	/**
	 * Save float value
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean saveFloatValue(Context context, String key,
			float value) {
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		Editor editor = sharedPreferences.edit();
		editor.putFloat(key, value);
		return editor.commit();
	}

	/**
	 * Get float value
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static float getFloatValue(Context context, String key,
			float defaultValue) {
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		return sharedPreferences.getFloat(key, defaultValue);
	}
}
