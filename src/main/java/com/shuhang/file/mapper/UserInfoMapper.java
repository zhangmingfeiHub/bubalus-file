package com.shuhang.file.mapper;

import com.shuhang.file.model.UserInfo;
import com.shuhang.file.model.UserInfoExample;
import java.util.List;

public interface UserInfoMapper {
    long countByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}