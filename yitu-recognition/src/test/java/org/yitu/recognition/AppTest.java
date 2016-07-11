package org.yitu.recognition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

import org.yitu.recognition.request.HttpClientRequest;
import org.yitu.recognition.request.HttpClient;
import org.yitu.recognition.util.Base64Util;
import org.yitu.recognition.util.YituConfig;
import org.yitu.recognition.util.YituPropertiesConfig;
import org.yitu.recognition.vo.FaceFeatureRequest;
import org.yitu.recognition.vo.FaceFeatureResponse;
import org.yitu.recognition.vo.FaceQueryRequest;
import org.yitu.recognition.vo.FaceQueryResponse;
import org.yitu.recognition.vo.IdcardRequest;
import org.yitu.recognition.vo.IdcardResponse;
import org.yitu.recognition.vo.Options;
import org.yitu.recognition.vo.UserInfo;

/**
 * Unit test for simple App.
 */
public class AppTest {
	static String fileName = "/company/properties/face_yitu.properties";
	static YituConfig config = new YituPropertiesConfig(fileName, "utf-8");
	HttpClient client = new HttpClientRequest(config, false, false);

	/** 特征抽取 */
	private FaceFeatureResponse checkFace(YituConfig config, String img) throws FileNotFoundException {
		FaceFeatureRequest json = getContent(img);
		FaceFeatureResponse output = client.execute(json);
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
		face.setIdcard_ocr(true);
		face.setFlip_image(true);
		return face;
	}

	/** 人脸验证 */
	private FaceQueryResponse verifyFace(YituConfig config, FaceFeatureResponse featureRes, String dataImg,
			String queryImg) {
		FaceQueryRequest request = getQueryRequest(featureRes, dataImg, queryImg);
		FaceQueryResponse response = client.compareExecute(request);
		return response;
	}

	private FaceQueryRequest getQueryRequest(FaceFeatureResponse featureRes, String dataImg, String queryImg) {
		return setQueryValues(featureRes, dataImg, queryImg);
	}

	private FaceQueryRequest setQueryValues(FaceFeatureResponse res, String dataImg, String queryImg) {
		FaceQueryRequest request = new FaceQueryRequest();
		// if (dataImg == null)
		if (res != null) {
			request.setDatabase_image_feature(res.getFeature());
			request.setQuery_image_feature(res.getFeature());
		}
		// else
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

	/**
	 * 人脸检测与验证
	 * 
	 * @param checkimg
	 * @param dataImg
	 * @param queryImg
	 * @Author yujinshui
	 * @createTime 2016年7月11日 下午10:51:46
	 */
	private void checkAndVerify(String checkimg, String dataImg, String queryImg) {
		FaceFeatureResponse featureRes = null;
		long a = System.currentTimeMillis();
		if (false) {// 判断仅供测试
			try {
				featureRes = checkFace(config, checkimg);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		long b = System.currentTimeMillis();
		// System.out.println(b - a);
		FaceQueryResponse verify = verifyFace(config, null, dataImg, queryImg);
		System.out.println("特征返回：" + featureRes);
		System.out.println("验证结果：" + verify);

		if (verify.getRtn() == 0)
			verifyPrint(verify);
		else
			System.out.println("rtn:" + verify.getRtn() + "  message:" + verify.getMessage());
	}

	private void idcardOcr(String idPic) {

		IdcardRequest request = getIdRequest(idPic);
		IdcardResponse response = client.recognizeIdcard(request);
		System.out.println(response);
	}

	private IdcardRequest getIdRequest(String idPic) {
		IdcardRequest request = new IdcardRequest();
		request.setSession_id(UUID.randomUUID().toString());
		request.setMode(1);
		request.setOptions(getOptions());
		request.setUser_info(getUserInfo(idPic));
		return request;
	}

	private Options getOptions() {
		Options option = new Options();
		option.setIdcard_ocr(true);
		option.setIdcard_ocr_mode(3);
		option.setImage_type(2);
		return option;
	}

	private UserInfo getUserInfo(String idPic) {
		UserInfo user = new UserInfo();
		user.setImage_content(getBase64Img(idPic));

		return user;
	}

	public static void main(String[] args) {
		AppTest app = new AppTest();
		String checkimg = "/Users/yujinshui/Desktop/img/he.jpg";// 特征抽取照
		String dataImg = "/Users/yujinshui/Desktop/img/he.jpg";// 已登记照
		String queryImg = "/Users/yujinshui/Desktop/img/he.jpg";// 待确认照

		String idCard = "/Users/yujinshui/Desktop/img/card_1.jpg";// 身份证正面照片
		String idCard2 = "/Users/yujinshui/Desktop/img/card_2.jpg";// 身份证反面照片

		// app.checkAndVerify(checkimg, dataImg, queryImg);
		app.idcardOcr(idCard2);
	}

}
