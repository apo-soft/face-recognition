package org.yitu.recognition.request;

import org.apache.log4j.Logger;
import org.yitu.recognition.util.HttpRequestUtil;
import org.yitu.recognition.util.YituConfig;
import org.yitu.recognition.vo.FaceFeatureRequest;
import org.yitu.recognition.vo.FaceFeatureResponse;
import org.yitu.recognition.vo.FaceQueryRequest;
import org.yitu.recognition.vo.FaceQueryResponse;

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
		return this.execute(JSON.toJSONString(face), config, url);
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
			String json = JSON.toJSONString(face);
			System.out.println("verifyRequest:" + json);
			String res = HttpRequestUtil.httpPostWithJSON(json, config, pair_url);
			response = JSON.parseObject(res, FaceQueryResponse.class);
		} catch (Exception e) {
			logger.error("特征对比失败 - Get FaceQueryResponse is wrong.", e);
		}
		return response;
	}

	private FaceFeatureResponse execute(String json, YituConfig config, String url) {
		FaceFeatureResponse response = null;
		try {
			String res = HttpRequestUtil.httpPostWithJSON(json, config, url);
			response = JSON.parseObject(res, FaceFeatureResponse.class);
		} catch (Exception e) {
			logger.error("特征抽取失败 - Get FaceFeatureResponse is wrong.", e);
		}
		return response;
	}

}
