package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.Logger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
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

	private CheckBox mShowPassCb, mAutoLoginCb;

	private EditText mUsernameEt, mPasswordEt;

	private SharedPreferences sp;

	private Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		initData();
		initView();
	}

	private void initData() {
		sp = getSharedPreferences("mysp", MODE_PRIVATE + MODE_APPEND);
		editor = sp.edit();
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
		mShowPassCb = (CheckBox) this.findViewById(R.id.show_password_cb);
		mShowPassCb.setOnClickListener(this);
		mAutoLoginCb = (CheckBox) this.findViewById(R.id.auto_login_cbox);
		mAutoLoginCb.setOnClickListener(this);
		mUsernameEt = (EditText) this.findViewById(R.id.login_username);
		mPasswordEt = (EditText) this.findViewById(R.id.login_password);
		if (sp.getBoolean("isAutoLogin", false)) {
			mUsernameEt.setText(sp.getString("username", ""));
			mPasswordEt.setText(sp.getString("password", ""));
			mUsernameEt.setSelection(mUsernameEt.getText().toString().length());
			mPasswordEt.setSelection(mPasswordEt.getText().toString().length());
		}
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.family_top_back_img:// 返回
			finish();
			break;
		case R.id.auto_login_cbox:// 自动登录
			break;
		case R.id.show_password_cb:// 显示密码
			if (mShowPassCb.isChecked()) {
				mPasswordEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
				mPasswordEt.setSelection(mPasswordEt.getText().toString().length());
			} else {
				mPasswordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
				mPasswordEt.setSelection(mPasswordEt.getText().toString().length());
			}
			break;
		case R.id.forget_password_tv:// 忘记密码
			Logger.showToast(mContext, "开发中...");
			break;
		case R.id.login_tv:// 登录
			login();
			finish();
			break;
		case R.id.login_register_layout:// 注册
			Logger.showToast(mContext, "开发中...");
			break;

		default:
			break;
		}
	}

	private void login() {
		// 自动登录保存用户名和密码
		if (null != mAutoLoginCb && mAutoLoginCb.isChecked()) {
			editor.putString("username", mUsernameEt.getText().toString());
			editor.putString("password", mPasswordEt.getText().toString());
			editor.putBoolean("isAutoLogin", true);
		} else {
			editor.remove("username");
			editor.remove("password");
			editor.putBoolean("isAutoLogin", false);
		}
		// 登录成功修改成功标识
		editor.putBoolean("isLogin", true);
		editor.commit();
	}
}
