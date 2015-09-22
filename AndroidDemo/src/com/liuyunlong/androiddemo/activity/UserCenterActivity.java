package com.liuyunlong.androiddemo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.dialog.MyAlertDialog;
import com.liuyunlong.androiddemo.dialog.MyAlertDialog.MyAlertDialogListener;
import com.liuyunlong.androiddemo.utils.ConstantUtils;
import com.liuyunlong.androiddemo.utils.Logger;

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

	private SharedPreferences sp;

	private Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.user_center);
		mContext = this;
		initData();
		initView();
	}

	private void initData() {
		sp = getSharedPreferences("mysp", MODE_PRIVATE + MODE_APPEND);
		editor = sp.edit();
	}

	private void initView() {
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
		case R.id.user_icon_layout: // 个人信息
			Logger.showToast(mContext, "devoloping...");
			break;
		case R.id.setting_layout: // 设置
			Logger.showToast(mContext, "devoloping...");
			break;
		case R.id.clear_cache_layout: // 缓存
			Logger.showToast(mContext, "devoloping...");
			break;
		case R.id.update_ver_layout: // 版本更新
			Logger.showToast(mContext, "devoloping...");
			break;
		case R.id.qiut_tv: // 退出
			quit();
			break;

		default:
			break;
		}
	}

	/**
	 * 退出登录
	 * 
	 * @author liuyunlong
	 * @date 2015-9-22下午2:06:03
	 */
	private void quit() {
		MyAlertDialog dialog = new MyAlertDialog(mContext);
		dialog.setDialogTitle("注销账户").setDialogContent("您确定要注销账户吗？").setmType(ConstantUtils.DIALOG_TYPE.NORMAL).setTitleBarBackground(getResources().getColor(R.color.bar_nor))
				.setCheckboxContent("同时清空缓存").show();
		dialog.setMyAlertDialogListener(new MyAlertDialogListener() {

			@Override
			public void confirm(MyAlertDialog dialog, boolean checked) {
				dialog.dismiss();
				editor.putBoolean("isLogin", false);
				editor.commit();
				finish();
			}

			@Override
			public void cancle(MyAlertDialog dialog, boolean checked) {
				dialog.dismiss();
			}
		});
	}
}
