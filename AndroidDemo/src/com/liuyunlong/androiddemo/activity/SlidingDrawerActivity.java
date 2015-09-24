package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.adpter.MyExpandableListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.SlidingDrawer.OnDrawerScrollListener;

/** 
* @author  : liuyunlong
* @version ：2015-9-24 上午9:05:17 
* */
public class SlidingDrawerActivity extends Activity {

	private ListView listView;

	private SlidingDrawer drawer;

	private Button button;

	private String data[] = { "cesf", "safd", "fweasd", "sdgae" };

	private LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.slidingdrawer);
		initView();
	}

	private void initView() {

		/***********************slidingDrawer****************************/

		layout = (LinearLayout) this.findViewById(R.id.content);
		listView = new ListView(this);
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, data));
		layout.addView(listView);
		drawer = (SlidingDrawer) this.findViewById(R.id.slidingDrawer1);
		button = (Button) this.findViewById(R.id.handle);
		drawer.setOnDrawerOpenListener(new OnDrawerOpenListener() {

			@Override
			public void onDrawerOpened() {

			}
		});
		drawer.setOnDrawerCloseListener(new OnDrawerCloseListener() {

			@Override
			public void onDrawerClosed() {
				// TODO Auto-generated method stub

			}
		});
		drawer.setOnDrawerScrollListener(new OnDrawerScrollListener() {

			@Override
			public void onScrollStarted() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onScrollEnded() {
				// TODO Auto-generated method stub

			}
		});
	}
}
