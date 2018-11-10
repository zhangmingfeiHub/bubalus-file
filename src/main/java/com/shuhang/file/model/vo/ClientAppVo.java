/**
 * @author mingfei.z 2018年11月10日 下午10:53:15
 */
package com.shuhang.file.model.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ClientAppVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3271913982190679294L;

    private String appId;

    @NotBlank(message = "应用名不能为空")
    private String appName;

    @NotBlank(message = "应用描述不能为空")
    private String appDesc;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

}
