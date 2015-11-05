package com.liuyunlong.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

/** 
* @author  : liuyunlong
* @version ：2015年11月3日 下午3:46:51 
* */
public class ValidateCodeUtil {

	private int width;

	private int height;

	private HttpServletResponse response;

	public ValidateCodeUtil(int width, int height, HttpServletResponse response) {
		super();
		this.width = width;
		this.height = height;
		this.response = response;
	}

	public void validateCode() {

		// 1. 构建图片（bufferimage类内存中的）
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 2. 向图片写随机数
		// 2.1 先要获取到这幅图形
		Graphics graphics = image.getGraphics();
		// 2.2 再在图形上进行设置
		setBackground(graphics);
		setBorder(graphics);
		drawRandomLine(graphics);
		drawRandomNum((Graphics2D) graphics);

		// 3. 将图片输出给浏览器（imageio类）同时告知浏览器以图片的形式打开,同时告知浏览器不要缓存该图片
		response.setContentType("image/jpeg");
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		try {
			ImageIO.write(image, "jpg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 写随机数
	 * @param graphics
	 * @version 2015年11月3日下午2:26:44
	 */
	private void drawRandomNum(Graphics2D graphics) {
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("宋体", Font.BOLD, 20));
		// 汉字区间[\u4e00-\u9fa5],不能从中文区间去因为会有繁体等难写字
		String str = "\u7684\u4e00\u662f\u4e86\u6211\u4e0d\u4eba\u5728\u4ed6\u6709\u8fd9\u4e2a\u4e0a\u4eec\u6765\u5230\u65f6\u5927\u5730\u4e3a\u5b50\u4e2d\u4f60\u8bf4\u751f\u56fd\u5e74\u7740\u5c31\u90a3\u548c\u8981\u5979\u51fa\u4e5f\u5f97\u91cc\u540e\u81ea\u4ee5\u4f1a\u5bb6\u53ef\u4e0b\u800c\u8fc7\u5929\u53bb\u80fd\u5bf9\u5c0f\u591a\u7136\u4e8e\u5fc3\u5b66\u4e48\u4e4b\u90fd\u597d\u770b\u8d77\u53d1\u5f53\u6ca1\u6210\u53ea\u5982\u4e8b\u628a\u8fd8\u7528\u7b2c\u6837\u9053\u60f3\u4f5c\u79cd\u5f00\u7f8e\u603b\u4ece\u65e0\u60c5\u5df1\u9762\u6700\u5973\u4f46\u73b0\u524d\u4e9b\u6240\u540c\u65e5\u624b\u53c8\u884c\u610f\u52a8\u65b9\u671f\u5b83\u5934\u7ecf\u957f\u513f\u56de\u4f4d\u5206\u7231\u8001\u56e0\u5f88\u7ed9\u540d\u6cd5\u95f4\u65af\u77e5\u4e16\u4ec0\u4e24\u6b21\u4f7f\u8eab\u8005\u88ab\u9ad8\u5df2\u4eb2\u5176\u8fdb\u6b64\u8bdd\u5e38\u4e0e\u6d3b\u6b63\u611f\u89c1\u660e\u95ee\u529b\u7406\u5c14\u70b9\u6587\u51e0\u5b9a\u672c\u516c\u7279\u505a\u5916\u5b69\u76f8\u897f\u679c\u8d70\u5c06\u6708\u5341\u5b9e\u5411\u58f0\u8f66\u5168\u4fe1\u91cd\u4e09\u673a\u5de5\u7269\u6c14\u6bcf\u5e76\u522b\u771f\u6253\u592a\u65b0\u6bd4\u624d\u4fbf\u592b\u518d\u4e66\u90e8\u6c34\u50cf\u773c\u7b49\u4f53\u5374\u52a0\u7535\u4e3b\u754c\u95e8\u5229\u6d77\u53d7\u542c\u8868\u5fb7\u5c11\u514b\u4ee3\u5458\u8bb8\u7a1c\u5148\u53e3\u7531\u6b7b\u5b89\u5199\u6027\u9a6c\u5149\u767d\u6216\u4f4f\u96be";
		int x = 10;
		for (int i = 0; i < 4; i++) {

			int degree = new Random().nextInt() % 30; // 生-30 - +30的随机数
			graphics.rotate(degree * Math.PI / 180, x, 20);
			String ch = str.charAt(new Random().nextInt(str.length())) + "";
			graphics.drawString(ch, x, 20);
			graphics.rotate(-degree * Math.PI / 180, x, 20);
			x += 30;
		}
	}

	/**
	 * 画干扰线
	 * @param graphics
	 * @version 2015年11月3日下午2:26:54
	 */
	private void drawRandomLine(Graphics graphics) {
		graphics.setColor(Color.GREEN);
		for (int i = 0; i < 4; i++) {
			int x1 = new Random().nextInt(width);
			int y1 = new Random().nextInt(height);
			int x2 = new Random().nextInt(width);
			int y2 = new Random().nextInt(height);
			graphics.drawLine(x1, y1, x2, y2);
		}
	}

	/**
	 * 设置边框
	 * @param graphics
	 * @version 2015年11月3日下午2:27:04
	 */
	private void setBorder(Graphics graphics) {
		graphics.setColor(Color.BLUE);
		graphics.drawRect(1, 1, width - 2, height - 2);
	}

	/**
	 * 设置背景
	 * @param graphics
	 * @version 2015年11月3日下午2:27:12
	 */
	private void setBackground(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height); // 填充
	}
}
