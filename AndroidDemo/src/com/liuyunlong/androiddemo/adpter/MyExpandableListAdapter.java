package com.liuyunlong.androiddemo.adpter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/** 
* @author  : liuyunlong
* @version ：2015-9-24 上午9:37:56 
* */
public class MyExpandableListAdapter extends BaseExpandableListAdapter {

	private Context mContext;

	public String groups[] = { "好友", "家人" };

	public String child[][] = { { "张三", "王五", "李四" }, { "爸爸", "妈妈" } };

	public MyExpandableListAdapter(Context mContext, String[] groups, String[][] child) {
		super();
		this.mContext = mContext;
	}

	@Override
	public int getGroupCount() {
		return groups.length;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return child[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groups[groupPosition];
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return child[groupPosition][childPosition];
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		TextView textView = buildTextView();
		textView.setText(getGroup(groupPosition).toString());
		return textView;
	}

	private TextView buildTextView() {
		AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 35);
		TextView textView = new TextView(this.mContext);
		textView.setLayoutParams(params);
		textView.setTextSize(15.0f);
		textView.setGravity(Gravity.LEFT); // 左对齐
		textView.setPadding(40, 8, 3, 3);
		return textView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		TextView textView = new TextView(this.mContext);
		textView.setText(getChild(groupPosition, childPosition).toString());
		return textView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
