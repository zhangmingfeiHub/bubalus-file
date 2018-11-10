/**
 * @author mingfei.z
 */
package com.shuhang.file.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shuhang.file.constants.Constants;
import com.shuhang.file.enums.StatementEnum;
import com.shuhang.file.model.ClientApp;
import com.shuhang.file.service.AccessTokenService;
import com.shuhang.file.service.RedisService;
import com.shuhang.file.utils.AlgUtils;
import com.shuhang.file.utils.CommonUtils;
import com.shuhang.file.utils.JsonUtils;
import com.shuhang.file.utils.StringUtils;

/**
 * token鉴权<br/>
 * 
 * <p>
 * 原理：
 * 1、客户端根据appId 和 appSecret 获取token；
 *  	token生成逻辑：
 *  	1、判断appId是否存在数据库中，且与appSecret匹配；
 *   	2、token由三部分组成，
 *   		1、第一部分由appId JSON格式base64加密，如：{"appId":"ewrjSDFsfseSF23jjSFE"}
 *   		2、第二部分由客户信息 JSON格式base64加密，如：{"name":"f-product", "desc":"未来店商品模块"}
 *   		3、第三部分由appId 和 客户信息 加密后的字符串，加上私钥 MD5加密，私钥由服务端保存，不提供给客户端；
 *   	3、三部分由 '_' 拼接；
 * 2、客户端访问接口需带上token 和 时间戳，
 *  	校验原理：
 *  	1、校验时间戳：
 *  		客户端传递的时间戳加上有效期（如：1分钟）得到的新的时间戳T1与服务端时间戳T2比较
 *  		1、如果T1 < T2，则不予通过，提示权限不足；
 *  		2、如果T1 >= T2，则继续；
 *  	2、token split拆成三部分，
 *  		1、第一部分解密得到 appId；
 *  		2、根据appId 拿到私钥；
 *  		3、拿第一部分 和 第二部分的加密字符串，加上私钥进行MD5加密；
 *  		4、MD5加密后得到的字符串 与 第三部分比较，相等则继续获取资源；
 * </p>
 * 
 * @author mingfei.z
 */
@RestController
@RequestMapping("/file/auth")
public class AccessTokenController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AccessTokenService accessTokenService;
	@Autowired
	private RedisService redisService;
	
	/**
	 * 获取token，每次生成不同
	 * @param appId 客户端唯一标识
	 * @param appSecret 客户端公钥
	 * @return
	 * @author mingfei.z
	 */
	@RequestMapping(value = "/accessToken", method = RequestMethod.POST)
	public Map<String, Object> accessToken(String appId, String appSecret) {
		
		Map<String, Object> resultMap = new HashMap<>();
		if (StringUtils.isEmpty(appId) || StringUtils.isEmpty(appSecret)) {
			resultMap.put("code", StatementEnum.ERROR_TOKEN_PARAM.getCode());
			resultMap.put("desc", StatementEnum.ERROR_TOKEN_PARAM.getMessage());
		} else {
			ClientApp clientApp = accessTokenService.getClientAppByAppId(appId);
			if (null == clientApp) {
				resultMap.put("code", StatementEnum.ERROR_TOKEN_APPID_NO_EXISTS.getCode());
				resultMap.put("desc", StatementEnum.ERROR_TOKEN_APPID_NO_EXISTS.getMessage());
			} else {
				if (!appSecret.equals(clientApp.getPubSecret())) {
					resultMap.put("code", StatementEnum.ERROR_TOKEN_APPSECRET.getCode());
					resultMap.put("desc", StatementEnum.ERROR_TOKEN_APPSECRET.getMessage());
				} else {
					Map<String, String> appIdMap = new HashMap<>();
					appIdMap.put("appId", clientApp.getAppId());
					String appIdJson = JsonUtils.objectToJson(appIdMap, false);
					String appIdEncode = AlgUtils.base64Encode(appIdJson);
					
					Map<String, String> clientMap = new HashMap<>();
					clientMap.put("appName", clientApp.getAppName());
					clientMap.put("appDesc", clientApp.getAppDesc());
					String clientJson = JsonUtils.objectToJson(clientMap, false);
					String clientEncode = AlgUtils.base64Encode(clientJson);
					
					String md5Encode = AlgUtils.md5Encode(appIdEncode + clientEncode + clientApp.getPriSecret());
					
					String accessToken = appIdEncode + Constants.SEPARATOR.UNDERLINE + clientEncode + Constants.SEPARATOR.UNDERLINE + md5Encode;
					int timeout = 2;
					// key = appId_priSecret
					redisService.set(clientApp.getAppId() + Constants.SEPARATOR.UNDERLINE + clientApp.getPriSecret(), accessToken, timeout, TimeUnit.HOURS);
					
					resultMap.put("access_token", accessToken);
					resultMap.put("expiry_date", CommonUtils.getSeconds(timeout, TimeUnit.HOURS));
				}
			}
		}
		
		logger.info("生成token，appId={}，appSecret={}，token={}", appId, appSecret, resultMap.get("access_token"));
		return resultMap;
	}
	
}
