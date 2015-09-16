package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.Logger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/** @author liuyunlong
  * @date 2015-9-15 下午11:53:38 
  * @version 1.0 
  */
public class FragmentPage3 extends Fragment implements OnClickListener {

	private Context mContext;

	private LinearLayout layout;

	private TextView mHeadTextView;

	private ImageView mTopLeftIcon, mTopRightIcon;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.fragment_layout_3, container, false);
			initData();
			initView(layout);
		}
		ViewGroup parent = (ViewGroup) layout.getParent();
		if (null != parent) {
			parent.removeView(layout);
		}
		return layout;
	}

	/**
	 * 初始化数据
	 * 
	 * @author liuyunlong
	 * @date 2015-9-16下午5:26:19
	 */
	private void initData() {

	}

	/**
	 * 初始化控件
	 * @param view
	 * @author liuyunlong
	 * @date 2015-9-16下午5:26:32
	 */
	private void initView(View view) {
		mContext = getActivity();
		mHeadTextView = (TextView) view.findViewById(R.id.fragment_layout_top_tv);
		mHeadTextView.setText(getResources().getStringArray(R.array.main_tab_text)[2]);
		mTopLeftIcon = (ImageView) view.findViewById(R.id.top_left_img);
		mTopLeftIcon.setOnClickListener(this);
		mTopRightIcon = (ImageView) view.findViewById(R.id.top_right_3_img);
		mTopRightIcon.setOnClickListener(this);
		mTopRightIcon.setVisibility(View.VISIBLE);
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
		case R.id.top_right_3_img:
			Logger.showToast(mContext, "正在开发中...");
			break;

		default:
			break;
		}
	}
}
