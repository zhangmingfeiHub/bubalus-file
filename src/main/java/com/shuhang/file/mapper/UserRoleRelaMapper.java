package com.shuhang.file.mapper;

import com.shuhang.file.model.UserRoleRela;
import com.shuhang.file.model.UserRoleRelaExample;
import java.util.List;

public interface UserRoleRelaMapper {
    long countByExample(UserRoleRelaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleRela record);

    int insertSelective(UserRoleRela record);

    List<UserRoleRela> selectByExample(UserRoleRelaExample example);

    UserRoleRela selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleRela record);

    int updateByPrimaryKey(UserRoleRela record);
}