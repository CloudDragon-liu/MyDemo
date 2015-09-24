package com.liuyunlong.androiddemo.fragment;

import java.util.ArrayList;
import java.util.List;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.adpter.MainListViewAdapter;
import com.liuyunlong.androiddemo.entity.MainItem;
import com.liuyunlong.androiddemo.utils.ConstantUtils;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

/** 
* @author  : liuyunlong
* @version ：2015-9-24 下午3:03:53 
* */
public class FragmentCollectTech extends Fragment implements OnItemClickListener {

	private LinearLayout layout;

	private Context mContext;

	private ListView listView;

	private MainListViewAdapter adapter;

	private List<MainItem> mainItems = new ArrayList<MainItem>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.collect_tech, container, false);
			mContext = getActivity();
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
		mainItems.add(new MainItem("个推", "http://www.getui.com/", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		mainItems.add(new MainItem("web开发技术", "http://www.itooy.com/", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
		mainItems.add(new MainItem("eoe Android开发", "http://www.eoeandroid.com/portal.php", BitmapFactory.decodeResource(getResources(), R.drawable.daughter)));
	}

	private void initView(View view) {
		listView = (ListView) view.findViewById(R.id.collect_tech_listview);
		adapter = new MainListViewAdapter(mContext, mainItems);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position) {
		case ConstantUtils.NUMBER.ZERO:
			openUrl(position);
			break;
		case ConstantUtils.NUMBER.ONE:
			openUrl(position);
			break;
		case ConstantUtils.NUMBER.TWO:
			openUrl(position);
			break;

		default:
			break;
		}
	}

	/**
	 * 打开地址
	 * @param position
	 * @author liuyunlong
	 * @date 2015-9-24下午3:39:04
	 */
	private void openUrl(int position) {
		MainItem item = new MainItem();
		item = mainItems.get(position);
		String url = item.getBrief();
		Uri uri = Uri.parse(url);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}
}
