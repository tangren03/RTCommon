package com.ryantang.common.db;

import java.util.ArrayList;

/**
 * Base DAO
 * @author Ryan
 */
public abstract class RTBaseDAO {

	/**
	 * insert data into database
	 * @param obj , completely down-loaded entity info
	 * */
	public abstract void insert(Object obj);
	
	/**
	 * query records with filter
	 * @return ArrayList<Object> , the list of records
	 * */
	public abstract ArrayList<?> query(Object obj);
	
	/**
	 * update and reset the records
	 * @param obj,
	 * */
	public abstract void update(Object obj,Object newObj); 
	
	/**
	 * delete record with filter
	 * */
	public abstract void delete(Object obj);
	
	/**
	 * drop table if exists
	 * @return String , for executing ,remove table from database
	 * */
	public abstract String dropTable();
}
