package org.yitu.recognition.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.misc.BASE64Encoder;

public class Base64Util {

	private Base64Util() {

	}

	/**
	 * 将图片转化为base64字符串
	 * 
	 * @param imgFile
	 *            图片文件【包含路径】
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年6月30日 下午7:03:13
	 */
	public static String getImgBase64Str(String imgFile) {
		InputStream in = null;
		byte[] data = null;

		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();

		return encoder.encode(data);
	}

	/**
	 * 将图片转化为base64字符串
	 * 
	 * @param in
	 *            文件输入流
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年6月30日 下午7:24:35
	 */
	public static String getImgBase64Str(FileInputStream in) {
		byte[] data = null;
		try {
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

}
