package com.liuyunlong.androiddemo.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;

/** 
 * ViewPager实现app的Tab效果
* @author  : liuyunlong
* @version ：2015-9-11 下午7:16:34 
* */
public class ViewPagerActivity extends Activity implements OnClickListener {

	private ViewPager viewPager;
	private LinearLayout tab_1_layout;
	private LinearLayout tab_2_layout;
	private LinearLayout tab_3_layout;
	private LinearLayout tab_4_layout;
	private ImageView tab_1_iv;
	private ImageView tab_2_iv;
	private ImageView tab_3_iv;
	private ImageView tab_4_iv;
	private TextView tab_1_tv;
	private TextView tab_2_tv;
	private TextView tab_3_tv;
	private TextView tab_4_tv;
	
	private List<View> mViews = new ArrayList<View>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tab_viewpager_main);
		initView();
	}

	private void initView() {
		viewPager = (ViewPager) this.findViewById(R.id.viewpager_content);
		tab_1_layout = (LinearLayout) this.findViewById(R.id.tab_equ_layout);
		tab_2_layout = (LinearLayout) this.findViewById(R.id.tab_mall_layout);
		tab_3_layout = (LinearLayout) this.findViewById(R.id.tab_hel_layout);
		tab_4_layout = (LinearLayout) this.findViewById(R.id.tab_fam_layout);
		tab_1_iv = (ImageView) this.findViewById(R.id.main_tab1_iv);
		tab_2_iv = (ImageView) this.findViewById(R.id.main_tab2_iv);
		tab_3_iv = (ImageView) this.findViewById(R.id.main_tab3_iv);
		tab_4_iv = (ImageView) this.findViewById(R.id.main_tab4_iv);
		tab_1_layout.setOnClickListener(this);
		tab_2_layout.setOnClickListener(this);
		tab_3_layout.setOnClickListener(this);
		tab_4_layout.setOnClickListener(this);
		//将布局转换为view
		LayoutInflater inflater = LayoutInflater.from(this); 
		View view_1 = inflater.inflate(R.layout.tab_viewpager_tab1, null);
		View view_2 = inflater.inflate(R.layout.tab_viewpager_tab2, null);
		View view_3 = inflater.inflate(R.layout.tab_viewpager_tab3, null);
		View view_4 = inflater.inflate(R.layout.tab_viewpager_tab4, null);
		mViews.add(view_1);
		mViews.add(view_2);
		mViews.add(view_3);
		mViews.add(view_4);
	}

	@Override
	public void onClick(View v) {
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
