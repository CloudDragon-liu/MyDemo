package com.liuyunlong.domain;

import java.util.Arrays;
import java.util.Date;

/** 
* @author  : liuyunlong
* @version ：2015年11月4日 上午9:56:44 
* */
public class User {

	private String username;

	private String password;

	private String nickname;

	private String email;

	private Date birthday;

	private Integer id;

	public User() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", nickname=" + nickname + ", email=" + email + ", birthday=" + birthday + ", id=" + id + "]";
	}

}
