package org.yitu.recognition.request;

import org.apache.log4j.Logger;
import org.yitu.recognition.util.HttpRequestUtil;
import org.yitu.recognition.util.YituConfig;
import org.yitu.recognition.vo.FaceFeatureRequest;
import org.yitu.recognition.vo.FaceFeatureResponse;
import org.yitu.recognition.vo.FaceQueryRequest;
import org.yitu.recognition.vo.FaceQueryResponse;
import org.yitu.recognition.vo.IdcardRequest;
import org.yitu.recognition.vo.IdcardResponse;

import com.alibaba.fastjson.JSON;

/**
 * 私有|公有 云请求
 * 
 * @author yujinshui
 * @createTime 2016年7月1日 下午4:33:58
 */
public class HttpClientRequest implements HttpClient {
	private static final Logger logger = Logger.getLogger(HttpClientRequest.class);
	private YituConfig config;
	private boolean verifyFlag = false;// 特征比对-测试用
	private boolean featureFlag = false;// 特征抽取-测试用

	public HttpClientRequest(YituConfig config) {
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
	public HttpClientRequest(YituConfig config, boolean featureFlag, boolean verifyFlag) {
		this.config = config;
		this.featureFlag = featureFlag;
		this.verifyFlag = verifyFlag;
	}

	/**
	 * 
	 * @see org.yitu.recognition.request.HttpClient#execute(org.yitu.recognition.vo.FaceFeatureRequest)
	 */
	@Override
	public FaceFeatureResponse execute(FaceFeatureRequest face) {
		String url = config.getLOCAL_URL();
		if (featureFlag) {
			url = config.getYITU_URL();
		}
		FaceFeatureResponse response = null;
		try {
			response = this.execute(JSON.toJSONString(face), config, url, FaceFeatureResponse.class);
		} catch (Exception e) {
			logger.error("特征抽取失败 - Get FaceFeatureResponse is wrong.", e);
		}
		return response;
	}

	/**
	 * 
	 * @see org.yitu.recognition.request.HttpClient#compareExecute(org.yitu.recognition.vo.FaceQueryRequest,
	 *      org.yitu.recognition.util.YituConfig)
	 */
	@Override
	public FaceQueryResponse compareExecute(FaceQueryRequest face) {
		FaceQueryResponse response = null;
		String pair_url = config.getYITU_PAIR_URL();
		if (verifyFlag) {// 如果true，走本地服务器平台
			pair_url = config.getLOCAL_PAIR_URL();
		}
		try {
			response = execute(JSON.toJSONString(face), config, pair_url, FaceQueryResponse.class);
		} catch (Exception e) {
			logger.error("特征对比失败 - Get FaceQueryResponse is wrong.", e);
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
		String res = HttpRequestUtil.httpPostWithJSON(json, config, url);
		response = JSON.parseObject(res, clazz);
		return response;
	}

	/**
	 * 
	 * @see org.yitu.recognition.request.HttpClient#recognizeIdcard(org.yitu.recognition.vo.IdcardRequest)
	 */
	@Override
	public IdcardResponse recognizeIdcard(IdcardRequest idCard) {
		IdcardResponse response = null;
		try {
			response = this.execute(JSON.toJSONString(idCard), config, config.getYITU_IDCARD_URL(),
					IdcardResponse.class);
		} catch (Exception e) {
			logger.error("100.1接口身份证识别异常 - Get IdcardResponse is wrong.", e);
		}
		return response;
	}

}