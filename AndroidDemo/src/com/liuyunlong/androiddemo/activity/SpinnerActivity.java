package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/** 
* @author  : liuyunlong
* @version ：2015-9-22 下午5:01:18 
* */
public class SpinnerActivity extends Activity {

	private TextView mSelectText;

	private Spinner mSpinnerProvince, mSpinnerCity;

	private ArrayAdapter<CharSequence> provinceAdapter, cityAdapter;

	private String[][] area;

	private Button button;

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
		// 设置省级数据
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
				// 设置城市数据
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

	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.toast_btn: // 不直接使用toast的setview方法是因为会覆盖文字
			Toast toast = Toast.makeText(this, "自定义Toast", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0); // 设置对齐方式
			LinearLayout view = (LinearLayout) toast.getView(); // 获取Toast的view对象
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(R.drawable.daughter);
			view.addView(imageView, 0);
			toast.show();
			break;

		default:
			break;
		}
	}
}
