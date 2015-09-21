package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/** 
* @author  : liuyunlong
* @version ：2015-9-21 下午1:51:18 
* */
public class FragmentComponentActivity extends Fragment {

	private LinearLayout layout;

	private Context mContext;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.component_activity, container, false);
			initView(layout);
		}
		ViewGroup parent = (ViewGroup) layout.getParent();
		if (null != parent) {
			parent.removeView(layout);
		}
		return layout;
	}

	private void initView(View view) {
		mContext = getActivity();
	}

}
