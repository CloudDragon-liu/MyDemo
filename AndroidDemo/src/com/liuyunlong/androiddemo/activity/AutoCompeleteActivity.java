package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/** 
* @author  : liuyunlong
* @version ：2015-9-23 下午2:35:01 
* */
public class AutoCompeleteActivity extends Activity {

	private AutoCompleteTextView autoCompleteTextView;

	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.auto_compelete_textview);
		initView();
	}

	private void initView() {
		autoCompleteTextView = (AutoCompleteTextView) this.findViewById(R.id.auto_compelete);
		autoCompleteTextView.setThreshold(1); // 默认为输入两个字符才开始提示，该属性可设置
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.auto_compelete));
		autoCompleteTextView.setAdapter(adapter);
	}
}
