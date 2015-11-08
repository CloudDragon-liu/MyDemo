package com.liuyunlong.domain;

import java.util.Date;

/** 
* @author  : liuyunlong
* @version ：2015年11月8日 上午9:54:24 
* */
public class User {

	private Integer id;

	private String username;

	private String nickname;

	private String email;

	private String icon;

	private String password;

	private Date birthday;

	public User() {
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", nickname=" + nickname + ", email=" + email + ", icon=" + icon + ", password=" + password + ", birthday=" + birthday + "]";
	}
}
