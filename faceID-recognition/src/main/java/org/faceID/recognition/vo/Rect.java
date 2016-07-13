package org.faceID.recognition.vo;

public class Rect {
	private double left;
	private double top;
	private double width;
	private double height;

	/**
	 * 人脸框的左上角（以图片宽度的比例给出）的x坐标。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:07:59
	 */
	public double getLeft() {
		return left;
	}

	/**
	 * 人脸框的左上角（以图片宽度的比例给出）的x坐标。
	 * 
	 * @param left
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:08:03
	 */
	public void setLeft(double left) {
		this.left = left;
	}

	/**
	 * 人脸框的左上角（以图片高度的比例给出）的y坐标。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:08:12
	 */
	public double getTop() {
		return top;
	}

	/**
	 * 人脸框的左上角（以图片高度的比例给出）的y坐标。
	 * 
	 * @param top
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:08:17
	 */
	public void setTop(double top) {
		this.top = top;
	}

	/**
	 * 人脸框的宽度（以图片宽度的比例给出）。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:08:26
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * 人脸框的宽度（以图片宽度的比例给出）。
	 * 
	 * @param width
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:08:29
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * 人脸框的高度（以图片高度的比例给出）。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:08:39
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * 人脸框的高度（以图片高度的比例给出）。
	 * 
	 * @param height
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:08:43
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rect [left=" + left + ", top=" + top + ", width=" + width + ", height=" + height + "]";
	}

}
