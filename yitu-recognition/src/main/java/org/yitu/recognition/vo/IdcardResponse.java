package org.yitu.recognition.vo;

/**
 * 100.1接口请求<br>
 * 身份证识别结果输出
 * 
 * @author yujinshui
 * @createTime 2016年7月7日 上午9:53:13
 */
public class IdcardResponse {
	private Integer rtn;
	private String message;
	private IdcardOcrResult idcard_ocr_result;
	private WatermarkResult watermark_result;

	/**
	 * 请求处理结果的错误代码 0表示OK,否则表示异常
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:39:59
	 */
	public Integer getRtn() {
		return rtn;
	}

	/**
	 * 请求处理结果的错误代码 0表示OK,否则表示异常
	 * 
	 * @param rtn
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:40:04
	 */
	public void setRtn(Integer rtn) {
		this.rtn = rtn;
	}

	/**
	 * 请求处理结果的debug信息
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:40:12
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 请求处理结果的debug信息
	 * 
	 * @param message
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:40:16
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 身份证信息详情
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:40:27
	 */
	public IdcardOcrResult getIdcard_ocr_result() {
		return idcard_ocr_result;
	}

	/**
	 * 身份证信息详情
	 * 
	 * @param idcard_ocr_result
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:40:42
	 */
	public void setIdcard_ocr_result(IdcardOcrResult idcard_ocr_result) {
		this.idcard_ocr_result = idcard_ocr_result;
	}

	/**
	 * 网纹照信息
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:40:50
	 */
	public WatermarkResult getWatermark_result() {
		return watermark_result;
	}

	/**
	 * 网纹照信息
	 * 
	 * @param watermark_result
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:41:02
	 */
	public void setWatermark_result(WatermarkResult watermark_result) {
		this.watermark_result = watermark_result;
	}

	@Override
	public String toString() {
		return "IdcardResponse [rtn=" + rtn + ", message=" + message + ", idcard_ocr_result=" + idcard_ocr_result
				+ ", watermark_result=" + watermark_result + "]";
	}

}
