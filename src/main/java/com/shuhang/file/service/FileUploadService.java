/**
 * @author mingfei.z 2018年11月4日 上午10:32:04
 */
package com.shuhang.file.service;

import com.shuhang.file.model.FileInfo;

public interface FileUploadService {

	long insert(FileInfo fileInfo);
	
}
