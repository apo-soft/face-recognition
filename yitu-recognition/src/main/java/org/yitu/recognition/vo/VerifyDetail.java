package org.yitu.recognition.vo;

import java.util.Arrays;

/**
 * 比对的详细信息,仅当开启 enable_verify_detail = true 时返回
 * 
 * @author yujinshui
 * @createTime 2016年7月2日 下午3:22:13
 */
public class VerifyDetail {
	private Integer[] score_list;
	private QueryFaceRect[] query_face_rect;//

	/**
	 * 查询照每张人脸分别和登记照人脸比对的分数,按从高到低排序
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:21:51
	 */
	public Integer[] getScore_list() {
		return score_list;
	}

	/**
	 * 查询照每张人脸分别和登记照人脸比对的分数,按从高到低排序
	 * 
	 * @param score_list
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:21:57
	 */
	public void setScore_list(Integer[] score_list) {
		this.score_list = score_list;
	}

	/**
	 * 查询照每张人脸的矩形位置列表,与score_list中的每个比对分数一一对应 仅当开启 return_face_rect = true 时返回
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:18:02
	 */
	public QueryFaceRect[] getQuery_face_rect() {
		return query_face_rect;
	}

	/**
	 * 查询照每张人脸的矩形位置列表,与score_list中的每个比对分数一一对应 仅当开启 return_face_rect = true 时返回
	 * 
	 * @param query_face_rect
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:18:11
	 */
	public void setQuery_face_rect(QueryFaceRect[] query_face_rect) {
		this.query_face_rect = query_face_rect;
	}

	@Override
	public String toString() {
		return "VerifyDetail [score_list=" + Arrays.toString(score_list) + ", query_face_rect="
				+ Arrays.toString(query_face_rect) + "]";
	}

}
