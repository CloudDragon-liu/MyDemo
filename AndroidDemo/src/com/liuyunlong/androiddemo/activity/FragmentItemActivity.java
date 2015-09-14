package com.liuyunlong.androiddemo.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
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
import com.liuyunlong.androiddemo.fragment.FragmentDynamic;
import com.liuyunlong.androiddemo.utils.ConstantUtils;

/**
 *  @author liuyunlong
 *  @date 2015-9-13 下午3:23:50 
 *  @version 1.0 
 */
public class FragmentItemActivity extends Activity implements OnClickListener, OnPageChangeListener {

	private Context mContext;

	/**Tab layout*/
	private LinearLayout fragmentTablay1, fragmentTablay2, fragmentTablay3, fragmentTablay4;

	/**Tab icon*/
	private ImageView fragmentTabIv1, fragmentTabIv2, fragmentTabIv3, fragmentTabIv4;

	/**Tab textView*/
	private TextView fragmentTabTv1, fragmentTabTv2, fragmentTabTv3, fragmentTabTv4, fragmentTabHeadTv;

	/**fragment viewpager*/
	private ViewPager viewPager;

	/**fragment viewpager views*/
	private List<View> views = new ArrayList<View>();

	/**fragment viewpager adapter*/
	private ViewPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment_activity_main);
		iniView();
	}

	/**
	 * 初始化view时，当前的Activity中的fragment中所包含的控件同样能访问并初始化
	 * @author liuyunlong
	 * @data 2015-9-13下午11:38:55
	 */
	private void iniView() {
		fragmentTablay1 = (LinearLayout) this.findViewById(R.id.fragment_tab_1_layout);
		fragmentTablay2 = (LinearLayout) this.findViewById(R.id.fragment_tab_2_layout);
		fragmentTablay3 = (LinearLayout) this.findViewById(R.id.fragment_tab_3_layout);
		fragmentTablay4 = (LinearLayout) this.findViewById(R.id.fragment_tab_4_layout);
		fragmentTablay1.setOnClickListener(this);
		fragmentTablay2.setOnClickListener(this);
		fragmentTablay3.setOnClickListener(this);
		fragmentTablay4.setOnClickListener(this);
		fragmentTabIv1 = (ImageView) this.findViewById(R.id.fragment_tab_1_iv);
		fragmentTabIv2 = (ImageView) this.findViewById(R.id.fragment_tab_2_iv);
		fragmentTabIv3 = (ImageView) this.findViewById(R.id.fragment_tab_3_iv);
		fragmentTabIv4 = (ImageView) this.findViewById(R.id.fragment_tab_4_iv);
		fragmentTabTv1 = (TextView) this.findViewById(R.id.fragment_tab_1_tv);
		fragmentTabTv2 = (TextView) this.findViewById(R.id.fragment_tab_2_tv);
		fragmentTabTv3 = (TextView) this.findViewById(R.id.fragment_tab_3_tv);
		fragmentTabTv4 = (TextView) this.findViewById(R.id.fragment_tab_4_tv);
		fragmentTabHeadTv = (TextView) this.findViewById(R.id.fragment_head_tv);

		viewPager = (ViewPager) this.findViewById(R.id.fragment_viewpager);
		viewPager.setOnPageChangeListener(this);
		View view1 = View.inflate(mContext, R.layout.fragment_activity_tab_static, null);
		View view2 = View.inflate(mContext, R.layout.fragment_activity_tab_dynamic, null);
		View view3 = View.inflate(mContext, R.layout.fragment_activity_tab_life, null);
		View view4 = View.inflate(mContext, R.layout.fragment_activity_tab_data, null);
		views.add(view1);
		views.add(view2);
		views.add(view3);
		views.add(view4);
		adapter = new ViewPagerAdapter(mContext, views);
		viewPager.setAdapter(adapter);
	}

	@Override
	public void onClick(View view) {
		set2Normal();
		switch (view.getId()) {
		case R.id.fragment_tab_1_layout:
			viewPager.setCurrentItem(ConstantUtils.NUMBER.ZERO);
			fragmentTabIv1.setImageResource(R.drawable.fragment_tab_1_sel);
			fragmentTabTv1.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			fragmentTabHeadTv.setText("静态加载");
			break;
		case R.id.fragment_tab_2_layout:
			viewPager.setCurrentItem(ConstantUtils.NUMBER.ONE);
			fragmentTabIv2.setImageResource(R.drawable.fragment_tab_2_sel);
			fragmentTabTv2.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			fragmentTabHeadTv.setText("动态加载");
			break;
		case R.id.fragment_tab_3_layout:
			viewPager.setCurrentItem(ConstantUtils.NUMBER.TWO);
			fragmentTabIv3.setImageResource(R.drawable.fragment_tab_3_sel);
			fragmentTabTv3.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			fragmentTabHeadTv.setText("生命周期");
			break;
		case R.id.fragment_tab_4_layout:
			viewPager.setCurrentItem(ConstantUtils.NUMBER.THREE);
			fragmentTabIv4.setImageResource(R.drawable.fragment_tab_4_sel);
			fragmentTabTv4.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			fragmentTabHeadTv.setText("数据传递");
			break;

		default:
			break;
		}
	}

	/**
	 * 动态加载fragment
	 * 
	 * @author liuyunlong
	 * @date 2015-9-14上午9:50:31
	 */
	private void dynamicAddFragment() {
		FragmentDynamic fragmentDynamic = new FragmentDynamic();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction beginTransaction = manager.beginTransaction();
		beginTransaction.add(R.id.fragment_dynamic_layout, fragmentDynamic);
		beginTransaction.addToBackStack(null);
		beginTransaction.commit();

	}

	/**
	 * 文字和图片重置为normal
	 * @author liuyunlong
	 * @data 2015-9-13下午9:25:15
	 */
	private void set2Normal() {
		fragmentTabIv1.setImageResource(R.drawable.fragment_tab_1_nor);
		fragmentTabIv2.setImageResource(R.drawable.fragment_tab_2_nor);
		fragmentTabIv3.setImageResource(R.drawable.fragment_tab_3_nor);
		fragmentTabIv4.setImageResource(R.drawable.fragment_tab_4_nor);
		fragmentTabTv1.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
		fragmentTabTv2.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
		fragmentTabTv3.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
		fragmentTabTv4.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int arg0) {
		set2Normal();
		switch (arg0) {
		case ConstantUtils.NUMBER.ZERO:
			fragmentTabIv1.setImageResource(R.drawable.fragment_tab_1_sel);
			fragmentTabTv1.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			fragmentTabHeadTv.setText("静态加载");
			break;
		case ConstantUtils.NUMBER.ONE:
			dynamicAddFragment();
			fragmentTabIv2.setImageResource(R.drawable.fragment_tab_2_sel);
			fragmentTabTv2.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			fragmentTabHeadTv.setText("动态加载");
			break;
		case ConstantUtils.NUMBER.TWO:
			fragmentTabIv3.setImageResource(R.drawable.fragment_tab_3_sel);
			fragmentTabTv3.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			fragmentTabHeadTv.setText("生命周期");
			break;
		case ConstantUtils.NUMBER.THREE:
			fragmentTabIv4.setImageResource(R.drawable.fragment_tab_4_sel);
			fragmentTabTv4.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			fragmentTabHeadTv.setText("数据传递");
			break;

		default:
			break;
		}
	}
}
