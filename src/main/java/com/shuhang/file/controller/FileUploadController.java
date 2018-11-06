/**
 * @author mingfei.z 2018年11月3日 下午11:03:14
 */
package com.shuhang.file.controller;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shuhang.file.constants.JsonResult;
import com.shuhang.file.enums.StatementEnum;
import com.shuhang.file.model.FileInfo;
import com.shuhang.file.model.vo.FileInfoVo;
import com.shuhang.file.service.FileUploadService;
import com.shuhang.file.utils.DateUtils;
import com.shuhang.file.utils.JsonUtils;
import com.shuhang.file.utils.StringUtils;

@Controller
@RequestMapping("/file")
public class FileUploadController {

	private final static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@Value("${bubalus.upload.url}")
	private String uploadUrl;
	@Value("${bubalus.access.domain}")
	private String accessDomain;
	
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public JsonResult<FileInfoVo> upload(@RequestParam("file") MultipartFile file) {
		
		logger.info("文件上传开始！");
		
		// 判断文件是否为空
		if (file.isEmpty())
			return JsonResult.error(StatementEnum.ERROR_FILE_EMPTY);
		
		// 获取文件名称
		String originName = file.getOriginalFilename();
		
		// 文件后缀
		String suffix = originName.substring(originName.lastIndexOf("."));
		
		// 重新生成唯一文件名，用于存储数据库
		String transferName = StringUtils.getRandomNumAndString(32) + suffix;
		
		// 文件大小
		long size = file.getSize();
		
		// 文件上传绝对路径
		StringBuilder filePathSb = new StringBuilder();
		filePathSb.append("api")
				.append(File.separator)
				.append("file")
				.append(File.separator)
				.append(DateUtils.getYearString())
				.append(File.separator)
				.append(DateUtils.getMonthString())
				.append(File.separator)
				.append(DateUtils.getDayString())
				.append(File.separator);
		String filePath = filePathSb.toString();
		//创建文件
		File dest = new File(uploadUrl + File.separator + filePath + transferName);
		// 判断文件是否存在
		if (dest.exists()) 
			return JsonResult.error(StatementEnum.ERROR_FILE_EXISTS);
		
		// 判断父级目录是否存在
		if (!dest.getParentFile().exists()) 
			dest.getParentFile().mkdirs();
		
		try {
			
			String fileJson = redisTemplate.opsForValue().get("file");
			if (StringUtils.isNotBlank(fileJson)) {
				logger.info("文件上传，redis缓存");
				FileInfoVo fileInfoVo = JsonUtils.jsonToObject(fileJson, FileInfoVo.class);
				return JsonResult.success(fileInfoVo);
			}
			
			file.transferTo(dest); // 保存文件
			
			FileInfo fileInfo = new FileInfo();
			fileInfo.setOriginName(originName);
			fileInfo.setTransferName(transferName);
			fileInfo.setSuffix(suffix);
			fileInfo.setPath(dest.getPath());
			fileInfo.setUrl((accessDomain + filePath + transferName).replace("\\", "/"));
			fileInfo.setFromSource("");
			fileInfo.setSize((int)size);

			fileUploadService.insert(fileInfo);
			
			logger.info("文件上传，文件信息={}", JsonUtils.objectToJson(fileInfo, false));
			FileInfoVo fileInfoVo = new FileInfoVo();
			BeanUtils.copyProperties(fileInfo, fileInfoVo);

			// redis
			redisTemplate.opsForValue().set("file", JsonUtils.objectToJson(fileInfoVo, false), 2, TimeUnit.HOURS);
			
			logger.info("文件上传结束！");
			return JsonResult.success(fileInfoVo);
		} catch (Exception e) {
			logger.error("文件上传发生异常", e);
			return JsonResult.error(StatementEnum.ERROR_FILE_UPLOAD_FAIL);
		}
	}
	
}
