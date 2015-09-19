package com.liuyunlong.androiddemo.adpter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.activity.PrivilegeManageActivity;
import com.liuyunlong.androiddemo.activity.StartActivity;
import com.liuyunlong.androiddemo.dialog.AddMemberDialog;
import com.liuyunlong.androiddemo.entity.Member;
import com.liuyunlong.androiddemo.utils.Logger;

/** 
* @author  : liuyunlong
* @version ：2015-9-17 上午11:48:43 
* */
public class MemberListViewAdapter extends BaseAdapter {

	private Context mContext;

	private List<Member> members;

	private LayoutInflater mInflate;

	public MemberListViewAdapter(Context mContext, List<Member> members) {
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
		final AddMemberDialog dialog = new AddMemberDialog(mContext, "修改备注名", null, "请输入备注名");

		ViewHolder viewHolder = null;
		if (null == convertView) {
			convertView = mInflate.inflate(R.layout.member_listview_item, null);
			viewHolder = new ViewHolder();
			viewHolder.userName = (TextView) convertView.findViewById(R.id.username);
			viewHolder.nickName = (TextView) convertView.findViewById(R.id.nickname);
			viewHolder.userIcon = (ImageView) convertView.findViewById(R.id.user_icon_img);
			viewHolder.privilegeIcon = (ImageView) convertView.findViewById(R.id.privilege_icon);
			viewHolder.privilegeIcon.setOnClickListener(new OnClickListener() { // 权限配置

						@Override
						public void onClick(View v) {
							Intent intent = new Intent(mContext, PrivilegeManageActivity.class);
							mContext.startActivity(intent);
						}
					});
			viewHolder.nicknameIcon = (ImageView) convertView.findViewById(R.id.nickname_icon);
			viewHolder.nicknameIcon.setOnClickListener(new OnClickListener() { // 修改备注名

						@Override
						public void onClick(View v) {
							dialog.show();
							EditText editText = dialog.getEditText();
							TextView okTextView = dialog.getmOkTv();
							TextView giveUpTextView = dialog.getmGiveUpTv();
							final String nickname = editText.getText().toString();
							okTextView.setOnClickListener(new OnClickListener() {

								@Override
								public void onClick(View v) {
									Logger.showToast(mContext, nickname);
								}
							});
							giveUpTextView.setOnClickListener(new OnClickListener() {

								@Override
								public void onClick(View v) {
									dialog.dismiss();
								}
							});
						}
					});
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.userIcon.setImageBitmap(member.getUserIcon());
		viewHolder.userName.setText(member.getUsername());
		viewHolder.nickName.setText(member.getNickname());
		return convertView;
	}

	static class ViewHolder {
		public TextView userName;
		public TextView nickName;
		public ImageView userIcon;
		public ImageView privilegeIcon;
		public ImageView nicknameIcon;
	}
}
