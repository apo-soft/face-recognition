package org.face.identify.faceid.vo.verify;

import java.io.File;

/**
 * 无源比对类
 * 
 * @author yujinshui
 * @createTime 2016年7月15日 下午11:40:28
 */
public class VerifyPassiveRequest extends VerifyBaseRequest {
	private String uuid;
	private File[] image_ref;

	/**
	 * 无源比对时，用于标志本次识别对应的用户的id，要求不长于512字节，否则返回错误码400（BAD_ARGUMENTS）。
	 * 建议您对来自同一用户的比对请求使用同样的id，这非常有利于您反查比对结果以及获得更好的监控、报表体验。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:41:53
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * 无源比对时，用于标志本次识别对应的用户的id，要求不长于512字节，否则返回错误码400（BAD_ARGUMENTS）。
	 * 建议您对来自同一用户的比对请求使用同样的id，这非常有利于您反查比对结果以及获得更好的监控、报表体验。
	 * 
	 * @param uuid
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:42:01
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * 多张由您自己提供的参照人脸照片。x表示此参数可重复多次，其中1<=x <= 3，即表示可以传最多三张参照人脸照片（参数分别为image_ref1,
	 * image_ref2, image_ref3）。 <br>
	 * 如果在image_ref1、image_ref2、image_ref3中的任一张图片里没有找到人脸，将返回错误码400（NO_FACE_FOUND
	 * )；如果这些图片中任一张中有多张脸，将返回错误码400（MULTIPLE_FACES）。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:42:21
	 */
	public File[] getImage_ref() {
		return image_ref;
	}

	/**
	 * 多张由您自己提供的参照人脸照片。x表示此参数可重复多次，其中1<=x <= 3，即表示可以传最多三张参照人脸照片（参数分别为image_ref1,
	 * image_ref2, image_ref3）。 <br>
	 * 如果在image_ref1、image_ref2、image_ref3中的任一张图片里没有找到人脸，将返回错误码400（NO_FACE_FOUND
	 * )；如果这些图片中任一张中有多张脸，将返回错误码400（MULTIPLE_FACES）。
	 * 
	 * @param image_ref
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:42:36
	 */
	public void setImage_ref(File[] image_ref) {
		this.image_ref = image_ref;
	}

}
