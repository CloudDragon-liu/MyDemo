package com.liuyunlong.domain;

import java.util.Arrays;

/** 
* @author  : liuyunlong
* @version ：2015年11月4日 上午9:56:44 
* */
public class User {

	private String username;

	private String password;

	private Integer id;

	private String city;

	private String gender;

	private String[] hobby;

	private String brief;

	private String icon;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + ", city=" + city + ", gender=" + gender + ", hobby=" + Arrays.toString(hobby) + ", brief=" + brief + ", icon="
				+ icon + "]";
	}
}
