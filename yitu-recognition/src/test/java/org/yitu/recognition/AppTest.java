package org.yitu.recognition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.yitu.recognition.util.Base64Util;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private void fileInputTest(String imgFile) {
		try {
			FileInputStream file = new FileInputStream(imgFile);
			String output = Base64Util.getImgBase64Str(file);
			System.out.println(output);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void filePath(String imgFile) {

		String result = Base64Util.getImgBase64Str(imgFile);
		System.out.println(result);
	}

	public static void main(String[] args) {
		AppTest app = new AppTest();
		String imgFile = "/Users/yujinshui/Desktop/info.png";
		// app.filePath(imgFile);
		app.fileInputTest(imgFile);

	}

}
