package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.service.MyServiceUtil;
import com.liuyunlong.androiddemo.utils.Logger;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/** 
* @author  : liuyunlong
* @version ：2015-9-21 下午1:56:20 
* */
public class FragmentComponentService extends Fragment implements OnClickListener {

	private LinearLayout layout;

	private Context mContext;

	private Button isNetBtn, isWifiBtn, volBtn, mPackageNameBtn, mStartBtn, mStopBtn, mBindBtn, mUnbindBtn;

	private TextView mBriefTv;

	private ImageView mIcon;

	private ServiceConnection serviceConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) { // 断开连接Service
			Logger.showToast(mContext, "Service 连接失败");
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) { // 连接到Service
			try {
				Logger.showToast(mContext, "连接Service成功，service = " + service.getInterfaceDescriptor());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.component_service, container, false);
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
		// LayoutInflater inflater = (LayoutInflater)
		// mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mIcon = (ImageView) view.findViewById(R.id.component_service_icon);
		mIcon.setOnClickListener(this);
		mStartBtn = (Button) view.findViewById(R.id.start_service_btn);
		mStartBtn.setOnClickListener(this);
		mStopBtn = (Button) view.findViewById(R.id.stop_service_btn);
		mStopBtn.setOnClickListener(this);
		mBindBtn = (Button) view.findViewById(R.id.bind_service_btn);
		mBindBtn.setOnClickListener(this);
		mUnbindBtn = (Button) view.findViewById(R.id.unbind_service_btn);
		mUnbindBtn.setOnClickListener(this);
		isNetBtn = (Button) view.findViewById(R.id.is_net_btn);
		isNetBtn.setOnClickListener(this);
		isWifiBtn = (Button) view.findViewById(R.id.is_wifi_on);
		isWifiBtn.setOnClickListener(this);
		volBtn = (Button) view.findViewById(R.id.vol_btn);
		volBtn.setOnClickListener(this);
		mPackageNameBtn = (Button) view.findViewById(R.id.package_name);
		mPackageNameBtn.setOnClickListener(this);
		mBriefTv = (TextView) view.findViewById(R.id.component_service_brief);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.is_net_btn:
			if (isNetConnected(mContext)) {
				Logger.showToast(mContext, "网络已连接");
			} else {
				Logger.showToast(mContext, "网络未连接");
			}
			break;
		case R.id.is_wifi_on:
			wifiSwitch(mContext);
			break;
		case R.id.vol_btn:
			getVol(mContext);
			break;
		case R.id.package_name:
			getCurrentPackageName(mContext);
			break;
		case R.id.component_service_icon:
			mBriefTv.setVisibility(mBriefTv.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
			mBriefTv.setText("1. 相当于一个没有界面的Acitivity。\n2. 当用户执行的操作需要进行跨进程访问时，"
					+ "可以用service来完成。\n3. 一个Service启动后如果没有意外或者明确的调用stopService则一直驻留在手机内，如果希望随着Activity程序结束一起结束需要和Activity绑定在一起\n\n");
			break;
		case R.id.start_service_btn:
			mContext.startService(new Intent(mContext, MyServiceUtil.class));
			Logger.showToast(mContext, "onCreate -->> onStartCommand\n如果未销毁则只执行onStartCommand");
			break;
		case R.id.stop_service_btn:
			mContext.stopService(new Intent(mContext, MyServiceUtil.class));
			Logger.showToast(mContext, "onDestory\n如果已经销毁则不再执行！");
			break;
		case R.id.bind_service_btn:
			mContext.bindService(new Intent(mContext, MyServiceUtil.class), serviceConnection, Context.BIND_AUTO_CREATE);
			break;
		case R.id.unbind_service_btn:
			mContext.unbindService(serviceConnection);
			break;

		default:
			break;
		}
	}

	/**
	 * 获取当前进程包名,需要添加getTask的权限
	 * @param mContext2
	 * @author liuyunlong
	 * @date 2015-9-21下午8:39:46
	 */
	private void getCurrentPackageName(Context context) {
		ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		String packageName = mActivityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
		Logger.showToast(mContext, "当前进程包名：" + packageName);
	}

	/**
	 * 获取系统音量
	 * @param mContext2
	 * @author liuyunlong
	 * @date 2015-9-21下午8:33:27
	 */
	private void getVol(Context context) {
		AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM); // 获取最大音量
		int currentVol = mAudioManager.getStreamVolume(AudioManager.STREAM_RING); // 获取最大音量
		Logger.showToast(mContext, "最大音量为：" + maxVolume + "当前音量为：" + currentVol);
	}

	/**
	 * wifi开关，需要开启两个权限（wifi_state和wifi_change_state）
	 * 
	 * @author liuyunlong
	 * @param context 
	 * @date 2015-9-21下午8:26:27
	 */
	private void wifiSwitch(Context context) {
		WifiManager mWifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
		if (mWifiManager.isWifiEnabled()) {
			mWifiManager.setWifiEnabled(false);
			Logger.showToast(mContext, "Wifi已关闭");
		} else {
			mWifiManager.setWifiEnabled(true);
			Logger.showToast(mContext, "Wifi已打开");
		}
	}

	/**
	 * 是否联网：需要打开网络访问权限
	 * @param context
	 * @return
	 * @author liuyunlong
	 * @date 2015-9-21下午8:19:08
	 */
	private boolean isNetConnected(Context context) {
		if (null != context) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
			if (null != info) {
				return info.isAvailable();
			}
		}
		return false;
	}
}
