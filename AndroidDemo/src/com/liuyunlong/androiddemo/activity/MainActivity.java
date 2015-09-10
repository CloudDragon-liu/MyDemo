package com.liuyunlong.androiddemo.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.adpter.MainListViewAdapter;
import com.liuyunlong.androiddemo.entity.MainItem;

/**
 * 之界面
 * @author liuyunlong
 *2015-9-9 上午9:59:45
 */
public class MainActivity extends Activity {

	private ListView listView;

	private Context mContext;

	private MainListViewAdapter adapter;

	private List<MainItem> mainItems = new ArrayList<MainItem>();

	private String[] mainTiStrings, mainBriefStrings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mContext = this;
		initData();
		initView();
	}

	/**
	 * 初始化数据
	 * 
	 * @author liuyunlong
	 * @date 2015-9-9下午8:58:07
	 */
	private void initData() {
		mainTiStrings = mContext.getResources().getStringArray(R.array.main_title_list);
		mainBriefStrings = mContext.getResources().getStringArray(R.array.main_brief_list);
		if (null != mainTiStrings && mainTiStrings.length > 0) {
			for (int i = 0; i < mainTiStrings.length; i++) {
				MainItem item = new MainItem();
				item.setTitle(mainTiStrings[i]);
				item.setBrief(mainBriefStrings[i]);
				item.setBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_launcher));
				mainItems.add(item);
			}
		}
	}

	/**
	 * 初始化控件
	 * 
	 * @author liuyunlong
	 * @date 2015-9-9下午8:57:56
	 */
	private void initView() {
		listView = (ListView) this.findViewById(R.id.main_listview);
		adapter = new MainListViewAdapter(mContext, mainItems);
		listView.setAdapter(adapter);
	}
}
