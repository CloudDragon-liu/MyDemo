package com.liuyunlong.androiddemo.activity;

import java.util.ArrayList;
import java.util.List;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.adpter.MemberListViewAdapter;
import com.liuyunlong.androiddemo.entity.Member;
import com.liuyunlong.androiddemo.fragment.FragmentPage4;
import com.liuyunlong.androiddemo.utils.Logger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/** 
 * 家庭管理（权限管理  + 备注名修改）
* @author  : liuyunlong
* @version ：2015-9-17 上午10:37:17 
* */
public class FamilyManagerActivity extends Activity implements OnClickListener {

	private Context mContext;

	private TextView mTopTextView, mQuitTextView;

	private ImageView mTopBackImgView;

	private ListView memListView;

	private MemberListViewAdapter mAdapter;

	private List<Member> members = new ArrayList<Member>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.family_manager);
		initData();
		initView();
	}

	private void initData() {
		members.add(new Member("女儿", "(露西露西露西露西露西露西露西)", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		members.add(new Member("儿子", "(格雷)", BitmapFactory.decodeResource(getResources(), R.drawable.son)));
		members.add(new Member("女儿", "(露西)", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
	}

	private void initView() {
		mContext = this;
		mTopBackImgView = (ImageView) this.findViewById(R.id.family_top_back_img);
		mTopBackImgView.setOnClickListener(this);
		mQuitTextView = (TextView) this.findViewById(R.id.family_quit_text);
		mQuitTextView.setOnClickListener(this);
		mTopTextView = (TextView) this.findViewById(R.id.family_top_text);
		mTopTextView.setText("家庭管理");
		memListView = (ListView) this.findViewById(R.id.family_member_listview);
		mAdapter = new MemberListViewAdapter(mContext, members);
		memListView.setAdapter(mAdapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.family_top_back_img:
			finish();
			break;
		case R.id.family_quit_text:
			Logger.showToast(mContext, "开发中。。。");
			break;

		default:
			break;
		}
	}
}
