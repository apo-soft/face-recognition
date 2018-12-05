package org.face.identify.faceid.vo;

/**
 * x与y的坐标值
 * 
 * @author yujinshui
 * @createTime 2016年7月13日 下午11:47:39
 */
public class Xy {
	private double x;
	private double y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Xy [x=" + x + ", y=" + y + "]";
	}

}
