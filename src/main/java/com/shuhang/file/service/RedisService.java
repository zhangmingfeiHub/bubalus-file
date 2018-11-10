/**
 * @author mingfei.z 2018年11月10日 下午5:20:14
 */
package com.shuhang.file.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {

	/**
	 * 放入缓存
	 * 
	 * @param key
	 * @param value
	 * @param timeout 有效期
	 * @param unit 有效期时间单位
	 * @author mingfei.z 2018年11月10日 下午5:27:38
	 */
	void set(String key, String value, int timeout, TimeUnit unit);
	
	/**
	 * 获取缓存数据
	 * 
	 * @param key
	 * @return
	 * @author mingfei.z 2018年11月10日 下午5:28:11
	 */
	String get(String key);
	
}
