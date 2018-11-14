/**
 * @author mingfei.z 2018年11月14日 下午10:46:10
 */
package com.shuhang.file.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuhang.file.mapper.UserInfoMapper;
import com.shuhang.file.model.UserInfo;
import com.shuhang.file.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public UserInfo getUserInfoById(Integer id) {
		
		return userInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public UserInfo getUserInfoByCondition(String accountOrMobile) {
		
		return userInfoMapper.getUserInfoByCondition(accountOrMobile);
	}

}
