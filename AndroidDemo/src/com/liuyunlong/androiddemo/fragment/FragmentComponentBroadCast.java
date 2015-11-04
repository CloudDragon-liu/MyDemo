package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.broadcastreceiver.MyBroadCastReceiver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/** 
* @author  : liuyunlong
* @version ：2015-9-21 下午1:59:57 
* */
public class FragmentComponentBroadCast extends Fragment implements OnClickListener {

	private static final String ACTION_STATIC = "broadcast_action_static";

	private static final String ACTION_DYNAMIC = "broadcast_action_dynamic";

	private LinearLayout layout;

	private Context mContext;

	private Button mStaticBtn, mDynamicBtn;

	MyBroadCastReceiver receiver = new MyBroadCastReceiver();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.component_broadcast_receiver, container, false);
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
		mStaticBtn = (Button) view.findViewById(R.id.broadcast_static_btn);
		mStaticBtn.setOnClickListener(this);
		mDynamicBtn = (Button) view.findViewById(R.id.broadcast_dynamic_btn);
		mDynamicBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.broadcast_static_btn: // 发送静态广播
			intent.setAction(ACTION_STATIC);
			mContext.sendBroadcast(intent);
			break;
		case R.id.broadcast_dynamic_btn:
			intent.setAction(ACTION_DYNAMIC);
			intent.putExtra("msg", "动态注册成功");
			IntentFilter filter = new IntentFilter(ACTION_DYNAMIC);
			mContext.registerReceiver(receiver, filter); // 动态注册
			mContext.sendBroadcast(intent); // 发送广播
			break;
		default:
			break;
		}
	}

	@Override
	public void onStop() {
		super.onStop();
		mContext.unregisterReceiver(receiver);
	}

}
