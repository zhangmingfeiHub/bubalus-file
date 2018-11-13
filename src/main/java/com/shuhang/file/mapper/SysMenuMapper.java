package com.shuhang.file.mapper;

import com.shuhang.file.model.SysMenu;
import com.shuhang.file.model.SysMenuExample;
import java.util.List;

public interface SysMenuMapper {
    long countByExample(SysMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}