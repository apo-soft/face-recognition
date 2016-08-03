package org.yitu.recognition.request;

import org.yitu.recognition.vo.FaceFeatureRequest;
import org.yitu.recognition.vo.FaceFeatureResponse;
import org.yitu.recognition.vo.FaceQueryRequest;
import org.yitu.recognition.vo.FaceQueryResponse;
import org.yitu.recognition.vo.IdcardRequest;
import org.yitu.recognition.vo.IdcardResponse;
import org.yitu.recognition.vo.ImgPackageRequest;
import org.yitu.recognition.vo.ImgPackageResponse;

public interface YituHttpClient {
	/**
	 * 101.3 sdk图片解析接口<br>
	 * 将sdk得到的图片数据包解析为可见图片
	 * 
	 * @param request
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年8月2日 下午5:52:46
	 */
	ImgPackageResponse checkImgPackage(ImgPackageRequest request);

	/**
	 * 100.1身份证识别接口
	 * 
	 * @param request
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月11日 下午6:52:41
	 */
	IdcardResponse recognizeIdcard(IdcardRequest request);

	/**
	 * 特征比对请求
	 * 
	 * @param face
	 * @param config
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午6:20:49
	 */
	FaceQueryResponse compareExecute(FaceQueryRequest face);

	/**
	 * 特征抽取请求 - bean方式请求
	 * 
	 * @param face
	 * @param config
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月1日 下午5:22:47
	 */
	FaceFeatureResponse execute(FaceFeatureRequest face);
}
