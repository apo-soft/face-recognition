package org.faceID.recognition;

import java.io.File;

import org.faceID.recognition.send.FaceHttpClient;
import org.faceID.recognition.send.FaceHttpClientRequest;
import org.faceID.recognition.util.FaceConfig;
import org.faceID.recognition.util.FaceIDPropertiesConfig;
import org.faceID.recognition.vo.DetectRequest;
import org.faceID.recognition.vo.DetectResponse;

/**
 * Unit test for simple App.
 */
public class AppFaceTest {
	String fileName = "/company/properties/faceID.properties";
	FaceConfig config = new FaceIDPropertiesConfig(fileName, "UTF-8");
	FaceHttpClient client = new FaceHttpClientRequest(config);

	private void detect() {
		DetectRequest request = getDetectContent();
		DetectResponse res = client.execute(request);
		System.out.println(res);
	}

	private DetectRequest getDetectContent() {
		DetectRequest detect = new DetectRequest();
		File image = new File("/Users/yujinshui/Desktop/img/card_1.jpg");
		detect.setImage(image);
		return detect;
	}

	public static void main(String[] args) {
		AppFaceTest app = new AppFaceTest();
		app.detect();
	}

}
