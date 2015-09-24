package com.liuyunlong.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.adpter.MyExpandableListAdapter;

/** 
* @author  : liuyunlong
* @version ：2015-9-23 下午3:04:01 
* */
public class SeekBarActivity extends Activity implements OnSeekBarChangeListener {

	private SeekBar textBar, imgBar, lightBar;

	private TextView barTextView;

	private ImageView barImageView;

	private int imgs[] = new int[] { R.drawable.daughter, R.drawable.son, R.drawable.daughter, R.drawable.son, R.drawable.daughter };

	private ExpandableListView expandableListView;

	private MyExpandableListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.seek_bar);
		initView();
	}

	private void initView() {
		textBar = (SeekBar) this.findViewById(R.id.seekBar_nor);
		imgBar = (SeekBar) this.findViewById(R.id.seekBar_imgview);
		imgBar.setMax(4);
		lightBar = (SeekBar) this.findViewById(R.id.seekBar_light);
		barTextView = (TextView) this.findViewById(R.id.text_seekbar);
		barTextView.setMovementMethod(ScrollingMovementMethod.getInstance()); // 设置文本滚动（xml中同时设置scrollbar）
		barImageView = (ImageView) this.findViewById(R.id.imgveiw_seekbar);
		textBar.setOnSeekBarChangeListener(this);
		imgBar.setOnSeekBarChangeListener(this);
		lightBar.setOnSeekBarChangeListener(this);
		
		
		/*******************************ExpandableListView**************/
		
		expandableListView = (ExpandableListView) this.findViewById(R.id.expandableListView1);
		adapter = new MyExpandableListAdapter(this, null, null);
		expandableListView.setAdapter(adapter);
		registerForContextMenu(expandableListView);
		expandableListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				return false;
			}
		});
		expandableListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				return false;
			}
		});
		expandableListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {

			}
		});
		expandableListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {

			}
		});
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		switch (seekBar.getId()) {
		case R.id.seekBar_nor:
			barTextView.append("********正在拖动，当前值为：" + seekBar.getProgress() + "\n");
			break;
		case R.id.seekBar_imgview: // 拖动切换图片
			barImageView.setImageResource(imgs[seekBar.getProgress()]);
			break;

		default:
			break;
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		switch (seekBar.getId()) {
		case R.id.seekBar_nor:
			barTextView.append("********开始拖动，当前值为：" + seekBar.getProgress() + "\n");
			break;

		default:
			break;
		}
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		switch (seekBar.getId()) {
		case R.id.seekBar_nor:
			barTextView.append("********停止拖动，当前值为：" + seekBar.getProgress() + "\n");
			break;
		case R.id.seekBar_light:
			setScreenBrightness((float) seekBar.getProgress() / 100);
			break;

		default:
			break;
		}
	}

	/**
	 * 设置屏幕亮度
	 * @param i
	 * @author liuyunlong
	 * @date 2015-9-23下午3:40:08
	 */
	private void setScreenBrightness(float i) {
		WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
		layoutParams.screenBrightness = i;
		super.getWindow().setAttributes(layoutParams);
	}
}
