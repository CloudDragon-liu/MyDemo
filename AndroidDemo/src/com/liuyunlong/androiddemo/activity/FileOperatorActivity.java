package com.liuyunlong.androiddemo.activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.jar.Attributes.Name;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.ConstantUtils;
import com.liuyunlong.androiddemo.utils.Logger;

/** 
 * 解析xml文件和json数据
* @author  : liuyunlong
* @version ：2015-10-8 下午5:26:55 
* */
public class FileOperatorActivity extends Activity {

	private TextView mDomTv, mSaxTv, mXmlpallTv, mJsonTv, mResourceTv;

	private EditText mDomName, mDomEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.file_operator);
		initData();
		initView();
	}

	private void initData() {

	}

	private void initView() {
		mDomTv = (TextView) this.findViewById(R.id.file_dom_tv);
		mSaxTv = (TextView) this.findViewById(R.id.file_sax_tv);
		mXmlpallTv = (TextView) this.findViewById(R.id.file_xmlpull_tv);
		mJsonTv = (TextView) this.findViewById(R.id.file_json_tv);
		mResourceTv = (TextView) this.findViewById(R.id.file_resource_tv);
		mDomName = (EditText) this.findViewById(R.id.dom_name_et);
		mDomEmail = (EditText) this.findViewById(R.id.dom_email_et);
	}

	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.file_dom_btn:
			if (mDomTv.getVisibility() == View.VISIBLE) {
				mDomTv.setVisibility(View.GONE);
			} else {
				mDomTv.setVisibility(View.VISIBLE);
				mDomTv.setText("dom是解析和生成xml文件的一种\nDOM方式解析xml是先把xml文档都读到内存中，然后再用DOM API来访问树形结构，并获取数据的，但是这样一来，如果xml文件很大呢？手机CPU处理能力当然不能与PC机器比，因此在处理效率方面就相对差了，当然这是对于其他方式处理xml文档而言\n"
						+ "具体思路是：\n首先利用DocumentBuilderFactory创建一个DocumentBuilderFactory实例\n然后利用DocumentBuilderFactory创建DocumentBuilder\n然后加载XML文档（Document）\n然后获取文档的根结点(Element)\n然后获取根结点中所有子节点的列表（NodeList）\n然后使用再获取子节点列表中的需要读取的结点\n");
			}
			break;
		case R.id.file_sax_btn:
			if (mSaxTv.getVisibility() == View.VISIBLE) {
				mSaxTv.setVisibility(View.GONE);
			} else {
				mSaxTv.setVisibility(View.VISIBLE);
				mSaxTv.setText("相比较DOM方式，sax方式适合进行大数据文件的操作");
			}
			break;
		case R.id.file_xmlpull_btn:

			break;
		case R.id.file_json_btn:

			break;
		case R.id.file_resource_btn:
			resourceFile();
			break;
		case R.id.dom_save_btn:
			dom2xml();
			break;
		case R.id.dom_get_btn:
			domFromXml();
			break;

		default:
			break;
		}
	}

	/**
	 * 读取xml文件中的内容
	 * 
	 * @author liuyunlong
	 * @date 2015-10-10上午10:10:13
	 */
	private void domFromXml() {
		if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			return;
		}
		File file = new File(Environment.getExternalStorageDirectory().toString() + File.separator + ConstantUtils.FILE_DIR.DIR + File.separator + "text.xml");
		if (!file.exists()) {
			return;
		}
		// 1. 建立DocumentBuilderFactory 用于获取DocumentBuilder
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		// 2. 通过DocumentBuilderFactory 获取DocumentBuilder
		DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		// 3. 定义 Document接口对象
		Document document = null;
		try {
			document = builder.parse(file);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 4. 查找linkman的节点
		NodeList list = document.getElementsByTagName("linkman");
		// 5. 输出NodeList中第一个节点的文本内容
		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element) list.item(i);
			mDomName.setText(element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
			mDomEmail.setText(element.getElementsByTagName("email").item(0).getFirstChild().getNodeValue());
		}
	}

	/**
	 * DOM解析xml文件,将EditText中的文字保存到xml文件中
	 * @author liuyunlong
	 * @date 2015-10-10上午9:27:29
	 */
	private void dom2xml() {
		if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) { // 如果sdcard不存在，返回
			return;
		}
		File file = new File(Environment.getExternalStorageDirectory().toString() + File.separator + ConstantUtils.FILE_DIR.DIR + File.separator + "text.xml");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		// 1. 建立DocumentBuilderFactory 用于获取DocumentBuilder
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		// 2. 通过DocumentBuilderFactory 获取DocumentBuilder
		DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		// 3. 定义 Document接口对象
		Document document = null;
		document = builder.newDocument();
		// 4. 建立各个节点操作
		Element addresslist = document.createElement("addresslist");
		Element linkman = document.createElement("linkman");
		Element name = document.createElement("name");
		Element email = document.createElement("email");
		// 5. 设置节点的文本内容
		name.appendChild(document.createTextNode(mDomName.getText().toString()));
		email.appendChild(document.createTextNode(mDomEmail.getText().toString()));
		// 6. 设置节点关系
		linkman.appendChild(name);
		linkman.appendChild(email);
		addresslist.appendChild(linkman);
		document.appendChild(addresslist);
		// 7. 输出文档到文件
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = factory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		DOMSource domSource = new DOMSource(document);
		StreamResult result = new StreamResult(file);
		try {
			transformer.transform(domSource, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 操作资源文件 raw文件夹中的
	 * 
	 * @author liuyunlong
	 * @date 2015-10-8下午5:56:43
	 */
	private void resourceFile() {
		InputStream is = getResources().openRawResource(R.raw.test);
		StringBuffer sb = new StringBuffer();
		sb.append("");
		try {
			String string = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			try {
				while (null != (string = br.readLine())) {
					sb.append(string);
					sb.append("\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (mResourceTv.getVisibility() == View.VISIBLE) {
			mResourceTv.setVisibility(View.GONE);
		} else {
			mResourceTv.setVisibility(View.VISIBLE);
			mResourceTv.setText("InputStream is = getResources().openRawResource(R.raw.test)\n" + sb.toString());
		}
	}
}
