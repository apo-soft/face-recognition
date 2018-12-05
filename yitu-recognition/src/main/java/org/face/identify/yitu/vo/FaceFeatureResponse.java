package org.face.identify.yitu.vo;

/**
 * 私有云response - 人脸识别返回值
 * 
 * @author yujinshui
 * @createTime 2016年7月1日 下午3:36:52
 */
public class FaceFeatureResponse {

	private Integer rtn;
	private String message;
	private String feature;
	private String flip_feature;
	private Integer face_num;
	private Integer image_type;
	private Integer idcard_type;

	/**
	 * 图像识别得到的人脸个数
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午4:30:47
	 */
	public Integer getFace_num() {
		return face_num;
	}

	/**
	 * 图像识别得到的人脸个数
	 * 
	 * @param face_num
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午4:30:32
	 */
	public void setFace_num(Integer face_num) {
		this.face_num = face_num;
	}

	/**
	 * 特征向量，一般大小在26k左右
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午4:30:18
	 */
	public String getFeature() {
		return feature;
	}

	/**
	 * 特征向量，一般大小在26k左右
	 * 
	 * @param feature
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午4:26:10
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * 登记照片类型<br>
	 * 证件照= 1<br>
	 * 证件照翻拍= 2<br>
	 * 类证件照= 3<br>
	 * 芯片照= 4<br>
	 * 小尺寸金融行业水印的证件照(不带横纹的老版网纹照)= 5<br>
	 * 中尺寸金融行业水印的证件照(不带横纹的老版网纹照)= 6<br>
	 * 小尺寸公安行业水印证件照(带横纹的老版网纹照) = 7<br>
	 * 中尺寸公安行业水印证件照(带横纹的老版网纹照) = 8<br>
	 * 小铁丝网水印的证件照(新版网纹照) = 9<br>
	 * 中铁丝网水印的证件照(新版网纹照) = 10<br>
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午4:29:32
	 */
	public Integer getImage_type() {
		return image_type;
	}

	/**
	 * 登记照片类型<br>
	 * 证件照= 1<br>
	 * 证件照翻拍= 2<br>
	 * 类证件照= 3<br>
	 * 芯片照= 4<br>
	 * 小尺寸金融行业水印的证件照(不带横纹的老版网纹照)= 5<br>
	 * 中尺寸金融行业水印的证件照(不带横纹的老版网纹照)= 6<br>
	 * 小尺寸公安行业水印证件照(带横纹的老版网纹照) = 7<br>
	 * 中尺寸公安行业水印证件照(带横纹的老版网纹照) = 8<br>
	 * 小铁丝网水印的证件照(新版网纹照) = 9<br>
	 * 中铁丝网水印的证件照(新版网纹照) = 10<br>
	 * 
	 * @param image_type
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午4:29:16
	 */
	public void setImage_type(Integer image_type) {
		this.image_type = image_type;
	}

	/**
	 * 请求处理结果的错误信息
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午4:19:27
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 请求处理结果的错误信息
	 * 
	 * @param message
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午4:18:51
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 请求处理结果的错误代码。0表示OK，小于0表示服务器发生错误
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午4:18:35
	 */
	public Integer getRtn() {
		return rtn;
	}

	/**
	 * 请求处理结果的错误代码。0表示OK，小于0表示服务器发生错误
	 * 
	 * @param rtn
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午4:17:17
	 */
	public void setRtn(Integer rtn) {
		this.rtn = rtn;
	}

	/**
	 * 特征向量，当请求参数flip_image为true时，则输出该字符串
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:48:35
	 */
	public String getFlip_feature() {
		return flip_feature;
	}

	/**
	 * 特征向量，当请求参数flip_image为true时，则输出该字符串
	 * 
	 * @param flip_feature
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:49:52
	 */
	public void setFlip_feature(String flip_feature) {
		this.flip_feature = flip_feature;
	}

	/**
	 * 识别出的身份证图片类型(只在开启了idcard_ocr功能之后返回)<br>
	 * 1:身份证正面识别<br>
	 * 2:身份证背面识别<br>
	 * -1:无效的身份证照片,既不是正面也不是背面
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:50:04
	 */
	public Integer getIdcard_type() {
		return idcard_type;
	}

	/**
	 * 识别出的身份证图片类型(只在开启了idcard_ocr功能之后返回)<br>
	 * 1:身份证正面识别<br>
	 * 2:身份证背面识别<br>
	 * -1:无效的身份证照片,既不是正面也不是背面
	 * 
	 * @param idcard_type
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:51:53
	 */
	public void setIdcard_type(Integer idcard_type) {
		this.idcard_type = idcard_type;
	}

	@Override
	public String toString() {
		return "FaceFeatureResponse [rtn=" + rtn + ", message=" + message + ", feature=" + feature + ", flip_feature="
				+ flip_feature + ", face_num=" + face_num + ", image_type=" + image_type + ", idcard_type="
				+ idcard_type + "]";
	}

}
