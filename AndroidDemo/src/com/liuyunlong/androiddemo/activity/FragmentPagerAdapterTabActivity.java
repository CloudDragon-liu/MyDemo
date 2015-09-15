package com.liuyunlong.androiddemo.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.fragment.FragmentDynamic;
import com.liuyunlong.androiddemo.fragment.FragmentLife1;
import com.liuyunlong.androiddemo.fragment.FragmentLife2;
import com.liuyunlong.androiddemo.fragment.FragmentStatic;
import com.liuyunlong.androiddemo.utils.ConstantUtils;

/** 
 * FragmenPagerAdapter + viewPager实现Tab
* @author  : liuyunlong
* @version ：2015-9-15 下午4:30:21 
* */
public class FragmentPagerAdapterTabActivity extends FragmentActivity implements OnPageChangeListener {

	private ViewPager viewPager;

	private ImageView mTabImg1, mTabImg2, mTabImg3, mTabImg4;

	private TextView mTabText1, mTabText2, mTabText3, mTabText4, mHeadText;

	private Fragment mFrag1, mFrag2, mFrag3, mFrag4;

	private FragmentPagerAdapter mAdapter;

	private List<Fragment> mFragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment_pageradapter_tab_main);
		initView();
	}

	private void initView() {
		mTabImg1 = (ImageView) this.findViewById(R.id.frag_tab_1_img);
		mTabImg2 = (ImageView) this.findViewById(R.id.frag_tab_2_img);
		mTabImg3 = (ImageView) this.findViewById(R.id.frag_tab_3_img);
		mTabImg4 = (ImageView) this.findViewById(R.id.frag_tab_4_img);

		mTabText1 = (TextView) this.findViewById(R.id.frag_tab_1_text);
		mTabText2 = (TextView) this.findViewById(R.id.frag_tab_2_text);
		mTabText3 = (TextView) this.findViewById(R.id.frag_tab_3_text);
		mTabText4 = (TextView) this.findViewById(R.id.frag_tab_4_text);
		mHeadText = (TextView) this.findViewById(R.id.frag_tab_head_text);

		viewPager = (ViewPager) this.findViewById(R.id.fragment_pageradapter_viewpager);
		viewPager.setOnPageChangeListener(this);

		mFragments = new ArrayList<Fragment>();
		mFrag1 = new FragmentStatic();
		mFrag2 = new FragmentDynamic();
		mFrag3 = new FragmentLife1();
		mFrag4 = new FragmentLife2();
		mFragments.add(mFrag1);
		mFragments.add(mFrag2);
		mFragments.add(mFrag3);
		mFragments.add(mFrag4);

		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public int getCount() {
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int position) {
				return mFragments.get(position);
			}
		};
		viewPager.setAdapter(mAdapter);

		viewPager.setCurrentItem(ConstantUtils.NUMBER.ZERO);
	}

	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.frag_tab_1_layout:
			viewPager.setCurrentItem(ConstantUtils.NUMBER.ZERO);
			break;
		case R.id.frag_tab_2_layout:
			viewPager.setCurrentItem(ConstantUtils.NUMBER.ONE);
			break;
		case R.id.frag_tab_3_layout:
			viewPager.setCurrentItem(ConstantUtils.NUMBER.TWO);
			break;
		case R.id.frag_tab_4_layout:
			viewPager.setCurrentItem(ConstantUtils.NUMBER.THREE);
			break;

		default:
			break;
		}
	}

	/**
	 * 图片文字置为normal
	 * 
	 * @author liuyunlong
	 * @date 2015-9-15下午4:46:08
	 */
	private void set2normal() {
		mTabImg1.setImageResource(R.drawable.fragment_tab_1_nor);
		mTabImg2.setImageResource(R.drawable.fragment_tab_2_nor);
		mTabImg3.setImageResource(R.drawable.fragment_tab_3_nor);
		mTabImg4.setImageResource(R.drawable.fragment_tab_4_nor);

		mTabText1.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
		mTabText2.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
		mTabText3.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
		mTabText4.setTextColor(getResources().getColor(R.color.main_tab_text_normal));

	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
	}

	@Override
	public void onPageSelected(int position) {
		set2normal();
		switch (position) {
		case ConstantUtils.NUMBER.ZERO:
			mTabImg1.setImageResource(R.drawable.fragment_tab_1_sel);
			mTabText1.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			mHeadText.setText(mTabText1.getText().toString());
			break;
		case ConstantUtils.NUMBER.ONE:
			mTabImg2.setImageResource(R.drawable.fragment_tab_2_sel);
			mTabText2.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			mHeadText.setText(mTabText2.getText().toString());
			break;
		case ConstantUtils.NUMBER.TWO:
			mTabImg3.setImageResource(R.drawable.fragment_tab_3_sel);
			mTabText3.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			mHeadText.setText(mTabText3.getText().toString());
			break;
		case ConstantUtils.NUMBER.THREE:
			mTabImg4.setImageResource(R.drawable.fragment_tab_4_sel);
			mTabText4.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			mHeadText.setText(mTabText4.getText().toString());
			break;

		default:
			break;
		}
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}
}
