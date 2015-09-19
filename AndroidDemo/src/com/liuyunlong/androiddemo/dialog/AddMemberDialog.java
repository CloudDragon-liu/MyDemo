package com.liuyunlong.androiddemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;

/** 
* @author  : liuyunlong
* @version ：2015-8-20 下午2:45:56 
* */
public class AddMemberDialog extends Dialog implements OnClickListener {

	private EditText editText;

	private MyDialogListener listener;

	private TextView mGiveUpTv, mOkTv, mTitle;

	private LinearLayout layout;

	public interface MyDialogListener {
		public void onClick(View v);
	}

	public AddMemberDialog(Context context, String str, MyDialogListener listener, String hint) {

		super(context);

		this.listener = listener;

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.add_member_dialog_layout, null);
		editText = (EditText) linearLayout.findViewById(R.id.add_member_dialog_et);
		editText.setFocusable(true);
		editText.setHint(hint);
		mTitle = (TextView) linearLayout.findViewById(R.id.add_member_dia_title);
		mTitle.setText(str);
		mGiveUpTv = (TextView) linearLayout.findViewById(R.id.add_give_up);
		mOkTv = (TextView) linearLayout.findViewById(R.id.add_complete);
		mGiveUpTv.setOnClickListener(this);
		mOkTv.setOnClickListener(this);
		setContentView(linearLayout);
		Window dialogWindow = getWindow();
		WindowManager.LayoutParams params = dialogWindow.getAttributes();
		params.height = context.getResources().getDisplayMetrics().heightPixels * 2 / 5;
		params.width = context.getResources().getDisplayMetrics().widthPixels * 5 / 6; // 宽度
		// dialogWindow.setBackgroundDrawableResource(R.drawable.dialog_background);
		dialogWindow.setBackgroundDrawableResource(R.color.fragment_bac);
		dialogWindow.setAttributes(params);
		setCanceledOnTouchOutside(false);
	}

	public EditText getEditText() {
		return editText;
	}

	public void setEditText(EditText editText) {
		this.editText = editText;
	}

	public TextView getmGiveUpTv() {
		return mGiveUpTv;
	}

	public void setmGiveUpTv(TextView mGiveUpTv) {
		this.mGiveUpTv = mGiveUpTv;
	}

	public TextView getmOkTv() {
		return mOkTv;
	}

	public void setmOkTv(TextView mOkTv) {
		this.mOkTv = mOkTv;
	}

	@Override
	public void onClick(View v) {
	}
}
