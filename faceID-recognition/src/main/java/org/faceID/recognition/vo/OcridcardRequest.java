package org.faceID.recognition.vo;

import java.io.File;

/**
 * 身份证识别请求
 * 
 * @author yujinshui
 * @createTime 2016年7月13日 下午11:31:35
 */
public class OcridcardRequest {
	private File image;
	private String legality;

	/**
	 * 一个图片，二进制文件，需要用post multipart/form-data的方式上传。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月13日 下午11:38:22
	 */
	public File getImage() {
		return image;
	}

	/**
	 * 一个图片，二进制文件，需要用post multipart/form-data的方式上传。
	 * 
	 * @param image
	 * @Author yujinshui
	 * @createTime 2016年7月13日 下午11:38:27
	 */
	public void setImage(File image) {
		this.image = image;
	}

	/**
	 * 返回身份证照片合法性检查结果，值只取“0”或“1”。“1”：返回； “0”：不返回。默认“0”。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月13日 下午11:38:50
	 */
	public String getLegality() {
		return legality;
	}

	/**
	 * 返回身份证照片合法性检查结果，值只取“0”或“1”。“1”：返回； “0”：不返回。默认“0”。
	 * 
	 * @param legality
	 * @Author yujinshui
	 * @createTime 2016年7月13日 下午11:38:54
	 */
	public void setLegality(String legality) {
		this.legality = legality;
	}

}
