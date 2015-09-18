package com.liuyunlong.androiddemo.adpter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.entity.Equipment;
import com.liuyunlong.androiddemo.listener.OnSwitchListener;
import com.liuyunlong.androiddemo.widget.SwitchButton;

/** 
* @author  : liuyunlong
* @version ：2015-9-17 下午3:54:17 
* */
public class PrivilegeListAdapter extends BaseAdapter {

	private Context mContext;

	private List<Equipment> equipments;

	private LayoutInflater mInflate;

	public PrivilegeListAdapter(Context mContext, List<Equipment> Equipments) {
		super();
		this.mContext = mContext;
		this.equipments = Equipments;
		this.mInflate = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return equipments.size();
	}

	@Override
	public Object getItem(int position) {
		return equipments.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Equipment equipment = equipments.get(position);

		ViewHolder viewHolder = null;
		if (null == convertView) {
			convertView = mInflate.inflate(R.layout.privilege_listview_item, null);
			viewHolder = new ViewHolder();
			viewHolder.deviceIcon = (ImageView) convertView.findViewById(R.id.equipment_icon);
			viewHolder.deviceName = (TextView) convertView.findViewById(R.id.equipment_text);
			viewHolder.privilegeSwitch = (SwitchButton) convertView.findViewById(R.id.privilege_switch_btn);
			// viewHolder.privilegeSwitch.setSwitchState(true); // 设置权限的初始状态
			viewHolder.privilegeSwitch.setOnSwitchStateListener(new OnSwitchListener() {

				@Override
				public void onSwitched(boolean isSwitchOn) {
					if (isSwitchOn) {
						Toast.makeText(mContext, "开关开启", Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(mContext, "开关关闭", Toast.LENGTH_SHORT).show();
					}

				}
			});
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.deviceIcon.setImageBitmap(equipment.getBitmap());
		viewHolder.deviceName.setText(equipment.getDeviceName());
		return convertView;
	}

	public static class ViewHolder {
		public ImageView deviceIcon;
		public TextView deviceName;
		public SwitchButton privilegeSwitch;
	}
}
