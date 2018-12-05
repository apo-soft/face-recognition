package org.face.identify.faceid.vo.verify;

import java.io.File;

/**
 * 活体检测参数请求
 * 
 * @author yujinshui
 * @createTime 2016年7月15日 下午11:46:59
 */
public class MegliveRequest {
	private String delta;

	private File image_best;
	private File image_env;
	private File[] image_action;

	/**
	 * 在配合MegLive SDK使用时，用于校验上传数据的校验字符串，此字符串会由MegLive SDK直接返回。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:45:36
	 */
	public String getDelta() {
		return delta;
	}

	/**
	 * 在配合MegLive SDK使用时，用于校验上传数据的校验字符串，此字符串会由MegLive SDK直接返回。
	 * 
	 * @param delta
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:45:40
	 */
	public void setDelta(String delta) {
		this.delta = delta;
	}

	/**
	 * 此参数请传MegLive SDK返回的质量最佳的人脸图片。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:45:51
	 */
	public File getImage_best() {
		return image_best;
	}

	/**
	 * 此参数请传MegLive SDK返回的质量最佳的人脸图片。
	 * 
	 * @param image_best
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:45:55
	 */
	public void setImage_best(File image_best) {
		this.image_best = image_best;
	}

	/**
	 * 此参数可选，用于假脸判定，请传MegLive
	 * SDK返回的用作云端假脸攻击判定的照片，FaceID将使用image_env进行假脸判定，完整返回face_genuineness对象中的所有字段
	 * 。注意：此参数需要MegLive SDK 2.4.1版本以及更新的版本配合支持，低于2.4.1版本的MegLive SDK不返回这张照片。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:46:10
	 */
	public File getImage_env() {
		return image_env;
	}

	/**
	 * 此参数可选，用于假脸判定，请传MegLive
	 * SDK返回的用作云端假脸攻击判定的照片，FaceID将使用image_env进行假脸判定，完整返回face_genuineness对象中的所有字段
	 * 。注意：此参数需要MegLive SDK 2.4.1版本以及更新的版本配合支持，低于2.4.1版本的MegLive SDK不返回这张照片。
	 * 
	 * @param image_env
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:46:18
	 */
	public void setImage_env(File image_env) {
		this.image_env = image_env;
	}

	/**
	 * 此字段可以传输多个文件，均为MegLive
	 * SDK返回的活体检测图片，其名称也由SDK来确定。其中1<=x<=5，即表示可以传最多五个活体检测图(参数分别为image_action1,
	 * image_action2, …, image_action5)
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:46:37
	 */
	public File[] getImage_action() {
		return image_action;
	}

	/**
	 * 此字段可以传输多个文件，均为MegLive
	 * SDK返回的活体检测图片，其名称也由SDK来确定。其中1<=x<=5，即表示可以传最多五个活体检测图(参数分别为image_action1,
	 * image_action2, …, image_action5)
	 * 
	 * @param image_action
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:46:43
	 */
	public void setImage_action(File[] image_action) {
		this.image_action = image_action;
	}

}
