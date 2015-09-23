package com.liuyunlong.androiddemo.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.liuyunlong.androiddemo.R;

/** 
* @author  : liuyunlong
* @version ：2015-9-23 上午9:21:04 
* */
public class DialogActivity extends Activity {

	private Context mContext;

	private TextView selectResult, mChoiceResult1, mChoiceResult2, mMultySelRsult;

	protected int num;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog);
		mContext = this;
		initView();
	}

	private void initView() {
		selectResult = (TextView) this.findViewById(R.id.select_result);
		mChoiceResult1 = (TextView) this.findViewById(R.id.choice_result_1);
		mChoiceResult2 = (TextView) this.findViewById(R.id.choice_result_2);
		mMultySelRsult = (TextView) this.findViewById(R.id.mult_select_result);
	}

	@SuppressWarnings("deprecation")
	public void doClick(View view) {
		AlertDialog dialog = null;
		switch (view.getId()) {
		case R.id.normal_btn: // 普通对话框
			dialog = new AlertDialog.Builder(mContext).setTitle("普通对话框").setMessage("我是一个普通的对话框").setIcon(R.drawable.daughter).create();
			dialog.show();
			break;
		case R.id.with_btn: // 带按钮的对话框
			dialog = new AlertDialog.Builder(mContext).setTitle("带按钮对话框").setMessage("我是一个带按钮对话框").setIcon(R.drawable.daughter).setPositiveButton("确定", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			}).setNegativeButton("取消", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			}).setNeutralButton("查看详情", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			}).create();
			dialog.show();
			break;
		case R.id.with_single_sel_btn: // 单选对话框，不能有setMessage否则列表出不来
			dialog = new AlertDialog.Builder(mContext).setTitle("请选择喜欢的水果").setIcon(R.drawable.daughter).setNegativeButton("取消", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			}).setItems(R.array.bj, new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					selectResult.setText("");
					selectResult.setText("您选择的水果是：" + getResources().getStringArray(R.array.bj)[which]);
				}
			}).create();
			dialog.show();
			break;

		case R.id.choice_btn: // 单选列表对话框
			dialog = new AlertDialog.Builder(mContext).setTitle("选择水果").setIcon(R.drawable.daughter).setPositiveButton("确定", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					mChoiceResult1.setText(getResources().getStringArray(R.array.hb)[num]);
				}
			}).setNegativeButton("取消", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			}).setSingleChoiceItems(R.array.bj, 0, new OnClickListener() { // 0为默认选中项

						@Override
						public void onClick(DialogInterface dialog, int which) {
							mChoiceResult2.setText("");
							mChoiceResult2.setText(getResources().getStringArray(R.array.bj)[which]);
							num = which;
						}
					}).create();
			dialog.show();
			break;
		case R.id.multy_btn: // 复选列表对话框
			dialog = new AlertDialog.Builder(mContext).setTitle("选择水果").setIcon(R.drawable.daughter).setPositiveButton("确定", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			}).setNegativeButton("取消", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			}).setMultiChoiceItems(R.array.bj, null, new OnMultiChoiceClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					for (int i = 0; i < getResources().getStringArray(R.array.bj).length; i++) {
						if (i == which && isChecked) {
							mMultySelRsult.append(getResources().getStringArray(R.array.bj)[i] + ",");
						}
					}
				}
			}).create();
			dialog.show();
			break;
		case R.id.customize_btn: // 定制对话框
			LayoutInflater layoutInflater = LayoutInflater.from(mContext);
			View dialogView = layoutInflater.inflate(R.layout.dialog_layout, null);
			dialog = new AlertDialog.Builder(mContext).setTitle("选择水果").setIcon(R.drawable.daughter).setPositiveButton("确定", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			}).setNegativeButton("取消", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			}).setView(dialogView).create();
			dialog.show();
			break;
		case R.id.datepicker_btn: // 日期对话框
			dialog = new DatePickerDialog(mContext, new OnDateSetListener() {

				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
					TextView textView = (TextView) findViewById(R.id.date_text);
					textView.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
				}
			}, 2015, 10, 20);
			dialog.show();
			break;
		case R.id.timepicker_btn: // 时间对话框
			dialog = new TimePickerDialog(mContext, new OnTimeSetListener() {

				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					TextView textView = (TextView) findViewById(R.id.time_text);
					textView.setText(hourOfDay + ":" + minute);
				}
			}, 12, 52, true);
			dialog.show();
			break;
		case R.id.progressbar_btn: // 进度条对话框
			final ProgressDialog dialog2 = ProgressDialog.show(mContext, "搜索网络", "请耐心等待...");
			new Thread() {

				@Override
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						dialog2.dismiss();
					}
				}
			}.start();
			dialog2.show();
			break;
		case R.id.ho_progressbar_btn: // 水平进度条对话框
			final ProgressDialog dialog3 = new ProgressDialog(mContext);
			dialog3.setTitle("搜索网络");
			dialog3.setMessage("请耐心等待...");
			dialog3.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); // 设置水平
			dialog3.setMax(100); // 设置最大值
			dialog3.setProgress(30); // 设置开始点
			dialog3.setButton("详细信息", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			});
			dialog3.setButton2("后台处理", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog3.dismiss();
				}
			});
			dialog3.onStart();
			new Thread() {

				@Override
				public void run() {
					for (int i = 0; i < 100; i++) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						dialog3.incrementProgressBy(1);
					}
					dialog3.dismiss();
				}
			}.start();
			dialog3.show();
			break;
		default:
			break;
		}
	}
}
