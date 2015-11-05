package com.liuyunlong.androiddemo.service;

import com.liuyunlong.androiddemo.utils.Logger;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/** 
* @author  : liuyunlong
* @version ：2015-10-13 下午1:58:06 
* */
public class MyServiceUtil extends Service {

	private IBinder mIBinder = new Binder() {

		@Override
		public String getInterfaceDescriptor() {
			return "My Service Class";
		}
	};

	@Override
	public IBinder onBind(Intent intent) {
		Logger.logIn("service onBind intent = " + intent);
		return mIBinder;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Logger.logIn("service onUnbind intent = " + intent);
		return super.onUnbind(intent);
	}

	@Override
	public void onRebind(Intent intent) {
		Logger.logIn("service onRebind intent = " + intent);
		super.onRebind(intent);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Logger.logIn("service onCreate");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Logger.logIn("onStartCommand intent = " + intent + "flags=" + flags + "startId=" + startId);
		return Service.START_CONTINUATION_MASK;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Logger.logIn("service onDestory");
	}

}
