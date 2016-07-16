package org.faceID.recognition.vo.verify;

/**
 * 该字段表示待比对的脸的真实性。“真实的人脸”是指待比对的人脸图像是真实人脸的拍摄，而不是戴面具的脸、通过软件人工合成的脸、或是屏幕翻拍回放的脸。
 * 本字段返回真实性检查结果以及用作参考的相关阈值。 {类功能描述}
 * 
 * @author yujinshui
 * @createTime 2016年7月16日 上午9:25:10
 */
public class FaceGenuineness {
	private double synthetic_face_confidence;
	private double synthetic_face_threshold;
	private double mask_confidence;
	private double mask_threshold;
	private double screen_replay_confidence;
	private double screen_replay_threshold;

	/**
	 * 取值［0，1］，表示人脸照片为软件合成脸的置信度。
	 * 
	 * @return the synthetic_face_confidence
	 */
	public double getSynthetic_face_confidence() {
		return synthetic_face_confidence;
	}

	/**
	 * 取值［0，1］，表示人脸照片为软件合成脸的置信度。
	 * 
	 * @param synthetic_face_confidence
	 *            the synthetic_face_confidence to set
	 */
	public void setSynthetic_face_confidence(double synthetic_face_confidence) {
		this.synthetic_face_confidence = synthetic_face_confidence;
	}

	/**
	 * 取值［0，1］，表示人脸照片为软件合成脸的置信度阈值。 如果synthetic_face_confidence <
	 * synthetic_face_threshold，可以认为人脸不是软件合成脸。
	 * 
	 * @return the synthetic_face_threshold
	 */
	public double getSynthetic_face_threshold() {
		return synthetic_face_threshold;
	}

	/**
	 * 取值［0，1］，表示人脸照片为软件合成脸的置信度阈值。 如果synthetic_face_confidence <
	 * synthetic_face_threshold，可以认为人脸不是软件合成脸。
	 * 
	 * @param synthetic_face_threshold
	 *            the synthetic_face_threshold to set
	 */
	public void setSynthetic_face_threshold(double synthetic_face_threshold) {
		this.synthetic_face_threshold = synthetic_face_threshold;
	}

	/**
	 * 取值［0，1］，表示人脸照片为面具的置信度。
	 * 
	 * @return the mask_confidence
	 */
	public double getMask_confidence() {
		return mask_confidence;
	}

	/**
	 * 取值［0，1］，表示人脸照片为面具的置信度。
	 * 
	 * @param mask_confidence
	 *            the mask_confidence to set
	 */
	public void setMask_confidence(double mask_confidence) {
		this.mask_confidence = mask_confidence;
	}

	/**
	 * 取值［0，1］，表示人脸照片为面具的置信度阈值。 如果mask_confidence < mask_threshold，可以认为人脸不是面具。
	 * 
	 * @return the mask_threshold
	 */
	public double getMask_threshold() {
		return mask_threshold;
	}

	/**
	 * 取值［0，1］，表示人脸照片为面具的置信度阈值。 如果mask_confidence < mask_threshold，可以认为人脸不是面具。
	 * 
	 * @param mask_threshold
	 *            the mask_threshold to set
	 */
	public void setMask_threshold(double mask_threshold) {
		this.mask_threshold = mask_threshold;
	}

	/**
	 * 取值［0，1］，表示人脸照片为屏幕翻拍的置信度。注意：此字段只有在调用时传入了image_env参数才返回。
	 * 
	 * @return the screen_replay_confidence
	 */
	public double getScreen_replay_confidence() {
		return screen_replay_confidence;
	}

	/**
	 * 取值［0，1］，表示人脸照片为屏幕翻拍的置信度。注意：此字段只有在调用时传入了image_env参数才返回。
	 * 
	 * @param screen_replay_confidence
	 *            the screen_replay_confidence to set
	 */
	public void setScreen_replay_confidence(double screen_replay_confidence) {
		this.screen_replay_confidence = screen_replay_confidence;
	}

	/**
	 * Float类型，取值［0，1］，表示人脸照片为屏幕翻拍的置信度阈值。 如果screen_replay_confidence <
	 * screen_replay_threshold，可以认为人脸不是屏幕翻拍。注意：此字段只有在调用时传入了image_env参数才返回。
	 * 
	 * @return the screen_replay_threshold
	 */
	public double getScreen_replay_threshold() {
		return screen_replay_threshold;
	}

	/**
	 * Float类型，取值［0，1］，表示人脸照片为屏幕翻拍的置信度阈值。 如果screen_replay_confidence <
	 * screen_replay_threshold，可以认为人脸不是屏幕翻拍。注意：此字段只有在调用时传入了image_env参数才返回。
	 * 
	 * @param screen_replay_threshold
	 *            the screen_replay_threshold to set
	 */
	public void setScreen_replay_threshold(double screen_replay_threshold) {
		this.screen_replay_threshold = screen_replay_threshold;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FaceGenuineness [synthetic_face_confidence=" + synthetic_face_confidence + ", synthetic_face_threshold="
				+ synthetic_face_threshold + ", mask_confidence=" + mask_confidence + ", mask_threshold="
				+ mask_threshold + ", screen_replay_confidence=" + screen_replay_confidence
				+ ", screen_replay_threshold=" + screen_replay_threshold + "]";
	}

}
