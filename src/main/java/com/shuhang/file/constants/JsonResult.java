/**
 * @author mingfei.z 2018年11月4日 下午10:30:30
 */
package com.shuhang.file.constants;

import com.shuhang.file.enums.StatementEnum;

public class JsonResult<T> {

	private String code;
	private String message;
	private T data;

	public JsonResult() {
		
	}

	public static <T> JsonResult<T> success(T data) {
		return success(StatementEnum.SUCCESS, data);
	}

	public static <T> JsonResult<T> success(StatementEnum statementEnum) {
		return success(statementEnum, null);
	}
	
	public static <T> JsonResult<T> success(StatementEnum statementEnum, T data) {
		return newInstance(statementEnum.getCode(), statementEnum.getMessage(), data);
	}

	public static <T> JsonResult<T> success(String message, T data) {
		return newInstance(StatementEnum.SUCCESS.getCode(), message, data);
	}

	public static <T> JsonResult<T> error(T data) {
		return error(StatementEnum.ERROR, data);
	}

	public static <T> JsonResult<T> error(StatementEnum statementEnum) {
		return error(statementEnum, null);
	}
	
	public static <T> JsonResult<T> error(StatementEnum statementEnum, T data) {
		return newInstance(statementEnum.getCode(), statementEnum.getMessage(), data);
	}

	public static <T> JsonResult<T> error(String code, String message) {
		return newInstance(code, message, null);
	}

	public static <T> JsonResult<T> newInstance(String code, String message, T data) {
		JsonResult<T> jsonResult = new JsonResult<>();
		jsonResult.setCode(code);
		jsonResult.setMessage(message);
		jsonResult.setData(data);
		return jsonResult;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
