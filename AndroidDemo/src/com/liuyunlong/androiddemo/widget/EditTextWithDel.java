package com.liuyunlong.androiddemo.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.liuyunlong.androiddemo.R;

/** 
* @author  : liuyunlong
* @version ：2015-9-18 上午10:09:37 
* */
public class EditTextWithDel extends EditText {

	private Drawable imgAble;
	private Drawable imgAble_h;
	private Context mContext;

	public EditTextWithDel(Context context) {
		super(context);
		mContext = context;
		init();
	}

	public EditTextWithDel(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		init();
	}

	public EditTextWithDel(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
	}

	private void init() {
		imgAble_h = getResources().getDrawable(R.drawable.edit_text_delete_h);

		addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				setDrawable();
			}
		});

		setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View arg0, boolean arg1) {
				if (!arg1) {
					imgAble = null;
					setCompoundDrawablesWithIntrinsicBounds(null, null, imgAble, null);
				} else {
					setDrawable();
				}
			}
		});
		setDrawable();
	}

	// 设置删除图片
	private void setDrawable() {
		if (length() > 0 && isEnabled() && isFocused()) {
			setPadding(0, 0, 10, 0);
			imgAble = getResources().getDrawable(R.drawable.edit_text_delete);
			setCompoundDrawablesWithIntrinsicBounds(null, null, imgAble, null);
		} else {
			imgAble = null;
			setCompoundDrawablesWithIntrinsicBounds(null, null, imgAble, null);
		}
	}

	// 处理删除事件
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (imgAble != null && event.getAction() == MotionEvent.ACTION_UP) {
			imgAble = getResources().getDrawable(R.drawable.edit_text_delete);
			setCompoundDrawablesWithIntrinsicBounds(null, null, imgAble, null);
			int eventX = (int) event.getRawX();
			Rect rect = new Rect();
			getGlobalVisibleRect(rect);
			rect.left = rect.right - getPaddingRight() - imgAble.getIntrinsicWidth();
			if (rect.left < eventX && eventX < rect.right) {
				setText("");
			}
		} else if (imgAble != null && event.getAction() == MotionEvent.ACTION_DOWN) {
			setCompoundDrawablesWithIntrinsicBounds(null, null, imgAble_h, null);
		}
		return super.onTouchEvent(event);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

}
