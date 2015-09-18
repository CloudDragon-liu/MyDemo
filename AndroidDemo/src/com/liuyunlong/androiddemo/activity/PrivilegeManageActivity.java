package com.liuyunlong.androiddemo.activity;

import java.util.ArrayList;
import java.util.List;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.adpter.PrivilegeListAdapter;
import com.liuyunlong.androiddemo.entity.Equipment;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/** 
 * 权限管理
* @author  : liuyunlong
* @version ：2015-9-17 下午3:30:03 
* */
public class PrivilegeManageActivity extends Activity implements OnClickListener {

	private Context mContext;

	private TextView mTopTextView, mNameTextView;

	private ListView mEqupPriviListView;

	private List<Equipment> equipments = new ArrayList<Equipment>();

	private PrivilegeListAdapter adapter;

	private ImageView mTopBackImg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.privilege_manage);
		initData();
		initView();
	}

	private void initData() {
		equipments.add(new Equipment("电灯", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		equipments.add(new Equipment("冰箱", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		equipments.add(new Equipment("洗衣机", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		equipments.add(new Equipment("洗衣机洗衣机洗衣机洗衣机洗衣机电灯", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
	}

	private void initView() {
		mContext = this;
		mTopTextView = (TextView) this.findViewById(R.id.family_top_text);
		mTopTextView.setText("权限管理");
		mNameTextView = (TextView) this.findViewById(R.id.privilege_manage_text);
		mNameTextView.setText("女儿  能控制以下设备");
		mTopBackImg = (ImageView) this.findViewById(R.id.family_top_back_img);
		mTopBackImg.setOnClickListener(this);
		mEqupPriviListView = (ListView) this.findViewById(R.id.equ_privi_listveiw);
		adapter = new PrivilegeListAdapter(mContext, equipments);
		mEqupPriviListView.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.family_top_back_img:
			finish();
			break;

		default:
			break;
		}
	}
}
