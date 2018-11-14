/**
 * @author mingfei.z 2018年11月14日 下午10:36:02
 */
package com.shuhang.file.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	@Bean
	public MyShiroRealm myShiroRealm() {
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		return myShiroRealm;
	}

	/**
	 * 安全管理器
	 * 
	 * @param securityManager
	 * @return
	 * @author mingfei.z 2018年11月14日 下午10:42:05
	 */
	@Bean
	public DefaultWebSecurityManager securityManager(MyShiroRealm myShiroRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm);
		return securityManager;
	}
	
	/**
	 * 配置需要被拦截的请求，被拦截下来的请求交给安全管理器管理
	 * 
	 * @param securityManager
	 * @return
	 * @author mingfei.z 2018年11月14日 下午10:42:37
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		return shiroFilterFactoryBean;
	}
	
}
