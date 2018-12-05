package org.face.identify.faceid.vo.verify;

public class IdExceptions {
	private int id_attacked;
	private int id_photo_monochrome;

	/**
	 * Int类型，判别身份证号码是否曾被冒用来攻击FaceID活体检测，取值1表示曾被攻击、取值0表示未被攻击。攻击形态包括但不限于戴面具、换人攻击、
	 * 软件3D合成人脸等手段。若被判别为“是”，则有可能这个身份证号码目前存在被利用的风险。注意：判别为“是”不意味身份持有者本人参与攻击，
	 * 有可能其身份被他人盗用而本人无感知。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:08:38
	 */
	public int getId_attacked() {
		return id_attacked;
	}

	/**
	 * Int类型，判别身份证号码是否曾被冒用来攻击FaceID活体检测，取值1表示曾被攻击、取值0表示未被攻击。攻击形态包括但不限于戴面具、换人攻击、
	 * 软件3D合成人脸等手段。若被判别为“是”，则有可能这个身份证号码目前存在被利用的风险。注意：判别为“是”不意味身份持有者本人参与攻击，
	 * 有可能其身份被他人盗用而本人无感知。
	 * 
	 * @param id_attacked
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:08:45
	 */
	public void setId_attacked(int id_attacked) {
		this.id_attacked = id_attacked;
	}

	/**
	 * Int类型，数据源身份证人像照片的色彩判断，取值1表示是黑白照片、取值0表示是彩色照片。身份数据源存在一部分人像照片是黑白的现象，
	 * 黑白的照片会影响比对质量，一般来说将降低比对分数。本字段表达这样的异常。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:08:54
	 */
	public int getId_photo_monochrome() {
		return id_photo_monochrome;
	}

	/**
	 * Int类型，数据源身份证人像照片的色彩判断，取值1表示是黑白照片、取值0表示是彩色照片。身份数据源存在一部分人像照片是黑白的现象，
	 * 黑白的照片会影响比对质量，一般来说将降低比对分数。本字段表达这样的异常。
	 * 
	 * @param id_photo_monochrome
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:09:07
	 */
	public void setId_photo_monochrome(int id_photo_monochrome) {
		this.id_photo_monochrome = id_photo_monochrome;
	}

	@Override
	public String toString() {
		return "IdExceptions [id_attacked=" + id_attacked + ", id_photo_monochrome=" + id_photo_monochrome + "]";
	}

}
