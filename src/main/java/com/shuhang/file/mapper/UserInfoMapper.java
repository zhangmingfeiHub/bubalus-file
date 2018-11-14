package com.shuhang.file.mapper;

import com.shuhang.file.model.UserInfo;
import com.shuhang.file.model.UserInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    long countByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    /**
     * 根据账号 或 手机号查询用户信息
     * 
     * @param accountOrMobile
     * @return
     * @author mingfei.z 2018年11月14日 下午10:58:42
     */
    UserInfo getUserInfoByCondition(@Param("param") String accountOrMobile);
    
}