package com.gmfiot.office.service;

import com.gmfiot.core.data.Query;
import com.gmfiot.core.data.Result;
import com.gmfiot.data.DataProvider;
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
        var effectRows= userMapper.insert(user);
        if(effectRows == 0){
            return Result.fail("failed");
        }
        var newUser = userMapper.selectById(id,User.class);
        return Result.success(newUser);
    }

    @Override
    public Result<User> getById(Long id) {
        User user = userMapper.selectById(id,User.class);
        return Result.success(user);
    }

    @Override
    public Result deleteById(Long id) {
        var effectRows = userMapper.deleteById(id,User.class);
        if(effectRows > 0){
            return Result.success("OK");
        }else {
            return Result.fail("failed");
        }
    }

    @Override
    public Result<User> updateById(User user) {
        var effectRows = userMapper.updateById(user);
        if(effectRows > 0){
            return Result.success("OK");
        }else {
            return Result.fail("failed");
        }
    }

    @Override
    public Result<List<User>> getList(Query query) {
        var userList = userMapper.selectList(query);
        return Result.success(userList);
    }
}
