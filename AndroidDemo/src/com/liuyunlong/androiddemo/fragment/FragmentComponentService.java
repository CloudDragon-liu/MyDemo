package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.Logger;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
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
* @version ：2015-9-21 下午1:56:20 
* */
public class FragmentComponentService extends Fragment implements OnClickListener {

	private LinearLayout layout;

	private Context mContext;

	private Button isNetBtn, isWifiBtn, volBtn, mPackageNameBtn;

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
		isNetBtn = (Button) view.findViewById(R.id.is_net_btn);
		isNetBtn.setOnClickListener(this);
		isWifiBtn = (Button) view.findViewById(R.id.is_wifi_on);
		isWifiBtn.setOnClickListener(this);
		volBtn = (Button) view.findViewById(R.id.vol_btn);
		volBtn.setOnClickListener(this);
		mPackageNameBtn = (Button) view.findViewById(R.id.package_name);
		mPackageNameBtn.setOnClickListener(this);
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
