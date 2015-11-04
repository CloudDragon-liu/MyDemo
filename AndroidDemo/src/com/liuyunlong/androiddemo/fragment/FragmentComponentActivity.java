package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;

import android.R.integer;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/** 
* @author  : liuyunlong
* @version ：2015-9-21 下午1:51:18 
* */
public class FragmentComponentActivity extends Fragment implements OnClickListener {

	private LinearLayout layout;

	private Context mContext;

	private TextView textView;

	private ImageView imageView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.component_activity, container, false);
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
		textView = (TextView) view.findViewById(R.id.component_activity_title);
		imageView = (ImageView) view.findViewById(R.id.component_activity_icon);
		imageView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.component_activity_icon:
			textView.setVisibility(textView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
			textView.setText(R.string.activity_brief);
			break;

		default:
			break;
		}
	}

}
