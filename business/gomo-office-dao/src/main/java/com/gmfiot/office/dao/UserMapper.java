package com.gmfiot.office.dao;

import com.gmfiot.core.data.Query;
import com.gmfiot.data.BaseMapper;
import com.gmfiot.office.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author ThinkPad
 */
public interface UserMapper extends BaseMapper<User> {

    @InsertProvider(type = UserSqlProvider.class,method = "insert")
    @Override
    Integer insert(User user);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateById")
    @Override
    Integer updateById(User entity);

    @DeleteProvider(type = UserSqlProvider.class, method = "deleteById")
    @Override
    Integer deleteById(long id);

    @SelectProvider(type = UserSqlProvider.class, method = "selectById")
    @Override
    User selectById(Long id);

    @SelectProvider(type = UserSqlProvider.class, method = "selectByQuery")
    @Override
    List<User> selectList(Object query);
}
