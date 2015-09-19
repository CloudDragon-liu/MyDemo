package com.liuyunlong.androiddemo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.activity.AddMemberActivity;
import com.liuyunlong.androiddemo.activity.FamilyManagerActivity;
import com.liuyunlong.androiddemo.activity.LoginActivity;
import com.liuyunlong.androiddemo.activity.UserCenterActivity;
import com.liuyunlong.androiddemo.adpter.ChatItemListViewAdapter;
import com.liuyunlong.androiddemo.adpter.MemberGridViewAdapter;
import com.liuyunlong.androiddemo.entity.ChatItem;
import com.liuyunlong.androiddemo.entity.Member;
import com.liuyunlong.androiddemo.utils.Logger;

/** @author liuyunlong
  * @date 2015-9-15 下午11:54:47 
  * @version 1.0 
  */
public class MainPage4Fragment extends Fragment implements OnClickListener, OnItemClickListener {

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

	/**更多*/
	private PopupWindow mPopWin;

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
		members.add(new Member("时光记忆", "", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		members.add(new Member("家庭健康", "", BitmapFactory.decodeResource(getResources(), R.drawable.son)));
		members.add(new Member("宝宝教育", "", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		members.add(new Member("添加", "", BitmapFactory.decodeResource(getResources(), R.drawable.add_family_member)));

		mChatItems.add(new ChatItem("女儿", "今晚没饭吃！", "上午11:22", "1", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		mChatItems.add(new ChatItem("女儿", "现在回来吗？", "上午11:22", "20", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		mChatItems.add(new ChatItem("儿子", "我打球去了？我打球去了？我打球去了？我打球去了？我打球去了？我打球去了？", "下午15:22", "99+", BitmapFactory.decodeResource(getResources(), R.drawable.son)));
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
		boolean isLogin = true; // 模拟已经登录
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.top_left_img:
			intent.setClass(mContext, isLogin ? UserCenterActivity.class : LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.fragment_layout_top_tv: // 切换家庭
			Logger.showToast(mContext, "devoloping...");
			break;
		case R.id.top_right_4_img: // 更多
			showMorePopupWindow();
			break;
		case R.id.add_mem_tv: // add member
			mPopWin.dismiss();
			intent.setClass(mContext, AddMemberActivity.class);
			startActivity(intent);
			break;
		case R.id.family_manager_tv: // family manager
			mPopWin.dismiss();
			intent.setClass(mContext, FamilyManagerActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	/**
	 * more widown
	 * 
	 * @author liuyunlong
	 * @date 2015-9-18下午3:37:44
	 */
	private void showMorePopupWindow() {
		int with = mContext.getResources().getDisplayMetrics().widthPixels * 330 / 1080;
		int height = android.widget.FrameLayout.LayoutParams.WRAP_CONTENT;
		LinearLayout layout = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.family_more_menu_layout, null);
		TextView addMemberTv = (TextView) layout.findViewById(R.id.add_mem_tv);
		TextView familyManTv = (TextView) layout.findViewById(R.id.family_manager_tv);
		mPopWin = new PopupWindow(layout, with, height, true);
		mPopWin.setBackgroundDrawable(new ColorDrawable(0));
		mPopWin.showAsDropDown(mTopRightIcon, -(with - mTopRightIcon.getWidth() - 15), 25);
		mPopWin.setOutsideTouchable(false);
		mPopWin.update();
		familyManTv.setOnClickListener(this);
		addMemberTv.setOnClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	}
}
