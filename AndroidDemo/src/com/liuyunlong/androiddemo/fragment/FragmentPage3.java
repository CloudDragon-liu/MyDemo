package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/** @author liuyunlong
  * @date 2015-9-15 下午11:53:38 
  * @version 1.0 
  */
public class FragmentPage3 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_layout_3, null);
	}
}
