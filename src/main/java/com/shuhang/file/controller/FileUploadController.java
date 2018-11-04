/**
 * @author mingfei.z 2018年11月3日 下午11:03:14
 */
package com.shuhang.file.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuhang.file.model.FileInfo;
import com.shuhang.file.service.FileUploadService;

@Controller
@RequestMapping("/file")
public class FileUploadController {

	private final static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload() {
		
		FileInfo fileInfo = new FileInfo();
		fileInfo.setOriginName("A");
		fileInfo.setTransferName("B");
		fileInfo.setSuffix("txt");
		fileInfo.setUrl("ddddddd");
		fileInfo.setFromSource("HD");
		fileInfo.setSize(10 * 1024);
		
		logger.info(fileInfo.toString());
		try {
			
			fileUploadService.insert(fileInfo);
		} catch (Exception e) {
			logger.error("发生异常", e);
		}
		
		return "success";
	}
	
}
