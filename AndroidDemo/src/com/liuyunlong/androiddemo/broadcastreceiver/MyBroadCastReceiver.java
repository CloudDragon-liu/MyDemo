package com.liuyunlong.androiddemo.broadcastreceiver;

import com.liuyunlong.androiddemo.utils.Logger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/** 
 * 广播接收器
* @author  : liuyunlong
* @version ：2015-10-13 下午4:07:35 
* */
public class MyBroadCastReceiver extends BroadcastReceiver {

	private static final String STATIC_ACTION = "broadcast_action_static";

	private static final String DYNAMIC_ACTION = "broadcast_action_dynamic";

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(STATIC_ACTION)) {
			Logger.showToast(context, "接收到静态广播信息");
		} else if (intent.getAction().equals(DYNAMIC_ACTION)) {
			Logger.showToast(context, "接收到动态广播信息：" + intent.getExtras().getString("msg"));
		}
	}
}
