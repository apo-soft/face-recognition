package org.face.identify.faceid;

import java.io.File;

import org.face.identify.faceid.send.FaceHttpClient;
import org.face.identify.faceid.send.FaceHttpClientRequest;
import org.face.identify.faceid.util.FaceConfig;
import org.face.identify.faceid.vo.DetectRequest;
import org.face.identify.faceid.vo.DetectResponse;
import org.face.identify.faceid.vo.OcridcardRequest;
import org.face.identify.faceid.vo.OcridcardResponse;
import org.face.identify.faceid.util.FaceIDPropertiesConfig;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppFaceTest {
	String fileName = "/company/properties/faceID.properties";
	FaceConfig config = new FaceIDPropertiesConfig(fileName, "UTF-8");
	FaceHttpClient client = new FaceHttpClientRequest(config, "detect");

	@Test
	public void detect() {
		DetectRequest request = getDetectContent();
		DetectResponse res = client.execute(request);
		System.out.println(res);
	}

	@Test
	public void ocrIdcard() {
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

	// public static void main(String[] args) {
	// AppFaceTest app = new AppFaceTest();
	// // app.detect();
	// app.ocrIdcard();
	// }

}
