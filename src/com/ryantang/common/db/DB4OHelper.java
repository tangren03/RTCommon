package com.ryantang.common.db;

import android.content.Context;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * DB4O HELPER
 * @author Ryan
 */
public class DB4OHelper {
	
	private DB4OHelper(){}
	
	private static ObjectContainer instance = null;
	
	public static synchronized ObjectContainer getObjectContainer(Context context,String dbName){
		String DATABASE_PATH = context.getFilesDir().getAbsolutePath() + "/" + dbName;
		if (instance == null) {
			instance = Db4oEmbedded.openFile(DATABASE_PATH);
		}
		return instance;
	}
	
}
