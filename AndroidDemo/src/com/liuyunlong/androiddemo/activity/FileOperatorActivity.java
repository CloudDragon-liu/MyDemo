package com.liuyunlong.androiddemo.activity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.liuyunlong.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/** 
 * 解析xml文件和json数据
* @author  : liuyunlong
* @version ：2015-10-8 下午5:26:55 
* */
public class FileOperatorActivity extends Activity {

	private TextView mDomTv, mSaxTv, mXmlpallTv, mJsonTv, mResourceTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.file_operator);
		initData();
		initView();
	}

	private void initData() {

	}

	private void initView() {
		mDomTv = (TextView) this.findViewById(R.id.file_dom_tv);
		mSaxTv = (TextView) this.findViewById(R.id.file_sax_tv);
		mXmlpallTv = (TextView) this.findViewById(R.id.file_xmlpull_tv);
		mJsonTv = (TextView) this.findViewById(R.id.file_json_tv);
		mResourceTv = (TextView) this.findViewById(R.id.file_resource_tv);
	}

	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.file_dom_btn:

			break;
		case R.id.file_sax_btn:

			break;
		case R.id.file_xmlpull_btn:

			break;
		case R.id.file_json_btn:

			break;
		case R.id.file_resource_btn:
			resourceFile();
			break;

		default:
			break;
		}
	}

	/**
	 * 操作资源文件 raw文件夹中的
	 * 
	 * @author liuyunlong
	 * @date 2015-10-8下午5:56:43
	 */
	private void resourceFile() {
		String fileString;
		FileInputStream fis = (FileInputStream) getResources().openRawResource(R.raw.test);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024]; // 每次的读取长度
		int len = 0;
		try {
			while (-1 != (len = fis.read(buffer))) {
				baos.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != baos) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		fileString = baos.toString();
		mResourceTv.setText(fileString);
	}
}
