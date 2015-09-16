package com.liuyunlong.androiddemo.adpter;

import java.util.ArrayList;
import java.util.List;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.entity.Member;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/** 
* @author  : liuyunlong
* @version ：2015-9-16 下午7:37:42 
* */
public class MemberGridViewAdapter extends BaseAdapter {

	private Context mContext;

	private LayoutInflater mInflater;

	private List<Member> members = new ArrayList<Member>();

	public MemberGridViewAdapter(Context mContext, List<Member> members) {
		super();
		this.mContext = mContext;
		this.members = members;
		mInflater = LayoutInflater.from(mContext);
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

		Member member = members.get(position);
		ViewHolder viewHolder = null;
		if (null == convertView) {
			convertView = mInflater.inflate(R.layout.member_gridview_item, null);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView.findViewById(R.id.member_gridview_item_img);
			viewHolder.text = (TextView) convertView.findViewById(R.id.member_gridview_item_text);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.text.setText(member.getNickname());
		viewHolder.icon.setImageBitmap(member.getBitmap());
		return convertView;
	}

	static class ViewHolder {
		public TextView text;
		public ImageView icon;
	}

}
