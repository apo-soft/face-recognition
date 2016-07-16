package org.faceID.recognition.vo.verify;

import java.io.File;

/**
 * raw_image参数请求
 * 
 * @author yujinshui
 * @createTime 2016年7月15日 下午11:50:16
 */
public class RawImageRequest {
	private File image;
	private String fail_when_multiple_faces;
	private String face_quality_threshold;
	private String return_faces;

	/**
	 * 待比对的人脸照片。当以这种方式调用verify方法时，该方法会首先检测出image中有几张人脸，并且判断最大的那张人脸的图像质量是否足够后续的比对
	 * 。
	 * 您可以通过设置可选参数fail_when_multiple_faces和face_quality_threshold来定义verify方法在人脸检测方面的行为
	 * ，具体请见这两个参数的描述
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:52:00
	 */
	public File getImage() {
		return image;
	}

	/**
	 * 待比对的人脸照片。当以这种方式调用verify方法时，该方法会首先检测出image中有几张人脸，并且判断最大的那张人脸的图像质量是否足够后续的比对
	 * 。
	 * 您可以通过设置可选参数fail_when_multiple_faces和face_quality_threshold来定义verify方法在人脸检测方面的行为
	 * ，具体请见这两个参数的描述
	 * 
	 * @param image
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:52:04
	 */
	public void setImage(File image) {
		this.image = image;
	}

	/**
	 * 对验证照作人脸检测时发现有多张脸，是否立即返回错误，或者取最大的一张脸继续比对。本参数取值只能是 “1” 或 "0" （缺省值为“1”）:
	 * <li>“1”: 立即返回错误码400（MULTIPLE_FACES）</li>
	 * <li>“0”：取最大脸继续比对</li>
	 * <li>其他值：返回错误码400（BAD_ARGUMENTS）</li>
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:52:28
	 */
	public String getFail_when_multiple_faces() {
		return fail_when_multiple_faces;
	}

	/**
	 * 对验证照作人脸检测时发现有多张脸，是否立即返回错误，或者取最大的一张脸继续比对。本参数取值只能是 “1” 或 "0" （缺省值为“1”）:
	 * <li>“1”: 立即返回错误码400（MULTIPLE_FACES）</li>
	 * <li>“0”：取最大脸继续比对</li>
	 * <li>其他值：返回错误码400（BAD_ARGUMENTS）</li>
	 * 
	 * @param fail_when_multiple_faces
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:53:10
	 */
	public void setFail_when_multiple_faces(String fail_when_multiple_faces) {
		this.fail_when_multiple_faces = fail_when_multiple_faces;
	}

	/**
	 * 验证照中（最大的一张）人脸图像质量分的阈值（缺省值为30）。验证照人脸图像质量低于该阈值就直接返回错误码400（LOW_QUALITY）。
	 * 本参数只能传入0至100的整数，传入其他整数或非整数字符串均返回错误码400（BAD_ARGUMENTS）。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:53:27
	 */
	public String getFace_quality_threshold() {
		return face_quality_threshold;
	}

	/**
	 * 验证照中（最大的一张）人脸图像质量分的阈值（缺省值为30）。验证照人脸图像质量低于该阈值就直接返回错误码400（LOW_QUALITY）。
	 * 本参数只能传入0至100的整数，传入其他整数或非整数字符串均返回错误码400（BAD_ARGUMENTS）。
	 * 
	 * @param face_quality_threshold
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:53:32
	 */
	public void setFace_quality_threshold(String face_quality_threshold) {
		this.face_quality_threshold = face_quality_threshold;
	}

	/**
	 * 返回人脸检测结果。本参数取值只能是“1”或“0”（缺省值为“0”）: <br>
	 * “1”: 返回人脸检测结果(faces)<br>
	 * “0”：不返回<br>
	 * 其他值：返回错误码400（BAD_ARGUMENTS）<br>
	 * <br>
	 * 注意：
	 * 
	 * 只要本参数设置为1，即使调用返回错误码400（LOW_QUALITY）、400（MULTIPLE_FACES）或400（NO_FACE_FOUND
	 * ），返回结果里依然会包含faces字段。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:53:47
	 */
	public String getReturn_faces() {
		return return_faces;
	}

	/**
	 * 返回人脸检测结果。本参数取值只能是“1”或“0”（缺省值为“0”）: <br>
	 * “1”: 返回人脸检测结果(faces)<br>
	 * “0”：不返回<br>
	 * 其他值：返回错误码400（BAD_ARGUMENTS）<br>
	 * <br>
	 * 注意：
	 * 
	 * 只要本参数设置为1，即使调用返回错误码400（LOW_QUALITY）、400（MULTIPLE_FACES）或400（NO_FACE_FOUND
	 * ），返回结果里依然会包含faces字段。
	 * 
	 * @param return_faces
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:54:43
	 */
	public void setReturn_faces(String return_faces) {
		this.return_faces = return_faces;
	}

}
