/**
 * @author mingfei.z 2018年11月3日 下午10:24:06
 */
package com.shuhang.file.mapper;

import org.apache.ibatis.annotations.Insert;

import com.shuhang.file.model.FileInfo;

public interface FileUploadMapper {

	@Insert("insert into file_info (origin_name,transfer_name,suffix,size,from_source,url,create_operator) "
			+ "values (#{originName},#{transferName},#{suffix},#{size},#{fromSource},#{url},#{createOperator})")
	int insert(FileInfo fileInfo);
	
}
