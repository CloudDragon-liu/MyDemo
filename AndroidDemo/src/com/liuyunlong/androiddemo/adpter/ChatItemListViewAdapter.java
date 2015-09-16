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
import com.liuyunlong.androiddemo.entity.ChatItem;
import com.liuyunlong.androiddemo.entity.MainItem;

/** 
* @author  : liuyunlong
* @version ：2015-9-9 下午8:31:04 
* */
public class ChatItemListViewAdapter extends BaseAdapter {

	private Context mContext;

	private List<ChatItem> chatItems;

	private LayoutInflater mInflate;

	public ChatItemListViewAdapter(Context mContext, List<ChatItem> chatItems) {
		super();
		this.mContext = mContext;
		this.chatItems = chatItems;
		this.mInflate = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return chatItems.size();
	}

	@Override
	public Object getItem(int position) {
		return chatItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ChatItem chatItem = chatItems.get(position);

		ViewHolder viewHolder = null;
		if (null == convertView) {
			convertView = mInflate.inflate(R.layout.chat_listview_item, null);
			viewHolder = new ViewHolder();
			viewHolder.name = (TextView) convertView.findViewById(R.id.chat_item_name_text);
			viewHolder.time = (TextView) convertView.findViewById(R.id.chat_item_time_text);
			viewHolder.lastMsg = (TextView) convertView.findViewById(R.id.chat_item_msg_text);
			viewHolder.tips = (TextView) convertView.findViewById(R.id.chat_item_tip_text);
			viewHolder.icon = (ImageView) convertView.findViewById(R.id.chat_item_icon);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.icon.setImageBitmap(chatItem.getIcon());
		viewHolder.name.setText(chatItem.getName());
		viewHolder.lastMsg.setText(chatItem.getMsg());
		viewHolder.tips.setText(chatItem.getTips());
		viewHolder.time.setText(chatItem.getTime());
		return convertView;
	}

	static class ViewHolder {
		public TextView name;
		public TextView time;
		public TextView lastMsg;
		public TextView tips;
		public ImageView icon;
	}
}
