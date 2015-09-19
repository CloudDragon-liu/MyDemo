package com.liuyunlong.androiddemo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.adpter.AddMemberListAdapter;
import com.liuyunlong.androiddemo.dialog.AddMemberDialog;
import com.liuyunlong.androiddemo.entity.Member;
import com.liuyunlong.androiddemo.utils.Logger;

/** 
 * 手动添加成员
* @author  : liuyunlong
* @version ：2015-9-18 下午4:27:16 
* */
public class AddMemByManualFragment extends Fragment implements OnClickListener, OnItemClickListener {

	private Context mContext;

	private LinearLayout layout;

	private TextView mResearchTv;

	private ListView listView;

	private AddMemberListAdapter adapter;

	private List<Member> members = new ArrayList<Member>();

	private AddMemberDialog dialog;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.add_member_manual, container, false);
			iniData();
			initView(layout);
		}
		ViewGroup parent = (ViewGroup) layout.getParent();
		if (parent != null) {
			parent.removeView(layout);
		}
		return layout;
	}

	private void iniData() {
		members.add(new Member("nv er", "lu xi", "13865245822", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
	}

	private void initView(View view) {
		mContext = getActivity();
		mResearchTv = (TextView) view.findViewById(R.id.add_member_search);
		mResearchTv.setOnClickListener(this);
		listView = (ListView) view.findViewById(R.id.add_mem_list);
		adapter = new AddMemberListAdapter(mContext, members);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		showAddMemberDialog();
	}

	private void showAddMemberDialog() {
		dialog = new AddMemberDialog(mContext, "添加家庭成员", null, "请输入备注名");
		dialog.show();
		EditText editText = dialog.getEditText();
		TextView giveUpTv = dialog.getmGiveUpTv();
		TextView okTv = dialog.getmOkTv();
		final String string = editText.getText().toString();
		giveUpTv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		okTv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Logger.showToast(mContext, string);
				dialog.dismiss();
			}
		});
	}
}
