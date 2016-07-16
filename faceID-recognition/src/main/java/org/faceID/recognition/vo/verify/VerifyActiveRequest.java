package org.faceID.recognition.vo.verify;

import java.io.File;

/**
 * 有源比对类
 * 
 * @author yujinshui
 * @createTime 2016年7月15日 下午11:37:02
 */
public class VerifyActiveRequest extends VerifyBaseRequest {
	private String idcard_name;
	private String idcard_number;
	private File[] image_ref;

	/**
	 * 需要核实身份对象的姓名。在有源比对时，verify方法需要该参数和idcard_number参数去从数据源获取参考人脸图像。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:39:24
	 */
	public String getIdcard_name() {
		return idcard_name;
	}

	/**
	 * 需要核实身份对象的姓名。在有源比对时，verify方法需要该参数和idcard_number参数去从数据源获取参考人脸图像。
	 * 
	 * @param idcard_name
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:39:31
	 */
	public void setIdcard_name(String idcard_name) {
		this.idcard_name = idcard_name;
	}

	/**
	 * 需要核实身份对象的身份证号，也就是一个18位长度的字符串。在有源比对时，
	 * verify方法需要该参数和idcard_name参数去从数据源获取参考人脸图像。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:39:42
	 */
	public String getIdcard_number() {
		return idcard_number;
	}

	/**
	 * 需要核实身份对象的身份证号，也就是一个18位长度的字符串。在有源比对时，
	 * verify方法需要该参数和idcard_name参数去从数据源获取参考人脸图像。
	 * 
	 * @param idcard_number
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:39:48
	 */
	public void setIdcard_number(String idcard_number) {
		this.idcard_number = idcard_number;
	}

	/**
	 * 有源比对
	 * <p>
	 * 多张由您自己提供的参照人脸照片。x表示此参数可重复多次，其中1<= x <=
	 * 3，即表示可以传最多三张参照人脸照片（参数分别为image_ref1, image_ref2, image_ref3）。在有源比对时使用这个参数，
	 * 主要目的是让待验证照不但与通过idcard_name和idcard_number参数获得的数据源照比对，也和您从其他渠道获得的参考照片比对（
	 * 如果您有）。 <br>
	 * 如果在image_ref1、image_ref2、image_ref3中的任一张图片里没有找到人脸，将返回错误码400（NO_FACE_FOUND
	 * )；如果这些图片中任一张中有多张脸，将返回错误码400（MULTIPLE_FACES）。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:31:02
	 */
	public File[] getImage_ref() {
		return image_ref;
	}

	/**
	 * 有源比对
	 * <p>
	 * 多张由您自己提供的参照人脸照片。x表示此参数可重复多次，其中1<= x <=
	 * 3，即表示可以传最多三张参照人脸照片（参数分别为image_ref1, image_ref2, image_ref3）。在有源比对时使用这个参数，
	 * 主要目的是让待验证照不但与通过idcard_name和idcard_number参数获得的数据源照比对，也和您从其他渠道获得的参考照片比对（
	 * 如果您有）。 <br>
	 * 如果在image_ref1、image_ref2、image_ref3中的任一张图片里没有找到人脸，将返回错误码400（NO_FACE_FOUND
	 * )；如果这些图片中任一张中有多张脸，将返回错误码400（MULTIPLE_FACES）。
	 * 
	 * 
	 * @param image_ref
	 * @Author yujinshui
	 * @createTime 2016年7月15日 下午11:31:22
	 */
	public void setImage_ref(File[] image_ref) {
		this.image_ref = image_ref;
	}
}
