package org.face.identify.yitu.vo;

/**
 * 100.1接口请求<br>
 * 身份证请求
 * 
 * @author yujinshui
 * @createTime 2016年7月7日 上午9:52:40
 */
public class IdcardRequest {
	private String session_id;
	private Integer mode;
	private UserInfo user_info;
	private Options options;

	/**
	 * [必填]会话号,用来表示会话<br>
	 * id最大长度128字节
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:00:46
	 */
	public String getSession_id() {
		return session_id;
	}

	/**
	 * [必填]会话号,用来表示会话<br>
	 * id最大长度128字节
	 * 
	 * @param session_id
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:01:30
	 */
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	/**
	 * 上传模式,包括如下几种: <br>
	 * 1: 上传图片模式(默认)<br>
	 * 2: 上传特征模式<br>
	 * 3: 上传身份信息模式
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:01:48
	 */
	public Integer getMode() {
		return mode;
	}

	/**
	 * 上传模式,包括如下几种: <br>
	 * 1: 上传图片模式(默认)<br>
	 * 2: 上传特征模式<br>
	 * 3: 上传身份信息模式
	 * 
	 * @param mode
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:02:08
	 */
	public void setMode(Integer mode) {
		this.mode = mode;
	}

	/**
	 * [必填]用户信息
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:02:17
	 */
	public UserInfo getUser_info() {
		return user_info;
	}

	/**
	 * [必填]用户信息
	 * 
	 * @param user_info
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:02:28
	 */
	public void setUser_info(UserInfo user_info) {
		this.user_info = user_info;
	}

	/**
	 * 其他选项
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:03:08
	 */
	public Options getOptions() {
		return options;
	}

	/**
	 * 其他选项
	 * 
	 * @param options
	 * @Author yujinshui
	 * @createTime 2016年7月7日 下午6:03:17
	 */
	public void setOptions(Options options) {
		this.options = options;
	}

}
