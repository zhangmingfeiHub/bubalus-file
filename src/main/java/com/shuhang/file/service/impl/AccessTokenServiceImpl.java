/**
 * @author mingfei.z
 */
package com.shuhang.file.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.shuhang.file.constants.Constants;
import com.shuhang.file.mapper.ClientAppMapper;
import com.shuhang.file.model.ClientApp;
import com.shuhang.file.model.ClientAppExample;
import com.shuhang.file.service.AccessTokenService;

@Service("accessTokenService")
public class AccessTokenServiceImpl implements AccessTokenService {

	@Autowired
	private ClientAppMapper clientAppMapper;
	
	@Override
	public ClientApp getClientAppByAppId(String appId) {
		
		ClientAppExample caExample = new ClientAppExample();
		caExample.createCriteria().andAppStatusEqualTo(Constants.STATUS.YES).andAppIdEqualTo(appId);
		List<ClientApp> list = clientAppMapper.selectByExample(caExample);
		if (CollectionUtils.isEmpty(list))
			return null;
		
		return list.get(0);
	}

}
