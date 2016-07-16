package org.faceID.recognition.send;

import java.io.IOException;

import org.faceID.recognition.vo.DetectRequest;
import org.faceID.recognition.vo.DetectResponse;
import org.faceID.recognition.vo.OcridcardRequest;
import org.faceID.recognition.vo.OcridcardResponse;
import org.faceID.recognition.vo.verify.FacetokenRequest;
import org.faceID.recognition.vo.verify.MegliveRequest;
import org.faceID.recognition.vo.verify.RawImageRequest;
import org.faceID.recognition.vo.verify.VerifyActiveRequest;
import org.faceID.recognition.vo.verify.VerifyPassiveRequest;
import org.faceID.recognition.vo.verify.VerifyResponse;

public interface FaceHttpClient {
	/**
	 * 人脸检测接口
	 * 
	 * @param request
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午5:37:15
	 */
	DetectResponse execute(DetectRequest request);

	/**
	 * 身份证识别接口
	 * 
	 * @param request
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月13日 下午11:51:42
	 */
	OcridcardResponse execute(OcridcardRequest request);

	/**
	 * 无源 - facetoken模式
	 * 
	 * @param passive
	 * @param facetoken
	 * @return
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:46:05
	 */
	VerifyResponse execute(VerifyPassiveRequest passive, FacetokenRequest facetoken) throws IOException;

	/**
	 * 无源 - meglive模式
	 * 
	 * @param passive
	 * @param meglive
	 * @return
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:46:29
	 */
	VerifyResponse execute(VerifyPassiveRequest passive, MegliveRequest meglive) throws IOException;

	/**
	 * 无源 - rawimage模式
	 * 
	 * @param passive
	 * @param rawimage
	 * @return
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:46:44
	 */
	VerifyResponse execute(VerifyPassiveRequest passive, RawImageRequest rawimage) throws IOException;

	/**
	 * 有源 - facetoken模式
	 * 
	 * @param active
	 * @param facetoken
	 * @return
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:48:32
	 */
	VerifyResponse execute(VerifyActiveRequest active, FacetokenRequest facetoken) throws IOException;

	/**
	 * 有源 - meglive模式
	 * 
	 * @param active
	 * @param meglive
	 * @return
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:48:54
	 */
	VerifyResponse execute(VerifyActiveRequest active, MegliveRequest meglive) throws IOException;

	/**
	 * 有源 - rawimage模式
	 * 
	 * @param active
	 * @param rawimage
	 * @return
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月16日 上午9:49:07
	 */
	VerifyResponse execute(VerifyActiveRequest active, RawImageRequest rawimage) throws IOException;
}
