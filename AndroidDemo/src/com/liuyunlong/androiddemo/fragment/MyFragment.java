package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author liuyunlong
 * @date 2015-9-13 下午3:26:11
 * @version 1.0
 */
public class MyFragment extends Fragment implements OnClickListener {

	private TextView fragmentTV;

	private Button fragmentBtn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// layout转换成View对象
		/**
		 * resource: fragment需要加载的布局文件
		 * root:加载layout的父ViewGroup中
		 * attachToRoot：true 返回父的ViewGroup
		 */
		View view = inflater.inflate(R.layout.my_fragment, container, false);
		initView(view);
		return view;
	}

	/**
	 * 初始化fragment控件
	 * @author liuyunlong
	 * @data 2015-9-14上午12:05:28
	 */
	private void initView(View view) {
		fragmentTV = (TextView) view.findViewById(R.id.my_fragment_text);
		fragmentBtn = (Button) view.findViewById(R.id.my_fragment_btn);
		fragmentBtn.setOnClickListener(this);
		fragmentBtn.setText("何为静态加载？");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.my_fragment_btn:
			fragmentTV.setText(getResources().getString(R.string.fragment_static_text));
			break;

		default:
			break;
		}

	}
}
