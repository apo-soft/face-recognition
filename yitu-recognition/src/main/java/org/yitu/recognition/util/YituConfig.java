package org.yitu.recognition.util;

public interface YituConfig {
	/** 105.1接口，通用身份证识别URL */
	String getYITU_IDCARD_OCR_URL();

	/** 100.1接口文档，允许特征码身份证识别URL */
	String getYITU_IDCARD_URL();

	/** 依图公有云特征抽取URL */
	String getYITU_URL();

	/** 本地服务特征抽取URL */
	String getLOCAL_URL();

	/** access_id */
	String getACCESS_ID();

	/** key(x-signature) */
	String getACCESS_KEY();

	/** 依图公有云比对URL */
	String getYITU_PAIR_URL();

	/** 本地服务比对URL */
	String getLOCAL_PAIR_URL();
}
