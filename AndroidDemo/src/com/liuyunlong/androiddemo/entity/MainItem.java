package com.liuyunlong.androiddemo.entity;

import java.util.Map;

import android.graphics.Bitmap;

/** 
* @author  : liuyunlong
* @version ：2015-9-9 下午8:34:10 
* */
public class MainItem {

	private String title;

	private String brief;

	private Bitmap bitmap;

	private Map<String, Object> extras;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public Map<String, Object> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, Object> extras) {
		this.extras = extras;
	}

	@Override
	public String toString() {
		return "MainItem [title=" + title + ", brief=" + brief + ", extras=" + extras + "]";
	}
}
