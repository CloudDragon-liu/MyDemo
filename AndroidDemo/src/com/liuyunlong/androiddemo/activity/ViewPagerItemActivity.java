package com.liuyunlong.androiddemo.activity;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.adpter.ViewPagerAdapter;
import com.liuyunlong.androiddemo.utils.ConstantUtils;

/** 
 * ViewPager实现app的Tab效果
 * @author  : liuyunlong
 * @version ：2015-9-11 下午7:16:34 
 * */
public class ViewPagerItemActivity extends Activity implements OnClickListener, OnPageChangeListener {

	private ViewPager viewPager;
	private LinearLayout tab_1_layout, tab_2_layout, tab_3_layout, tab_4_layout;
	private ImageView tab_1_iv, tab_2_iv, tab_3_iv, tab_4_iv;
	private TextView tab_1_tv, tab_2_tv, tab_3_tv, tab_4_tv, headTV;
	private ViewPagerAdapter adapter;

	private List<View> mViews = new ArrayList<View>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.viewpager_activity_main);
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
		tab_1_tv = (TextView) this.findViewById(R.id.main_tab1_tv);
		tab_2_tv = (TextView) this.findViewById(R.id.main_tab2_tv);
		tab_3_tv = (TextView) this.findViewById(R.id.main_tab3_tv);
		tab_4_tv = (TextView) this.findViewById(R.id.main_tab4_tv);
		headTV = (TextView) this.findViewById(R.id.main_head_tv);
		tab_1_layout.setOnClickListener(this);
		tab_2_layout.setOnClickListener(this);
		tab_3_layout.setOnClickListener(this);
		tab_4_layout.setOnClickListener(this);
		// 将布局转换为view
		View view_1 = View.inflate(this, R.layout.tab_viewpager_tab1, null);
		View view_2 = View.inflate(this, R.layout.tab_viewpager_tab2, null);
		View view_3 = View.inflate(this, R.layout.tab_viewpager_tab3, null);
		View view_4 = View.inflate(this, R.layout.tab_viewpager_tab4, null);
		mViews.add(view_1);
		mViews.add(view_2);
		mViews.add(view_3);
		mViews.add(view_4);

		adapter = new ViewPagerAdapter(this, mViews);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		resetToNormal();
		switch (v.getId()) {
		case R.id.tab_equ_layout:
			viewPager.setCurrentItem(0); // 设置为当前viewpage
			tab_1_iv.setImageResource(R.drawable.main_tab_equ_sel); // 设置图标为选中状态
			tab_1_tv.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			headTV.setText(tab_1_tv.getText());
			break;
		case R.id.tab_mall_layout:
			viewPager.setCurrentItem(1);
			tab_2_iv.setImageResource(R.drawable.main_tab_mall_sel);
			tab_2_tv.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			headTV.setText(tab_2_tv.getText());
			break;
		case R.id.tab_hel_layout:
			viewPager.setCurrentItem(2);
			tab_3_iv.setImageResource(R.drawable.main_tab_hel_sel);
			tab_3_tv.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			headTV.setText(tab_3_tv.getText());
			break;
		case R.id.tab_fam_layout:
			viewPager.setCurrentItem(3);
			tab_4_iv.setImageResource(R.drawable.main_tab_fam_sel);
			tab_4_tv.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			headTV.setText(tab_4_tv.getText());
			break;

		default:
			break;
		}
	}

	/**
	 * 图标和文字全部置normal状态
	 * 
	 * @author liuyunlong
	 * @date 2015-9-12上午11:49:50
	 */
	private void resetToNormal() {
		tab_1_iv.setImageResource(R.drawable.main_tab_equ_nor);
		tab_2_iv.setImageResource(R.drawable.main_tab_mall_nor);
		tab_3_iv.setImageResource(R.drawable.main_tab_hel_nor);
		tab_4_iv.setImageResource(R.drawable.main_tab_fam_nor);
		tab_1_tv.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
		tab_2_tv.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
		tab_3_tv.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
		tab_4_tv.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int position) {
		resetToNormal();
		switch (position) {
		case ConstantUtils.NUMBER.ZERO:
			tab_1_iv.setImageResource(R.drawable.main_tab_equ_sel); // 设置图标为选中状态
			tab_1_tv.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			headTV.setText(tab_1_tv.getText());
			break;
		case ConstantUtils.NUMBER.ONE:
			tab_2_iv.setImageResource(R.drawable.main_tab_mall_sel);
			tab_2_tv.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			headTV.setText(tab_2_tv.getText());
			break;
		case ConstantUtils.NUMBER.TWO:
			tab_3_iv.setImageResource(R.drawable.main_tab_hel_sel);
			tab_3_tv.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			headTV.setText(tab_3_tv.getText());
			break;
		case ConstantUtils.NUMBER.THREE:
			tab_4_iv.setImageResource(R.drawable.main_tab_fam_sel);
			tab_4_tv.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			headTV.setText(tab_4_tv.getText());
			break;

		default:
			break;
		}
	}
}
