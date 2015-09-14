package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.utils.Logger;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/** 
 * 演示Fragment生命周期
* @author  : liuyunlong
* @version ：2015-9-14 下午7:23:11 
* */
public class FragmentLife2 extends Fragment {

	/**
	 * 每次创建都会绘制Fragment的view组件
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Logger.logIn("FragmentLife2 onCreateView");
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	/**
	 * Fragment被添加到Activity时回调，只调用一次
	 */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Logger.logIn("FragmentLife2 onAttach");
	}

	/**
	 * 创建Fragment时回调，只调用一次
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Logger.logIn("FragmentLife2 onCreate");
	}

	/**
	 * 当Fragment所在的Acitivty启动完成后调用
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Logger.logIn("FragmentLife2 onActivityCreated");
	}

	/**
	 * 启动Fragment
	 */
	@Override
	public void onStart() {
		super.onStart();
		Logger.logIn("FragmentLife2 onStart");
	}

	/**
	 * 恢复Fragment时被调用，onStart之后一定会调用onResume
	 */
	@Override
	public void onResume() {
		super.onResume();
		Logger.logIn("FragmentLife2 onResume");
	}

	/**
	 * 暂停Fragment
	 */
	@Override
	public void onPause() {
		super.onPause();
		Logger.logIn("FragmentLife2 onPause");
	}

	/**
	 * 停止Fragment
	 */
	@Override
	public void onStop() {
		super.onStop();
		Logger.logIn("FragmentLife2 onStop");
	}

	/**
	 * 销毁Fragment所包含的组件
	 */
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Logger.logIn("FragmentLife2 onDestroyView");
	}

	/**
	 * 销毁Fragment
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		Logger.logIn("FragmentLife2 onDestroy");
	}

	/**
	 * Fragment从Activity中删除，只能调用一次
	 */
	@Override
	public void onDetach() {
		super.onDetach();
		Logger.logIn("FragmentLife2 onDetach");
	}
}
