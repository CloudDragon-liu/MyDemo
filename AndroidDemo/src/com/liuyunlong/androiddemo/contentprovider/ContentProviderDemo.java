package com.liuyunlong.androiddemo.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/** 
 * 提供给第三方应用程序访问本程序数据的接口，如果只实现了增，则第三方程序只能向该程序增加数据
* @author  : liuyunlong
* @version ：2015-9-21 下午4:27:59 
* */
public class ContentProviderDemo extends ContentProvider {

	/**
	 * ContentProvider创建后调用
	 */
	@Override
	public boolean onCreate() {
		return false;
	}

	/**
	 * 根据Uri查询selection指定的条件所匹配的所有记录
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		return null;
	}

	/**
	 * 返回当前Uri的MIME类型，
	 * 多条数据：vnd.android.dir开头
	 * 一条数据：vnd.android.cursor.item开头
	 */
	@Override
	public String getType(Uri uri) {
		return null;
	}

	/**
	 * 根据Uri插入
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		return null;
	}

	/**
	 * 根据Uri删除selection指定的条件所匹配的所有记录
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	/**
	 * 根据Uri修改selection指定的条件所匹配的所有记录
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		return 0;
	}

}
