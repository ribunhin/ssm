package com.webbleen.ssm.mapper;

import com.webbleen.ssm.entity.UmsMenu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMenu record);

    UmsMenu selectByPrimaryKey(Long id);

    List<UmsMenu> selectAll();

    int updateByPrimaryKey(UmsMenu record);
}