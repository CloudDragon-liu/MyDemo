package com.liuyunlong.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.liuyunlong.androiddemo.R;

/**
 * 之界面
 * @author liuyunlong
 *2015-9-9 上午9:59:45
 */
public class MainActivity extends Activity {

	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();
	}

	private void initView() {
		listView = (ListView) this.findViewById(R.id.main_listview);
	}
}
