package com.liuyunlong.androiddemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.fragment.FragmentPage1;
import com.liuyunlong.androiddemo.fragment.FragmentPage2;
import com.liuyunlong.androiddemo.fragment.FragmentPage3;
import com.liuyunlong.androiddemo.fragment.FragmentPage4;

/** 
 * Tab主界面
* @author  : liuyunlong
* @version ：2015-9-15 下午8:42:17 
* */
public class MainTabActivity extends FragmentActivity {

	/**布局对象*/
	private LayoutInflater layoutInflater;

	private FragmentTabHost mTabHost;

	private Class[] mFragmentArray = { FragmentPage1.class, FragmentPage2.class, FragmentPage3.class, FragmentPage4.class };

	private String[] mTextviewArray;

	private int[] mImageViewArray = { R.drawable.fragment_tab_1_nor, R.drawable.fragment_tab_2_nor, R.drawable.fragment_tab_3_nor, R.drawable.fragment_tab_4_nor };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_tab_layout);
		initView();
	}

	private void initView() {
		layoutInflater = LayoutInflater.from(this);
		// 实例化TabHost对象，得到TabHost
		mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		mTextviewArray = getResources().getStringArray(R.array.main_tab_text);

		for (int i = 0; i < mFragmentArray.length; i++) {
			// 为每一个Tab按钮设置图标、文字和内容
			TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
			// 将Tab按钮添加进Tab选项卡中
			mTabHost.addTab(tabSpec, mFragmentArray[i], null);
			// 设置Tab按钮的背景
			// mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
		}
	}

	/**
	 * 给Tab按钮设置图标和文字 
	 * @author liuyunlong
	 * @data 2015-9-16上午12:15:20
	 */
	private View getTabItemView(int index) {
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);

		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageViewArray[index]);

		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTextviewArray[index]);

		return view;
	}
}
