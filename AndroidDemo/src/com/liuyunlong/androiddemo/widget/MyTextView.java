package com.liuyunlong.androiddemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/** 
 * 自定义TextView控件实现跑马灯效果
* @author  : liuyunlong
* @version ：2015-9-12 下午3:00:40 
* */
public class MyTextView extends TextView {

	public MyTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyTextView(Context context) {
		super(context);
	}

	@Override
	public boolean isFocused() {
		return true;
	}
}
