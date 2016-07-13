package org.faceID.recognition.vo;

import java.util.List;

/**
 * 人脸检测返回
 * 
 * @author yujinshui
 * @createTime 2016年7月12日 下午4:00:20
 */
public class DetectResponse {
	private String request_id;
	private Float time_used;
	private List<Faces> faces;

	/**
	 * 用于区分每一次请求的唯一的字符串。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:05:42
	 */
	public String getRequest_id() {
		return request_id;
	}

	/**
	 * 用于区分每一次请求的唯一的字符串。
	 * 
	 * @param request_id
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:05:47
	 */
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	/**
	 * 整个请求所花费的时间，单位为毫秒。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:05:58
	 */
	public Float getTime_used() {
		return time_used;
	}

	/**
	 * 整个请求所花费的时间，单位为毫秒。
	 * 
	 * @param time_used
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:06:02
	 */
	public void setTime_used(Float time_used) {
		this.time_used = time_used;
	}

	/**
	 * 在照片中所有找到的人脸，都以Json的形式返回，并组成一个Array。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:06:12
	 */
	public List<Faces> getFaces() {
		return faces;
	}

	/**
	 * 在照片中所有找到的人脸，都以Json的形式返回，并组成一个Array。
	 * 
	 * @param faces
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午4:06:16
	 */
	public void setFaces(List<Faces> faces) {
		this.faces = faces;
	}

	@Override
	public String toString() {
		return "DetectResponse [request_id=" + request_id + ", time_used=" + time_used + ", faces=" + faces + "]";
	}

}
