package org.face.identify.faceid.send;

import java.io.File;
import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.face.identify.faceid.vo.DetectRequest;
import org.face.identify.faceid.vo.DetectResponse;
import org.face.identify.faceid.vo.OcridcardRequest;
import org.face.identify.faceid.vo.OcridcardResponse;
import org.face.identify.faceid.vo.verify.MegliveRequest;
import org.face.identify.faceid.util.FaceConfig;
import org.face.identify.faceid.vo.verify.FacetokenRequest;
import org.face.identify.faceid.vo.verify.RawImageRequest;
import org.face.identify.faceid.vo.verify.VerifyActiveRequest;
import org.face.identify.faceid.vo.verify.VerifyBaseRequest;
import org.face.identify.faceid.vo.verify.VerifyPassiveRequest;
import org.face.identify.faceid.vo.verify.VerifyResponse;

import com.alibaba.fastjson.JSON;

public class FaceHttpClientRequest implements FaceHttpClient {
    private FaceConfig config = null;
    private HttpClient httpClient = null;
    private HttpPost httppost = null;
    private MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    // private static String urlName = "";

    @Deprecated
    public FaceHttpClientRequest(FaceConfig config) {
        init(config);
    }

    /**
     * @param config
     * @param urlName [detect:检测接口，ocrid:身份识别接口，verify:身份比对接口]
     */
    public FaceHttpClientRequest(FaceConfig config, String urlName) {
        init(config);
        if ("detect".equals(urlName)) {
            httppost = new HttpPost(config.getDETECT_URL());
        } else if ("ocrid".equals(urlName)) {
            httppost = new HttpPost(config.getOCRIDCARD_URL());
        } else if ("verify".equals(urlName)) {
            httppost = new HttpPost(config.getVERIFY_URL());
        } else {
            throw new IllegalArgumentException("参数不符合要求");
        }
    }

    private void init(FaceConfig config) {
        this.config = config;
        httpClient = HttpClients.createDefault();
        builder.addTextBody("api_key", config.getAPI_KEY());
        builder.addTextBody("api_secret", config.getAPI_SECRET());
    }

    private void checkConfig() {
        if (config == null) {
            throw new IllegalArgumentException("配置信息不能为NULL");
        } else if (config.getAPI_KEY() == null || "".equals(config.getAPI_KEY())) {
            throw new IllegalArgumentException("api_key信息不能为空");
        } else if (config.getAPI_SECRET() == null || "".equals(config.getAPI_SECRET())) {
            throw new IllegalArgumentException("api_secret信息不能为空");
        }
    }

    /**
     * 检测接口
     *
     * @param detect request信息
     * @return
     * @throws IOException
     * @Author yujinshui
     * @createTime 2016年7月13日 下午11:28:47
     */
    private DetectResponse doPost(DetectRequest detect) throws IOException {
        if (httppost == null)
            httppost = new HttpPost(config.getDETECT_URL());
        builder.addBinaryBody("image", detect.getImage());
        httppost.setEntity(builder.build());
        return response(DetectResponse.class);
    }

    /**
     * 返回信息-字符串
     *
     * @param <T>
     * @return
     * @throws IOException
     * @Author yujinshui
     * @createTime 2016年7月13日 下午11:26:18
     */
    private <T> T response(Class<T> clazz) throws IOException {
        HttpResponse response = httpClient.execute(httppost);
        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity, Consts.UTF_8.toString());
        return JSON.parseObject(res, clazz);
    }

    private OcridcardResponse doPost(OcridcardRequest request) throws IOException {
        if (httppost == null)
            httppost = new HttpPost(config.getOCRIDCARD_URL());
        builder.addBinaryBody("image", request.getImage());
        String legality = "0";// 默认：0
        if ("0".equals(request.getLegality()) || "1".equals(request.getLegality())) {
            legality = request.getLegality();
        }
        builder.addTextBody("legality", legality);
        httppost.setEntity(builder.build());
        return response(OcridcardResponse.class);
    }

    @Override
    public DetectResponse execute(DetectRequest request) {
        checkConfig();
        DetectResponse response = null;
        try {
            response = doPost(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public OcridcardResponse execute(OcridcardRequest request) {
        checkConfig();
        OcridcardResponse response = null;
        try {
            response = doPost(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 字典参数值检查，并赋值
     *
     * @param verify
     * @Author yujinshui
     * @createTime 2016年7月16日 下午7:33:26
     */
    private void checkAndSetBaseParams(VerifyBaseRequest verify) {
        if (!"0".equals(verify.getComparison_type()) && "1".equals(verify.getComparison_type())) {
            throw new IllegalArgumentException("VerifyPassiveRequest comparison_type 参数值错误");
        }
        if (!"meglive".equals(verify.getFace_image_type()) && !"meglive".equals(verify.getFace_image_type())
                && !"meglive".equals(verify.getFace_image_type())) {
            throw new IllegalArgumentException("VerifyPassiveRequest face_image_type 参数值错误");
        }
        if (httppost == null)
            httppost = new HttpPost(config.getVERIFY_URL());
        builder.addTextBody("comparison_type", verify.getComparison_type());
        builder.addTextBody("face_image_type", verify.getFace_image_type());
    }

    /**
     * 无源参数 - 赋值部分
     *
     * @param passive
     * @Author yujinshui
     * @createTime 2016年7月16日 下午8:09:47
     */
    private void setPassiveValues(VerifyPassiveRequest passive) {
        builder.addTextBody("uuid", passive.getUuid());
        for (File f : passive.getImage_ref()) {
            builder.addBinaryBody("image_ref", f);
        }
    }

    @Override
    public VerifyResponse execute(VerifyPassiveRequest passive, FacetokenRequest facetoken) throws IOException {
        checkConfig();
        checkAndSetBaseParams(passive);
        setPassiveValues(passive);
        setFaceTokenEntity(facetoken);
        return response(VerifyResponse.class);
    }

    /**
     * facetoken模式赋值
     *
     * @param facetoken
     * @Author yujinshui
     * @createTime 2016年7月17日 上午10:47:21
     */
    private void setFaceTokenEntity(FacetokenRequest facetoken) {
        builder.addTextBody("face_token", facetoken.getFace_token());
        httppost.setEntity(builder.build());
    }

    @Override
    public VerifyResponse execute(VerifyPassiveRequest passive, MegliveRequest meglive) throws IOException {
        checkConfig();
        checkAndSetBaseParams(passive);
        setPassiveValues(passive);
        setMegliveEntity(meglive);
        return response(VerifyResponse.class);
    }

    /**
     * meglive模式赋值
     *
     * @param meglive
     * @Author yujinshui
     * @createTime 2016年7月17日 上午10:45:10
     */
    private void setMegliveEntity(MegliveRequest meglive) {
        builder.addTextBody("delta", meglive.getDelta());
        builder.addBinaryBody("image_best", meglive.getImage_best());
        if (meglive.getImage_env() != null) {
            builder.addBinaryBody("image_env", meglive.getImage_env());
        }
        if (meglive.getImage_action() != null) {
            for (File file : meglive.getImage_action()) {
                builder.addBinaryBody("image_action", file);
            }
        }
        httppost.setEntity(builder.build());
    }

    @Override
    public VerifyResponse execute(VerifyPassiveRequest passive, RawImageRequest rawimage) throws IOException {
        checkConfig();
        checkAndSetBaseParams(passive);
        setPassiveValues(passive);
        setRawImageEntity(rawimage);
        return response(VerifyResponse.class);
    }

    /**
     * rawimage模式赋值
     *
     * @param rawimage
     * @Author yujinshui
     * @createTime 2016年7月17日 上午10:46:42
     */
    private void setRawImageEntity(RawImageRequest rawimage) {
        builder.addBinaryBody("image", rawimage.getImage());
        if (rawimage.getFail_when_multiple_faces() != null) {
            builder.addTextBody("fail_when_multiple_faces", rawimage.getFail_when_multiple_faces());
        }
        if (rawimage.getFace_quality_threshold() != null) {
            builder.addTextBody("face_quality_threshold", rawimage.getFace_quality_threshold());
        }
        if (rawimage.getReturn_faces() != null) {
            builder.addTextBody("return_faces", rawimage.getReturn_faces());
        }
        httppost.setEntity(builder.build());
    }

    @Override
    public VerifyResponse execute(VerifyActiveRequest active, FacetokenRequest facetoken) throws IOException {
        checkConfig();
        checkAndSetBaseParams(active);
        setActiveValues(active);
        setFaceTokenEntity(facetoken);
        return response(VerifyResponse.class);
    }

    /**
     * 有源 - 参数赋值部分
     *
     * @param active
     * @Author yujinshui
     * @createTime 2016年7月17日 上午10:39:16
     */
    private void setActiveValues(VerifyActiveRequest active) {
        builder.addTextBody("idcard_name", active.getIdcard_name());
        builder.addTextBody("idcard_number", active.getIdcard_number());
        if (active.getImage_ref() != null) {
            for (File f : active.getImage_ref()) {
                builder.addBinaryBody("image_ref", f);
            }
        }
    }

    @Override
    public VerifyResponse execute(VerifyActiveRequest active, MegliveRequest meglive) throws IOException {
        checkConfig();
        checkAndSetBaseParams(active);
        setActiveValues(active);
        setMegliveEntity(meglive);
        return response(VerifyResponse.class);
    }

    @Override
    public VerifyResponse execute(VerifyActiveRequest active, RawImageRequest rawimage) throws IOException {
        checkConfig();
        checkAndSetBaseParams(active);
        setActiveValues(active);
        setRawImageEntity(rawimage);
        return response(VerifyResponse.class);
    }
}
