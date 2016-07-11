package org.yitu.recognition.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 依图配置文件读取
 * 
 * @author yujinshui
 * @createTime 2016年7月1日 上午10:22:30
 */
public class YituPropertiesConfig implements YituConfig {
	private String YITU_URL;
	private String LOCAL_URL;
	private String YITU_PAIR_URL;
	private String LOCAL_PAIR_URL;
	private String YITU_IDCARD_URL;
	private String YITU_IDCARD_OCR_URL;

	private String ACCESS_ID;// header部分accessID(x-access-id)
	private String ACCESS_KEY;// header部分key(x-signature)

	public YituPropertiesConfig(String fileName) {
		getProperties(fileName);
	}

	public YituPropertiesConfig(String fileName, String encoding) {
		getFileProperties(fileName, encoding);
	}

	/**
	 * 读取指定位置配置文件
	 * 
	 * @param fileName
	 *            文件名
	 * @param encoding
	 *            文件编码
	 * @Author yujinshui
	 * @createTime 2016年7月1日 上午10:30:15
	 */
	private void getFileProperties(String fileName, String encoding) {
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream(fileName), encoding);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			System.out.println("读取指定路径配置失败。" + fileName);
			// logger.error("读取指定路径配置文件失败，请检查文件是否存在。" + fileName);
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(reader);
		} catch (IOException e1) {
			System.out.println("配置文件读取失败，请检查.");
			e1.printStackTrace();
		}
		setPropertiesValues(p);
	}

	/**
	 * 读取项目配置文件参数
	 * <p>
	 * 采用ISO-8859-1默认字符集
	 * 
	 * @param fileName
	 * @author Yujinshui
	 */
	private void getProperties(String fileName) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			System.out.println("配置文件读取失败，请检查.");
			e1.printStackTrace();
		}
		setPropertiesValues(p);
	}

	/**
	 * 配置文件赋值
	 * 
	 * @param p
	 * @Author yujinshui
	 * @createTime 2016年7月1日 上午10:33:35
	 */
	private void setPropertiesValues(Properties p) {
		YITU_URL = p.getProperty("YITU_URL");
		LOCAL_URL = p.getProperty("LOCAL_URL");
		YITU_PAIR_URL = p.getProperty("YITU_PAIR_URL");
		LOCAL_PAIR_URL = p.getProperty("LOCAL_PAIR_URL");
		YITU_IDCARD_URL = p.getProperty("YITU_IDCARD_URL");
		YITU_IDCARD_OCR_URL = p.getProperty("YITU_IDCARD_OCR_URL");
		ACCESS_ID = p.getProperty("ACCESS_ID");
		ACCESS_KEY = p.getProperty("ACCESS_KEY");

	}

	@Override
	public String getYITU_URL() {
		return YITU_URL;
	}

	@Override
	public String getLOCAL_URL() {
		return LOCAL_URL;
	}

	@Override
	public String getACCESS_ID() {
		return ACCESS_ID;
	}

	@Override
	public String getACCESS_KEY() {
		return ACCESS_KEY;
	}

	@Override
	public String getYITU_PAIR_URL() {
		return YITU_PAIR_URL;
	}

	@Override
	public String getLOCAL_PAIR_URL() {
		return LOCAL_PAIR_URL;
	}

	@Override
	public String getYITU_IDCARD_URL() {
		return YITU_IDCARD_URL;
	}

	@Override
	public String getYITU_IDCARD_OCR_URL() {
		return YITU_IDCARD_OCR_URL;
	}
}
