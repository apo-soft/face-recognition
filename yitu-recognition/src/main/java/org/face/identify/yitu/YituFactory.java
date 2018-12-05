package org.face.identify.yitu;

import org.face.identify.yitu.request.YituHttpClientRequest;
import org.face.identify.yitu.util.YituPropertiesConfig;
import org.face.identify.yitu.request.YituHttpClient;
import org.face.identify.yitu.util.YituConfig;

public class YituFactory {
	private static YituConfig config = new YituPropertiesConfig();
	private static YituHttpClient client = new YituHttpClientRequest(config);

	private YituFactory() {
	}

	public static YituHttpClient getFactory() {
		return client;
	}
}
