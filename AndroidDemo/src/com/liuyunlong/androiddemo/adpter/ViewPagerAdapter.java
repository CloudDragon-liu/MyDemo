package com.liuyunlong.androiddemo.adpter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/** 
* @author  : liuyunlong
* @version ：2015-9-12 上午10:20:50 
* */
public class ViewPagerAdapter extends PagerAdapter {

	private List<View> views;

	private Context mContext;

	private List<String> titleList;

	public ViewPagerAdapter(Context mContext, List<View> views, List<String> titles) {
		super();
		this.mContext = mContext;
		this.views = views;
		this.titleList = titles;
	}

	@Override
	public int getCount() {
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(views.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(views.get(position));
		return views.get(position);
	}

	/**
	 * 设置ViewPage的标题
	 */
	@Override
	public CharSequence getPageTitle(int position) {
		return titleList != null ? titleList.get(position) : "null";
	}
}
