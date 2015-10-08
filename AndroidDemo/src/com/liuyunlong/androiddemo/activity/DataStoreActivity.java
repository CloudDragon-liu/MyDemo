package com.liuyunlong.androiddemo.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.fragment.FragmentDataStore1;
import com.liuyunlong.androiddemo.fragment.FragmentDataStore2;
import com.liuyunlong.androiddemo.fragment.FragmentDataStore3;
import com.liuyunlong.androiddemo.fragment.FragmentDataStore4;

/** 
 * 介绍android中的数据存储
* @author  : liuyunlong
* @version ：2015-9-20 下午3:11:53 
* */
public class DataStoreActivity extends FragmentActivity {

	private Context mContext;

	private String[] mTextviewArray;

	private int[] mImgsArray = { R.drawable.tab_1_selector, R.drawable.tab_2_selector, R.drawable.tab_3_selector, R.drawable.tab_4_selector };

	private List<Class> mFragments = new ArrayList<Class>();

	private LayoutInflater layoutInflater;

	private FragmentTabHost mTabHost;

	/**当前TabHost的位置*/
	private int mTabHostPos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.data_store);
		initData();
		initView();
	}

	private void initData() {
		mTextviewArray = getResources().getStringArray(R.array.data_store_tab_text);
		mFragments.add(FragmentDataStore1.class);
		mFragments.add(FragmentDataStore2.class);
		mFragments.add(FragmentDataStore3.class);
		mFragments.add(FragmentDataStore4.class);
	}

	private void initView() {
		mContext = this;
		layoutInflater = LayoutInflater.from(mContext);
		mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String tabId) {
				setCurmTabHostPos(mTabHost.getCurrentTab());
			}
		});
		for (int i = 0; i < mFragments.size(); i++) {
			// 为每一个Tab按钮设置图标、文字和内容
			TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
			// 将Tab按钮添加进Tab选项卡中
			mTabHost.addTab(tabSpec, mFragments.get(i), null);
			// 设置Tab按钮的背景
			// mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
		}
	}

	private View getTabItemView(int index) {
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);

		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImgsArray[index]);

		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTextviewArray[index]);

		return view;
	}

	protected void setCurmTabHostPos(int mTabHostPos) {
		this.mTabHostPos = mTabHostPos;
	}
}
