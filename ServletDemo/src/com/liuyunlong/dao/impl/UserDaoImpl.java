package com.liuyunlong.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;

import com.liuyunlong.dao.UserDao;
import com.liuyunlong.domain.User;
import com.liuyunlong.utils.XmlUtil;

/** 
* @author  : liuyunlong
* @version ：2015年11月7日 上午10:16:05 
* */
public class UserDaoImpl implements UserDao {

	/**
	 * 增加用户
	 * @param user
	 * @version 2015年11月7日上午11:06:45
	 */
	@Override
	public void add(User user) {
		try {
			Document document = XmlUtil.getDocument();
			Element root = document.getRootElement();
			Element element = root.addElement("user");
			element.setAttributeValue("id", user.getId().toString());
			element.setAttributeValue("username", user.getUsername());
			element.setAttributeValue("password", user.getPassword());
			element.setAttributeValue("email", user.getEmail());
			element.setAttributeValue("nickname", user.getNickname());
			element.setAttributeValue("birthday", user.getBirthday() == null ? "" : user.getBirthday().toLocaleString());
			XmlUtil.write2Xml(document);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询用户
	 * @param user
	 * @return
	 * @version 2015年11月7日上午11:06:37
	 */
	@Override
	public User select(User user) {
		try {
			Document document = XmlUtil.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='" + user.getUsername() + "' and @password='" + user.getPassword() + "'");
			if (null == e) {
				return null;
			}
			User entity = new User();
			entity.setUsername(e.attributeValue("username"));
			entity.setPassword(e.attributeValue("password"));
			entity.setId(Integer.parseInt(e.attributeValue("id")));
			entity.setNickname(e.attributeValue("nickname"));
			entity.setEmail(e.attributeValue("email"));
			String date = e.attributeValue("birthday");
			if (null == date || date.equals("")) {
				entity.setBirthday(null);
			} else {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				entity.setBirthday(df.parse(date));
			}
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
