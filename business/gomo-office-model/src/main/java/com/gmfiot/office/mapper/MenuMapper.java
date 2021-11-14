package com.gmfiot.office.mapper;

import com.gmfiot.core.data.Query;
import com.gmfiot.data.BaseMapper;
import com.gmfiot.office.model.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MenuMapper extends BaseMapper<Menu> {

//    @Select(value = "SELECT * from Menus where id = #{id}")
//    @Override
//    Menu selectById(Long id,Class<?> clazz);
//
//    @Select(value = "SELECT * from Menus where 1=1")
//    @Override
//    List<Menu> selectList(Map<String,Object> queryMap);

    @Select(value = "SELECT * from Menus where 1=1")
    @Override
    List<Menu> selectList(Object query);

    @Select(value = "SELECT * from Menus where id = #{id}")
    @Override
    Menu selectById(Long id);
}




