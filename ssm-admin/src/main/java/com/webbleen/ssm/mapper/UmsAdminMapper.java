package com.webbleen.ssm.mapper;

import com.webbleen.ssm.entity.UmsAdmin;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    UmsAdmin selectByPrimaryKey(Long id);

    UmsAdmin selectByUsername(String username);

    List<UmsAdmin> selectAll();

    int updateByPrimaryKey(UmsAdmin record);
}