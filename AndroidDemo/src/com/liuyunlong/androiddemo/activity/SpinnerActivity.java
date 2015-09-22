package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/** 
* @author  : liuyunlong
* @version ：2015-9-22 下午5:01:18 
* */
public class SpinnerActivity extends Activity {

	private TextView mSelectText;

	private Spinner mSpinnerProvince, mSpinnerCity;

	ArrayAdapter<CharSequence> provinceAdapter, cityAdapter;

	private String[][] area;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.spinner);
		initView();
		initData();
	}

	private void initView() {
		mSpinnerProvince = (Spinner) this.findViewById(R.id.spinner_province);
		mSpinnerCity = (Spinner) this.findViewById(R.id.spinner_city);
		mSelectText = (TextView) this.findViewById(R.id.select_text);
	}

	private void initData() {
		provinceAdapter = ArrayAdapter.createFromResource(this, R.array.province, android.R.layout.simple_spinner_item); // 设置默认适配器数据
		provinceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // 设置下拉风格
		mSpinnerProvince.setAdapter(provinceAdapter);
		mSpinnerProvince.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Spinner spinner = (Spinner) parent;
				String pro = (String) spinner.getItemAtPosition(position);
				cityAdapter = ArrayAdapter.createFromResource(SpinnerActivity.this, R.array.moren, android.R.layout.simple_spinner_item);
				if (pro != null && pro.equals("河北省")) {
					cityAdapter = ArrayAdapter.createFromResource(SpinnerActivity.this, R.array.hb, android.R.layout.simple_spinner_item);
				} else if (pro != null && pro.equals("北京市")) {
					cityAdapter = ArrayAdapter.createFromResource(SpinnerActivity.this, R.array.bj, android.R.layout.simple_spinner_item);
				} else if (pro != null && pro.equals("山西省")) {
					cityAdapter = ArrayAdapter.createFromResource(SpinnerActivity.this, R.array.shx, android.R.layout.simple_spinner_item);
				}
				mSpinnerCity.setAdapter(cityAdapter);
				cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				mSpinnerCity.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						String string = mSpinnerCity.getSelectedItem().toString(); // 获取选中项的内容
						mSelectText.setText(string);
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {

					}
				});
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}
}
