package org.yitu.recognition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;
import org.yitu.recognition.request.YituHttpClientRequest;
import org.junit.Test;
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
import org.yitu.recognition.vo.ImgPackageRequest;
import org.yitu.recognition.vo.ImgPackageResponse;
import org.yitu.recognition.vo.Options;
import org.yitu.recognition.vo.UserInfo;

import com.alibaba.fastjson.JSONObject;

/**
 * Unit test for simple App.
 */
public class AppTest {

	static String fileName = "/company/properties/face_yitu.properties";
	static YituConfig config = new YituPropertiesConfig(fileName, "utf-8");
	static YituHttpClient client = new YituHttpClientRequest(config, false, false);

	public AppTest() {
		System.out.println(config.getLOCAL_URL());
	}

	/** 特征抽取 */
	@Test
	public void checkFace() {
		FaceFeatureResponse res = checkFace("/Users/yujinshui/Desktop/img/a.jpg");
		System.out.println(res);
	}

	private FaceFeatureResponse checkFace(String img) {
		FaceFeatureRequest json = getContent(img);
		FaceFeatureResponse output = client.execute(json);
		return output;
	}

	private FaceFeatureResponse checkFace(String img, int imgType) {
		FaceFeatureRequest json = getContent(img, imgType);
		FaceFeatureResponse output = client.execute(json);
		return output;
	}

	/** 特征抽取-赋值 */
	private FaceFeatureRequest getContent(String img) {
		String output = getBase64Img(img);
		// System.out.println("base64编码：" + output);
		FaceFeatureRequest face = new FaceFeatureRequest();
		face.setImage_content(output);
		face.setImage_type(3);
		face.setIdcard_ocr(true);
		face.setIdcard_ocr_mode(1);
		face.setMax_faces_allowed(2);
		face.setIdcard_ocr(true);
		face.setFlip_image(true);
		return face;
	}

	/** 特征抽取-赋值 */
	private FaceFeatureRequest getContent(String img, int imgType) {
		String output = getBase64Img(img);
		// System.out.println("base64编码：" + output);
		FaceFeatureRequest face = new FaceFeatureRequest();
		face.setImage_content(output);
		face.setImage_type(imgType);
		face.setIdcard_ocr(true);
		face.setIdcard_ocr_mode(1);
		face.setMax_faces_allowed(2);
		face.setIdcard_ocr(true);
		face.setFlip_image(true);
		return face;
	}

	/** 得到图片的base64加密串 */
	public String getBase64Img(String img) {
		return YituBase64Util.getImgBase64Str(img);
	}

	/** 人脸验证 */
	public FaceQueryResponse verifyFace(FaceFeatureResponse featureRes, String dataImg, String queryImg) {
		FaceQueryRequest request = getQueryRequest(featureRes, dataImg, queryImg);
		FaceQueryResponse response = client.compareExecute(request);
		return response;
	}

	/**
	 * 
	 * @param res1
	 *            基准照
	 * @param res2
	 *            待检测照
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年8月3日 下午5:01:25
	 */
	public FaceQueryResponse verifyFace(FaceFeatureResponse res1, FaceFeatureResponse res2) {
		FaceQueryRequest request = getQueryRequest(res1, res2);
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
		} else {
			request.setDatabase_image_content(getBase64Img(dataImg));
			request.setQuery_image_content(getBase64Img(queryImg));
		}
		request.setDatabase_image_type(3);
		request.setQuery_image_type(3);
		request.setTrue_negative_rate("99.99");

		// request.setQuery_image_package("pack");
		// request.setEnable_verify_detail(true);
		return request;
	}

	/**
	 * 人脸验证参数赋值
	 * 
	 * @param res1
	 *            基准照特征
	 * @param res2
	 *            待检测照特征
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月27日 下午10:36:21
	 */
	private FaceQueryRequest getQueryRequest(FaceFeatureResponse res1, FaceFeatureResponse res2) {
		FaceQueryRequest request = new FaceQueryRequest();
		request.setDatabase_image_feature(res1.getFeature());
		request.setQuery_image_feature(res2.getFeature());
		request.setDatabase_image_type(9);
		request.setQuery_image_type(3);
		request.setTrue_negative_rate("99.999");

		// request.setQuery_image_package("pack");
		// request.setEnable_verify_detail(true);
		System.out.println(JSONObject.toJSONString(request));
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
			featureRes = checkFace(checkimg);
		}
		long b = System.currentTimeMillis();
		System.out.println(featureRes);
		FaceQueryResponse verify = verifyFace(featureRes, dataImg, queryImg);
		System.out.println("特征返回：" + featureRes);
		System.out.println("验证结果：" + verify);

		if (verify.getRtn() == 0)
			verifyPrint(verify);
		else
			System.out.println("rtn:" + verify.getRtn() + " message:" + verify.getMessage());
	}

	/**
	 * 100.1接口
	 * 
	 * @param idPic
	 * @Author yujinshui
	 * @createTime 2016年7月12日 上午10:13:43
	 */
	@Test
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
		request.setMode(2);
		request.setOptions(getOptions());
		request.setUser_info(getUserInfo(idPic, request));
		return request;
	}

	private Options getOptions() {
		Options option = new Options();
		option.setIdcard_ocr(true);
		option.setIdcard_ocr_mode(3);
		option.setImage_type(2);
		// option.setRemove_watermark(true);
		return option;
	}

	private UserInfo getUserInfo(String idPic, IdcardRequest request) {
		UserInfo user = new UserInfo();
		if (request.getMode() == 1)
			user.setImage_content(getBase64Img(idPic));
		else if (request.getMode() == 2) {
			FaceFeatureResponse res = checkFace(idPic);
			user.setFeature_content(res.getFeature());
		}
		return user;
	}

	/** 101.3 sdk照片解析接口 */
	@Test
	public void sdkPic(String img) {
		ImgPackageRequest imgpack = getImgPackage(img);
		ImgPackageResponse res = client.checkImgPackage(imgpack);
		System.out.println("特征码：" + res.getQuery_image_package_result().getFeature_string());
		if (res.getRtn() == 0) {
			String pic = res.getQuery_image_package_result().getQuery_image_contents()[0];
			YituBase64Util.getBase64ToImg(pic, "/Users/yujinshui/Desktop/");
		}

		System.out.println(res);
	}

	private ImgPackageRequest getImgPackage(String query_image_package) {
		ImgPackageRequest img = new ImgPackageRequest();
		img.setQuery_image_package(query_image_package);
		// img.setQuery_image_package_check_same_person(true);
		img.setQuery_image_package_return_feature_string(true);
		img.setQuery_image_package_return_image_list(true);
		return img;
	}

	public static void main(String[] args) {
		AppTest app = new AppTest();
		String checkImg = "/Users/yujinshui/Desktop/img/a.jpg";// 特征抽取照
		String dataImg = "/Users/yujinshui/Desktop/img/he.jpg";// 已登记照
		String queryImg = "/Users/yujinshui/Desktop/img/he.jpg";// 待确认照

		String idCard = "/Users/yujinshui/Desktop/img/card_1.jpg";// 身份证正面照片
		// String idCard = "/Users/yujinshui/Downloads/11.jpg";//
		String idCard2 = "/Users/yujinshui/Desktop/img/card_2.jpg";// 身份证反面照片
		String normal = "/Users/yujinshui/Desktop/img/me_glass.jpg";// 待检测照片
		// app.idcardOcr(idCard);
		// app.checkAndVerify(checkImg, dataImg, queryImg);
		/***********************/
		
		YituBase64Util.getBase64ToImg(null, "/Users/yujinshui/Desktop/");
		String name = "wang";
		String img1 = "/Users/yujinshui/Desktop/" + name + ".jpg";
		String img2 = "/Users/yujinshui/Desktop/" + name + "_1.jpg";
		// FaceFeatureResponse res1 = app.checkFace(img1, 3);
		// FaceFeatureResponse res2 = app.checkFace(img2, 3);
		// System.out.println("基准照：" + res1.getFeature());
		// System.out.println("比对照：" + res2.getFeature());
		// FaceQueryRequest request = app.getQueryRequest(res1, res2);
		// FaceQueryResponse response = client.compareExecute(request);
		// // System.out.println("网纹特征码：" + res1.getFeature());
		// Integer res = response.getPair_verify_result();
		// if (res != null)
		// System.out.println((response.getPair_verify_result() == 0 ? name +
		// "同一人" : name + "不同人")
		// + response.getPair_verify_similarity());
		// System.out.println(response);
		System.out.println("Execute is ok.");
	}

}
