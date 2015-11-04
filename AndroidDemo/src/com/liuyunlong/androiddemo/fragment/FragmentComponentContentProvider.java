package com.liuyunlong.androiddemo.fragment;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.ConstantUtils;
import com.liuyunlong.androiddemo.utils.Logger;
import com.liuyunlong.androiddemo.utils.Utils;

import android.R.integer;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/** 
* @author  : liuyunlong
* @version ：2015-9-21 下午2:03:00 
* */
public class FragmentComponentContentProvider extends Fragment implements OnClickListener {

	private LinearLayout layout;

	private Context mContext;

	private ImageView mIcon;

	private TextView mTitleTv, mBriefTv, mResult, mDialTv;

	private Button mQueryBtn, mAddBtn, mDialBtn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == layout) {
			layout = (LinearLayout) inflater.inflate(R.layout.component_content_provider, container, false);
			initView(layout);
		}
		ViewGroup parent = (ViewGroup) layout.getParent();
		if (null != parent) {
			parent.removeView(layout);
		}
		return layout;
	}

	private void initView(View view) {
		mContext = getActivity();
		mIcon = (ImageView) view.findViewById(R.id.component_activity_icon);
		mBriefTv = (TextView) view.findViewById(R.id.component_activity_brief);
		mIcon.setOnClickListener(this);
		mQueryBtn = (Button) view.findViewById(R.id.qurey_btn);
		mAddBtn = (Button) view.findViewById(R.id.add_btn);
		mAddBtn.setOnClickListener(this);
		mQueryBtn.setOnClickListener(this);
		mResult = (TextView) view.findViewById(R.id.result);
		mDialBtn = (Button) view.findViewById(R.id.dial_record_btn);
		mDialBtn.setOnClickListener(this);
		mDialTv = (TextView) view.findViewById(R.id.dial_record_tv);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.component_activity_icon:
			if (mBriefTv.getVisibility() == View.GONE) {
				mBriefTv.setVisibility(View.VISIBLE);
			} else {
				mBriefTv.setVisibility(View.GONE);
			}
			break;
		case R.id.qurey_btn:
			queryContacts();
			break;
		case R.id.add_btn:
			addContacts();
			break;
		case R.id.dial_record_btn:
			getDialogRecords();
			break;

		default:
			break;
		}
	}

	/**
	 * 获取通话记录
	 * 
	 * @author liuyunlong
	 * @date 2015-10-12上午9:58:47
	 */
	private void getDialogRecords() {
		ContentResolver resolver = mContext.getContentResolver();
		Uri uri = CallLog.Calls.CONTENT_URI;
		String[] projection = { CallLog.Calls._ID, CallLog.Calls.NUMBER, CallLog.Calls.CACHED_NAME, CallLog.Calls.TYPE, CallLog.Calls.DURATION };
		Cursor cursor = resolver.query(uri, projection, null, null, null);
		int id = 0;
		String phoneStr;
		String nameStr;
		String phoneType;
		String time;
		String resultString = "";
		if (null != cursor) {
			while (cursor.moveToNext()) {
				id = cursor.getInt(cursor.getColumnIndex(CallLog.Calls._ID));
				phoneStr = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
				nameStr = cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));
				phoneType = cursor.getString(cursor.getColumnIndex(CallLog.Calls.TYPE));
				time = cursor.getString(cursor.getColumnIndex(CallLog.Calls.DURATION));
				resultString += "id：" + id + "\n" + "号码为：" + phoneStr + "\n" + "姓名为：" + ((nameStr == null) ? "未知" : nameStr) + "\n" + "类型为：" + Utils.getDialType(phoneType) + "\n"
						+ "通话时间为：" + time + "\n";
			}
			cursor.close();
		}
		mDialTv.setText(resultString);
		
	}

	/**
	 * 查询联系人，通过ContentResolve，获取到Cursor后操作类似SQLlite
	 * 需要开通访问联系人的权限
	 * 记得关闭游标
	 * 
	 * @author liuyunlong
	 * @date 2015-9-21下午5:30:47
	 */
	private void queryContacts() {
		ContentResolver resolver = mContext.getContentResolver();
		int id = 0;
		String name = null;
		String homePhone = null;
		String mobilePhone = null;
		String workEmail = null;
		/**
		 * uri: 使用新api,引入包：android.provider.ContactsContract;
		 * projection: 查询的条件
		 * selection:
		 * selectionArgs:
		 * sortOrder: 排序方式
		 */
		Uri uri = Contacts.CONTENT_URI;
		String[] projection = { Contacts._ID, Contacts.DISPLAY_NAME };
		Cursor cursor = resolver.query(uri, projection, null, null, null);
		if (null != cursor) {
			while (cursor.moveToNext()) {
				id = cursor.getInt(cursor.getColumnIndex("_id"));
				name = cursor.getString(cursor.getColumnIndex("display_name"));
				Logger.logIn("联系人的id = " + id);
				Logger.logIn("联系人的姓名 = " + name);
				// 根据id查询该联系人的所有号码
				Cursor cursor2 = resolver.query(Phone.CONTENT_URI, new String[] { Phone.NUMBER, Phone.TYPE }, Phone.CONTACT_ID + "=" + id, null, null);
				if (null != cursor2) { // 根据类型id查询联系人的电话号码
					while (cursor2.moveToNext()) {
						int type = cursor2.getInt(cursor2.getColumnIndex(Phone.TYPE));
						if (type == Phone.TYPE_HOME) {
							homePhone = cursor2.getString(cursor2.getColumnIndex(Phone.NUMBER));
							Logger.logIn("家庭电话 = " + homePhone);
						} else if (type == Phone.TYPE_MOBILE) {
							mobilePhone = cursor2.getString(cursor2.getColumnIndex(Phone.NUMBER));
							Logger.logIn("移动电话 = " + mobilePhone);
						}
					}
					cursor2.close();
				}
				// 根据联系人的id查询联系人的邮箱
				Cursor cursor3 = resolver.query(Email.CONTENT_URI, new String[] { Email.DATA, Email.TYPE }, Email.CONTACT_ID + "=" + id, null, null);
				if (null != cursor3) {
					while (cursor3.moveToNext()) {
						int type = cursor3.getInt(cursor3.getColumnIndex(Email.TYPE));
						if (type == Email.TYPE_WORK) {
							workEmail = cursor3.getString(cursor3.getColumnIndex(Email.DATA));
							Logger.logIn("工作邮箱 = " + workEmail);
						}
					}
					cursor3.close();
				}
			}
			cursor.close();
		}
		String result = "id = " + id + "\n" + "name = " + name + "\n" + "家庭电话 = " + homePhone + "\n" + "移动电话 = " + mobilePhone + "\n" + "工作邮箱 = " + workEmail + "\n";
		mResult.setText(result);
	}

	/**
	 * 数据的插入和更新
	 * 增加write_context和read_context的权限
	 * 
	 * @author liuyunlong
	 * @date 2015-9-21下午5:47:45
	 */
	private void addContacts() {
		ContentResolver resolver = mContext.getContentResolver();
		ContentValues values = new ContentValues();
		Uri uri = resolver.insert(RawContacts.CONTENT_URI, values);
		long id = ContentUris.parseId(uri); // 人名对应的Id
		values.clear();// 首先清空
		// 插入人名
		values.put(StructuredName.RAW_CONTACT_ID, id);
		values.put(StructuredName.DISPLAY_NAME, "张三");
		values.put(StructuredName.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
		uri = resolver.insert(Data.CONTENT_URI, values);
		// 插入电话信息
		values.clear();
		values.put(Phone.RAW_CONTACT_ID, id);
		values.put(Phone.NUMBER, "13254786455");
		values.put(Phone.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
		uri = resolver.insert(Data.CONTENT_URI, values);
	}
}
