package com.liuyunlong.domain;

import java.io.Serializable;

/** 
* @author  : liuyunlong
* @version ：2015年11月5日 下午7:34:38 
* */
public class Book implements Serializable {

	/**
	 * liuyunlong
	 * 20152015年11月5日下午8:19:48
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String author;

	public Book(Integer id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public Book() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
}
