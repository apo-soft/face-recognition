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
	HttpClientUtil client = new HttpClientRequest(config, false, false);

	/** 特征抽取 */
	private FaceFeatureResponse checkFace(YituConfig config) throws FileNotFoundException {
		String img = "/Users/yujinshui/Desktop/img/card_1.jpg";
		FaceFeatureRequest json = getContent(img);

		FaceFeatureResponse output = client.execute(json);
		System.out.println(output.toString());
		return output;

	}

	/** 特征抽取-赋值 */
	private FaceFeatureRequest getContent(String img) {
		String output = getBase64Img(img);
		return setPrivateValue(output);

	}

	/** 得到图片的base64加密串 */
	private String getBase64Img(String img) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(img);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String output = Base64Util.getImgBase64Str(file);
		return output;
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
	private FaceQueryResponse verifyFace(YituConfig config, FaceFeatureResponse featureRes) {
		FaceQueryRequest request = getQueryRequest(featureRes);
		FaceQueryResponse response = client.compareExecute(request);
		// System.out.println(response);
		return response;
	}

	private FaceQueryRequest getQueryRequest(FaceFeatureResponse featureRes) {
		return setQueryValues(featureRes);
	}

	private FaceQueryRequest setQueryValues(FaceFeatureResponse res) {

		String img = getBase64Img("/Users/yujinshui/Desktop/img/id_1.jpg");

		FaceQueryRequest request = new FaceQueryRequest();
		request.setDatabase_image_content(img);
//		request.setDatabase_image_feature(res.getFeature());
		request.setDatabase_image_type(2);
		request.setQuery_image_type(3);
		request.setQuery_image_feature(res.getFeature());
		request.setTrue_negative_rate("99.999");

		// request.setQuery_image_package("pack");
		// request.setEnable_verify_detail(true);
		return request;
	}

	private void verifyPrint(FaceQueryResponse verify) {

		System.out.println(verify.getPair_verify_result() == 0 ? "同一个人" : "不同人员");
		System.out.println("相似值：" + verify.getPair_verify_similarity());
		// System.out.println(verify);
		// System.out.println(verify);
		// System.out.println(verify);
		// System.out.println(verify);
	}

	public static void main(String[] args) {
		AppTest app = new AppTest();
		FaceFeatureResponse featureRes = null;
		try {
			featureRes = app.checkFace(config);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FaceQueryResponse verify = app.verifyFace(config, featureRes);
		if (verify.getRtn() == 0)
			app.verifyPrint(verify);
		else
			System.out.println("rtn:" + verify.getRtn() + "  message:" + verify.getMessage());
	}

}
