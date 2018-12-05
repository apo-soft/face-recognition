package org.face.identify.faceid.vo;

/**
 * 在照片中所有找到的人脸，都以Json的形式返回，并组成一个Array。
 * 
 * @author yujinshui
 * @createTime 2016年7月12日 下午4:04:36
 */
public class Faces {
	private double quality;
	private double quality_threshold;
	private Rect rect;
	private String token;

	/**
	 * 每一个人脸都会有一个质量判断的分数。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:06:34
	 */
	public double getQuality() {
		return quality;
	}

	/**
	 * 每一个人脸都会有一个质量判断的分数。
	 * 
	 * @param quality
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:06:38
	 */
	public void setQuality(double quality) {
		this.quality = quality;
	}

	/**
	 * 表示人脸质量基本合格的一个阈值，超过该阈值的人脸适合用于人脸比对
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:06:56
	 */
	public double getQuality_threshold() {
		return quality_threshold;
	}

	/**
	 * 表示人脸质量基本合格的一个阈值，超过该阈值的人脸适合用于人脸比对
	 * 
	 * @param quality_threshold
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:07:00
	 */
	public void setQuality_threshold(double quality_threshold) {
		this.quality_threshold = quality_threshold;
	}

	/**
	 * 图片中人脸框的位置，会用一个Json表示。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:07:12
	 */
	public Rect getRect() {
		return rect;
	}

	/**
	 * 图片中人脸框的位置，会用一个Json表示。
	 * 
	 * @param rect
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:07:16
	 */
	public void setRect(Rect rect) {
		this.rect = rect;
	}

	/**
	 * 用于标示每一个人脸的唯一字符串，可以用于verify上的face_token。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:07:39
	 */
	public String getToken() {
		return token;
	}

	/**
	 * 用于标示每一个人脸的唯一字符串，可以用于verify上的face_token。
	 * 
	 * @param token
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:07:43
	 */
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Faces [quality=" + quality + ", quality_threshold=" + quality_threshold + ", rect=" + rect + ", token="
				+ token + "]";
	}

}
