package com.liuyunlong.androiddemo.fragment;

import java.util.ArrayList;
import java.util.List;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.adpter.MainListViewAdapter;
import com.liuyunlong.androiddemo.entity.MainItem;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/** @author liuyunlong
  * @date 2015-9-15 下午11:52:46 
  * @version 1.0 
  */
public class FragmentPage1 extends Fragment {

	private TextView mHeadTextView;

	private LinearLayout layout;

	private ListView listView;

	private List<MainItem> mainItems = new ArrayList<MainItem>();

	private String[] mItemTitleArray, mItemBriefArray;

	private MainListViewAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.fragment_layout_1, container, false);
			initData();
			initView(layout);
		}
		ViewGroup parent = (ViewGroup) layout.getParent();
		if (parent != null) {
			parent.removeView(layout);
		}
		return layout;
	}

	/**
	 * 初始化数据
	 * @author liuyunlong
	 * @date 2015-9-16下午2:18:09
	 */
	private void initData() {
		mItemTitleArray = getResources().getStringArray(R.array.main_title_list);
		mItemBriefArray = getResources().getStringArray(R.array.main_brief_list);
		if (null != mItemTitleArray && mItemTitleArray.length > 0) {
			for (int i = 0; i < mItemTitleArray.length; i++) {
				MainItem item = new MainItem();
				item.setTitle(mItemTitleArray[i]);
				item.setBrief(mItemBriefArray[i]);
				item.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.main_item_icon));
				mainItems.add(item);
			}
		}
		adapter = new MainListViewAdapter(getActivity(), mainItems);
	}

	/**
	 * 初始化控件
	 * @param view
	 * @author liuyunlong
	 * @date 2015-9-16下午2:21:04
	 */
	private void initView(View view) {
		mHeadTextView = (TextView) view.findViewById(R.id.fragment_layout_top_tv);
		mHeadTextView.setText(getResources().getStringArray(R.array.main_tab_text)[0]);
		listView = (ListView) view.findViewById(R.id.learn_rec_list);
		listView.setAdapter(adapter);
	}
}
