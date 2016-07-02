package org.yitu.recognition.vo;

/**
 * 图片比对服务
 * 
 * @author yujinshui
 * @createTime 2016年7月2日 下午1:57:21
 */
public class FaceQueryRequest {
	private String query_image_content;
	private String query_image_feature;
	private String query_image_package;
	private boolean query_image_package_check_same_person;
	private boolean query_image_return_image_list;
	private Integer query_image_type;
	private String database_image_content;
	private String database_image_feature;
	private Integer database_image_type;
	private boolean auto_flip;
	private boolean auto_rotate_for_query;
	private boolean auto_rotate_for_database;
	private String true_negative_rate;
	private Integer query_image_detection_mode;
	private Integer max_faces_allowed;
	private boolean enable_verify_detail;
	private boolean return_face_rect;

	/**
	 * 查询图片(JPG)的Base64编码【小于1M查询图片和特征量两个必须有一个】
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:19:13
	 */
	public String getQuery_image_content() {
		return query_image_content;
	}

	/**
	 * 查询图片(JPG)的Base64编码【小于1M查询图片和特征量两个必须有一个】
	 * 
	 * @param query_image_content
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:20:32
	 */
	public void setQuery_image_content(String query_image_content) {
		this.query_image_content = query_image_content;
	}

	/**
	 * 查询人脸的特征量
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:20:59
	 */
	public String getQuery_image_feature() {
		return query_image_feature;
	}

	/**
	 * 查询人脸的特征量
	 * 
	 * @param query_image_feature
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:21:21
	 */
	public void setQuery_image_feature(String query_image_feature) {
		this.query_image_feature = query_image_feature;
	}

	/**
	 * 查询人脸的大礼包-来自依图活体SDK捕捉的图片
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:21:53
	 */
	public String getQuery_image_package() {
		return query_image_package;
	}

	/**
	 * 查询人脸的大礼包-来自依图活体SDK捕捉的图片
	 * 
	 * @param query_image_package
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:22:09
	 */
	public void setQuery_image_package(String query_image_package) {
		this.query_image_package = query_image_package;
	}

	/**
	 * 是否检查大礼包中查询照片是同一个人【默认不开启检查】
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:23:03
	 */
	public boolean isQuery_image_package_check_same_person() {
		return query_image_package_check_same_person;
	}

	/**
	 * 是否检查大礼包中查询照片是同一个人【默认不开启检查】
	 * 
	 * @param query_image_package_check_same_person
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:23:36
	 */
	public void setQuery_image_package_check_same_person(boolean query_image_package_check_same_person) {
		this.query_image_package_check_same_person = query_image_package_check_same_person;
	}

	/**
	 * 是否返回大礼包中解出的图片列表- Base64编码
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:23:48
	 */
	public boolean isQuery_image_return_image_list() {
		return query_image_return_image_list;
	}

	/**
	 * 是否返回大礼包中解出的图片列表- Base64编码
	 * 
	 * @param query_image_return_image_list
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:27:32
	 */
	public void setQuery_image_return_image_list(boolean query_image_return_image_list) {
		this.query_image_return_image_list = query_image_return_image_list;
	}

	/**
	 * 【必填】查询图片的类型
	 * <p>
	 * 类证件照 = 3 目前只支持查询照片类型为类证件照。
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:27:48
	 */
	public Integer getQuery_image_type() {
		return query_image_type;
	}

	/**
	 * 【必填】查询图片的类型
	 * <p>
	 * 类证件照 = 3 目前只支持查询照片类型为类证件照。
	 * 
	 * @param query_image_type
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:28:23
	 */
	public void setQuery_image_type(Integer query_image_type) {
		this.query_image_type = query_image_type;
	}

	/**
	 * 登记照片(JPG)的Base64编码【<1M 查询图片和特征量两个必须有一个】
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:28:46
	 */
	public String getDatabase_image_content() {
		return database_image_content;
	}

	/**
	 * 登记照片(JPG)的Base64编码【<1M 查询图片和特征量两个必须有一个】
	 * 
	 * @param database_image_content
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:29:14
	 */
	public void setDatabase_image_content(String database_image_content) {
		this.database_image_content = database_image_content;
	}

	/**
	 * 登记人脸的特征量
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:31:11
	 */
	public String getDatabase_image_feature() {
		return database_image_feature;
	}

	/**
	 * 登记人脸的特征量
	 * 
	 * @param database_image_feature
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:31:19
	 */
	public void setDatabase_image_feature(String database_image_feature) {
		this.database_image_feature = database_image_feature;
	}

	/**
	 * 【必填】登记照片的图片的类型
	 * <p>
	 * 证件照= 1<br>
	 * 证件照翻拍= 2<br>
	 * 类证件照 = 3<br>
	 * 金融行业水印的证件照(不带横纹的老版网纹照) = 5<br>
	 * 公安行业水印证件照( 带横纹的老版网纹照 ) = 7<br>
	 * 铁丝网水印的证件照(新版网纹照) = 9<br>
	 * 自动类型水印照 (能够自动区分 金融, 公安, 铁丝网, 正确率99.5%) = 101
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:29:53
	 */
	public Integer getDatabase_image_type() {
		return database_image_type;
	}

	/**
	 * 【必填】登记照片的图片的类型
	 * <p>
	 * 证件照= 1<br>
	 * 证件照翻拍= 2<br>
	 * 类证件照 = 3<br>
	 * 金融行业水印的证件照(不带横纹的老版网纹照) = 5<br>
	 * 公安行业水印证件照( 带横纹的老版网纹照 ) = 7<br>
	 * 铁丝网水印的证件照(新版网纹照) = 9<br>
	 * 自动类型水印照 (能够自动区分 金融, 公安, 铁丝网, 正确率99.5%) = 101
	 * 
	 * @param database_image_type
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:30:55
	 */
	public void setDatabase_image_type(Integer database_image_type) {
		this.database_image_type = database_image_type;
	}

	/**
	 * 是否开启自动镜像优化[只支持查询照为非水印照]
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:31:50
	 */
	public boolean isAuto_flip() {
		return auto_flip;
	}

	/**
	 * 是否开启自动镜像优化[只支持查询照为非水印照]
	 * 
	 * @param auto_flip
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:32:10
	 */
	public void setAuto_flip(boolean auto_flip) {
		this.auto_flip = auto_flip;
	}

	/**
	 * 是否开启查询照的自动旋转识别【只支持非水印照】
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:32:49
	 */
	public boolean isAuto_rotate_for_query() {
		return auto_rotate_for_query;
	}

	/**
	 * 是否开启查询照的自动旋转识别【只支持非水印照】
	 * 
	 * @param auto_rotate_for_query
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:32:55
	 */
	public void setAuto_rotate_for_query(boolean auto_rotate_for_query) {
		this.auto_rotate_for_query = auto_rotate_for_query;
	}

	/**
	 * 是否开启登记照的自动旋转识别【只支持非水印照】
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:33:56
	 */
	public boolean isAuto_rotate_for_database() {
		return auto_rotate_for_database;
	}

	/**
	 * 是否开启登记照的自动旋转识别【只支持非水印照】
	 * 
	 * @param auto_rotate_for_database
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:34:09
	 */
	public void setAuto_rotate_for_database(boolean auto_rotate_for_database) {
		this.auto_rotate_for_database = auto_rotate_for_database;
	}

	/**
	 * 【必填】期望的负例的recall
	 * <p>
	 * 只能填以下三种字符串 <br>
	 * 99.9 表示千分之一的误报率 <br>
	 * 99.99 表示 万分之一的误报率<br>
	 * 99.999 表示 十万分之一的误报率
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:34:26
	 */
	public String getTrue_negative_rate() {
		return true_negative_rate;
	}

	/**
	 * 【必填】期望的负例的recall
	 * <p>
	 * 只能填以下三种字符串 <br>
	 * 99.9 表示千分之一的误报率 <br>
	 * 99.99 表示 万分之一的误报率<br>
	 * 99.999 表示 十万分之一的误报率
	 * 
	 * @param true_negative_rate
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:35:36
	 */
	public void setTrue_negative_rate(String true_negative_rate) {
		this.true_negative_rate = true_negative_rate;
	}

	/**
	 * 查询照人脸检测模型
	 * <p>
	 * 查询照人脸检测模型分类:<br>
	 * 1 使用人脸检测分数最高的人脸做后续1比1比对<br>
	 * 2 使用所有被识别被检测到的人脸做后续1比1比对<br>
	 * 3 使用被检测到的最大的人脸做后续1比1比对<br>
	 * 目前只有公有云支持该参数
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:35:51
	 */
	public Integer getQuery_image_detection_mode() {
		return query_image_detection_mode;
	}

	/**
	 * 查询照人脸检测模型
	 * <p>
	 * 查询照人脸检测模型分类:<br>
	 * 1 使用人脸检测分数最高的人脸做后续1比1比对<br>
	 * 2 使用所有被识别被检测到的人脸做后续1比1比对<br>
	 * 3 使用被检测到的最大的人脸做后续1比1比对<br>
	 * 目前只有公有云支持该参数
	 * 
	 * @param query_image_detection_mode
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:36:50
	 */
	public void setQuery_image_detection_mode(Integer query_image_detection_mode) {
		this.query_image_detection_mode = query_image_detection_mode;
	}

	/**
	 * 查询照片中至多有几个人脸
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午2:37:07
	 */
	public Integer getMax_faces_allowed() {
		return max_faces_allowed;
	}

	/**
	 * 查询照片中至多有几个人脸
	 * 
	 * @param max_faces_allowed
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:00:11
	 */
	public void setMax_faces_allowed(Integer max_faces_allowed) {
		this.max_faces_allowed = max_faces_allowed;
	}

	/**
	 * 是否返回比对的详细信息,包含查询照每张人脸和登记照人脸分别比对的分数
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:00:34
	 */
	public boolean isEnable_verify_detail() {
		return enable_verify_detail;
	}

	/**
	 * 是否返回比对的详细信息,包含查询照每张人脸和登记照人脸分别比对的分数
	 * 
	 * @param enable_verify_detail
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:00:40
	 */
	public void setEnable_verify_detail(boolean enable_verify_detail) {
		this.enable_verify_detail = enable_verify_detail;
	}

	/**
	 * 是否返回查询照每张人脸的位置
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:00:53
	 */
	public boolean isReturn_face_rect() {
		return return_face_rect;
	}

	/**
	 * 是否返回查询照每张人脸的位置
	 * 
	 * @param return_face_rect
	 * @Author yujinshui
	 * @createTime 2016年7月2日 下午3:00:58
	 */
	public void setReturn_face_rect(boolean return_face_rect) {
		this.return_face_rect = return_face_rect;
	}

}
