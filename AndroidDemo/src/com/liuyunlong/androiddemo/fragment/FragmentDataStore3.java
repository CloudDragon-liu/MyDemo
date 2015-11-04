package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/** 
 * Content Provider
* @author  : liuyunlong
* @version ：2015-9-20 下午3:38:39 
* */
public class FragmentDataStore3 extends Fragment implements OnClickListener {

	private LinearLayout layout;

	private ImageView imageView;

	private TextView textView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.data_store_page3, container, false);
			initData();
			initView(layout);
		}
		ViewGroup parent = (ViewGroup) layout.getParent();
		if (null != parent) {
			parent.removeView(layout);
		}
		return layout;
	}

	private void initView(View view) {
		imageView = (ImageView) view.findViewById(R.id.content_provider_icon);
		textView = (TextView) view.findViewById(R.id.content_provider_brief);
		imageView.setOnClickListener(this);
	}

	private void initData() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.content_provider_icon:
			textView.setText(R.string.content_provider_brief_text);
			int isVisible = (textView.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
			textView.setVisibility(isVisible);
			break;

		default:
			break;
		}
	}
}
