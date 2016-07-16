package org.faceID.recognition.vo.verify;

public class ResultRef {
	private double confidence;
	private String thresholds;

	/**
	 * 比对结果的置信度，Float类型，取值［0，100］，数字越大表示两张照片越可能是同一个人
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:04:59
	 */
	public double getConfidence() {
		return confidence;
	}

	/**
	 * 比对结果的置信度，Float类型，取值［0，100］，数字越大表示两张照片越可能是同一个人
	 * 
	 * @param confidence
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:05:04
	 */
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	/**
	 * 一组用于参考的置信度阈值，Object类型，包含三个字段，均为Float类型、取值［0，100］
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:05:18
	 */
	public String getThresholds() {
		return thresholds;
	}

	/**
	 * 一组用于参考的置信度阈值，Object类型，包含三个字段，均为Float类型、取值［0，100］
	 * 
	 * @param thresholds
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:05:22
	 */
	public void setThresholds(String thresholds) {
		this.thresholds = thresholds;
	}

	@Override
	public String toString() {
		return "ResultRef [confidence=" + confidence + ", thresholds=" + thresholds + "]";
	}
}
