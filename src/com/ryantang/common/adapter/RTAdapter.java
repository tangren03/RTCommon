package com.ryantang.common.adapter;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Super Adapter
 * @author Ryan
 * @param <T>
 */
public abstract class RTAdapter<T> extends BaseAdapter {

	private final List<T> mList = new ArrayList<T>();

	public void setList(List<T> list) {
		if (list != null) {
			mList.addAll(list);
		}
	}
	
	public RTAdapter(List<T> list){
		mList.addAll(list);
	}
	
	public List<T> getList() {
		return mList;
	}

	public void appendToBottomList(List<T> list) {
		if (list == null) {
			return;
		}
		mList.addAll(list);
		notifyDataSetChanged();
	}

	public void appendToTopList(List<T> list) {
		if (list == null) {
			return;
		}
		mList.addAll(0, list);
		notifyDataSetChanged();
	}

	public void clear() {
		mList.clear();
		notifyDataSetChanged();
	}

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
	 * Custom view
	 * 
	 * @param position
	 * @param convertView
	 * @param parent
	 * @return
	 */
	protected abstract View getItemView(int position, View convertView,
			ViewGroup parent);

}
