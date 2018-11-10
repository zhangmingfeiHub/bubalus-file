/**
 * @author mingfei.z 2018年11月10日 下午10:45:56
 */
package com.shuhang.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuhang.file.constants.JsonResult;
import com.shuhang.file.enums.StatementEnum;
import com.shuhang.file.model.vo.ClientAppVo;
import com.shuhang.file.service.ClientAppService;

@Controller
@RequestMapping("/clientApp")
public class ClientAppController {

	@Autowired
	private ClientAppService clientAppService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<String> addClientApp(@RequestBody ClientAppVo appVo, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return JsonResult.newInstance(StatementEnum.ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage(), null);
		}
		
		int clientAppId = clientAppService.addClientApp(appVo);
		
		return JsonResult.success(String.valueOf(clientAppId));
	}
	
}
