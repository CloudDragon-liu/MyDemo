package com.liuyunlong.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;

import com.liuyunlong.androiddemo.R;

/** 
 * ViewPager实现app的Tab效果
* @author  : liuyunlong
* @version ：2015-9-11 下午7:16:34 
* */
public class ViewPagerActivity extends Activity {

	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tab_viewpager_main);
		initView();
	}

	private void initView() {
		viewPager = (ViewPager) this.findViewById(R.id.viewpager_content);
	}

	private void doClick(View v) {
		switch (v.getId()) {
		case R.id.tab_equ_layout:

			break;
		case R.id.tab_mall_layout:

			break;
		case R.id.tab_hel_layout:

			break;
		case R.id.tab_fam_layout:

			break;

		default:
			break;
		}
	}
}
