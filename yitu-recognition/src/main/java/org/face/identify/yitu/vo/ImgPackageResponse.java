package org.face.identify.yitu.vo;

/**
 * 101.3接口 - 手机SDK捕获图片数据包接口
 * <p>
 * sdk捕获数据公有云返回信息 - 用于进行sdk捕获的图片数据进行解密，得到图片信息
 * 
 * @author yujinshui
 * @createTime 2016年8月2日 下午5:27:51
 */
public class ImgPackageResponse {
	private Integer rtn;
	private String message;
	private QueryImgPackageResult query_image_package_result;

	/**
	 * @return the rtn
	 */
	public Integer getRtn() {
		return rtn;
	}

	/**
	 * @param rtn
	 *            the rtn to set
	 */
	public void setRtn(Integer rtn) {
		this.rtn = rtn;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the query_image_package_result
	 */
	public QueryImgPackageResult getQuery_image_package_result() {
		return query_image_package_result;
	}

	/**
	 * @param query_image_package_result
	 *            the query_image_package_result to set
	 */
	public void setQuery_image_package_result(QueryImgPackageResult query_image_package_result) {
		this.query_image_package_result = query_image_package_result;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ImgPackageResponse [rtn=" + rtn + ", message=" + message + ", query_image_package_result="
				+ query_image_package_result + "]";
	}

}
