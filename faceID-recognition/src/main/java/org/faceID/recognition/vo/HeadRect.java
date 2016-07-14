package org.faceID.recognition.vo;

/**
 * 身份证中人脸框的位置，分别包含左上、右上、右下、左下四个角点。可能会超过图本身。
 * 
 * @author yujinshui
 * @createTime 2016年7月13日 下午11:48:41
 */
public class HeadRect {

	private Xy lt;
	private Xy rt;
	private Xy rb;
	private Xy lb;

	public Xy getLt() {
		return lt;
	}

	public void setLt(Xy lt) {
		this.lt = lt;
	}

	public Xy getRt() {
		return rt;
	}

	public void setRt(Xy rt) {
		this.rt = rt;
	}

	public Xy getRb() {
		return rb;
	}

	public void setRb(Xy rb) {
		this.rb = rb;
	}

	public Xy getLb() {
		return lb;
	}

	public void setLb(Xy lb) {
		this.lb = lb;
	}

	@Override
	public String toString() {
		return "HeadRect [lt=" + lt + ", rt=" + rt + ", rb=" + rb + ", lb=" + lb + "]";
	}

}
