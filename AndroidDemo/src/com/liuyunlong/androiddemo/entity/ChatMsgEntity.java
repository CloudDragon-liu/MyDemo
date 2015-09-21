package com.liuyunlong.androiddemo.entity;

import java.io.Serializable;
import java.util.Map;

import android.graphics.Bitmap;

/** 
* @author  : liuyunlong
* @version ：2015-8-11 下午9:29:24 
* */
public class ChatMsgEntity implements Serializable {
	/**
	 * liuyunlong
	 * 2015-9-11下午12:28:25
	 */
	private static final long serialVersionUID = 4579861449727457112L;

	private static final String TAG = ChatMsgEntity.class.getSimpleName();

	private String name;

	private String icon;

	private Bitmap bitmap;

	private Integer id;

	private String msg;

	private String time;

	/**1 等待发送 2发送成功 3 发送失败*/
	private byte status;

	private String from;

	private String to;

	/**1 群消息 2 单聊消息*/
	private byte pattern;

	/**0-业务请求 1-业务响应 2-oneway消息 3-握手请求 4-握手应答 5-心跳请求 6-心跳应答*/
	private byte type;

	/**0-文本 1-文件 2-资讯分享 3-状态通知*/
	private byte msgStyle;

	private Map<String, Object> extra;

	/**消息类型  1 他人消息 2 本人消息*/
	private byte msgType;

	public ChatMsgEntity() {
	}

	public ChatMsgEntity(String name, String date, String text, byte msgType) {
		super();
		this.name = name;
		this.time = date;
		this.msg = text;
		this.msgType = msgType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	/**1 等待接收 2发送成功 3 发送失败*/
	public byte getStatus() {
		return status;
	}

	/**1 等待接收 2发送成功 3 发送失败*/
	public void setStatus(byte status) {
		this.status = status;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	/**1 群消息 2 单聊消息*/
	public byte getPattern() {
		return pattern;
	}

	/**1 群消息 2 单聊消息*/
	public void setPattern(byte pattern) {
		this.pattern = pattern;
	}

	/**0-业务请求 1-业务响应 2-oneway消息 3-握手请求 4-握手应答 5-心跳请求 6-心跳应答*/
	public byte getType() {
		return type;
	}

	/**0-业务请求 1-业务响应 2-oneway消息 3-握手请求 4-握手应答 5-心跳请求 6-心跳应答*/
	public void setType(byte type) {
		this.type = type;
	}

	/**0-文本 1-文件 2-资讯分享 3-状态通知*/
	public byte getMsgStyle() {
		return msgStyle;
	}

	/**0-文本 1-文件 2-资讯分享 3-状态通知*/
	public void setMsgStyle(byte msgStyle) {
		this.msgStyle = msgStyle;
	}

	public Map<String, Object> getExtra() {
		return extra;
	}

	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}

	/**消息类型  1 他人消息 2 本人消息*/
	public byte getMsgType() {
		return msgType;
	}

	/**消息类型  1 他人消息 2 本人消息*/
	public void setMsgType(byte msgType) {
		this.msgType = msgType;
	}

	@Override
	public String toString() {
		return "ChatMsgEntity [name=" + name + ", icon=" + icon + ", bitmap=" + bitmap + ", id=" + id + ", msg=" + msg + ", time=" + time + ", status=" + status + ", from=" + from
				+ ", to=" + to + ", pattern=" + pattern + ", type=" + type + ", msgStyle=" + msgStyle + ", extra=" + extra + ", msgType=" + msgType + "]";
	}
}