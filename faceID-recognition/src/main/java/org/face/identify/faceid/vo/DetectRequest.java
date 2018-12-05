package org.face.identify.faceid.vo;

import java.io.File;

/**
 * 人脸检测接口
 * 
 * @author yujinshui
 * @createTime 2016年7月12日 下午3:58:06
 */
public class DetectRequest {
	private File image;

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}
}
