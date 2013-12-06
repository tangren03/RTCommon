package com.ryantang.common.adapter;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Extents from BaseAdapter RTAdapter.java
 * 
 * @author Ryan Create at 2013-12-6 下午1:37:31
 * @param <T>
 */
public abstract class RTAdapter<T> extends BaseAdapter {

	private List<T> mList = new ArrayList<T>();

	/**
	 * Set data list to Adapter
	 * 
	 * @param list
	 */
	protected void setList(List<T> list) {
		if (list != null) {
			mList.addAll(list);
		} else {
			throw new NullPointerException();
		}
	}

	/**
	 * Clear data list and reset it, update ListView
	 * 
	 * @param list
	 */
	public void notifyDateSetUpdate(List<T> list) {
		if (list != null && mList.size() > 0) {
			mList.clear();
			mList.addAll(list);
			notifyDataSetChanged();
		}
	}

	/**
	 * Get data list
	 * 
	 * @return
	 */
	public List<T> getList() {
		return mList;
	}

	/**
	 * Append data list to bottom of the ListView
	 * 
	 * @param list
	 */
	public void appendToBottomList(List<T> list) {
		if (list == null) {
			return;
		}
		mList.addAll(list);
		notifyDataSetChanged();
	}

	/**
	 * Append data list to top of the ListView
	 * 
	 * @param list
	 */
	public void appendToTopList(List<T> list) {
		if (list == null) {
			return;
		}
		mList.addAll(0, list);
		notifyDataSetChanged();
	}

	/**
	 * Clear all the data and update ListView
	 */
	public void clear() {
		mList.clear();
		notifyDataSetChanged();
	}

	/* BaseAdapter methods */
	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		if (position > mList.size() - 1) {
			return null;
		}
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getItemView(position, convertView, parent);
	}

	/**
	 * Custom item view in your subclass
	 * 
	 * @param position
	 * @param convertView
	 * @param parent
	 * @return
	 */
	protected abstract View getItemView(int position, View convertView,
			ViewGroup parent);

}
