package org.face.identify.faceid.vo;

/**
 * 身份证检测结果返回
 * 
 * @author yujinshui
 * @createTime 2016年7月13日 下午11:40:50
 */
public class OcridcardResponse {

	private String request_id;
	private Float time_used;
	private String address;
	private Birthday birthday;
	private String gender;
	private String name;
	private String race;
	private String side;
	private String issued_by;
	private String valid_date;
	private HeadRect head_rect;
	private String legality;

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public Float getTime_used() {
		return time_used;
	}

	public void setTime_used(Float time_used) {
		this.time_used = time_used;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Birthday getBirthday() {
		return birthday;
	}

	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getIssued_by() {
		return issued_by;
	}

	public void setIssued_by(String issued_by) {
		this.issued_by = issued_by;
	}

	public String getValid_date() {
		return valid_date;
	}

	public void setValid_date(String valid_date) {
		this.valid_date = valid_date;
	}

	public HeadRect getHead_rect() {
		return head_rect;
	}

	public void setHead_rect(HeadRect head_rect) {
		this.head_rect = head_rect;
	}

	public String getLegality() {
		return legality;
	}

	public void setLegality(String legality) {
		this.legality = legality;
	}

	@Override
	public String toString() {
		return "OcridcardResponse [request_id=" + request_id + ", time_used=" + time_used + ", address=" + address
				+ ", birthday=" + birthday + ", gender=" + gender + ", name=" + name + ", race=" + race + ", side="
				+ side + ", issued_by=" + issued_by + ", valid_date=" + valid_date + ", head_rect=" + head_rect
				+ ", legality=" + legality + "]";
	}

}
