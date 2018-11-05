/**
 * @author mingfei.z 2018年11月4日 下午11:39:25
 */
package com.shuhang.file.model.vo;

import java.io.Serializable;

public class FileInfoVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -42806071605180538L;
	private String originName;
	
	private String url;
	
	private Integer size;

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
