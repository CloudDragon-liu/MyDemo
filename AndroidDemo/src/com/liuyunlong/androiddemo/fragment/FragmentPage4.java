package com.liuyunlong.androiddemo.fragment;

import java.util.ArrayList;
import java.util.List;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.adpter.ChatItemListViewAdapter;
import com.liuyunlong.androiddemo.adpter.MemberGridViewAdapter;
import com.liuyunlong.androiddemo.entity.ChatItem;
import com.liuyunlong.androiddemo.entity.Member;
import com.liuyunlong.androiddemo.utils.Logger;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/** @author liuyunlong
  * @date 2015-9-15 下午11:54:47 
  * @version 1.0 
  */
public class FragmentPage4 extends Fragment implements OnClickListener, OnItemClickListener {

	private Context mContext;

	private LinearLayout mLayout;

	private TextView mHeadTextView;

	private ImageView mTopLeftIcon, mTopRightIcon;

	private GridView membGridView;

	private ListView mChatListView;

	private MemberGridViewAdapter mGridViewAdapter;

	private ChatItemListViewAdapter mChatItemAdapter;

	private List<Member> members = new ArrayList<Member>();

	private List<ChatItem> mChatItems = new ArrayList<ChatItem>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == mLayout) {
			mLayout = (LinearLayout) inflater.inflate(R.layout.fragment_layout_4, container, false);
			initData();
			initView(mLayout);
		}
		ViewGroup parent = (ViewGroup) mLayout.getParent();
		if (parent != null) {
			parent.removeView(mLayout);
		}
		return mLayout;
	}

	private void initData() {
		members.add(new Member("女儿", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		members.add(new Member("儿子", BitmapFactory.decodeResource(getResources(), R.drawable.son)));
		members.add(new Member("女儿", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		members.add(new Member("儿子", BitmapFactory.decodeResource(getResources(), R.drawable.son)));
		members.add(new Member("添加", BitmapFactory.decodeResource(getResources(), R.drawable.add_family_member)));

		// mChatItems.add(new ChatItem("女儿", "现在回来吗？", "上午11:22", "1",
		// BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		// mChatItems.add(new ChatItem("儿子", "我打球去了？", "下午15:22", "3",
		// BitmapFactory.decodeResource(getResources(), R.drawable.son)));
		mChatItems.add(new ChatItem("女儿", "现在回来吗？", "上午11:22", "20", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		mChatItems.add(new ChatItem("儿子", "我打球去了？", "下午15:22", "99+", BitmapFactory.decodeResource(getResources(), R.drawable.son)));
	}

	private void initView(View view) {
		mContext = getActivity();
		mHeadTextView = (TextView) view.findViewById(R.id.fragment_layout_top_tv);
		mHeadTextView.setText(getResources().getStringArray(R.array.main_tab_text)[3]);
		mTopLeftIcon = (ImageView) view.findViewById(R.id.top_left_img);
		mTopLeftIcon.setOnClickListener(this);
		mTopRightIcon = (ImageView) view.findViewById(R.id.top_right_4_img);
		mTopRightIcon.setOnClickListener(this);
		mTopRightIcon.setVisibility(View.VISIBLE);

		membGridView = (GridView) view.findViewById(R.id.member_gridview);
		membGridView.setOnItemClickListener(this);
		mChatListView = (ListView) view.findViewById(R.id.chat_listview);
		mChatListView.setOnItemClickListener(this);

		mGridViewAdapter = new MemberGridViewAdapter(mContext, members);
		mChatItemAdapter = new ChatItemListViewAdapter(mContext, mChatItems);
		membGridView.setAdapter(mGridViewAdapter);
		mChatListView.setAdapter(mChatItemAdapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.top_left_img:

			break;
		case R.id.top_right_4_img:

			break;

		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	}
}
