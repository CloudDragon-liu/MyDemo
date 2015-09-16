package com.liuyunlong.androiddemo.activity;

import java.util.ArrayList;
import java.util.List;

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
import com.liuyunlong.androiddemo.fragment.FragmentPage1;
import com.liuyunlong.androiddemo.fragment.FragmentPage2;
import com.liuyunlong.androiddemo.fragment.FragmentPage3;
import com.liuyunlong.androiddemo.fragment.FragmentPage4;

/** 
 * Tab主界面
* @author  : liuyunlong
* @version ：2015-9-15 下午8:42:17 
* */
public class MainTabActivity extends FragmentActivity {

	/**布局对象*/
	private LayoutInflater layoutInflater;

	private FragmentTabHost mTabHost;

	/**当前TabHost的位置*/
	private int mTabHostPos;

	private List<Class> mFragments = new ArrayList<Class>();

	private String[] mTextviewArray;

	private List<Integer> mImgs = new ArrayList<Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_tab_layout);
		initData();
		initView();
	}

	private void initData() {
		mTextviewArray = getResources().getStringArray(R.array.main_tab_text);
		mFragments.add(FragmentPage1.class);
		mFragments.add(FragmentPage2.class);
		mFragments.add(FragmentPage3.class);
		mFragments.add(FragmentPage4.class);
		mImgs.add(R.drawable.tab_1_selector);
		mImgs.add(R.drawable.tab_2_selector);
		mImgs.add(R.drawable.tab_3_selector);
		mImgs.add(R.drawable.tab_4_selector);
	}

	private void initView() {
		layoutInflater = LayoutInflater.from(this);
		// 实例化TabHost对象，得到TabHost
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

	/**
	 * 给Tab按钮设置图标和文字 
	 * @author liuyunlong
	 * @data 2015-9-16上午12:15:20
	 */
	private View getTabItemView(int index) {
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);

		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImgs.get(index));

		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTextviewArray[index]);

		return view;
	}

	public int getCurmTabHostPos() {
		return mTabHostPos;
	}

	public void setCurmTabHostPos(int mTabHostPos) {
		this.mTabHostPos = mTabHostPos;
	}
}
