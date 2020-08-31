package com.gmfiot.office.dao;

import com.gmfiot.core.data.BaseMapper;
import com.gmfiot.core.data.Query;
import com.gmfiot.office.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ThinkPad
 */
public interface UserMapper extends BaseMapper<User> {
//    User getUser(Long id);
//
//    void addUser(User user);
//
//    void updateUser(User user);
//
//    void deleteUser(User user);
//
//    List<User> getList(Map<String,Object> map);

//    @Override
//    void insert(User entity);

//    @Select("SELECT * from Users where id = #{id}")
//    User selectOne(Long id);

//    @Select("SELECT * from Users where 1=1")
//    User[] selectList(Query query);

//    @Select(value = "SELECT * from Users where id = #{id}")
//    User select(Long id);
//
//    @Select(value = "SELECT * from Users where 1=1")
//    User[] select(Query query);

    @InsertProvider(type = UserSqlProvider.class,method = "insert")
    @Override
    void insert(User user);

    @UpdateProvider(type = UserSqlProvider.class, method = "update")
    @Override
    void updateById(User entity);

    @Delete("DELETE FROM users WHERE id =#{id}")
    @Override
    void deleteById(long id);

    @Select(value = "SELECT * from Users where id = #{id}")
    @Override
    User selectById(Long id);

    @SelectProvider(type = UserSqlProvider.class, method = "selectByQuery")
    @Override
    List<User> selectList(Query query);

//    @UpdateProvider(type = UserSqlProvider.class, method = "updateUser")
//    public int updateUser(@Param("U") User user);
//
//    @InsertProvider(type= UserSqlProvider.class, method = "batchInsert")
//    int batchInsert(@Param("userList")List<User> userList);
}
