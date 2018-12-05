package org.face.identify.faceid.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class FaceIDPropertiesConfig implements FaceConfig {
	private String API_KEY;
	private String API_SECRET;
	private String DETECT_URL;
	private String VERIFY_URL;
	private String OCRIDCARD_URL;

	public FaceIDPropertiesConfig() {
		getProperties("faceID.properties");
	}

	public FaceIDPropertiesConfig(String fileName) {
		getProperties(fileName);
	}

	public FaceIDPropertiesConfig(String fileName, String charset) {
		getFileProperties(fileName, charset);
	}

	/**
	 * 读取指定位置配置文件
	 * 
	 * @param fileName
	 *            文件名
	 * @param encoding
	 * @Author yujinshui 文件编码
	 * @createTime 2016年7月12日 下午2:57:26
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
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午2:58:51
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

	private void setPropertiesValues(Properties p) {
		API_KEY = p.getProperty("API_KEY");
		API_SECRET = p.getProperty("API_SECRET");
		DETECT_URL = p.getProperty("DETECT_URL");
		VERIFY_URL = p.getProperty("VERIFY_URL");
		OCRIDCARD_URL = p.getProperty("OCRIDCARD_URL");

	}

	@Override
	public String getAPI_KEY() {
		return API_KEY;
	}

	@Override
	public String getAPI_SECRET() {
		return API_SECRET;
	}

	@Override
	public String getDETECT_URL() {
		return DETECT_URL;
	}

	@Override
	public String getVERIFY_URL() {
		return VERIFY_URL;
	}

	@Override
	public String getOCRIDCARD_URL() {
		return OCRIDCARD_URL;
	}

}
