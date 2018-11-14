/**
 * @author mingfei.z 2018年11月14日 下午10:48:18
 */
package com.shuhang.file.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.shuhang.file.model.UserInfo;
import com.shuhang.file.service.UserInfoService;
import com.shuhang.file.utils.StringUtils;

public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 授权
	 * 
	 * @author mingfei.z 2018年11月14日 下午10:49:22
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		return authorizationInfo;
	}

	/**
	 * 登录认证
	 * 
	 * @author mingfei.z 2018年11月14日 下午10:50:09
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		// 获取用户的输入的账号
		String username = token.getPrincipal().toString();
		UserInfo userInfo = userInfoService.getUserInfoByCondition(username);
		
		if (null == userInfo) {
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
					userInfo, userInfo.getPassword(), getName());
			
			return authenticationInfo;
		}
		
		return null;
	}

}
