/**
 * @author mingfei.z 2018年11月4日 上午10:36:18
 */
package com.shuhang.file.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuhang.file.mapper.FileInfoMapper;
import com.shuhang.file.model.FileInfo;
import com.shuhang.file.service.FileUploadService;

@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	private FileInfoMapper fileInfoMapper;
	
	@Override
	public long insert(FileInfo fileInfo) {
		
		fileInfoMapper.insertSelective(fileInfo);
		
		return fileInfo.getId();
	}

}
