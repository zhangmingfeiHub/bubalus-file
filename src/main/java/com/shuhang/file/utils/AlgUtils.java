/**
 * @author mingfei.z 2018年11月10日 下午4:44:14
 */
package com.shuhang.file.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import com.shuhang.file.constants.Constants;

/**
 * 算法工具类
 * 
 * @author mingfei.z 2018年11月10日 下午4:44:19
 */
public class AlgUtils {

	private static final Logger logger = LoggerFactory.getLogger(AlgUtils.class);
	
	/**
	 * base64 编码工具
	 * 
	 * @param str
	 * @return
	 * @author mingfei.z 2018年11月10日 下午4:45:41
	 */
	public static String base64Encode(String str) {
		if (StringUtils.isEmpty(str))
			return "";
		
		Encoder encoder = Base64.getEncoder();
		byte[] strBytes = null;
		try {
			strBytes = str.getBytes(Constants.CHARSET.UTF_8);
		} catch (UnsupportedEncodingException e) {
			logger.error("str={} base64编码异常", str, e);
		}
		
		return encoder.encodeToString(strBytes);
	}

	/**
	 * base64 解码工具
	 * 
	 * @param str
	 * @return
	 * @author mingfei.z 2018年11月10日 下午5:01:21
	 */
	public static String base64Decode(String str) {
		if (StringUtils.isEmpty(str))
			return "";
		
		Decoder decoder = Base64.getDecoder();
		byte[] strBytes = decoder.decode(str);
		
		String result = "";
		try {
			result = new String(strBytes, Constants.CHARSET.UTF_8);
		} catch (UnsupportedEncodingException e) {
			logger.error("str={} base64解码异常", str, e);
		}
		
		return result;
	}
	
	/**
	 * md5加密
	 * 
	 * @param str
	 * @return
	 * @author mingfei.z 2018年11月10日 下午5:07:12
	 */
	public static String md5Encode(String str) {
		if (StringUtils.isEmpty(str))
			return "";
		
		byte[] strBytes = null;
		try {
			strBytes = str.getBytes(Constants.CHARSET.UTF_8);
		} catch (UnsupportedEncodingException e) {
			logger.error("str={} md5加密异常", str, e);
		}
		
		return DigestUtils.md5DigestAsHex(strBytes);
	}
	
	/**
	 * md5密文验证
	 * 
	 * @param str
	 * @param md5 密文
	 * @return
	 * @author mingfei.z 2018年11月10日 下午5:13:47
	 */
	public static boolean md5Verify(String str, String md5) {
		String strMd5Encode = md5Encode(str);
		if (strMd5Encode.equalsIgnoreCase(md5)) {
			logger.info("str={} md5验证通过", str);
			return true;
		}
		
		return false;
	}
	
}
