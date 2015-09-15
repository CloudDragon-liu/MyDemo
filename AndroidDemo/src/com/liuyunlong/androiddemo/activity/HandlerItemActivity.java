package com.liuyunlong.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.liuyunlong.androiddemo.R;

/** 
* @author  : liuyunlong
* @version ：2015-9-11 下午5:12:54 
* */
public class HandlerItemActivity extends Activity {

	private Integer count = 0;

	private Button countBtn;

	private Handler mHandler = new Handler();

	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			mHandler.postDelayed(this, 1000); // 在删除之前执行，否则无法停止
			count++;
			countBtn.setText(count.toString());
			if (count == 5) {
				mHandler.removeCallbacks(runnable); // 删除
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handler_item);
		initView();
	}

	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.handler_begin_btn:
			count = 0;
			mHandler.postDelayed(runnable, 1000); // 启动
			break;

		default:
			break;
		}
	}

	private void initView() {
		countBtn = (Button) this.findViewById(R.id.handler_count_btn);

	}
}
