package com.liuyunlong.androiddemo.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;

/** 
 * SharedPreference方式存储数据
* @author  : liuyunlong
* @version ：2015-9-20 下午3:27:38 
* */
public class FragmentDataStore1 extends Fragment implements OnClickListener {

	private LinearLayout layout;

	private Context mContext;

	private TextView mIconText, mBriefText;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.data_store_page1, container, false);
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

	}

	private void initView(View view) {
		mContext = getActivity();
		mIconText = (TextView) view.findViewById(R.id.shared_text_with_icon);
		mBriefText = (TextView) view.findViewById(R.id.shared_preference_text);
		mIconText.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.shared_text_with_icon:
			mBriefText.setVisibility(View.VISIBLE);
			SharedPreferencesDemo();
			break;

		default:
			break;
		}
	}

	private void SharedPreferencesDemo() {
		// 第二个参数为文件的模式：只读，是否其他应用可访问等
		SharedPreferences spf = mContext.getSharedPreferences("mySp", mContext.MODE_PRIVATE);
		Editor editor = spf.edit();
		editor.putString("name", "liuyunlong");
		editor.putInt("age", 27);
		editor.putLong("time", System.currentTimeMillis());
		editor.putBoolean("default", true);
		editor.commit();

		// 取数据
		System.out.println(spf.getString("name", "default"));
		System.out.println(spf.getInt("age", 0));
		System.out.println(spf.getLong("time", System.currentTimeMillis()));
		System.out.println(spf.getBoolean("default", true));
	}

}
