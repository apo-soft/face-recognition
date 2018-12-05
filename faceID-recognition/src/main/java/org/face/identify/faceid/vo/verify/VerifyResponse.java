package org.face.identify.faceid.vo.verify;

import java.util.Arrays;

/**
 * 人脸比对返回参数
 * 
 * @author yujinshui
 * @createTime 2016年7月15日 下午11:56:36
 */
public class VerifyResponse {
	private String request_id;
	private ResultFaceId result_faceid;
	private ResultRef[] result_ref;
	private IdExceptions id_exceptions;
	private int time_used;
	private FaceInfo faces;
	private FaceGenuineness face_genuineness;

	/**
	 * @return the request_id
	 */
	public String getRequest_id() {
		return request_id;
	}

	/**
	 * @param request_id
	 *            the request_id to set
	 */
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	/**
	 * @return the result_faceid
	 */
	public ResultFaceId getResult_faceid() {
		return result_faceid;
	}

	/**
	 * @param result_faceid
	 *            the result_faceid to set
	 */
	public void setResult_faceid(ResultFaceId result_faceid) {
		this.result_faceid = result_faceid;
	}

	/**
	 * @return the result_ref
	 */
	public ResultRef[] getResult_ref() {
		return result_ref;
	}

	/**
	 * @param result_ref
	 *            the result_ref to set
	 */
	public void setResult_ref(ResultRef[] result_ref) {
		this.result_ref = result_ref;
	}

	/**
	 * @return the id_exceptions
	 */
	public IdExceptions getId_exceptions() {
		return id_exceptions;
	}

	/**
	 * @param id_exceptions
	 *            the id_exceptions to set
	 */
	public void setId_exceptions(IdExceptions id_exceptions) {
		this.id_exceptions = id_exceptions;
	}

	/**
	 * @return the time_used
	 */
	public int getTime_used() {
		return time_used;
	}

	/**
	 * @param time_used
	 *            the time_used to set
	 */
	public void setTime_used(int time_used) {
		this.time_used = time_used;
	}

	/**
	 * @return the faces
	 */
	public FaceInfo getFaces() {
		return faces;
	}

	/**
	 * @param faces
	 *            the faces to set
	 */
	public void setFaces(FaceInfo faces) {
		this.faces = faces;
	}

	/**
	 * @return the face_genuineness
	 */
	public FaceGenuineness getFace_genuineness() {
		return face_genuineness;
	}

	/**
	 * @param face_genuineness
	 *            the face_genuineness to set
	 */
	public void setFace_genuineness(FaceGenuineness face_genuineness) {
		this.face_genuineness = face_genuineness;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VerifyResponse [request_id=" + request_id + ", result_faceid=" + result_faceid + ", result_ref="
				+ Arrays.toString(result_ref) + ", id_exceptions=" + id_exceptions + ", time_used=" + time_used
				+ ", faces=" + faces + ", face_genuineness=" + face_genuineness + "]";
	}

}
