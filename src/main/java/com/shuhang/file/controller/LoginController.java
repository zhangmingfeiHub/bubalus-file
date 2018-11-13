/**
 * @author mingfei.z
 */
package com.shuhang.file.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuhang.file.constants.JsonResult;
import com.shuhang.file.enums.StatementEnum;
import com.shuhang.file.model.vo.LoginParamVo;

@Controller
public class LoginController {

	@RequestMapping(value = {"/login", ""}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public JsonResult<String> login(@RequestBody LoginParamVo paramVo, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return JsonResult.error(StatementEnum.ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
		}
		
		
		
	}
	
}
