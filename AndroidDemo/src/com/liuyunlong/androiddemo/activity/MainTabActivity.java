package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;

/** 
* @author  : liuyunlong
* @version ：2015-9-15 下午8:42:17 
* */
public class MainTabActivity extends FragmentActivity {

	/**layout object*/
	private LayoutInflater layoutInflater;

	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_tab_layout);
		initView();
	}

	private void initView() {
		layoutInflater = LayoutInflater.from(this);
		// 实例化TabHost对象，得到TabHost
		mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
	}
}
