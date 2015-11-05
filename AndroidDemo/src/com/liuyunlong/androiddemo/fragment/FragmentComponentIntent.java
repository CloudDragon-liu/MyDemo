package com.liuyunlong.androiddemo.fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.Logger;

/** 
 * Intent
* @author  : liuyunlong
* @version ：2015-10-12 下午2:12:48 
* */
public class FragmentComponentIntent extends Fragment implements OnClickListener {

	private LinearLayout layout;

	private Context mContext;

	private Button mNetBtn, mDialBtn, mSendMsgBtn, mThreadBtn;

	private EditText editText, mReceiverEt, mSendContentEt;

	private static final int SETMAIN = 1;

	private static final int SETCHILD = 2;

	private static final int CLOKC = 3;

	private Handler mMainHandler, mChildHandler, mClockHandler;

	private TextView mTimeTv;

	private AnalogClock clock;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.compnent_intent, container, false);
			initView(layout);
		}
		ViewGroup parent = (ViewGroup) layout.getParent();
		if (null != parent) {
			parent.removeView(layout);
		}
		return layout;
	}

	private void initView(View view) {
		mContext = getActivity();
		mNetBtn = (Button) view.findViewById(R.id.intent_net_btn);
		mNetBtn.setOnClickListener(this);
		mDialBtn = (Button) view.findViewById(R.id.intent_dial_btn);
		mDialBtn.setOnClickListener(this);
		mSendMsgBtn = (Button) view.findViewById(R.id.intent_send_msg_btn);
		mSendMsgBtn.setOnClickListener(this);
		mThreadBtn = (Button) view.findViewById(R.id.thread_btn);
		mThreadBtn.setOnClickListener(this);
		editText = (EditText) view.findViewById(R.id.intent_dial_et);
		mReceiverEt = (EditText) view.findViewById(R.id.intent_msg_num);
		mSendContentEt = (EditText) view.findViewById(R.id.intent_msg_content);
		mTimeTv = (TextView) view.findViewById(R.id.intent_analogClock_tv);
		clock = (AnalogClock) view.findViewById(R.id.intent_analogClock);
		mMainHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case SETMAIN:
					Logger.showToast(mContext, "子线程发送的消息：" + msg.obj.toString());
					break;

				default:
					break;
				}
			}
		};
		new Thread(new ChildThread(), "子线程").start();

		mClockHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case CLOKC:
					mTimeTv.setText(msg.obj.toString());
					break;

				default:
					break;
				}
			}
		};
		new Thread(new ClockThread()).start();
	}

	/**
	 * intent 拨打电话
	 * Intent.ACTION_DIAL:打开拨号面板之后通过拨号程序拨号
	 * Intent.ACTION_CALL:直接拨号,需要打开call_phone权限
	 * @author liuyunlong
	 * @date 2015-10-12下午2:43:47
	 */
	private void Dial() {
		String numberString = editText.getText().toString();
		Uri uri = Uri.parse("tel:" + numberString);
		Intent intent = new Intent();
		// intent.setAction(Intent.ACTION_DIAL);
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(uri);
		startActivity(intent);
	}

	/**
	 * intent 打开网页
	 * 
	 * @author liuyunlong
	 * @date 2015-10-12下午2:43:29
	 */
	private void opurl() {
		Uri uri = Uri.parse("http://www.mldn.cn");
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(uri);
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.intent_net_btn:
			opurl();
			break;
		case R.id.intent_dial_btn:
			Dial();
			break;
		case R.id.intent_send_msg_btn:
			sendMsg();
			break;
		case R.id.thread_btn:
			Thread2thread();
			break;
		default:
			break;
		}
	}

	private void Thread2thread() {
		Message message = mChildHandler.obtainMessage();
		message.obj = mChildHandler.getLooper().getThread().getName();
		message.what = SETCHILD;
		mChildHandler.sendMessage(message);
	}

	/**
	 * intent 发送短信
	 * 该方法只是打开发送信息的页面，如何直接发送短信？（需要service）
	 * @author liuyunlong
	 * @date 2015-10-12下午3:17:15
	 */
	private void sendMsg() {
		String receiver = mReceiverEt.getText().toString();
		String content = mSendContentEt.getText().toString();
		Uri uri = Uri.parse("smsto:" + receiver);
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_SENDTO);
		intent.putExtra("sms_body", content);
		intent.setType("vnd.android-dir/mms-sms");
		intent.setData(uri);
		startActivity(intent);
	}

	public class ChildThread implements Runnable {

		@Override
		public void run() {
			Looper.prepare();
			mChildHandler = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					switch (msg.what) {
					case SETCHILD:
						Logger.showToast(mContext, "主线程发送的信息：" + msg.obj);
						Message message = mMainHandler.obtainMessage();
						message.obj = mMainHandler.getLooper().getThread().getName();
						message.what = SETMAIN;
						mMainHandler.sendMessage(message);
						break;

					default:
						break;
					}
				}
			};
			Looper.loop();
		}
	}

	private class ClockThread implements Runnable {

		@SuppressLint("SimpleDateFormat")
		@Override
		public void run() {
			while (true) {
				try {
					Message msgMessage = mClockHandler.obtainMessage(CLOKC, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					mClockHandler.sendMessage(msgMessage);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
