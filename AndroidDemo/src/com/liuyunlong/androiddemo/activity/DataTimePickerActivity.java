package com.liuyunlong.androiddemo.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import com.liuyunlong.androiddemo.R;

/** 
* @author  : liuyunlong
* @version ：2015-9-22 下午7:43:28 
* */
public class DataTimePickerActivity extends Activity {

	private EditText editText;

	private DatePicker date;

	private TimePicker time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.data_time_picker);
		initView();
	}

	private void initView() {
		editText = (EditText) this.findViewById(R.id.editText1);
		date = (DatePicker) this.findViewById(R.id.datePicker);
		date.init(date.getYear(), date.getMonth(), date.getDayOfMonth(), new DateChangeListenerImp());
		time = (TimePicker) this.findViewById(R.id.timePicker);
		time.setOnTimeChangedListener(new TimeChangeListenerImp());
		time.setIs24HourView(true);
		setDateTime();
		resizePicker(date);
		resizePicker(time);
	}

	private void resizePicker(FrameLayout tp) {
		List<NumberPicker> npList = findNumberPicker(tp);
		for (NumberPicker np : npList) {
			resizeNumberPicker(np);
		}
	}

	private void resizeNumberPicker(NumberPicker np) {
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(80, LayoutParams.WRAP_CONTENT);
		params.setMargins(10, 0, 10, 0);
		np.setLayoutParams(params);
	}

	private List<NumberPicker> findNumberPicker(ViewGroup viewGroup) {
		List<NumberPicker> npList = new ArrayList<NumberPicker>();
		View child = null;
		if (null != viewGroup) {
			for (int i = 0; i < viewGroup.getChildCount(); i++) {
				child = viewGroup.getChildAt(i);
				if (child instanceof NumberPicker) {
					npList.add((NumberPicker) child);
				} else if (child instanceof LinearLayout) {
					List<NumberPicker> result = findNumberPicker((ViewGroup) child);
					if (result.size() > 0) {
						return result;
					}
				}
			}
		}
		return npList;
	}

	private void setDateTime() {
		editText.setText(date.getYear() + "-" + date.getMonth() + "-" + date.getDayOfMonth() + " " + time.getCurrentHour() + ":" + time.getCurrentMinute());
	}

	private class DateChangeListenerImp implements OnDateChangedListener {

		@Override
		public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			setDateTime();
		}
	}

	private class TimeChangeListenerImp implements OnTimeChangedListener {

		@Override
		public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
			setDateTime();
		}
	}
}
