package com.liuyunlong.androiddemo.activity.adpter;

import java.util.List;

import com.android.yulong.chatdemo.R;
import com.android.yulong.chatdemo.adapter.MyListViewAdapter.ViewHolder;
import com.android.yulong.chatdemo.data.ImageDownload;
import com.android.yulong.chatdemo.entity.Equipment;
import com.liuyunlong.androiddemo.activity.entity.MainItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/** 
* @author  : liuyunlong
* @version ：2015-9-9 下午8:31:04 
* */
public class MainListViewAdapter extends BaseAdapter {

	private Context mContext;

	private List<MainItem> mainItems;

	private LayoutInflater mInflate;

	public MainListViewAdapter(Context mContext, List<MainItem> mainItems) {
		super();
		this.mContext = mContext;
		this.mainItems = mainItems;
		this.mInflate = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mainItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mainItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final MainItem maItem = mainItems.get(position);

		ViewHolder viewHolder = null;
		if (null == convertView) {
			convertView = mInflate.inflate(R.layout.listview_items, null);
			viewHolder = new ViewHolder();
			viewHolder.title = (TextView) convertView.findViewById(R.id.house_list_text);
			viewHolder.brief = (TextView) convertView.findViewById(R.id.house_list_text);
			viewHolder.icon = (ImageView) convertView.findViewById(R.id.house_list_image);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.icon.setTag(iconUrl);
		viewHolder.title.setText(maItem.getDeviceName());
		viewHolder.brief.setText(maItem.getDeviceName());
		return convertView;
	}

	static class ViewHolder {
		public TextView title;
		public TextView brief;
		public ImageView icon;
	}
}
