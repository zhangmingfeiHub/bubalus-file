/**
 * @author mingfei.z
 */
package com.shuhang.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value = {"/login", ""})
	public String login() {
		return "login";
	}
	
}
