/**
 * @author mingfei.z
 */
package com.shuhang.file.service;

import com.shuhang.file.model.ClientApp;

public interface AccessTokenService {

	ClientApp getClientAppByAppId(String appId);
	
}
