package org.yitu.recognition.vo;

import java.util.List;

public class QueryImgPackResult {

	private String customer_defined_content;
	private List<String> query_image_contents;

	/**
	 * 用户在大礼包中预先加入的自定义字段
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:23:50
	 */
	public String getCustomer_defined_content() {
		return customer_defined_content;
	}

	/**
	 * 用户在大礼包中预先加入的自定义字段
	 * 
	 * @param customer_defined_content
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:23:55
	 */
	public void setCustomer_defined_content(String customer_defined_content) {
		this.customer_defined_content = customer_defined_content;
	}

	/**
	 * 大礼包中解码的图片列表
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:33:57
	 */
	public List<String> getQuery_image_contents() {
		return query_image_contents;
	}

	/**
	 * 大礼包中解码的图片列表
	 * 
	 * @param query_image_contents
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:34:03
	 */
	public void setQuery_image_contents(List<String> query_image_contents) {
		this.query_image_contents = query_image_contents;
	}

	@Override
	public String toString() {
		return "QueryImgPackResult [customer_defined_content=" + customer_defined_content + ", query_image_contents="
				+ query_image_contents + "]";
	}

}
