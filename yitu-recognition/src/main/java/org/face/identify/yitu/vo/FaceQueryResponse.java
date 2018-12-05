package org.face.identify.yitu.vo;

/**
 * 特征比对返回结果bean
 * 
 * @author yujinshui
 * @createTime 2016年7月1日 下午6:18:51
 */
public class FaceQueryResponse {
	private Integer rtn;
	private String message;
	private Integer pair_verify_result;
	private Double pair_verify_similarity;
	private QueryImgPackResult query_image_package_result;
	private VerifyDetail verify_detail;

	/**
	 * 请求处理结果的错误代码 0表示OK,<0表示服务器发生错误。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:30:40
	 */
	public Integer getRtn() {
		return rtn;
	}

	/**
	 * 请求处理结果的错误代码 0表示OK,<0表示服务器发生错误。
	 * 
	 * @param rtn
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:30:50
	 */
	public void setRtn(Integer rtn) {
		this.rtn = rtn;
	}

	/**
	 * 请求处理结果的错误信息
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:31:06
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 请求处理结果的错误信息
	 * 
	 * @param message
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:31:10
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 0 表示认为是同一个人<br>
	 * 1 表示认为不是同一个人
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:31:31
	 */
	public Integer getPair_verify_result() {
		return pair_verify_result;
	}

	/**
	 * 0 表示认为是同一个人<br>
	 * 1 表示认为不是同一个人
	 * 
	 * @param pair_verify_result
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:31:42
	 */
	public void setPair_verify_result(Integer pair_verify_result) {
		this.pair_verify_result = pair_verify_result;
	}

	/**
	 * 相似值, 值越大越相似 分数取值范围 0 -100
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:31:59
	 */
	public Double getPair_verify_similarity() {
		return pair_verify_similarity;
	}

	/**
	 * 相似值, 值越大越相似 分数取值范围 0 -100
	 * 
	 * @param pair_verify_similarity
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:32:04
	 */
	public void setPair_verify_similarity(Double pair_verify_similarity) {
		this.pair_verify_similarity = pair_verify_similarity;
	}

	/**
	 * 如果输入参数中有 query_image_package, 则会返回解大礼包结果
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:32:28
	 */
	public QueryImgPackResult getQuery_image_package_result() {
		return query_image_package_result;
	}

	/**
	 * 如果输入参数中有 query_image_package, 则会返回解大礼包结果
	 * 
	 * @param query_image_package_result
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:32:33
	 */
	public void setQuery_image_package_result(QueryImgPackResult query_image_package_result) {
		this.query_image_package_result = query_image_package_result;
	}

	/**
	 * 比对的详细信息,仅当开启 enable_verify_detail = true 时返回
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:32:48
	 */
	public VerifyDetail getVerify_detail() {
		return verify_detail;
	}

	/**
	 * 比对的详细信息,仅当开启 enable_verify_detail = true 时返回
	 * 
	 * @param verify_detail
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午4:32:54
	 */
	public void setVerify_detail(VerifyDetail verify_detail) {
		this.verify_detail = verify_detail;
	}

	@Override
	public String toString() {
		return "FaceQueryResponse [rtn=" + rtn + ", message=" + message + ", pair_verify_result=" + pair_verify_result
				+ ", pair_verify_similarity=" + pair_verify_similarity + ", query_image_package_result="
				+ query_image_package_result + ", verify_detail=" + verify_detail + "]";
	}

}
