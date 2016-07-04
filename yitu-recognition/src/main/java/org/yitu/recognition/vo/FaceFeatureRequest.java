package org.yitu.recognition.vo;

/**
 * 私有云请求 - 人脸特征抽取请求bean
 * 
 * @author yujinshui
 * @createTime 2016年6月30日 下午10:19:43
 */
public class FaceFeatureRequest {
	/****** 必填字段 *******/
	private String image_content;
	private int image_type;

	/****** 选填字段 *******/
	private boolean auto_rotate;
	private boolean flip_image;
	private Integer max_faces_allowed;
	private boolean idcard_ocr;
	private Integer idcard_ocr_mode;

	/**
	 * 【必填】入图像(JPG) BASE64编码。JPG编码，图片最大1MB
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午1:29:29
	 */
	public String getImage_content() {
		return image_content;
	}

	/**
	 * 【必填】入图像(JPG) BASE64编码。JPG编码，图片最大1MB
	 * 
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午1:35:42
	 */
	public void setImage_content(String image_content) {
		this.image_content = image_content;
	}

	/**
	 * 【必填】输入图像类型
	 * <p>
	 * 登记照片类型<br>
	 * 证件照= 1<br>
	 * 证件照翻拍= 2<br>
	 * 类证件照= 3<br>
	 * 芯片照= 4<br>
	 * 金融行业水印的证件照(不带横纹的老版网纹照)= 5<br>
	 * 公安行业水印证件照(带横纹的老版网纹照) = 7<br>
	 * 铁丝网水印的证件照(新版网纹照) = 9<br>
	 * 自动类型水印照(能够自动区分金融，公安，铁丝网，正确率99.5%) = 101
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午1:30:50
	 */
	public int getImage_type() {
		return image_type;
	}

	/**
	 * 【必填】输入图像类型
	 * <p>
	 * 登记照片类型<br>
	 * 证件照= 1<br>
	 * 证件照翻拍= 2<br>
	 * 类证件照= 3<br>
	 * 芯片照= 4<br>
	 * 金融行业水印的证件照(不带横纹的老版网纹照)= 5<br>
	 * 公安行业水印证件照(带横纹的老版网纹照) = 7<br>
	 * 铁丝网水印的证件照(新版网纹照) = 9<br>
	 * 自动类型水印照(能够自动区分金融，公安，铁丝网，正确率99.5%) = 101
	 * 
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午1:35:29
	 */
	public void setImage_type(int image_type) {
		this.image_type = image_type;
	}

	/**
	 * 是否开启自动动旋 (如果图片存在90，180，270度旋，则开启此选项) <br>
	 * 仅针对非水印照有效
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:14:13
	 */
	public boolean isAuto_rotate() {
		return auto_rotate;
	}

	/**
	 * 是否开启自动动旋 (如果图片存在90，180，270度旋，则开启此选项) <br>
	 * 仅针对非水印照有效
	 * 
	 * @param auto_rotate
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:15:36
	 */
	public void setAuto_rotate(boolean auto_rotate) {
		this.auto_rotate = auto_rotate;
	}

	/**
	 * 是否开启镜像
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:15:46
	 */
	public boolean isFlip_image() {
		return flip_image;
	}

	/**
	 * 是否开启镜像
	 * 
	 * @param flip_image
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:16:00
	 */
	public void setFlip_image(boolean flip_image) {
		this.flip_image = flip_image;
	}

	/**
	 * 最多抽取人脸特征数(只能1或者2)
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:16:08
	 */
	public Integer getMax_faces_allowed() {
		return max_faces_allowed;
	}

	/**
	 * 最多抽取人脸特征数(只能1或者2)
	 * 
	 * @param max_faces_allowed
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:16:25
	 */
	public void setMax_faces_allowed(Integer max_faces_allowed) {
		this.max_faces_allowed = max_faces_allowed;
	}

	/**
	 * 开启身份证识别，将返回身份证信息（仅在上传翻拍身份证照时有意义【image_type=2】）
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:17:17
	 */
	public boolean isIdcard_ocr() {
		return idcard_ocr;
	}

	/**
	 * 开启身份证识别，将返回身份证信息（仅在上传翻拍身份证照时有意义【image_type=2
	 * 
	 * @param idcard_ocr
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:18:51
	 */
	public void setIdcard_ocr(boolean idcard_ocr) {
		this.idcard_ocr = idcard_ocr;
	}

	/**
	 * 身份证识别条件 value值如下：<br>
	 * 1:身份证正面识别<br>
	 * 2:身份证背面识别<br>
	 * 3:auto自动区分正面背面
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:18:59
	 */
	public Integer getIdcard_ocr_mode() {
		return idcard_ocr_mode;
	}

	/**
	 * 身份证识别条件 value值如下：<br>
	 * 1:身份证正面识别<br>
	 * 2:身份证背面识别<br>
	 * 3:auto自动区分正面背面
	 * 
	 * @param idcard_ocr_mode
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:20:46
	 */
	public void setIdcard_ocr_mode(Integer idcard_ocr_mode) {
		this.idcard_ocr_mode = idcard_ocr_mode;
	}

}
