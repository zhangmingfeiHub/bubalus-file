package com.shuhang.file.mapper;

import com.shuhang.file.model.FileInfo;
import com.shuhang.file.model.FileInfoExample;
import java.util.List;

public interface FileInfoMapper {
    long countByExample(FileInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileInfo record);

    int insertSelective(FileInfo record);

    List<FileInfo> selectByExample(FileInfoExample example);

    FileInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FileInfo record);

    int updateByPrimaryKey(FileInfo record);
}