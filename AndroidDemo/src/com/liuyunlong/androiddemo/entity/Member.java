package com.liuyunlong.androiddemo.entity;

import java.util.Date;

import android.graphics.Bitmap;

/** 
 * 家庭成员
* @author  : liuyunlong
* @version ：2015-9-16 下午7:31:35 
* */
public class Member {
	private Integer id;

	private String username;

	private String password;

	private String nickname;

	private String phonenumber;

	private String email;

	private String icon;

	private Integer isdel;

	private Date registerTime;

	private Integer usertype;

	private String queryString;

	private Bitmap userIcon;

	public Member() {
		super();
	}

	public Member(String nickname, String username, Bitmap bitmap) {
		super();
		this.nickname = nickname;
		this.username = username;
		this.userIcon = bitmap;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getIsdel() {
		return isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public Bitmap getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(Bitmap userIcon) {
		this.userIcon = userIcon;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname + ", phonenumber=" + phonenumber + ", email=" + email
				+ ", icon=" + icon + ", isdel=" + isdel + ", registerTime=" + registerTime + ", usertype=" + usertype + ", queryString=" + queryString + ", userIcon=" + userIcon
				+ "]";
	}
}
