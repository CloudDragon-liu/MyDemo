package com.liuyunlong.androiddemo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.activity.AndroidComponentsActivity;
import com.liuyunlong.androiddemo.activity.AutoCompeleteActivity;
import com.liuyunlong.androiddemo.activity.DataStoreActivity;
import com.liuyunlong.androiddemo.activity.DataTimePickerActivity;
import com.liuyunlong.androiddemo.activity.DialogActivity;
import com.liuyunlong.androiddemo.activity.FragmentBaseItemActivity;
import com.liuyunlong.androiddemo.activity.FragmentPagerAdapterTabActivity;
import com.liuyunlong.androiddemo.activity.FragmentTabItemActivity;
import com.liuyunlong.androiddemo.activity.GalleryActivity;
import com.liuyunlong.androiddemo.activity.GestureActivity;
import com.liuyunlong.androiddemo.activity.HandlerItemActivity;
import com.liuyunlong.androiddemo.activity.MainTabActivity;
import com.liuyunlong.androiddemo.activity.MenuActivity;
import com.liuyunlong.androiddemo.activity.SeekBarActivity;
import com.liuyunlong.androiddemo.activity.SlidingDrawerActivity;
import com.liuyunlong.androiddemo.activity.SpinnerActivity;
import com.liuyunlong.androiddemo.activity.ViewPagerItemActivity;
import com.liuyunlong.androiddemo.adpter.MainListViewAdapter;
import com.liuyunlong.androiddemo.entity.MainItem;
import com.liuyunlong.androiddemo.utils.ConstantUtils;
import com.liuyunlong.androiddemo.utils.Logger;

/** @author liuyunlong
  * @date 2015-9-15 下午11:52:46 
  * @version 1.0 
  */
public class MainPage1Fragment extends Fragment implements OnItemClickListener, OnClickListener {

	private Context mContext;

	private TextView mHeadTextView;

	private LinearLayout layout;

	private ListView listView;

	private List<MainItem> mainItems = new ArrayList<MainItem>();

	private String[] mItemTitleArray, mItemBriefArray;

	private MainListViewAdapter adapter;

	private ImageView mTopLeftIcon, mTopRightIcon;

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
		mContext = getActivity();
		mHeadTextView = (TextView) view.findViewById(R.id.fragment_layout_top_tv);
		mHeadTextView.setText(getResources().getStringArray(R.array.main_tab_text)[0]);
		mTopLeftIcon = (ImageView) view.findViewById(R.id.top_left_img);
		mTopRightIcon = (ImageView) view.findViewById(R.id.top_right_1_img);
		mTopRightIcon.setVisibility(View.VISIBLE);
		mTopLeftIcon.setOnClickListener(this);
		mTopRightIcon.setOnClickListener(this);
		listView = (ListView) view.findViewById(R.id.learn_rec_list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	/**
	 * listView的点击监听
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = new Intent();
		switch (position) {
		case ConstantUtils.NUMBER.ZERO:
			intent.setClass(mContext, HandlerItemActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.ONE: // Fragment
			intent.setClass(mContext, FragmentBaseItemActivity.class);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.TWO: // ViewPager实现Tab页效果
			intent.setClass(mContext, ViewPagerItemActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.THREE: // Fragment实现Tab页效果
			intent.setClass(mContext, FragmentTabItemActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.FOUR: // FragmentPagerAdapter+
										// viewPager实现Tab页效果
			intent.setClass(mContext, FragmentPagerAdapterTabActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.FIVE: // ViewPagerIndicator
										// +viewPager实现Tab页效果
			Logger.showToast(mContext, "devoloping...");
			break;
		case ConstantUtils.NUMBER.SIX: // FragmentTabHost
			intent.setClass(mContext, MainTabActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.SEVEN: // Android 数据存储
			intent.setClass(mContext, DataStoreActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.EIGHT: // Android 四大组件
			intent.setClass(mContext, AndroidComponentsActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.NINE: // Android 手势识别
			intent.setClass(mContext, GestureActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.TEN: // spinner
			intent.setClass(mContext, SpinnerActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.ELEVEN: // DataPicker
			intent.setClass(mContext, DataTimePickerActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.TWELVE: // Dialog
			intent.setClass(mContext, DialogActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.THIRTEEN: // autoCompelete TextView
			intent.setClass(mContext, AutoCompeleteActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.FOURTEEN: // seekbar
			intent.setClass(mContext, SeekBarActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.FIFTEEN: // Gallery
			intent.setClass(mContext, GalleryActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.SIXTEEN: // Menu
			intent.setClass(mContext, MenuActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case ConstantUtils.NUMBER.SEVENTEEN: // slidingDrawer
			intent.setClass(mContext, SlidingDrawerActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	/**
	 * 点击事件监听
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.top_left_img:
			Logger.showToast(mContext, "正在开发中。。。");
			break;
		case R.id.top_right_1_img:
			Logger.showToast(mContext, "正在开发中。。。");
			break;

		default:
			break;
		}
	}
}
