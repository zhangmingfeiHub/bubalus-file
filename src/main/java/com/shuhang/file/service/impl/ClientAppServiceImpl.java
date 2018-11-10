/**
 * @author mingfei.z 2018年11月10日 下午11:04:20
 */
package com.shuhang.file.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuhang.file.mapper.ClientAppMapper;
import com.shuhang.file.model.ClientApp;
import com.shuhang.file.model.vo.ClientAppVo;
import com.shuhang.file.service.ClientAppService;
import com.shuhang.file.utils.StringUtils;

@Service("clientAppService")
public class ClientAppServiceImpl implements ClientAppService {

	@Autowired
	private ClientAppMapper clientAppMapper;
	
	@Override
	public int addClientApp(ClientAppVo appVo) {
		
		ClientApp clientApp = new ClientApp();
		BeanUtils.copyProperties(appVo, clientApp);
		
		String appId = StringUtils.getRandomNumAndString(16);
		String pubSecret = StringUtils.getRandomNumAndString(24);
		String priSecret = StringUtils.getRandomNumAndString(24);
		
		clientApp.setAppId(appId);
		clientApp.setPubSecret(pubSecret);
		clientApp.setPriSecret(priSecret);
		clientApp.setCreateOperator("Postman");
		clientAppMapper.insertSelective(clientApp);
		return clientApp.getId();
	}

}
