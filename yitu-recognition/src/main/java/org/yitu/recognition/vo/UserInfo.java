package org.yitu.recognition.vo;

/**
 * 100.1接口请求<br>
 * 用户信息填写
 * 
 * @author yujinshui
 * @createTime 2016年7月7日 下午5:00:00
 */
public class UserInfo {

	private String image_content;
	private String feature_content;
	private String name;
	private String citizen_id;

	/**
	 * 经Base64编码的用户登记照的内容[使用条件：mode=1]
	 * <p>
	 * 照片要求为JPEG格式 最大图片大小:3MB
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:00:20
	 */
	public String getImage_content() {
		return image_content;
	}

	/**
	 * 经Base64编码的用户登记照的内容[使用条件：mode=1]
	 * <p>
	 * 照片要求为JPEG格式 最大图片大小:3MB
	 * 
	 * @param image_content
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:01:31
	 */
	public void setImage_content(String image_content) {
		this.image_content = image_content;
	}

	/**
	 * 经Base64编码的用户特征内容[使用条件：mode=2]
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:02:13
	 */
	public String getFeature_content() {
		return feature_content;
	}

	/**
	 * 经Base64编码的用户特征内容[使用条件：mode=2]
	 * 
	 * @param feature_content
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:02:42
	 */
	public void setFeature_content(String feature_content) {
		this.feature_content = feature_content;
	}

	/**
	 * 用户姓名【使用条件：mode=3】,最长128字节
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:02:56
	 */
	public String getName() {
		return name;
	}

	/**
	 * 用户姓名【使用条件：mode=3】，最长128字节
	 * 
	 * @param name
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:02:53
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 身份证号【使用条件：mode=3】
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:03:25
	 */
	public String getCitizen_id() {
		return citizen_id;
	}

	/**
	 * 身份证号【使用条件：mode=3】
	 * 
	 * @param citizen_id
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午5:04:04
	 */
	public void setCitizen_id(String citizen_id) {
		this.citizen_id = citizen_id;
	}

}
