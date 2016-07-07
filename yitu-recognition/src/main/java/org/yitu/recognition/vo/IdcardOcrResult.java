package org.yitu.recognition.vo;

/**
 * 100.1接口请求<br>
 * 身份证信息识别结果
 * 
 * @author yujinshui
 * @createTime 2016年7月7日 下午6:07:02
 */
public class IdcardOcrResult {
	private String name;
	private String address;
	private String citizen_id;
	private String valid_date_begin;
	private String valid_date_end;
	private String gender;
	private String nation;
	private String birthday;
	private String agency;
	private Integer idcard_type;

	/**
	 * 身份证翻拍照上的姓名信息
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:24:24
	 */
	public String getName() {
		return name;
	}

	/**
	 * 身份证翻拍照上的姓名信息
	 * 
	 * @param name
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:24:28
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 身份证翻拍照上的地址信息
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:24:41
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 身份证翻拍照上的地址信息
	 * 
	 * @param address
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:24:46
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 身份证翻拍照上的身份证号信息
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:24:56
	 */
	public String getCitizen_id() {
		return citizen_id;
	}

	/**
	 * 身份证翻拍照上的身份证号信息
	 * 
	 * @param citizen_id
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:25:00
	 */
	public void setCitizen_id(String citizen_id) {
		this.citizen_id = citizen_id;
	}

	/**
	 * 身份证有效期 开始时间
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:25:11
	 */
	public String getValid_date_begin() {
		return valid_date_begin;
	}

	/**
	 * 身份证有效期 开始时间
	 * 
	 * @param valid_date_begin
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:25:16
	 */
	public void setValid_date_begin(String valid_date_begin) {
		this.valid_date_begin = valid_date_begin;
	}

	/**
	 * 身份证有效期 结束时间
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:25:27
	 */
	public String getValid_date_end() {
		return valid_date_end;
	}

	/**
	 * 身份证有效期 结束时间
	 * 
	 * @param valid_date_end
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:25:32
	 */
	public void setValid_date_end(String valid_date_end) {
		this.valid_date_end = valid_date_end;
	}

	/**
	 * 性别
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:25:43
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 性别
	 * 
	 * @param gender
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:25:48
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 民族
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:26:00
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * 民族
	 * 
	 * @param nation
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:26:04
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * 出生年月日
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:26:15
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * 出生年月日
	 * 
	 * @param birthday
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:26:22
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 签发机关
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:26:34
	 */
	public String getAgency() {
		return agency;
	}

	/**
	 * 签发机关
	 * 
	 * @param agency
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:26:39
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}

	/**
	 * 识别出的身份证图片类型 <br>
	 * 1: 身份证正面识别<br>
	 * 2: 身份证背面识别<br>
	 * -1: 无效的身份证照片
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:27:29
	 */
	public Integer getIdcard_type() {
		return idcard_type;
	}

	/**
	 * 识别出的身份证图片类型 <br>
	 * 1: 身份证正面识别<br>
	 * 2: 身份证背面识别<br>
	 * -1: 无效的身份证照片
	 * 
	 * @param idcard_type
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:27:46
	 */
	public void setIdcard_type(Integer idcard_type) {
		this.idcard_type = idcard_type;
	}

}
