/**
 * @author mingfei.z 2018年11月10日 下午5:28:35
 */
package com.shuhang.file.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.shuhang.file.service.RedisService;

@Service("redisService")
public class RedisServiceImpl implements RedisService {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Override
	public void set(String key, String value, int timeout, TimeUnit unit) {
		redisTemplate.opsForValue().set(key, value, timeout, unit);
	}

	@Override
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

}
