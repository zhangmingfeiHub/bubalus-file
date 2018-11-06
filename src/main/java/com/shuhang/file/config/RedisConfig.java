/**
 * @author mingfei.z 2018年11月6日 下午3:46:26
 */
package com.shuhang.file.config;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * redis 配置
 * 
 * @author mingfei.z 2018年11月6日 下午3:46:49
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Bean
	public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
		
		logger.info("redis container 配置");
		
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
		
		return container;
	}
	
	@Bean
	public MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	
	@Bean
	public Receiver receiver(CountDownLatch latch) {
		return new Receiver(latch);
	}
	
	@Bean
	public CountDownLatch latch() {
		return new CountDownLatch(1);
	}
	
	@Bean
	public StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}
	
	public class Receiver {
		private CountDownLatch latch;
		
		@Autowired
		public Receiver(CountDownLatch latch) {
			this.latch = latch;
		}
		
		public void receiveMessage(String message) {
			latch.countDown();
		}
	}
	
}
