package org.yitu.recognition.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import org.apache.commons.codec.binary.Base64;

public class YituBase64Util {

	private YituBase64Util() {

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
		return Base64.encodeBase64String(data);
		
	}
	
	

	/**
	 * 将字符串转化为base64加密串
	 * 
	 * @param str
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年8月14日 下午9:30:28
	 */
	public static String getStringBase64Str(String str) {
		return Base64.encodeBase64String(str.getBytes()).replaceAll("\r|\n", "");
	}
	public static String getStringBase64Str1(String str) {
		return Base64.encodeBase64URLSafeString(str.getBytes()).replaceAll("\r|\n", "");
	}
	public static void main(String[] args) {
		String ba1 = getStringBase64Str("hello/world");
		String ba2 = getStringBase64Str1("hello/world");
		System.out.println(ba1);
		System.out.println(ba2);
		System.out.println(ba1.equals(ba2));
		
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
	public static String getImgBase64Str(InputStream in) {
		byte[] data = null;
		try {
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		BASE64Encoder encoder = new BASE64Encoder();
//		return encoder.encode(data).replaceAll("\r|\n", "");
		return Base64.encodeBase64URLSafeString(data).replaceAll("\r|\n", "");
	}

	/**
	 * base64编码图片还原
	 * 
	 * @param imgStr
	 *            base64位编码的图片
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 上午10:49:42
	 */
	public static byte[] getBase64ToImg(String imgStr) {
		if (imgStr == null) {
			return null;
		}
//		BASE64Decoder decoder = new BASE64Decoder();

		byte[] b = null;
//		try {
//			b = decoder.decodeBuffer(imgStr);
			b = Base64.decodeBase64(imgStr);
			for (int i = 0; i < b.length; i++) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return b;
	}

	/**
	 * 在服务器设定位置生成图片
	 * 
	 * @param imgStr
	 * @param savePath
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 上午10:55:18
	 */
	public static String getBase64ToImg(String imgStr, String savePath) {
		if (imgStr == null || savePath == null) {
			return null;
		}
		byte[] b = getBase64ToImg(imgStr);
		String imgPath = savePath + UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
		try {
			OutputStream out = new FileOutputStream(imgPath);
			out.write(b);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return imgPath;
	}

}
