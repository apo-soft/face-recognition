package org.yitu.recognition;

import org.yitu.recognition.request.HttpClient;
import org.yitu.recognition.request.HttpClientRequest;
import org.yitu.recognition.util.YituConfig;
import org.yitu.recognition.util.YituPropertiesConfig;

public class YituFactory {
	private static YituConfig config = new YituPropertiesConfig();
	private static HttpClient client = new HttpClientRequest(config);

	private YituFactory() {
	}

	public static HttpClient getFactory() {
		return client;
	}
}
