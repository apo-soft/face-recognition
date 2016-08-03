package org.yitu.recognition.request;

import org.apache.log4j.Logger;
import org.yitu.recognition.util.YituHttpRequestUtil;
import org.yitu.recognition.util.YituConfig;
import org.yitu.recognition.vo.FaceFeatureRequest;
import org.yitu.recognition.vo.FaceFeatureResponse;
import org.yitu.recognition.vo.FaceQueryRequest;
import org.yitu.recognition.vo.FaceQueryResponse;
import org.yitu.recognition.vo.IdcardRequest;
import org.yitu.recognition.vo.IdcardResponse;
import org.yitu.recognition.vo.ImgPackageRequest;
import org.yitu.recognition.vo.ImgPackageResponse;

import com.alibaba.fastjson.JSON;

/**
 * 私有|公有 云请求
 * 
 * @author yujinshui
 * @createTime 2016年7月1日 下午4:33:58
 */
public class YituHttpClientRequest implements YituHttpClient {
	private static final Logger logger = Logger.getLogger(YituHttpClientRequest.class);
	private YituConfig config;
	private boolean verifyFlag = false;// 特征比对-测试用
	private boolean featureFlag = false;// 特征抽取-测试用

	public YituHttpClientRequest(YituConfig config) {
		this.config = config;
	}

	/**
	 * 测试用
	 * 
	 * @param config
	 * @param featureFlag
	 *            特征抽取【true:公有云，false，私有云。默认false】
	 * @param verifyFlag
	 *            特征比对【true：私有云，false：公有云。默认false】
	 */
	public YituHttpClientRequest(YituConfig config, boolean featureFlag, boolean verifyFlag) {
		this.config = config;
		this.featureFlag = featureFlag;
		this.verifyFlag = verifyFlag;
	}

	/**
	 * 配置信息验证接口
	 * 
	 * @param config
	 * @Author yujinshui
	 * @createTime 2016年7月12日 上午11:34:06
	 */
	private final void checkConfig(YituConfig config) {
		if (config == null) {
			throw new IllegalArgumentException("配置信息不能为NULL");
		}
		if (config.getACCESS_ID() == null || config.getACCESS_ID().isEmpty()) {
			throw new IllegalArgumentException("ID配置信息不能为空");

		}
		if (config.getACCESS_KEY() == null || config.getACCESS_KEY().isEmpty()) {
			throw new IllegalArgumentException("ACCESS_KEY配置信息不能为空");
		}
	}

	/**
	 * 
	 * @see org.yitu.recognition.request.YituHttpClient#execute(org.yitu.recognition.vo.FaceFeatureRequest)
	 */
	@Override
	public FaceFeatureResponse execute(FaceFeatureRequest face) {
		checkConfig(config);
		String url = config.getLOCAL_URL();
		if (featureFlag) {
			url = config.getYITU_URL();
		}
		FaceFeatureResponse response = null;

		try {
			response = this.execute(JSON.toJSONString(face), config, url, FaceFeatureResponse.class);
		} catch (Exception e) {
			logger.error("特征抽取失败 - Get FaceFeatureResponse is wrong.", e);
			System.out.println("特征抽取失败 - Get FaceFeatureResponse is wrong.");
		}
		return response;
	}

	/**
	 * 
	 * @see org.yitu.recognition.request.YituHttpClient#compareExecute(org.yitu.recognition.vo.FaceQueryRequest,
	 *      org.yitu.recognition.util.YituConfig)
	 */
	@Override
	public FaceQueryResponse compareExecute(FaceQueryRequest face) {
		checkConfig(config);
		FaceQueryResponse response = null;
		String pair_url = config.getYITU_PAIR_URL();
		if (verifyFlag) {// 如果true，走本地服务器平台
			pair_url = config.getLOCAL_PAIR_URL();
		}
		try {
			response = execute(JSON.toJSONString(face), config, pair_url, FaceQueryResponse.class);
		} catch (Exception e) {
			logger.error("特征对比失败 - Get FaceQueryResponse is wrong.", e);
			System.out.println("特征对比失败 - Get FaceQueryResponse is wrong.");
		}

		return response;

	}

	/**
	 * 统一调用封装
	 * 
	 * @param json
	 *            json实体
	 * @param config
	 *            配置信息
	 * @param url
	 *            请求URL
	 * @param clazz
	 *            返回数据bean
	 * @return
	 * @throws Exception
	 * @Author yujinshui
	 * @createTime 2016年7月11日 下午10:28:35
	 */
	private <T> T execute(String json, YituConfig config, String url, Class<T> clazz) throws Exception {
		T response = null;
		String res = YituHttpRequestUtil.httpPostWithJSON(json, config, url);
		response = JSON.parseObject(res, clazz);
		return response;
	}

	/**
	 * 
	 * @see org.yitu.recognition.request.YituHttpClient#recognizeIdcard(org.yitu.recognition.vo.IdcardRequest)
	 */
	@Override
	public IdcardResponse recognizeIdcard(IdcardRequest idCard) {
		checkConfig(config);
		IdcardResponse response = null;
		try {
			response = this.execute(JSON.toJSONString(idCard), config, config.getYITU_IDCARD_URL(),
					IdcardResponse.class);
		} catch (Exception e) {
			logger.error("100.1接口身份证识别异常 - Get IdcardResponse is wrong.", e);
			System.out.println("100.1接口身份证识别异常 - Get IdcardResponse is wrong.");
		}
		return response;
	}

	/**
	 * 
	 * @see org.yitu.recognition.request.YituHttpClient#transImgPackage(org.yitu.recognition.vo.ImgPackageRequest)
	 */
	@Override
	public ImgPackageResponse checkImgPackage(ImgPackageRequest request) {
		checkConfig(config);
		ImgPackageResponse response = null;
		try {
			response = this.execute(JSON.toJSONString(request), config, config.getYITU_CHECK_IMAGE_PACKAGE_URL(),
					ImgPackageResponse.class);
		} catch (Exception e) {
			logger.error("101.3sdk图片解析异常 - Get ImgPackageResponse is wrong.", e);
			System.out.println("101.3sdk图片解析异常 - Get ImgPackageResponse is wrong.");
		}
		return response;
	}

}
