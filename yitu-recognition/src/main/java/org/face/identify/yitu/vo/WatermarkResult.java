package org.face.identify.yitu.vo;

/**
 * 100.1接口请求<br>
 * 网纹照去水印返回结果
 * 
 * @author yujinshui
 * @createTime 2016年7月7日 下午6:28:31
 */
public class WatermarkResult {
	private String origin_image_content;
	private String processed_image_content;

	/**
	 * 原始网纹照图片内容-Base64编码
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:30:04
	 */
	public String getOrigin_image_content() {
		return origin_image_content;
	}

	/**
	 * 原始网纹照图片内容-Base64编码
	 * 
	 * @param origin_image_content
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:30:10
	 */
	public void setOrigin_image_content(String origin_image_content) {
		this.origin_image_content = origin_image_content;
	}

	/**
	 * 去水印后网纹照图片内容-Base64编码
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:30:22
	 */
	public String getProcessed_image_content() {
		return processed_image_content;
	}

	/**
	 * 去水印后网纹照图片内容-Base64编码
	 * 
	 * @param processed_image_content
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:30:27
	 */
	public void setProcessed_image_content(String processed_image_content) {
		this.processed_image_content = processed_image_content;
	}

	@Override
	public String toString() {
		return "WatermarkResult [origin_image_content=" + origin_image_content + ", processed_image_content="
				+ processed_image_content + "]";
	}

}
