package com.gmfiot.office.service;

import com.gmfiot.core.data.DataProvider;
import com.gmfiot.core.data.Query;
import com.gmfiot.core.data.Result;
import com.gmfiot.office.dao.UserMapper;
import com.gmfiot.office.model.User;
import com.gmfiot.office.service.definition.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author ThinkPad
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    DataProvider dataProvider;

    @Resource
    UserMapper userMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Result<User> addUser(User user) {
        var id = dataProvider.getId();
        System.out.println("id=" + id);
        user.setId(id);
        userMapper.insert(user);
        var newUser = userMapper.selectById(id,User.class);
        return Result.success(newUser);
    }

    @Override
    public Result<User> getById(Long id) {
//        var user = userMapper.selectById(id);

        User user = queryById(id,User.class);
        return Result.success(user);
    }

    @Override
    public Result<List<User>> getList(Query query) {
        var userList = userMapper.selectList(query);
        return Result.success(userList);
    }



    private <E> E queryById(long id,Class<E> type){

//        var sql = "SELECT Id as id,CreatedAt as createdAt,Name as name,[Status] as status ," +
//                "Failures as failures ,ReferenceId as referenceId ,Directory as directory FROM Users WHERE Id=?";
        //E e = null;
        //Class<E> tClass = (Class<E>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        E ee = ReflectionUtil.getObject(tClass);
//        var a = Type.getObjectType();

//        var aa = E.class;
//        Class<E> myClass = Type.getType(Class<E>.getClass());
        var sql = "SELECT * FROM Users WHERE Id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(type),id);
    }

}
