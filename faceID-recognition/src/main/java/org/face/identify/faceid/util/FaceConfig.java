package org.face.identify.faceid.util;

public interface FaceConfig {
	/**
	 * 账户key
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午3:13:14
	 */
	String getAPI_KEY();

	/**
	 * 账户secret
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午3:13:25
	 */
	String getAPI_SECRET();

	/**
	 * 人脸检测接口URL
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午3:13:33
	 */
	String getDETECT_URL();

	/**
	 * 人脸比对接口URL
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午3:13:45
	 */
	String getVERIFY_URL();

	/**
	 * 身份证识别接口URL
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午3:13:55
	 */
	String getOCRIDCARD_URL();
}
