package com.liuyunlong.androiddemo.fragment;

import java.util.ArrayList;
import java.util.List;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.adpter.MemberListViewAdapter;
import com.liuyunlong.androiddemo.entity.Member;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/** 
* @author  : liuyunlong
* @version ：2015-9-18 下午4:27:16 
* */
public class AddMemByManualFragment extends Fragment implements OnClickListener {

	private Context mContext;

	private LinearLayout layout;

	private TextView mResearchTv;

	private ListView listView;

	private MemberListViewAdapter adapter;

	private List<Member> members = new ArrayList<Member>();

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
		adapter = new MemberListViewAdapter(mContext, members);
		listView.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {

	}

}
