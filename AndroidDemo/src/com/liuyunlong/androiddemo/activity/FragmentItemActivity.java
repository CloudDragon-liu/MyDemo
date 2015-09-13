package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/** @author liuyunlong
 * @date 2015-9-13 下午3:23:50 
 * @version 1.0 
 */
public class FragmentItemActivity extends Activity implements OnClickListener {

	private LinearLayout fragmentTablay1, fragmentTablay2, fragmentTablay3, fragmentTablay4;

	private ImageView fragmentTabIv1, fragmentTabIv2, fragmentTabIv3, fragmentTabIv4;

	private TextView fragmentTabTv1, fragmentTabTv2, fragmentTabTv3, fragmentTabTv4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment_activity_main);
		iniView();
	}

	private void iniView() {

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.fragment_tab_1_layout:

			break;
		case R.id.fragment_tab_2_layout:

			break;
		case R.id.fragment_tab_3_layout:

			break;
		case R.id.fragment_tab_4_layout:

			break;

		default:
			break;
		}
	}
}
