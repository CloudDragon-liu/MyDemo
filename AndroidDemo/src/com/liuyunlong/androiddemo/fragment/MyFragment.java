package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author liuyunlong
 * @date 2015-9-13 下午3:26:11
 * @version 1.0
 */
public class MyFragment extends Fragment {

	private TextView text;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// layout转换成View对象
		/**
		 * resource: fragment需要加载的布局文件
		 * root:加载layout的父ViewGroup中
		 * attachToRoot：true 返回父的ViewGroup
		 */
		View view = inflater.inflate(R.layout.my_fragment, container, false);
		text = (TextView) view.findViewById(R.id.my_fragment_text);
		text.setText("静态加载");
		return view;
	}
}
