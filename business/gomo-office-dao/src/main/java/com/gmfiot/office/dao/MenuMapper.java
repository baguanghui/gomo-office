package com.gmfiot.office.dao;

import com.gmfiot.core.data.BaseMapper;
import com.gmfiot.core.data.Query;
import com.gmfiot.office.model.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    @Select(value = "SELECT * from Menus where id = #{id}")
    @Override
    Menu selectById(Long id,Class<?> clazz);

    @Select(value = "SELECT * from Menus where 1=1")
    @Override
    List<Menu> selectList(Query query);
}
