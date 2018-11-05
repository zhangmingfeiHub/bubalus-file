/**
 * @author mingfei.z 2018年11月5日 上午10:15:13
 */
package com.shuhang.file.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadFilePathConfig implements WebMvcConfigurer {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${bubalus.access.url}")
	private String accessUrl;
	@Value("${bubalus.upload.url}")
	private String uploadUrl;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("文件上传路径，uploadUrl={}", uploadUrl);
		logger.info("文件访问路径，accessUrl={}", accessUrl);
        registry.addResourceHandler(accessUrl).addResourceLocations("file:" + uploadUrl);
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
}
