package org.face.identify.yitu.vo;

/**
 * 选项
 * 
 * @author yujinshui
 * @createTime 2016年7月7日 下午5:05:03
 */
public class Options {
	private Integer image_type;
	private boolean auto_rotate;
	private boolean idcard_confirm;
	private boolean idcard_ocr;
	private Integer idcard_ocr_mode;
	private boolean remove_watermark;

	/**
	 * 图片类型,包括如下几种: <br>
	 * 1: 人行照<br>
	 * 2: 翻拍身份证照<br>
	 * 5: 不带横纹的老版网纹照 <br>
	 * 7: 带横纹的老版网纹照<br>
	 * 9: 新版网纹照(铁丝网照) <br>
	 * 101: 自动区分网纹照
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:32:01
	 */
	public Integer getImage_type() {
		return image_type;
	}

	/**
	 * 图片类型,包括如下几种: <br>
	 * 1: 人行照<br>
	 * 2: 翻拍身份证照<br>
	 * 5: 不带横纹的老版网纹照 <br>
	 * 7: 带横纹的老版网纹照<br>
	 * 9: 新版网纹照(铁丝网照) <br>
	 * 101: 自动区分网纹照
	 * 
	 * @param image_type
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:32:30
	 */
	public void setImage_type(Integer image_type) {
		this.image_type = image_type;
	}

	/**
	 * 开启自动旋转矫正
	 * <p>
	 * 在上传翻拍身份证照(image_type=2)的图片(mode=1)有意义
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:55:45
	 */
	public boolean isAuto_rotate() {
		return auto_rotate;
	}

	/**
	 * 开启自动旋转矫正
	 * <p>
	 * 在上传翻拍身份证照(image_type=2)的图片(mode=1)有意义
	 * 
	 * @param auto_rotate
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:56:07
	 */
	public void setAuto_rotate(boolean auto_rotate) {
		this.auto_rotate = auto_rotate;
	}

	/**
	 * 开启有效身份证翻拍照效验
	 * <p>
	 * 在上传翻拍身份证照(image_type=2)的图片(mode=1) 或者特征(mode=2)有意义
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:56:30
	 */
	public boolean isIdcard_confirm() {
		return idcard_confirm;
	}

	/**
	 * 开启有效身份证翻拍照效验
	 * <p>
	 * 在上传翻拍身份证照(image_type=2)的图片(mode=1) 或者特征(mode=2)有意义
	 * 
	 * @param idcard_confirm
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:56:53
	 */
	public void setIdcard_confirm(boolean idcard_confirm) {
		this.idcard_confirm = idcard_confirm;
	}

	/**
	 * 开启身份证识别, 将返回身份证信息
	 * <p>
	 * 在上传翻拍身份证照(image_type=2)的图片(mode=1) 或者特征(mode=2)有意义
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:57:31
	 */
	public boolean isIdcard_ocr() {
		return idcard_ocr;
	}

	/**
	 * 开启身份证识别, 将返回身份证信息
	 * <p>
	 * 在上传翻拍身份证照(image_type=2)的图片(mode=1) 或者特征(mode=2)有意义
	 * 
	 * @param idcard_ocr
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:58:06
	 */
	public void setIdcard_ocr(boolean idcard_ocr) {
		this.idcard_ocr = idcard_ocr;
	}

	/**
	 * 1: 身份证正面识别 <br>
	 * 2: 身份证背面识别 <br>
	 * 3: 自动区分正面背面
	 * <p>
	 * 在上传翻拍身份证照(image_type=2)的图片(mode=1) 或者特征(mode=2)有意义
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:58:22
	 */
	public Integer getIdcard_ocr_mode() {
		return idcard_ocr_mode;
	}

	/**
	 * 1: 身份证正面识别 <br>
	 * 2: 身份证背面识别 <br>
	 * 3: 自动区分正面背面
	 * <p>
	 * 在上传翻拍身份证照(image_type=2)的图片(mode=1) 或者特征(mode=2)有意义
	 * 
	 * @param idcard_ocr_mode
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:59:00
	 */
	public void setIdcard_ocr_mode(Integer idcard_ocr_mode) {
		this.idcard_ocr_mode = idcard_ocr_mode;
	}

	/**
	 * 开启去水印, 将返回去水印后的图片
	 * <p>
	 * 在上传图片(mode=1)且图片类型为网纹照(image_type=5/7/9/101) 或者上传身份信息(mode=3)时有意义
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:59:16
	 */
	public boolean isRemove_watermark() {
		return remove_watermark;
	}

	/**
	 * 开启去水印, 将返回去水印后的图片
	 * <p>
	 * 在上传图片(mode=1)且图片类型为网纹照(image_type=5/7/9/101) 或者上传身份信息(mode=3)时有意义
	 * 
	 * @param remove_watermark
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:59:37
	 */
	public void setRemove_watermark(boolean remove_watermark) {
		this.remove_watermark = remove_watermark;
	}

}
