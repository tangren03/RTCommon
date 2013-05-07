package com.ryantang.common.db;

import android.content.Context;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * 对象型数据库
 * @author Ryan
 */
public class DB4OHelper {
	
	private DB4OHelper(){}
	
	private static ObjectContainer instance = null;
	
	public static synchronized ObjectContainer getContainer(Context context,String tableName){
		String DATABASE_PATH = context.getFilesDir().getAbsolutePath() + "/" + tableName;
		if (instance == null) {
			instance = Db4oEmbedded.openFile(DATABASE_PATH);
		}
		return instance;
	}
	
}
