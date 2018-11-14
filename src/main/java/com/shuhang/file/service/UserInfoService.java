/**
 * @author mingfei.z 2018年11月14日 下午10:45:16
 */
package com.shuhang.file.service;

import com.shuhang.file.model.UserInfo;

public interface UserInfoService {

	UserInfo getUserInfoById(Integer id);
	
	/**
	 * 根据账号 或 手机号查询用户信息
	 * 
	 * @param accountOrMobile
	 * @return
	 * @author mingfei.z 2018年11月14日 下午10:57:41
	 */
	UserInfo getUserInfoByCondition(String accountOrMobile);
	
}
