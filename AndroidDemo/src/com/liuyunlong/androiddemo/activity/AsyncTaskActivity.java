package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.Logger;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/** 
* @author  : liuyunlong
* @version ：2015-10-13 上午9:15:52 
* */
public class AsyncTaskActivity extends Activity implements OnClickListener {

	private Context mContext;

	private Button mBriefBtn;

	private TextView mBriefTv, mProgressBarTv, mBeginBtn;

	private ProgressBar bar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.asynctask_layout);
		initData();
		initView();
	}

	private void initView() {
		mContext = this;
		mBriefBtn = (Button) this.findViewById(R.id.async_task_btn);
		mBriefBtn.setOnClickListener(this);
		mBeginBtn = (Button) this.findViewById(R.id.async_task_begin_btn);
		mBeginBtn.setOnClickListener(this);
		mBriefTv = (TextView) this.findViewById(R.id.async_task_brief_tv);
		bar = (ProgressBar) this.findViewById(R.id.async_task_progressBar);
		mProgressBarTv = (TextView) this.findViewById(R.id.async_task_pro_tv);
	}

	private void initData() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.async_task_btn:
			mBriefTv.setText("异步线程处理类\nonProgressUpdate:每次更新都执行\nonPostExecute:任务执行完成后，参数值为doInBackground返回值\ndoInBackground：后台执行params的值由调用者传递");
			mBriefTv.setVisibility(mBriefTv.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
			break;
		case R.id.async_task_begin_btn:
			ProgressBarAsyncTask asyncTask = new ProgressBarAsyncTask();
			asyncTask.execute(100); // 传递给doInBackground的参数params的第一个值params[0]
			break;

		default:
			break;
		}
	}

	/*********************************************异步操作****************************************************/

	private class ProgressBarAsyncTask extends AsyncTask<Integer, Integer, String> {

		@Override
		protected String doInBackground(Integer... params) {
			for (int i = 0; i < 100; i++) {
				bar.setProgress(i); // 设置进度
				publishProgress(i); // 传递每次更新的内容
				try {
					Thread.sleep(params[0]); // 延缓执行，延缓的时间由调用者传递
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return "执行完毕";
		}

		@Override
		protected void onProgressUpdate(Integer... values) { // 每次更新之后
			mProgressBarTv.setText("当前的进度为：" + String.valueOf(values[0]));
		}

		@Override
		protected void onPostExecute(String result) { // 任务执行完后执行,resule的值为doInBackground的返回值
			Logger.showToast(mContext, result);
			mProgressBarTv.setText(result);
		}

	}
}
