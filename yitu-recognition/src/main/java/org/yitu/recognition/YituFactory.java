package org.yitu.recognition;

import org.yitu.recognition.request.YituHttpClient;
import org.yitu.recognition.request.YituHttpClientRequest;
import org.yitu.recognition.util.YituConfig;
import org.yitu.recognition.util.YituPropertiesConfig;

public class YituFactory {
	private static YituConfig config = new YituPropertiesConfig();
	private static YituHttpClient client = new YituHttpClientRequest(config);

	private YituFactory() {
	}

	public static YituHttpClient getFactory() {
		return client;
	}
}
