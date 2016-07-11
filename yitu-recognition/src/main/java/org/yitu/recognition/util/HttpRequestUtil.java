package org.yitu.recognition.util;

import java.net.URLEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

@SuppressWarnings({ "unused", "deprecation", "resource" })
public class HttpRequestUtil {
	private static final Logger logger = Logger.getLogger(HttpRequestUtil.class);

	private HttpRequestUtil() {
	}

	private static final String APPLICATION_JSON = "application/json";
	private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
	private static final String ISO_8859_1 = "ISO-8859-1";
	private static final String UTF_8 = "utf-8";

	/**
	 * httpclient发送post请求
	 * 
	 * @param json
	 *            json字符串
	 * @param config
	 *            配置信息
	 * @throws Exception
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午4:25:16
	 */
	public static String httpPostWithJSON(String json, YituConfig config, String url) throws Exception {
		// 将JSON进行UTF-8编码,以便传输中文
		String encoderJson = URLEncoder.encode(json, HTTP.UTF_8);

		CloseableHttpClient httpClient = HttpClients.createDefault();;
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
		httpPost.addHeader("x-access-id", config.getACCESS_ID());
		httpPost.addHeader("x-signature", config.getACCESS_KEY());

		StringEntity se = new StringEntity(json);
		se.setContentType(CONTENT_TYPE_TEXT_JSON);
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
		httpPost.setEntity(se);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		String out = EntityUtils.toString(entity);
		return new String(out.getBytes(ISO_8859_1), UTF_8);
	}

}