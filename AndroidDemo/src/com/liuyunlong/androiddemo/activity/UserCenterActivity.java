package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.Logger;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/** 
 * 个人中心
* @author  : liuyunlong
* @version ：2015-9-18 上午10:51:31 
* */
public class UserCenterActivity extends Activity implements OnClickListener {

	private Context mContext;

	private TextView mTopTV, mQuitTV;

	private ImageView mTopBackIV;

	private RelativeLayout mUserCenLayout, mSettingLayout, mClearCachLayout, mUpdateVerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.user_center);
		initData();
		initView();
	}

	private void initData() {

	}

	private void initView() {
		mContext = this;
		mTopTV = (TextView) this.findViewById(R.id.family_top_text);
		mTopTV.setText(getResources().getString(R.string.user_center));
		mQuitTV = (TextView) this.findViewById(R.id.qiut_tv);
		mQuitTV.setOnClickListener(this);
		mTopBackIV = (ImageView) this.findViewById(R.id.family_top_back_img);
		mTopBackIV.setOnClickListener(this);
		mUserCenLayout = (RelativeLayout) this.findViewById(R.id.user_icon_layout);
		mUserCenLayout.setOnClickListener(this);
		mSettingLayout = (RelativeLayout) this.findViewById(R.id.setting_layout);
		mSettingLayout.setOnClickListener(this);
		mClearCachLayout = (RelativeLayout) this.findViewById(R.id.clear_cache_layout);
		mClearCachLayout.setOnClickListener(this);
		mUpdateVerLayout = (RelativeLayout) this.findViewById(R.id.update_ver_layout);
		mUpdateVerLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.family_top_back_img:
			finish();
			break;
		case R.id.user_icon_layout:
			Logger.showToast(mContext, "devoloping...");
			break;
		case R.id.setting_layout:
			Logger.showToast(mContext, "devoloping...");
			break;
		case R.id.clear_cache_layout:
			Logger.showToast(mContext, "devoloping...");
			break;
		case R.id.update_ver_layout:
			Logger.showToast(mContext, "devoloping...");
			break;
		case R.id.qiut_tv:
			Logger.showToast(mContext, "devoloping...");
			break;

		default:
			break;
		}
	}
}
