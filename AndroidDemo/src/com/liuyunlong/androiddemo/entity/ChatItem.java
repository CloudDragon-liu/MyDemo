package com.liuyunlong.androiddemo.entity;

import android.graphics.Bitmap;

/** 
* @author  : liuyunlong
* @version ：2015-9-16 下午8:17:34 
* */
public class ChatItem {

	private String name;

	private String msg;

	private String time;

	private String tips;

	private Bitmap icon;

	public ChatItem() {
		super();
	}

	public ChatItem(String name, String msg, String time, String tips, Bitmap icon) {
		super();
		this.name = name;
		this.msg = msg;
		this.time = time;
		this.tips = tips;
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public Bitmap getIcon() {
		return icon;
	}

	public void setIcon(Bitmap icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "ChatItem [name=" + name + ", msg=" + msg + ", time=" + time + ", tips=" + tips + ", icon=" + icon + "]";
	}
}
