package com.ryantang.common.activity;

import java.util.Stack;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

/**
 * Activity Manager (Stack)
 * 
 * @Author Ryan
 * @Create 2013-7-15 下午3:25:18
 */
public class RTActivityManager {

	private static Stack<Activity> activityStack;
	// Single Instance
	private static RTActivityManager instance;

	private RTActivityManager() {
	}

	public static RTActivityManager getActivityManager() {
		if (instance == null) {
			instance = new RTActivityManager();
		}
		return instance;
	}

	/**
	 * Push activity to the stack
	 * 
	 * @param activity
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * Get current activity on the top of the stack
	 * 
	 * @return
	 */
	public Activity getCurrentActivity() {
		Activity currentActivity = activityStack.lastElement();
		return currentActivity;
	}

	/**
	 * Finish current activity
	 */
	public void finishCurrentActivity() {
		Activity currentActivity = activityStack.lastElement();
		finishActivity(currentActivity);
	}

	/**
	 * Finish activity
	 * 
	 * @param activity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * Finish activity by class name
	 * 
	 * @param activity
	 */
	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	/**
	 * Finish all activity
	 * 
	 * @param activity
	 */
	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}

	/**
	 * Exit the application
	 * 
	 * @param context
	 */
	public void exitApplication(Context context) {
		try {
			finishAllActivity();
			ActivityManager activityMgr = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			activityMgr.restartPackage(context.getPackageName());
			System.exit(0);
		} catch (Exception e) {
		}
	}
	
	public int getActivityCount(){
		if (activityStack != null) {
			return activityStack.size();
		}
		return 0;
	}
}
