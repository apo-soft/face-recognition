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
	private FaceFeatureResponse checkFace(YituConfig config, String img) throws FileNotFoundException {

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
		face.setMax_faces_allowed(2);
		return face;
	}

	/** 人脸验证 */
	private FaceQueryResponse verifyFace(YituConfig config, FaceFeatureResponse featureRes, String dataImg,
			String queryImg) {
		FaceQueryRequest request = getQueryRequest(featureRes, dataImg, queryImg);
		FaceQueryResponse response = client.compareExecute(request);
		// System.out.println(response);
		return response;
	}

	private FaceQueryRequest getQueryRequest(FaceFeatureResponse featureRes, String dataImg, String queryImg) {
		return setQueryValues(featureRes, dataImg, queryImg);
	}

	private FaceQueryRequest setQueryValues(FaceFeatureResponse res, String dataImg, String queryImg) {
		FaceQueryRequest request = new FaceQueryRequest();
		if (dataImg == null)
			request.setDatabase_image_feature(res.getFeature());
		else
			request.setDatabase_image_content(getBase64Img(dataImg));
		request.setDatabase_image_type(2);
		request.setQuery_image_type(3);
		request.setQuery_image_content(getBase64Img(queryImg));
		request.setTrue_negative_rate("99.99");

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
		String checkimg = "/Users/yujinshui/Desktop/img/dan_1.jpg";// 特征抽取照
		String dataImg = "/Users/yujinshui/Desktop/img/me_1.jpg";// 已登记照
		String queryImg = "/Users/yujinshui/Desktop/img/he.jpg";// 待确认照

		try {
			featureRes = app.checkFace(config, checkimg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		FaceQueryResponse verify = app.verifyFace(config, featureRes, null, queryImg);
		if (verify.getRtn() == 0)
			app.verifyPrint(verify);
		else
			System.out.println("rtn:" + verify.getRtn() + "  message:" + verify.getMessage());
	}

}
