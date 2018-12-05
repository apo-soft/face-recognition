package org.face.identify.faceid.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.face.identify.faceid.vo.DetectRequest;
import org.face.identify.faceid.vo.DetectResponse;
import com.alibaba.fastjson.JSON;

/**
 * 暂不启用，仅用于记录代码编写方式
 * 
 * @author yujinshui
 * @createTime 2016年7月14日 下午6:28:02
 */
@Deprecated
public class FaceHttpClientUtil {
	private FaceHttpClientUtil() {
	}

	/**
	 * 检测接口
	 * 
	 * @param detect
	 *            请求信息
	 * @param config
	 *            配置信息
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午5:35:10
	 */
	public static DetectResponse doPost(DetectRequest detect, FaceConfig config) throws IOException {
		return postDetectRequest(detect, config);
	}

	/**
	 * 检测接口
	 * 
	 * @param detect
	 *            请求信息
	 * @param config
	 *            配置信息
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @Author yujinshui
	 * @createTime 2016年7月12日 下午5:35:10
	 * @deprecated
	 */
	private static DetectResponse postDetectRequest(DetectRequest detect, FaceConfig config) throws IOException {
		HttpClient httpClient = null;
		HttpPost httppost = new HttpPost(config.getDETECT_URL());
		httpClient = HttpClients.createDefault();
		MultipartEntity entityInput = new MultipartEntity();
		entityInput.addPart("api_key", new StringBody(config.getAPI_KEY(), Charset.forName("UTF-8")));
		entityInput.addPart("api_secret", new StringBody(config.getAPI_SECRET(), Charset.forName("UTF-8")));
		entityInput.addPart("image", new FileBody(detect.getImage()));
		httppost.setEntity(entityInput);
		HttpResponse response = httpClient.execute(httppost);
		HttpEntity entity = response.getEntity();
		String res = EntityUtils.toString(entity);
		DetectResponse detectRes = JSON.parseObject(res, DetectResponse.class);

		return detectRes;
	}

	/**
	 * 父子类反射方式返回SortedMap
	 * 
	 * @param o
	 * @return
	 * @throws IllegalAccessException
	 * @Author yujinshui
	 * @createTime 2016年7月14日 下午6:28:54
	 */
	public static SortedMap<String, Object> createSortedMap(Object o) throws IllegalAccessException {
		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
		Class<?> cls = o.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			Object v = f.get(o);
			if (v != null && v != "") {
				parameters.put(f.getName(), v);
			}
		}
		/**
		 * 迭代读取父类
		 */
		for (Class<?> superCls = cls.getSuperclass(); superCls != null; superCls = superCls.getSuperclass()) {
			fields = superCls.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				Object v = f.get(o);
				if (v != null && v != "") {
					parameters.put(f.getName(), v);
				}
			}
		}
		return parameters;
	}

	/**
	 * 实现从对象到String的转换, 针对null对象进行特殊处理,直接返回nullString 其他情况参考
	 * {@link String#valueOf(Object)}
	 * 
	 * @param o
	 *            待转换为String的对象
	 * @return 输入o为null时,返回null,其他情况返回String.valueOf(o);
	 */
	private static String toString(Object o) {
		if (o == null) {
			return null;
		} else if (o instanceof String) {
			return (String) o;
		} else {
			return String.valueOf(o);
		}
	}
}
