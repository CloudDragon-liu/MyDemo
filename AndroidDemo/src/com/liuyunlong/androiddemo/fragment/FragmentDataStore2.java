package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.entity.ChatMsgEntity;
import com.liuyunlong.androiddemo.sqllite.DBOpenHelper;
import com.liuyunlong.androiddemo.utils.Logger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/** 
 * SQLite存储
* @author  : liuyunlong
* @version ：2015-9-20 下午3:35:30 
* */
public class FragmentDataStore2 extends Fragment implements OnClickListener {

	private LinearLayout layout;

	private ImageView mIcon;

	private TextView mBriefTv;

	private Button mDelBtn, mAddBtn, mUpdateBtn, mSelBtn;

	private DBOpenHelper mHelper;

	private ChatMsgEntity msg = new ChatMsgEntity();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.data_store_page2, container, false);
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
		mIcon = (ImageView) view.findViewById(R.id.sqllite_img);
		mIcon.setOnClickListener(this);
		mBriefTv = (TextView) view.findViewById(R.id.sqllite_brief);
		mDelBtn = (Button) view.findViewById(R.id.del_btn);
		mAddBtn = (Button) view.findViewById(R.id.add_btn);
		mUpdateBtn = (Button) view.findViewById(R.id.update_btn);
		mSelBtn = (Button) view.findViewById(R.id.sel_btn);
		mSelBtn.setOnClickListener(this);
		mDelBtn.setOnClickListener(this);
		mUpdateBtn.setOnClickListener(this);
		mAddBtn.setOnClickListener(this);
	}

	private void initData() {
		mHelper = new DBOpenHelper(getActivity(), "my.db");
		msg.setFrom("2");
		msg.setTo("2");
		msg.setMsg("大家好");
		msg.setType((byte) 1);
		msg.setStatus((byte) 2);
		msg.setPattern((byte) 1);
		msg.setMsgType((byte) 1);
		msg.setMsgStyle((byte) 2);
		msg.setTime("2015-09-21 09:41:44");
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.sqllite_img:
			int isShow = mBriefTv.getVisibility();
			if (isShow == View.VISIBLE) {
				mBriefTv.setVisibility(View.INVISIBLE);
			} else {
				mBriefTv.setVisibility(View.VISIBLE);
			}
			break;
		case R.id.add_btn:
			long id = DBOpenHelper.addChatMsg(new DBOpenHelper(getActivity(), "my.db"), msg, (byte) 1);
			Logger.showToast(getActivity(), "插入记录id = " + id);
			break;
		case R.id.del_btn:
			break;
		case R.id.update_btn:
			break;
		case R.id.sel_btn:
			break;

		default:
			break;
		}
	}
}
