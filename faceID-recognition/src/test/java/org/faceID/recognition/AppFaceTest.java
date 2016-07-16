package org.faceID.recognition;

import java.io.File;

import org.faceID.recognition.send.FaceHttpClient;
import org.faceID.recognition.send.FaceHttpClientRequest;
import org.faceID.recognition.util.FaceConfig;
import org.faceID.recognition.util.FaceIDPropertiesConfig;
import org.faceID.recognition.vo.DetectRequest;
import org.faceID.recognition.vo.DetectResponse;
import org.faceID.recognition.vo.OcridcardRequest;
import org.faceID.recognition.vo.OcridcardResponse;

/**
 * Unit test for simple App.
 */
public class AppFaceTest {
	String fileName = "/company/properties/faceID.properties";
	FaceConfig config = new FaceIDPropertiesConfig(fileName, "UTF-8");
	FaceHttpClient client = new FaceHttpClientRequest(config, "detect");

	private void detect() {
		DetectRequest request = getDetectContent();
		DetectResponse res = client.execute(request);
		System.out.println(res);
	}

	private void ocrIdcard() {
		OcridcardRequest request = getOcrRequest();
		OcridcardResponse response = client.execute(request);
		System.out.println(response);
	}

	private OcridcardRequest getOcrRequest() {
		OcridcardRequest ocr = new OcridcardRequest();
		File image = new File("/Users/yujinshui/Desktop/img/card_1.jpg");
		ocr.setImage(image);
		return ocr;
	}

	private DetectRequest getDetectContent() {
		DetectRequest detect = new DetectRequest();
		File image = new File("/Users/yujinshui/Desktop/img/card_2.jpg");
		detect.setImage(image);
		return detect;
	}

	public static void main(String[] args) {
		AppFaceTest app = new AppFaceTest();
		// app.detect();
		app.ocrIdcard();
	}

}
