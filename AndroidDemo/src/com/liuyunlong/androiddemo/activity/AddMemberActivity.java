package com.liuyunlong.androiddemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.fragment.AddMemByManualFragment;
import com.liuyunlong.androiddemo.fragment.AddMemByQrcodeFragment;
import com.liuyunlong.androiddemo.utils.ConstantUtils;

/** 
* @author  : liuyunlong
* @version ：2015-9-18 下午3:43:45 
* */
public class AddMemberActivity extends FragmentActivity implements OnClickListener {

	private Context mContext;

	private Fragment mAddByQrcodeFramet, mAddByManualFramet;

	private TextView mTopTv, mAddByQrcodTv, mAddByManualTv;

	private ImageView mTopBackIv;

	private LinearLayout mAddQrcodeLayout, mAddManualLayout, mAddQrcodeLine, mAddManualLine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.add_member);
		initView();
	}

	private void initView() {
		mContext = this;
		mTopTv = (TextView) this.findViewById(R.id.family_top_text);
		mTopTv.setText(getResources().getString(R.string.add_member));
		mTopBackIv = (ImageView) this.findViewById(R.id.family_top_back_img);
		mTopBackIv.setOnClickListener(this);
		mAddQrcodeLayout = (LinearLayout) this.findViewById(R.id.add_by_qrcode_layout);
		mAddManualLayout = (LinearLayout) this.findViewById(R.id.add_by_manual_layout);
		mAddQrcodeLayout.setOnClickListener(this);
		mAddManualLayout.setOnClickListener(this);
		mAddQrcodeLine = (LinearLayout) this.findViewById(R.id.add_qrcode_line);
		mAddManualLine = (LinearLayout) this.findViewById(R.id.add_manual_line);
		mAddByQrcodTv = (TextView) this.findViewById(R.id.add_by_qrcode_tv);
		mAddByManualTv = (TextView) this.findViewById(R.id.add_by_manual_tv);
		setSelect(ConstantUtils.NUMBER.ZERO);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.family_top_back_img:
			finish();
			break;
		case R.id.add_by_qrcode_layout:
			setSelect(ConstantUtils.NUMBER.ZERO);
			break;
		case R.id.add_by_manual_layout:
			setSelect(ConstantUtils.NUMBER.ONE);
			break;

		default:
			break;
		}
	}

	private void setSelect(int num) {
		set2normal();
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		// hideFragments(transaction);
		switch (num) {
		case ConstantUtils.NUMBER.ZERO:
			mAddQrcodeLine.setVisibility(View.VISIBLE);
			mAddByQrcodTv.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			if (null == mAddByQrcodeFramet) {
				mAddByQrcodeFramet = new AddMemByQrcodeFragment();
				transaction.add(R.id.add_member_content, mAddByQrcodeFramet);
			} else {
				transaction.show(mAddByQrcodeFramet);
			}
			break;
		case ConstantUtils.NUMBER.ONE:
			mAddManualLine.setVisibility(View.VISIBLE);
			mAddByManualTv.setTextColor(getResources().getColor(R.color.main_tab_text_select));
			if (null == mAddByManualFramet) {
				mAddByManualFramet = new AddMemByManualFragment();
				transaction.add(R.id.add_member_content, mAddByManualFramet);
			} else {
				transaction.show(mAddByManualFramet);
			}
			break;

		default:
			break;
		}
		transaction.addToBackStack(null);
		transaction.commit();
	}

	private void set2normal() {
		mAddQrcodeLine.setVisibility(View.INVISIBLE);
		mAddByQrcodTv.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
		mAddManualLine.setVisibility(View.INVISIBLE);
		mAddByManualTv.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
	}

	/**
	 * hide all fragments before show special one
	 * @param transaction
	 * @author liuyunlong
	 * @param manager 
	 * @date 2015-9-18下午4:47:24
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (null != mAddByQrcodeFramet) {
			transaction.hide(mAddByManualFramet);
		}
		if (null != mAddByManualFramet) {
			transaction.hide(mAddByManualFramet);
		}
	}
}
