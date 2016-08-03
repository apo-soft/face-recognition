package org.yitu.recognition.vo;

/**
 * 101.3接口 - 手机SDK捕获图片数据包接口
 * <p>
 * sdk捕获数据请求信息 - 用于进行sdk捕获的图片数据进行解密，得到图片信息
 * 
 * @author yujinshui
 * @createTime 2016年8月2日 下午5:20:16
 */
public class ImgPackageRequest {
	private String query_image_package;
	private boolean query_image_package_return_image_list;
	private boolean query_image_package_check_same_person;
	private boolean query_image_package_return_feature_string;
	private Integer query_image_package_feature_number;

	/**
	 * 查询人脸的大礼包
	 * 
	 * @return the query_image_package
	 */
	public String getQuery_image_package() {
		return query_image_package;
	}

	/**
	 * 查询人脸的大礼包
	 * 
	 * @param query_image_package
	 *            the query_image_package to set
	 */
	public void setQuery_image_package(String query_image_package) {
		this.query_image_package = query_image_package;
	}

	/**
	 * 【选填】是否返回大礼包中解出的图片列表
	 * 
	 * @return the query_image_package_return_image_list
	 */
	public boolean isQuery_image_package_return_image_list() {
		return query_image_package_return_image_list;
	}

	/**
	 * 【选填】是否返回大礼包中解出的图片列表
	 * 
	 * @param query_image_package_return_image_list
	 *            the query_image_package_return_image_list to set
	 */
	public void setQuery_image_package_return_image_list(boolean query_image_package_return_image_list) {
		this.query_image_package_return_image_list = query_image_package_return_image_list;
	}

	/**
	 * 【选填】是否检查活体比对数据包中查询照片是同一个人
	 * 
	 * @return the query_image_package_check_same_person
	 */
	public boolean isQuery_image_package_check_same_person() {
		return query_image_package_check_same_person;
	}

	/**
	 * 【选填】是否检查活体比对数据包中查询照片是同一个人
	 * 
	 * @param query_image_package_check_same_person
	 *            the query_image_package_check_same_person to set
	 */
	public void setQuery_image_package_check_same_person(boolean query_image_package_check_same_person) {
		this.query_image_package_check_same_person = query_image_package_check_same_person;
	}

	/**
	 * 【选填】是否返回正脸特征图片
	 * 
	 * @return the query_image_package_return_feature_string
	 */
	public boolean isQuery_image_package_return_feature_string() {
		return query_image_package_return_feature_string;
	}

	/**
	 * 【选填】是否返回正脸特征图片
	 * 
	 * @param query_image_package_return_feature_string
	 *            the query_image_package_return_feature_string to set
	 */
	public void setQuery_image_package_return_feature_string(boolean query_image_package_return_feature_string) {
		this.query_image_package_return_feature_string = query_image_package_return_feature_string;
	}

	/**
	 * 【选填】返回feature string 中 feature的数量
	 * 
	 * @return the query_image_package_feature_number
	 */
	public Integer getQuery_image_package_feature_number() {
		return query_image_package_feature_number;
	}

	/**
	 * 【选填】返回feature string 中 feature的数量
	 * 
	 * @param query_image_package_feature_number
	 *            the query_image_package_feature_number to set
	 */
	public void setQuery_image_package_feature_number(Integer query_image_package_feature_number) {
		this.query_image_package_feature_number = query_image_package_feature_number;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ImgPackageRequest [query_image_package=" + query_image_package
				+ ", query_image_package_return_image_list=" + query_image_package_return_image_list
				+ ", query_image_package_check_same_person=" + query_image_package_check_same_person
				+ ", query_image_package_return_feature_string=" + query_image_package_return_feature_string
				+ ", query_image_package_feature_number=" + query_image_package_feature_number + "]";
	}

}
