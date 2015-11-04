package com.liuyunlong.androiddemo.activity;

import java.util.ArrayList;
import java.util.List;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.fragment.FragmentComponentActivity;
import com.liuyunlong.androiddemo.fragment.FragmentComponentBroadCast;
import com.liuyunlong.androiddemo.fragment.FragmentComponentContentProvider;
import com.liuyunlong.androiddemo.fragment.FragmentComponentIntent;
import com.liuyunlong.androiddemo.fragment.FragmentComponentService;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

/** 
 * 四大组件界面
* @author  : liuyunlong
* @version ：2015-9-21 上午11:43:44 
* */
public class AndroidComponentsActivity extends FragmentActivity {

	private LayoutInflater layoutInflater;

	private FragmentTabHost tabHost;

	private int[] tabImgArray = { R.drawable.tab_1_selector, R.drawable.tab_1_selector, R.drawable.tab_2_selector, R.drawable.tab_3_selector, R.drawable.tab_4_selector };

	private String[] tabTextArray;

	private List<Class> fragments = new ArrayList<Class>();

	private Context mContext;

	/**当前TabHost的位置*/
	private int mTabHostPos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.components);
		initData();
		initView();
	}

	private void initView() {
		mContext = this;
		layoutInflater = LayoutInflater.from(this);
		tabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
		tabHost.setup(mContext, getSupportFragmentManager(), R.id.realtabcontent);
		tabHost.getTabWidget().setDividerDrawable(null);
		tabHost.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setmTabHostPos(tabHost.getCurrentTab());
			}
		});

		if (null != fragments && fragments.size() > 0) {
			for (int i = 0; i < fragments.size(); i++) {
				// 为每一个Tab按钮设置图标、文字和内容
				TabSpec tabSpec = tabHost.newTabSpec(tabTextArray[i]).setIndicator(getTabItemView(i));
				// 将Tab按钮添加进Tab选项卡中
				tabHost.addTab(tabSpec, fragments.get(i), null);
				// 设置Tab按钮的背景
				// mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
			}
		}
	}

	private View getTabItemView(int index) {
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);

		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(tabImgArray[index]);

		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(tabTextArray[index]);

		return view;
	}

	private void initData() {
		tabTextArray = getResources().getStringArray(R.array.components_tab_text);
		fragments.add(FragmentComponentIntent.class);
		fragments.add(FragmentComponentActivity.class);
		fragments.add(FragmentComponentService.class);
		fragments.add(FragmentComponentContentProvider.class);
		fragments.add(FragmentComponentBroadCast.class);
	}

	public int getmTabHostPos() {
		return mTabHostPos;
	}

	public void setmTabHostPos(int mTabHostPos) {
		this.mTabHostPos = mTabHostPos;
	}
}
