package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/** 
* @author  : liuyunlong
* @version ：2015-9-20 下午3:38:39 
* */
public class FragmentDataStore3 extends Fragment {

	private LinearLayout layout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.data_store_page3, container, false);
			initData();
			initView(layout);
		}
		ViewGroup parent = (ViewGroup) layout.getParent();
		if (null != parent) {
			parent.removeView(layout);
		}
		return layout;
	}

	private void initView(View view) {

	}

	private void initData() {

	}

}
