package org.faceID.recognition.send;

import java.io.IOException;

import org.faceID.recognition.util.FaceConfig;
import org.faceID.recognition.util.FaceHttpClientUtil;
import org.faceID.recognition.vo.DetectRequest;
import org.faceID.recognition.vo.DetectResponse;

public class FaceHttpClientRequest implements FaceHttpClient {
	private static FaceConfig config = null;

	public FaceHttpClientRequest(FaceConfig config) {
		this.config = config;
	}

	@Override
	public DetectResponse execute(DetectRequest request) {
		DetectResponse response = null;
		try {
			response = FaceHttpClientUtil.doPost(request, config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

}
