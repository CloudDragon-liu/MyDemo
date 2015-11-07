package com.liuyunlong.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/** 
* @author  : liuyunlong
* @version ：2015年11月7日 上午10:18:09 
* */
public class XmlUtil {

	private static String path;

	static {
		path = XmlUtil.class.getClassLoader().getResource("users.xml").getPath();
	}

	public static Document getDocument() throws Exception {

		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(path));
		return document;

	}

	public static void write2Xml(Document document) throws Exception, FileNotFoundException {
		// Pretty print the document to System.out
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream(path), format);
		writer.write(document);
	}

	public static String getPath() {
		return path;
	}
}
