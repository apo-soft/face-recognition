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
import org.yitu.recognition.vo.FaceQueryRequest;
import org.yitu.recognition.vo.FaceQueryResponse;

/**
 * Unit test for simple App.
 */
public class AppTest {
	static String fileName = "/company/properties/face.properties";
	static YituConfig config = new YituPropertiesConfig(fileName, "utf-8");

	/** 特征抽取 */
	private void checkFace(YituConfig config) throws FileNotFoundException {
		FaceFeatureRequest json = getContent();
		HttpClientUtil client = new HttpClientRequest(config);
		FaceFeatureResponse output = client.execute(json);
		System.out.println(output.toString());

	}

	private FaceFeatureRequest getContent() {
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

	/** 人脸验证 */
	private void verifyFace(YituConfig config) {
		FaceQueryRequest request = getQueryRequest();
		HttpClientUtil client = new HttpClientRequest(config);
		FaceQueryResponse response = client.compareExecute(request);
		System.out.println(response);
	}

	private FaceQueryRequest getQueryRequest() {
		// TODO
		return setQueryValues();
	}

	private FaceQueryRequest setQueryValues() {
		FaceQueryRequest request = new FaceQueryRequest();
		request.setDatabase_image_content("");
		request.setDatabase_image_type(2);
		request.setQuery_image_type(1);
		request.setTrue_negative_rate("99.9");
		
		request.setQuery_image_package("pack");
		request.setEnable_verify_detail(true);
		// TODO
		return request;
	}

	public static void main(String[] args) {
		AppTest app = new AppTest();

//		try {
//			app.checkFace(config);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		app.verifyFace(config);

	}

}
