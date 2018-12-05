package org.face.identify.faceid.vo.verify;

/**
 * facetoken参数请求(人脸检测+比对)
 * 
 * @author yujinshui
 * @createTime 2016年7月15日 下午11:47:44
 */
public class FacetokenRequest {
	private String face_token;

	/**
	 * 使用detect接口获得的一个标示人脸的token。您只有在调用detect方法对待验证照进行人脸检测后，才能以这种方式调用verify方法。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:48:51
	 */
	public String getFace_token() {
		return face_token;
	}

	/**
	 * 使用detect接口获得的一个标示人脸的token。您只有在调用detect方法对待验证照进行人脸检测后，才能以这种方式调用verify方法。
	 * 
	 * @param face_token
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:48:55
	 */
	public void setFace_token(String face_token) {
		this.face_token = face_token;
	}

}
