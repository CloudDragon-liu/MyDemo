package com.liuyunlong.androiddemo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.Logger;

/** 
* @author  : liuyunlong
* @version ：2015-9-15 上午10:12:09 
* */
public class FragmentData extends Fragment {

	private TextView textView;

	private MyListener listener;

	private String transString;

	public String getTransString() {
		return transString;
	}

	public void setTransString(String transString) {
		this.transString = transString;
	}

	public interface MyListener { // 监听到Activity发送的数据后回应
		public void response(String string);
	}

	@Override
	public void onAttach(Activity activity) {
		listener = (MyListener) activity;
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_life, container, false);
		initView(view);
		return view;
	}

	private void initView(View view) {
		String string = getArguments().getString("name"); // Fragment中获取Activity传值
		textView = (TextView) view.findViewById(R.id.fragment_life_tv);
		textView.setText(getResources().getString(R.string.activity_data_2_fragment));
		Logger.showToast(getActivity(), "Fragment成功接收到Activity传值：" + string); // getActivity()获取宿主Activity
		Logger.showToast(getActivity(), "Fragment回应Activity,并发送:" + string);
		Logger.showToast(getActivity(), "我通过get方法获取值:" + getTransString());
		listener.response(string);
	}
}
