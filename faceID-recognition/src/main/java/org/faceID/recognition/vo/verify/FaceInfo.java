package org.faceID.recognition.vo.verify;

public class FaceInfo {
	private double quality;
	private double quality_threshold;
	private RectFace rect;

	/**
	 * Float类型，表示检测出的一张人脸图像的质量，取值［0，100］，越高越好。
	 * 
	 * @return the quality
	 */
	public double getQuality() {
		return quality;
	}

	/**
	 * Float类型，表示检测出的一张人脸图像的质量，取值［0，100］，越高越好。
	 * 
	 * @param quality
	 *            the quality to set
	 */
	public void setQuality(double quality) {
		this.quality = quality;
	}

	/**
	 * Float类型，取值［0，100］，表示FaceId建议的人脸图像质量阈值，大于此阈值可以认定图像质量足够完成比对。
	 * 
	 * @return the quality_threshold
	 */
	public double getQuality_threshold() {
		return quality_threshold;
	}

	/**
	 * Float类型，取值［0，100］，表示FaceId建议的人脸图像质量阈值，大于此阈值可以认定图像质量足够完成比对。
	 * 
	 * @param quality_threshold
	 *            the quality_threshold to set
	 */
	public void setQuality_threshold(double quality_threshold) {
		this.quality_threshold = quality_threshold;
	}

	/**
	 * 表示检测出的一张人脸在原始图像中的包围盒。它包含left、top、width、height四个Float类型字段来表示坐标，均取值［0，1］，
	 * 小数点后数字不限3位。left、top分别表示此包围盒的左上角相对于原始图像左上角的位置的比例，width、
	 * height分别表示此包围盒相对原始图像的宽、高的比例，比如 left =0.5、top=0.5、width =0.5、height＝0.5
	 * 表示该包围盒的左上角是图像正中心，右下角是图像的右下角。
	 * 
	 * @return the rect
	 */
	public RectFace getRect() {
		return rect;
	}

	/**
	 * 表示检测出的一张人脸在原始图像中的包围盒。它包含left、top、width、height四个Float类型字段来表示坐标，均取值［0，1］，
	 * 小数点后数字不限3位。left、top分别表示此包围盒的左上角相对于原始图像左上角的位置的比例，width、
	 * height分别表示此包围盒相对原始图像的宽、高的比例，比如 left =0.5、top=0.5、width =0.5、height＝0.5
	 * 表示该包围盒的左上角是图像正中心，右下角是图像的右下角。
	 * 
	 * @param rect
	 *            the rect to set
	 */
	public void setRect(RectFace rect) {
		this.rect = rect;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FaceInfo [quality=" + quality + ", quality_threshold=" + quality_threshold + ", rect=" + rect + "]";
	}

}
