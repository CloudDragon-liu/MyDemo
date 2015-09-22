package com.liuyunlong.androiddemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.ConstantUtils;
import com.liuyunlong.androiddemo.utils.Logger;

/** 
* @author  : liuyunlong
* @version ：2015-9-22 下午2:28:21 
* */
public class MyAlertDialog extends Dialog implements OnClickListener {

	private TextView mTitle, mContent, mCancel, mConfirm, mDeleteTV;

	private ProgressBar mProgressBar;

	private LinearLayout mCheckLayout;

	private CheckBox mDelCBox;

	private int mType = ConstantUtils.DIALOG_TYPE.NORMAL;

	private MyAlertDialogListener alertDialogListener;

	public interface MyAlertDialogListener {
		void cancle(MyAlertDialog dialog, boolean checked);

		void confirm(MyAlertDialog dialog, boolean checked);
	}

	public void setMyAlertDialogListener(MyAlertDialogListener listener) {
		this.alertDialogListener = listener;
	}

	public MyAlertDialog(Context context, int theme) {
		super(context, theme);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		layoutInflater(context);
	}

	public MyAlertDialog(Context context) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		layoutInflater(context);
	}

	/**
	 * 设置标题
	 * @param title
	 * @return
	 * @author liuyunlong
	 * @date 2015-9-22下午3:08:15
	 */
	public MyAlertDialog setDialogTitle(CharSequence title) {
		if (this.mTitle != null) {
			this.mTitle.setText(title);
		}
		return this;
	}

	/**
	 * 设置内容
	 * @param content
	 * @return
	 * @author liuyunlong
	 * @date 2015-9-22下午3:08:26
	 */
	public MyAlertDialog setDialogContent(CharSequence content) {
		if (this.mContent != null) {
			this.mContent.setText(content);
		}
		return this;
	}

	/**
	 * 设置复选框内容
	 * @param content
	 * @author liuyunlong
	 * @date 2015-9-22下午3:08:37
	 */
	public MyAlertDialog setCheckboxContent(CharSequence content) {
		if (mDeleteTV != null) {
			mDeleteTV.setText(content);
		}
		return this;
	}

	/**
	 * 设置标题栏的背景
	 * @param barBac
	 * @return
	 * @author liuyunlong
	 * @date 2015-9-22下午3:50:18
	 */
	public MyAlertDialog setTitleBarBackground(int barBac) {
		if (mTitle != null) {
			mTitle.setBackgroundColor(barBac);
		}
		return this;
	}

	/**
	 * 根据dialo的类型显示不同功能的dialog
	 * @param mType
	 * @return
	 * @author liuyunlong
	 * @date 2015-9-22下午3:45:42
	 */
	public MyAlertDialog setmType(int mType) {
		this.mType = mType;
		switch (mType) {
		case ConstantUtils.DIALOG_TYPE.NORMAL:

			break;
		case ConstantUtils.DIALOG_TYPE.WITH_CHECKBOX:
			mDelCBox.setVisibility(View.INVISIBLE);
			break;
		case ConstantUtils.DIALOG_TYPE.WITH_EDITTEXT:

			break;
		case ConstantUtils.DIALOG_TYPE.WITH_CHECKBOX_PROGRESSBAR:
			mCheckLayout.setVisibility(View.VISIBLE);
			mProgressBar.setVisibility(View.VISIBLE);
			break;
		case ConstantUtils.DIALOG_TYPE.WITH_PROGRESSBAR:
			mProgressBar.setVisibility(View.VISIBLE);
			break;

		default:
			break;
		}
		return this;
	}

	private void layoutInflater(Context context) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.my_alert_dialog_layout, null);

		mTitle = (TextView) linearLayout.findViewById(R.id.dialog_title);
		mContent = (TextView) linearLayout.findViewById(R.id.dialog_content);
		mProgressBar = (ProgressBar) linearLayout.findViewById(R.id.dialog_progressbar);
		mCancel = (TextView) linearLayout.findViewById(R.id.dialog_cancel);
		mConfirm = (TextView) linearLayout.findViewById(R.id.dialog_confirm);
		mCheckLayout = (LinearLayout) linearLayout.findViewById(R.id.check_layout);
		mDelCBox = (CheckBox) linearLayout.findViewById(R.id.deletecheckbox);
		mDeleteTV = (TextView) linearLayout.findViewById(R.id.delete_textview);
		mCancel.setOnClickListener(this);
		mConfirm.setOnClickListener(this);
		mCheckLayout.setOnClickListener(this);

		setContentView(linearLayout);
		setCanceledOnTouchOutside(false);
		setPositonAndAnimation();

	}

	private MyAlertDialog setPositonAndAnimation() {
		Window dialogWindow = getWindow();
		dialogWindow.setBackgroundDrawableResource(R.color.white);
		WindowManager.LayoutParams params = dialogWindow.getAttributes();
		params.width = getContext().getResources().getDisplayMetrics().widthPixels * 4 / 5;
		dialogWindow.setAttributes(params);
		// dialogWindow.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
		// dialogWindow.setWindowAnimations(R.style.new_offline_dialog_animation);
		// // 添加动画
		return this;

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.check_layout:
			mDelCBox.setChecked(!mDelCBox.isChecked());
			break;
		case R.id.dialog_cancel:
			alertDialogListener.cancle(this, mDelCBox.isChecked());
			break;
		case R.id.dialog_confirm:
			alertDialogListener.confirm(this, mDelCBox.isChecked());
			break;

		default:
			break;
		}
	}
}
