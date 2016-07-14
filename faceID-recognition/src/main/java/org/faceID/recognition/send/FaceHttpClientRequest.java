package org.faceID.recognition.send;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.faceID.recognition.util.FaceConfig;
import org.faceID.recognition.vo.DetectRequest;
import org.faceID.recognition.vo.DetectResponse;
import org.faceID.recognition.vo.OcridcardRequest;
import org.faceID.recognition.vo.OcridcardResponse;

import com.alibaba.fastjson.JSON;

public class FaceHttpClientRequest implements FaceHttpClient {
	private static FaceConfig config = null;
	private static HttpClient httpClient = null;
	private static HttpPost httppost = null;
	private static MultipartEntityBuilder builder = MultipartEntityBuilder.create();

	public FaceHttpClientRequest(FaceConfig config) {
		this.config = config;
		httpClient = HttpClients.createDefault();
		builder.addTextBody("api_key", config.getAPI_KEY());
		builder.addTextBody("api_secret", config.getAPI_SECRET());
	}

	@Override
	public DetectResponse execute(DetectRequest request) {
		checkConfig();
		DetectResponse response = null;
		try {
			response = doPost(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	private void checkConfig() {
		if (config == null) {
			throw new IllegalArgumentException("配置信息不能为NULL");
		} else if (config.getAPI_KEY() == null || "".equals(config.getAPI_KEY())) {
			throw new IllegalArgumentException("api_key信息不能为空");
		} else if (config.getAPI_SECRET() == null || "".equals(config.getAPI_SECRET())) {
			throw new IllegalArgumentException("api_secret信息不能为空");
		}
	}

	@Override
	public OcridcardResponse execute(OcridcardRequest request) {
		checkConfig();
		OcridcardResponse response = null;
		try {
			response = doPost(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 检测接口
	 * 
	 * @param detect
	 *            request信息
	 * @return
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月13日 下午11:28:47
	 */
	private DetectResponse doPost(DetectRequest detect) throws IOException {
		httppost = new HttpPost(config.getDETECT_URL());
		builder.addBinaryBody("image", detect.getImage());
		httppost.setEntity(builder.build());
		return response(DetectResponse.class);
	}

	/**
	 * 返回信息-字符串
	 * 
	 * @param <T>
	 * 
	 * @return
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月13日 下午11:26:18
	 */
	private <T> T response(Class<T> clazz) throws IOException {
		HttpResponse response = httpClient.execute(httppost);
		HttpEntity entity = response.getEntity();
		String res = EntityUtils.toString(entity, Consts.UTF_8.toString());
		return JSON.parseObject(res, clazz);
	}

	private OcridcardResponse doPost(OcridcardRequest request) throws IOException {
		httppost = new HttpPost(config.getOCRIDCARD_URL());
		builder.addBinaryBody("image", request.getImage());
		String legality = "0";// 默认：0
		if ("0".equals(request.getLegality()) || "1".equals(request.getLegality())) {
			legality = request.getLegality();
		}
		builder.addTextBody("legality", legality);
		httppost.setEntity(builder.build());
		return response(OcridcardResponse.class);
	}
}
