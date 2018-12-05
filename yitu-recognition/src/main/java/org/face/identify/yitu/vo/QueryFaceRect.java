package org.face.identify.yitu.vo;

/**
 * 查询照每张人脸的矩形位置,包含左上角坐标、矩形的宽度和高度
 * 
 * @author yujinshui
 * @createTime 2016年7月2日 下午3:16:37
 */
public class QueryFaceRect {
	private Integer h;
	private Integer w;
	private Integer x;
	private Integer y;

	/**
	 * 人脸矩形高度
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:19:42
	 */
	public Integer getH() {
		return h;
	}

	/**
	 * 人脸矩形高度
	 * 
	 * @param h
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:20:09
	 */
	public void setH(Integer h) {
		this.h = h;
	}

	/**
	 * 人脸矩形宽度
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:20:14
	 */
	public Integer getW() {
		return w;
	}

	/**
	 * 人脸矩形宽度
	 * 
	 * @param w
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:20:27
	 */
	public void setW(Integer w) {
		this.w = w;
	}

	/**
	 * 坐标X
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:20:48
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * 坐标Y
	 * 
	 * @param x
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:20:57
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "QueryFaceRect [h=" + h + ", w=" + w + ", x=" + x + ", y=" + y + "]";
	}

}
