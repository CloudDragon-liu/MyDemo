package com.liuyunlong.androiddemo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.Logger;

/** @author liuyunlong
  * @date 2015-9-15 下午11:53:15 
  * @version 1.0 
  */
public class MainPage2Fragment extends Fragment implements OnClickListener, OnPageChangeListener {

	private LinearLayout layout;

	private Context mContext;

	private ImageView mTopLeftIcon, mTopRightIcon;

	private TextView mHeadTextView;

	private List<Fragment> fragments = new ArrayList<Fragment>();

	private String viewTitleArray[];

	private ViewPager viewPager;

	private PagerTabStrip tabStrip;

	private FragmentPagerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.fragment_layout_2, container, false);
			mContext = getActivity();
			initData();
			initView(layout);
		}
		ViewGroup parent = (ViewGroup) layout.getParent();
		if (null != parent) {
			parent.removeView(layout);
		}
		return layout;
	}

	private void initData() {
		viewTitleArray = mContext.getResources().getStringArray(R.array.collect_page_title);
		fragments.add(new FragmentCollectTech());
		fragments.add(new FragmentComponentBroadCast());
		fragments.add(new FragmentComponentContentProvider());
		fragments.add(new FragmentComponentService());
	}

	private void initView(View view) {
		mHeadTextView = (TextView) view.findViewById(R.id.fragment_layout_top_tv);
		mHeadTextView.setText(getResources().getStringArray(R.array.main_tab_text)[1]);
		mTopLeftIcon = (ImageView) view.findViewById(R.id.top_left_img);
		mTopRightIcon = (ImageView) view.findViewById(R.id.top_right_2_img);
		mTopLeftIcon.setOnClickListener(this);
		mTopRightIcon.setOnClickListener(this);
		mTopRightIcon.setVisibility(View.VISIBLE);

		viewPager = (ViewPager) view.findViewById(R.id.collect_viewpager);
		tabStrip = (PagerTabStrip) view.findViewById(R.id.collect_pager_tab);
		// 为PagerTabStrip设置属性
		tabStrip.setBackgroundColor(Color.WHITE);
		tabStrip.setTextColor(getResources().getColor(R.color.bar_sel));
		tabStrip.setDrawFullUnderline(false);// 去掉长线
		tabStrip.setTabIndicatorColor(getResources().getColor(R.color.bar_sel));// 设置选中的线
		adapter = new FragmentPagerAdapter(getFragmentManager()) {

			@Override
			public int getCount() {
				return fragments.size();
			}

			@Override
			public CharSequence getPageTitle(int position) {
				return viewTitleArray[position];
			}

			@Override
			public Fragment getItem(int position) {
				return fragments.get(position);
			}
		};
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
	}

	/**
	 * 响应点击事件
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.top_left_img:
			Logger.showToast(mContext, "正在开发中...");
			break;
		case R.id.top_right_2_img:
			Logger.showToast(mContext, "正在开发中...");
			break;

		default:
			break;
		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {

	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}
}
