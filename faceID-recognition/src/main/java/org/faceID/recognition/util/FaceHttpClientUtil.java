package org.faceID.recognition.util;

import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.faceID.recognition.vo.DetectRequest;
import org.faceID.recognition.vo.DetectResponse;
import com.alibaba.fastjson.JSON;

public class FaceHttpClientUtil {
	private FaceHttpClientUtil() {
	}

	/**
	 * 检测接口
	 * 
	 * @param detect
	 *            请求信息
	 * @param config
	 *            配置信息
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午5:35:10
	 */
	public static DetectResponse doPost(DetectRequest detect, FaceConfig config) throws IOException {
		return postDetect(detect, config);
	}

	/**
	 * 检测接口
	 * 
	 * @param detect
	 *            请求信息
	 * @param config
	 *            配置信息
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午5:35:10
	 * @deprecated
	 */
	private static DetectResponse postDetectRequest(DetectRequest detect, FaceConfig config) throws IOException {
		HttpClient httpClient = null;
		HttpPost httppost = new HttpPost(config.getDETECT_URL());
		httpClient = HttpClients.createDefault();
		MultipartEntity entityInput = new MultipartEntity();
		entityInput.addPart("api_key", new StringBody(config.getAPI_KEY(), Charset.forName("UTF-8")));
		entityInput.addPart("api_secret", new StringBody(config.getAPI_SECRET(), Charset.forName("UTF-8")));
		entityInput.addPart("image", new FileBody(detect.getImage()));
		httppost.setEntity(entityInput);
		HttpResponse response = httpClient.execute(httppost);
		HttpEntity entity = response.getEntity();
		String res = EntityUtils.toString(entity);
		DetectResponse detectRes = JSON.parseObject(res, DetectResponse.class);

		return detectRes;
	}

	/**
	 * 检测接口
	 * 
	 * @param detect
	 *            请求信息
	 * @param config
	 *            配置信息
	 * @return
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月13日 下午2:57:08
	 */
	private static DetectResponse postDetect(DetectRequest detect, FaceConfig config) throws IOException {
		HttpClient httpClient = null;
		HttpPost httppost = new HttpPost(config.getDETECT_URL());
		httpClient = HttpClients.createDefault();
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addTextBody("api_key", config.getAPI_KEY());
		builder.addTextBody("api_secret", config.getAPI_SECRET());
		builder.addBinaryBody("image", detect.getImage());
		httppost.setEntity(builder.build());
		HttpResponse response = httpClient.execute(httppost);
		HttpEntity entity = response.getEntity();
		String res = EntityUtils.toString(entity);
		DetectResponse detectRes = JSON.parseObject(res, DetectResponse.class);

		return detectRes;
	}
}
