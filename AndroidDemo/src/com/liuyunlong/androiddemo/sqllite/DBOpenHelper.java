package com.liuyunlong.androiddemo.sqllite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.liuyunlong.androiddemo.entity.ChatMsgEntity;
import com.liuyunlong.androiddemo.utils.Logger;

/** 
* @author  : liuyunlong
* @version ：2015-8-31 下午5:11:44 
* */
public class DBOpenHelper extends SQLiteOpenHelper {

	public static final String TABLENAME = "chat_msg";

	public DBOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	public DBOpenHelper(Context context, String name) {
		super(context, name, null, 1);
	}

	/**
	 * 首次创建数据库时调用，执行建库和建表的操作 ，不允许认为调用
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table if not exists "
				+ TABLENAME
				+ " (_id integer primary key autoincrement, fromID integer not null,"
				+ " toID integer not null, content text not null, type integer not null, status integer not null,msgType integer not null, msgStyle integer not null, pattern integer not null,"
				+ " addTime text not null)";
		db.execSQL(sql);
	}

	/**
	 * 当数据的版本发生变化自动执行 ，不允许人为调用
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	/**
	 * 保存聊天记录到本地
	 * @param helper
	 * @param msg
	 * liuyunlong
	 * 2015-8-31下午7:59:54
	 * @param msgType 标识左边显示还是右边显示
	 * @return 
	 */
	public static long addChatMsg(DBOpenHelper helper, ChatMsgEntity msg, byte msgType) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("fromID", msg.getFrom());
		values.put("toID", msg.getTo());
		values.put("content", msg.getMsg());
		values.put("type", msg.getType());
		values.put("msgStyle", msg.getMsgStyle());
		values.put("pattern", msg.getPattern());
		values.put("msgType", msgType);
		values.put("addTime", msg.getTime());
		values.put("status", 1);
		long rowId = db.insert("chat_msg", null, values); // 返回值为插入行的id
		db.close();
		return rowId;
	}

	/**
	 * 根据toID查信息
	 * @param helper
	 * @param belongTo 消息所属(家ID或成员ID)
	 * @param fromId 发送者(成员ID)
	 * @param pattern 1 群聊 2单聊
	 * @return
	 * liuyunlong
	 * 2015-8-31下午8:00:33
	 */
	public static List<ChatMsgEntity> getChatMsgs(DBOpenHelper helper, Integer belongTo, Integer fromId, Integer pattern) {
		List<ChatMsgEntity> messages = new ArrayList<ChatMsgEntity>();
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor c = null;
		if (pattern == 1) { // group
			c = db.query("chat_msg", null, "toID = ? and pattern = ? ", new String[] { belongTo.toString(), pattern.toString() }, null, null, null);
		} else if (pattern == 2) { // member
			c = db.query("chat_msg", null, "toID in (?,?) and fromID in (?, ?) and pattern=?",
					new String[] { belongTo.toString(), fromId.toString(), belongTo.toString(), fromId.toString(), pattern.toString() }, null, null, null);
		}
		if (null != c) {
			while (c.moveToNext()) {
				ChatMsgEntity message = new ChatMsgEntity();
				message.setId(c.getInt(c.getColumnIndex("_id")));
				message.setFrom(c.getInt(c.getColumnIndex("fromID")) + "");
				message.setTo(c.getInt(c.getColumnIndex("toID")) + "");
				message.setType((byte) c.getInt(c.getColumnIndex("type")));
				message.setMsgStyle((byte) c.getInt(c.getColumnIndex("msgStyle")));
				message.setMsgType((byte) c.getInt(c.getColumnIndex("msgType")));
				message.setPattern((byte) c.getInt(c.getColumnIndex("pattern")));
				message.setStatus((byte) c.getInt(c.getColumnIndex("status")));
				message.setId(c.getInt(c.getColumnIndex("_id")));
				message.setMsg(c.getString(c.getColumnIndex("content")));
				message.setTime(c.getString(c.getColumnIndex("addTime")));
				messages.add(message);
			}
			Logger.logIn("DBOpenHelper get msg from msgRecord = " + messages);
			c.close();
		}
		db.close();
		return messages;
	}

	/**
	 * 更新消息记录
	 * @param helper
	 * @param msgId 消息id
	 * @param status 消息的最新状态
	 * @author liuyunlong
	 * @date 2015-9-9下午5:46:39
	 */
	public static void updateChatMsg(DBOpenHelper helper, String msgId, Integer status) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("status", status);
		// update chat_msg set status = ? where _id = ?;
		String whereClause = "_id=?";
		String[] whereArgs = new String[] { msgId };
		db.update("chat_msg", values, whereClause, whereArgs);
		Logger.logIn("DBOpenHelper update database = " + msgId);
		db.close();
	}
}
