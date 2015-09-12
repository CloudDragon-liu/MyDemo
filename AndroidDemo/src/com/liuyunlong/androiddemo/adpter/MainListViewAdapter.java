package com.liuyunlong.androiddemo.adpter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.entity.MainItem;

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
		return mainItems.size();
	}

	@Override
	public Object getItem(int position) {
		return mainItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final MainItem maItem = mainItems.get(position);

		ViewHolder viewHolder = null;
		if (null == convertView) {
			convertView = mInflate.inflate(R.layout.main_item_view, null);
			viewHolder = new ViewHolder();
			viewHolder.title = (TextView) convertView.findViewById(R.id.main_item_title_tv);
			viewHolder.brief = (TextView) convertView.findViewById(R.id.main_item_brief_tv);
			viewHolder.icon = (ImageView) convertView.findViewById(R.id.main_item_iv);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.icon.setImageBitmap(maItem.getBitmap());
		viewHolder.title.setText(maItem.getTitle());
		viewHolder.brief.setText(maItem.getBrief());
		return convertView;
	}

	static class ViewHolder {
		public TextView title;
		public TextView brief;
		public ImageView icon;
	}
}
