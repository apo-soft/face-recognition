package org.face.identify.faceid.vo.verify;

/**
 * 人脸核对基础bean
 * 
 * @author yujinshui
 * @createTime 2016年7月15日 下午11:28:40
 */
public class VerifyBaseRequest {

	private String comparison_type;
	private String face_image_type;

	/**
	 * 确定本次比对为“有源比对”或“无源比对”。取值只为“1”或“0”，取其他值返回错误码400（BAD_ARGUMENTS）。 <br>
	 * a. “1”表示有源比对，FaceID将连接身份数据源获得比对人脸照。以下的“二选一”参数组里，必须使用“有源比对时”参数组，
	 * 否则可能返回错误码400（ MISSING_ARGUMENTS）。此外，如果没有“有源比对”的权限，也不能设置此参数为“1”，否则返回错误码
	 * 403（AUTHORIZATION_ERROR:“No data source permission.”） <br>
	 * b. “0”表示无源比对，FaceID将使用用户自己提供的照片（参数image_ref[x]）作为比对人脸照。以下的“二选一”参数集里，必须使用“
	 * 无源比对时”参数组，否则可能返回错误码400（MISSING_ARGUMENTS）。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:25:15
	 */
	public String getComparison_type() {
		return comparison_type;
	}

	/**
	 * 确定本次比对为“有源比对”或“无源比对”。取值只为“1”或“0”，取其他值返回错误码400（BAD_ARGUMENTS）。 <br>
	 * a. “1”表示有源比对，FaceID将连接身份数据源获得比对人脸照。以下的“二选一”参数组里，必须使用“有源比对时”参数组，
	 * 否则可能返回错误码400（ MISSING_ARGUMENTS）。此外，如果没有“有源比对”的权限，也不能设置此参数为“1”，否则返回错误码
	 * 403（AUTHORIZATION_ERROR:“No data source permission.”） <br>
	 * b. “0”表示无源比对，FaceID将使用用户自己提供的照片（参数image_ref[x]）作为比对人脸照。以下的“二选一”参数集里，必须使用“
	 * 无源比对时”参数组，否则可能返回错误码400（MISSING_ARGUMENTS）。
	 * 
	 * @param comparison_type
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:27:13
	 */
	public void setComparison_type(String comparison_type) {
		this.comparison_type = comparison_type;
	}

	/**
	 * 确定待比对图片的类型。取值只为“meglive”、“facetoken”、“raw_image”三者之一，取其他值返回错误码400（
	 * BAD_ARGUMENTS）。 <br>
	 * 1).“meglive”表示本次比对照为从FaceID活体检测SDK MegLive
	 * 中生成的最优照片。以下的“三选一”参数组里，必须使用“配合MegLive
	 * SDK使用时”这一组参数，否则可能返回错误码400（MISSING_ARGUMENTS）。 <br>
	 * 2).“facetoken”表示本次比对时，用户已经调用了FaceID的detect方法从原始图片中检测出人脸，用一个facetoken表示，
	 * 然后将这个facetoken作为待比对的人脸。以下的“三选一”参数组里，必须使用“调用detect后获得facetoken时”这一组参数，
	 * 否则可能返回错误码400（MISSING_ARGUMENTS）。 <br>
	 * 3).“raw_image”表示本次比对时，用户直接上传一张可能包含人脸的图片作为待比对的图片，FaceID将先检测图中人脸然后将人脸与参照脸比对
	 * 。以下的“三选一”参数组里，必须使用“直接上传一张照片时”这一组参数，否则可能返回错误码400（MISSING_ARGUMENTS）。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:27:38
	 */
	public String getFace_image_type() {
		return face_image_type;
	}

	/**
	 * 确定待比对图片的类型。取值只为“meglive”、“facetoken”、“raw_image”三者之一，取其他值返回错误码400（
	 * BAD_ARGUMENTS）。 <br>
	 * 1).“meglive”表示本次比对照为从FaceID活体检测SDK MegLive
	 * 中生成的最优照片。以下的“三选一”参数组里，必须使用“配合MegLive
	 * SDK使用时”这一组参数，否则可能返回错误码400（MISSING_ARGUMENTS）。 <br>
	 * 2).“facetoken”表示本次比对时，用户已经调用了FaceID的detect方法从原始图片中检测出人脸，用一个facetoken表示，
	 * 然后将这个facetoken作为待比对的人脸。以下的“三选一”参数组里，必须使用“调用detect后获得facetoken时”这一组参数，
	 * 否则可能返回错误码400（MISSING_ARGUMENTS）。 <br>
	 * 3).“raw_image”表示本次比对时，用户直接上传一张可能包含人脸的图片作为待比对的图片，FaceID将先检测图中人脸然后将人脸与参照脸比对
	 * 。以下的“三选一”参数组里，必须使用“直接上传一张照片时”这一组参数，否则可能返回错误码400（MISSING_ARGUMENTS）。
	 * 
	 * 
	 * @param face_image_type
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:28:25
	 */
	public void setFace_image_type(String face_image_type) {
		this.face_image_type = face_image_type;
	}

}
