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
import com.liuyunlong.androiddemo.entity.Member;

/** 
* @author  : liuyunlong
* @version ：2015-9-19 上午10:13:03 
* */
public class AddMemberListAdapter extends BaseAdapter {

	private Context mContext;

	private List<Member> members;

	private LayoutInflater mInflate;

	public AddMemberListAdapter(Context mContext, List<Member> members) {
		super();
		this.mContext = mContext;
		this.members = members;
		this.mInflate = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return members.size();
	}

	@Override
	public Object getItem(int position) {
		return members.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Member member = members.get(position);

		ViewHolder viewHolder = null;
		if (null == convertView) {
			convertView = mInflate.inflate(R.layout.add_member_listview_item, null);
			viewHolder = new ViewHolder();
			viewHolder.userName = (TextView) convertView.findViewById(R.id.add_member_username_tv);
			viewHolder.phoneNumber = (TextView) convertView.findViewById(R.id.add_member_phone_tv);
			viewHolder.userIcon = (ImageView) convertView.findViewById(R.id.add_member_icon);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.userIcon.setImageBitmap(member.getUserIcon());
		viewHolder.userName.setText(member.getUsername());
		viewHolder.phoneNumber.setText(member.getPhonenumber());
		return convertView;
	}

	static class ViewHolder {
		public TextView userName;
		public TextView phoneNumber;
		public ImageView userIcon;
	}
}
