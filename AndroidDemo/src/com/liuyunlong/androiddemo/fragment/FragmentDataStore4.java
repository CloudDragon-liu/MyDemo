package com.liuyunlong.androiddemo.fragment;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.Logger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/** 
 * 文件存储
* @author  : liuyunlong
* @version ：2015-9-20 下午3:43:07 
* */
public class FragmentDataStore4 extends Fragment implements OnClickListener {

	private EditText mEditText;

	private Button mWrButn;

	private ImageView mIcon;

	private TextView mShowTv, mBriefTv;

	private LinearLayout layout;

	private Context mContext;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.data_store_page4, container, false);
			initData();
			initView(layout);
		}
		ViewGroup parent = (ViewGroup) layout.getParent();
		if (null != parent) {
			parent.removeView(layout);
		}
		return layout;
	}

	private void initData() {

	}

	private void initView(View view) {
		mContext = getActivity();
		mEditText = (EditText) view.findViewById(R.id.file_edit_et);
		mWrButn = (Button) view.findViewById(R.id.file_read_write_btn);
		mShowTv = (TextView) view.findViewById(R.id.file_read_content);
		mWrButn.setOnClickListener(this);
		mIcon = (ImageView) view.findViewById(R.id.file_store_iv);
		mIcon.setOnClickListener(this);
		mBriefTv = (TextView) view.findViewById(R.id.file_store__brief_iv);
	}

	/**
	 * 保存文件，如果文件不存在，自动创建，默认路径为data目录下
	 * @param content
	 * @author liuyunlong
	 * @date 2015-9-21上午10:36:59
	 */
	public void write2file(String content) {
		try {
			// 如果想多种模式一起使用，中间使用+连接
			FileOutputStream fos = mContext.openFileOutput("a.txt", Context.MODE_PRIVATE);
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读文件
	 * 
	 * @author liuyunlong
	 * @date 2015-9-21上午10:42:19
	 */
	public String readFiles() {
		String fileString = null;
		try {
			FileInputStream fis = mContext.openFileInput("a.txt");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024]; // 每次的读取长度
			int len = 0;
			while (-1 != (len = fis.read(buffer))) {
				baos.write(buffer, 0, len);
			}
			fileString = baos.toString();
			fis.close();
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileString;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.file_read_write_btn:
			String editContenString = mEditText.getText().toString();
			write2file(editContenString);
			mShowTv.setText(readFiles());
			break;
		case R.id.file_store_iv:
			if (mBriefTv.getVisibility() == View.VISIBLE) {
				mBriefTv.setVisibility(View.INVISIBLE);
			} else {
				mBriefTv.setVisibility(View.VISIBLE);
			}
			break;

		default:
			break;
		}
	}
}
