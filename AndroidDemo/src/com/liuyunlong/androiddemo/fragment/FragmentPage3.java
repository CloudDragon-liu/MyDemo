package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/** @author liuyunlong
  * @date 2015-9-15 下午11:53:38 
  * @version 1.0 
  */
public class FragmentPage3 extends Fragment {

	private TextView mHeadTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout_3, null);
		initView(view);
		return view;
	}

	private void initView(View view) {
		mHeadTextView = (TextView) view.findViewById(R.id.fragment_layout_top_tv);
		mHeadTextView.setText(getResources().getStringArray(R.array.main_tab_text)[2]);
	}
}
