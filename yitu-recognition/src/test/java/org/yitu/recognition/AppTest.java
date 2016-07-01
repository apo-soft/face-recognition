package org.yitu.recognition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.yitu.recognition.request.HttpClientRequest;
import org.yitu.recognition.request.HttpClientUtil;
import org.yitu.recognition.util.Base64Util;
import org.yitu.recognition.util.YituConfig;
import org.yitu.recognition.util.YituPropertiesConfig;
import org.yitu.recognition.vo.FaceFeatureRequest;
import org.yitu.recognition.vo.FaceFeatureResponse;

import com.alibaba.fastjson.JSON;

/**
 * Unit test for simple App.
 */
public class AppTest {
	static String fileName = "/company/properties/face.properties";
	static YituPropertiesConfig config = new YituPropertiesConfig(fileName, "utf-8");

	private void test(YituConfig config) throws FileNotFoundException {

		FaceFeatureRequest json = getContent();
		HttpClientUtil client = new HttpClientRequest();
		FaceFeatureResponse output = client.execute(json, config);
		System.out.println(output.toString());

	}

	FaceFeatureRequest getContent() {
		FileInputStream file = null;
		try {
			file = new FileInputStream("/Users/yujinshui/Desktop/img/net.jpg");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String output = Base64Util.getImgBase64Str(file);
		return setPrivateValue(output);

	}

	public FaceFeatureRequest setPrivateValue(String output) {
		FaceFeatureRequest face = new FaceFeatureRequest();
		face.setImage_content(output);
		face.setImage_type(2);
		face.setIdcard_ocr(true);
		face.setIdcard_ocr_mode(1);
		return face;
	}

	public static void main(String[] args) {
		AppTest app = new AppTest();

		try {
			app.test(config);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
