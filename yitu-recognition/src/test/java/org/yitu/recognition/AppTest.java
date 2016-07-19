package org.yitu.recognition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

import org.yitu.recognition.request.YituHttpClientRequest;
import org.yitu.recognition.request.YituHttpClient;
import org.yitu.recognition.util.YituBase64Util;
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
	YituHttpClient client = new YituHttpClientRequest(config, false, false);

	/** 特征抽取 */
	public FaceFeatureResponse checkFace(YituConfig config, String img) {
		FaceFeatureRequest json = getContent(img);
		FaceFeatureResponse output = client.execute(json);
		return output;
	}

	/** 特征抽取-赋值 */
	private FaceFeatureRequest getContent(String img) {
		String output = getBase64Img(img);

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

	/** 得到图片的base64加密串 */
	public String getBase64Img(String img) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(img);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String output = YituBase64Util.getImgBase64Str(file);
		return output;
	}

	/** 人脸验证 */
	public FaceQueryResponse verifyFace(YituConfig config, FaceFeatureResponse featureRes, String dataImg,
			String queryImg) {
		FaceQueryRequest request = getQueryRequest(featureRes, dataImg, queryImg);
		FaceQueryResponse response = client.compareExecute(request);
		return response;
	}

	/** 人脸验证参数赋值 */
	private FaceQueryRequest getQueryRequest(FaceFeatureResponse res, String dataImg, String queryImg) {
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
	public void checkAndVerify(String checkimg, String dataImg, String queryImg) {
		FaceFeatureResponse featureRes = null;
		long a = System.currentTimeMillis();
		if (true) {// 判断仅供测试
			featureRes = checkFace(config, checkimg);
		}
		long b = System.currentTimeMillis();
		System.out.println(featureRes);
		// FaceQueryResponse verify = verifyFace(config, featureRes, dataImg,
		// queryImg);
		// System.out.println("特征返回：" + featureRes);
		// System.out.println("验证结果：" + verify);
		//
		// if (verify.getRtn() == 0)
		// verifyPrint(verify);
		// else
		// System.out.println("rtn:" + verify.getRtn() + " message:" +
		// verify.getMessage());
	}

	/**
	 * 100.1接口
	 * 
	 * @param idPic
	 * @Author yujinshui
	 * @createTime 2016年7月12日 上午10:13:43
	 */
	public void idcardOcr(String idPic) {

		IdcardRequest request = getIdRequest(idPic);
		IdcardResponse response = client.recognizeIdcard(request);
		// String imgStr =
		// response.getWatermark_result().getProcessed_image_content();
		// /// Users/yujinshui/Desktop
		// String result = Base64Util.getBase64ToImg(imgStr,
		// "/Users/yujinshui/Desktop/");
		// System.out.println("图片路径：" + result);
		System.out.println(response);
	}

	private IdcardRequest getIdRequest(String idPic) {
		IdcardRequest request = new IdcardRequest();
		request.setSession_id(UUID.randomUUID().toString());
		request.setMode(1);
		request.setOptions(getOptions());
		request.setUser_info(getUserInfo(idPic, request));
		return request;
	}

	private Options getOptions() {
		Options option = new Options();
		option.setIdcard_ocr(true);
		option.setIdcard_ocr_mode(3);
		option.setImage_type(2);
		option.setRemove_watermark(true);
		return option;
	}

	private UserInfo getUserInfo(String idPic, IdcardRequest request) {
		UserInfo user = new UserInfo();
		if (request.getMode() == 1)
			user.setImage_content(getBase64Img(idPic));
		else if (request.getMode() == 2) {
			FaceFeatureResponse res = checkFace(config, idPic);
			user.setFeature_content(res.getFeature());
		}
		return user;
	}

	public static void main(String[] args) {
		AppTest app = new AppTest();
		String checkImg = "/Users/yujinshui/Desktop/img/qqq.jpg";// 特征抽取照
		String dataImg = "/Users/yujinshui/Desktop/img/he.jpg";// 已登记照
		String queryImg = "/Users/yujinshui/Desktop/img/he.jpg";// 待确认照

		String idCard = "/Users/yujinshui/Desktop/img/card_1.jpg";// 身份证正面照片
		// String idCard = "/Users/yujinshui/Downloads/11.jpg";//
		String idCard2 = "/Users/yujinshui/Desktop/img/card_2.jpg";// 身份证反面照片

		app.checkAndVerify(checkImg, dataImg, queryImg);
		// app.idcardOcr(idCard);
	}

}
