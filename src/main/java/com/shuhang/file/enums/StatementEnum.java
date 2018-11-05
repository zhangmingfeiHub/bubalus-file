/**
 * @author mingfei.z 2018年11月4日 下午10:25:41
 */
package com.shuhang.file.enums;

/**
 * 上传状态
 * 
 * @author mingfei.z 2018年11月4日 下午10:25:46
 */
public enum StatementEnum {

	/** 200 - 成功 */
	SUCCESS("200", "成功"),
	/** 500 - 系统异常 */
	ERROR("500", "系统异常"),
	/** 51001 - 请指定上传文件 */
	ERROR_FILE_EMPTY("51001", "请指定上传文件"),
	/** 51002 - 文件已存在 */
	ERROR_FILE_EXISTS("51002", "文件已存在"),
	/** 51003 - 文件上传失败 */
	ERROR_FILE_UPLOAD_FAIL("51003", "文件上传失败");
	
	private String code;
	private String message;
	
	private StatementEnum(String code, String message) {
		this.code = code;
		this.message = message;
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
	
}
