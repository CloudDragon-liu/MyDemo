package com.liuyunlong.androiddemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
 * fragment实现Tab
* @author  : liuyunlong
* @version ：2015-9-15 下午1:56:15 
* */
public class FragmentTabItemActivity extends FragmentActivity {

	private ImageView mTabImg1, mTabImg2, mTabImg3, mTabImg4;

	private TextView mTabText1, mTabText2, mTabText3, mTabText4, mHeadText;

	private Fragment mFrag1, mFrag2, mFrag3, mFrag4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment_tab_main);
		initView();
		setSelect(ConstantUtils.NUMBER.ZERO);
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
	}

	public void doClick(View view) {
		switch (view.getId()) {
		case R.id.frag_tab_1_layout:
			setSelect(ConstantUtils.NUMBER.ZERO);
			break;
		case R.id.frag_tab_2_layout:
			setSelect(ConstantUtils.NUMBER.TWO);
			break;
		case R.id.frag_tab_3_layout:
			setSelect(ConstantUtils.NUMBER.THREE);
			break;
		case R.id.frag_tab_4_layout:
			setSelect(ConstantUtils.NUMBER.FOUR);
			break;

		default:
			break;
		}
	}

	/**
	 * 图片和文字置为normal
	 * 
	 * @author liuyunlong
	 * @date 2015-9-15下午2:35:07
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

	private void setSelect(int num) {
		set2normal();
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		hideFragment(transaction);
		switch (num) {
		case ConstantUtils.NUMBER.ZERO:
			mTabImg1.setImageResource(R.drawable.fragment_tab_1_sel);
			mTabText1.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			mHeadText.setText(mTabText1.getText().toString());
			if (null == mFrag1) {
				mFrag1 = new FragmentStatic("fragment_tab");
				transaction.add(R.id.fragment_tab_content, mFrag1);
			} else {
				transaction.show(mFrag1);
			}
			break;
		case ConstantUtils.NUMBER.TWO:
			mTabImg2.setImageResource(R.drawable.fragment_tab_2_sel);
			mTabText2.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			mHeadText.setText(mTabText2.getText().toString());
			if (null == mFrag2) {
				mFrag2 = new FragmentDynamic();
				transaction.add(R.id.fragment_tab_content, mFrag2);
			} else {
				transaction.show(mFrag2);
			}
			break;
		case ConstantUtils.NUMBER.THREE:
			mTabImg3.setImageResource(R.drawable.fragment_tab_3_sel);
			mTabText3.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			mHeadText.setText(mTabText3.getText().toString());
			if (null == mFrag3) {
				mFrag3 = new FragmentLife1();
				transaction.add(R.id.fragment_tab_content, mFrag3);
			} else {
				transaction.show(mFrag3);
			}
			break;
		case ConstantUtils.NUMBER.FOUR:
			mTabImg4.setImageResource(R.drawable.fragment_tab_4_sel);
			mTabText4.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			mHeadText.setText(mTabText4.getText().toString());
			if (null == mFrag4) {
				mFrag4 = new FragmentLife2();
				transaction.add(R.id.fragment_tab_content, mFrag4);
			} else {
				transaction.show(mFrag4);
			}
			break;

		default:
			break;
		}
		transaction.commit();
	}

	/**
	 * 先全部隐藏Fragment，再显示需要显示的Fragment
	 * @param transaction
	 * @author liuyunlong
	 * @date 2015-9-15下午3:06:17
	 */
	private void hideFragment(FragmentTransaction transaction) {
		if (null != mFrag1) {
			transaction.hide(mFrag1);
		}
		if (null != mFrag2) {
			transaction.hide(mFrag2);
		}
		if (null != mFrag3) {
			transaction.hide(mFrag3);
		}
		if (null != mFrag4) {
			transaction.hide(mFrag4);
		}
	}
}
