package com.shuhang.file.mapper;

import com.shuhang.file.model.ClientApp;
import com.shuhang.file.model.ClientAppExample;
import java.util.List;

public interface ClientAppMapper {
    long countByExample(ClientAppExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClientApp record);

    int insertSelective(ClientApp record);

    List<ClientApp> selectByExample(ClientAppExample example);

    ClientApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClientApp record);

    int updateByPrimaryKey(ClientApp record);
}