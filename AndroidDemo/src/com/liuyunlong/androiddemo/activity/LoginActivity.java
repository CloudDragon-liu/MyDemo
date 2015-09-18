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
import android.widget.LinearLayout;
import android.widget.TextView;

/** 
 * 登录界面
* @author  : liuyunlong
* @version ：2015-9-18 上午8:54:26 
* */
public class LoginActivity extends Activity implements OnClickListener {

	private Context mContext;

	private TextView mTopTv, mForgetPassTv, mLoginTv;

	private LinearLayout mRegisterLayout;

	private ImageView mTopBackIv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		initData();
		initView();
	}

	private void initData() {

	}

	private void initView() {
		mContext = this;
		mTopTv = (TextView) this.findViewById(R.id.family_top_text);
		mTopTv.setText(getResources().getString(R.string.login));
		mForgetPassTv = (TextView) this.findViewById(R.id.forget_password_tv);
		mForgetPassTv.setOnClickListener(this);
		mLoginTv = (TextView) this.findViewById(R.id.login_tv);
		mLoginTv.setOnClickListener(this);
		mRegisterLayout = (LinearLayout) this.findViewById(R.id.login_register_layout);
		mRegisterLayout.setOnClickListener(this);
		mTopBackIv = (ImageView) this.findViewById(R.id.family_top_back_img);
		mTopBackIv.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.family_top_back_img:
			finish();
			break;
		case R.id.forget_password_tv:
			Logger.showToast(mContext, "开发中...");
			break;
		case R.id.login_tv:
			Logger.showToast(mContext, "开发中...");
			break;
		case R.id.login_register_layout:
			Logger.showToast(mContext, "开发中...");
			break;

		default:
			break;
		}
	}
}
