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
* @version ：2015-9-18 下午4:27:16 
* */
public class AddMemByQrcodeFragment extends Fragment {

	private Context mContext;

	private LinearLayout layout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.add_member_qrcode, container, false);
			initView(layout);
		}
		ViewGroup parent = (ViewGroup) layout.getParent();
		if (parent != null) {
			parent.removeView(layout);
		}
		return layout;
	}

	private void initView(View view) {

	}
}
