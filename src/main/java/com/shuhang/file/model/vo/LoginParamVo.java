/**
 * @author mingfei.z
 */
package com.shuhang.file.model.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class LoginParamVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2040804183679180074L;

	@NotBlank(message = "请输入用户名")
	private String username;
	@NotBlank(message = "请输入密码")
	private String password;
	@NotBlank(message = "请输入验证码")
	private String imageCode;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

}
