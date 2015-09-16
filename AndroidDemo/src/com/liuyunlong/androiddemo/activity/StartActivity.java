package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.ConstantUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

/** 
 * 启动界面
* @author  : liuyunlong
* @version ：2015-9-16 下午2:45:56 
* */
public class StartActivity extends Activity {

	private Context mContext;

	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			Intent intent = new Intent();
			switch (msg.what) {
			case ConstantUtils.MSG_HANDLER.ENTER_MAIN_MENU:
				intent.setClass(mContext, MainTabActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				break;

			default:
				break;
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.start_activity);
		mContext = this;
		initView();
		mHandler.sendEmptyMessageDelayed(ConstantUtils.MSG_HANDLER.ENTER_MAIN_MENU, 1500);
	}

	private void initView() {

	}
}
