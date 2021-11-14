package com.gmfiot.office.service;

import com.gmfiot.core.BusinessException;
import com.gmfiot.core.data.Paged;
import com.gmfiot.core.data.Query;
import com.gmfiot.core.data.Result;
import com.gmfiot.data.SqlServerDataProvider;
import com.gmfiot.office.dao.UserMapper;
import com.gmfiot.office.model.User;
import com.gmfiot.office.service.definition.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author ThinkPad
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    SqlServerDataProvider dataProvider;

    @Override
    public Result<User> addUser(User user) {
        var id = dataProvider.getId();
        user.setId(id);
        var effectRows= dataProvider.insert(user);

        if(effectRows == 0){
            return Result.fail("failed");
        }
        var newUser = dataProvider.select(id,User.class);
        return Result.success(newUser);
    }

    @Override
    public Result<User> getById(Long id) {
        User user = dataProvider.select(id,User.class);
        return Result.success(user);
    }

    @Override
    public Result deleteById(Long id) {
        var effectRows = dataProvider.delete(id,User.class);
        if(effectRows > 0){
            return Result.success("OK");
        }else {
            return Result.fail("failed");
        }
    }

    @Override
    public Result<User> updateById(User user) {
        var effectRows = dataProvider.update(user);
        if(effectRows > 0){
            return Result.success("OK");
        }else {
            return Result.fail("failed");
        }
    }

    @Override
    public Result<Paged<User>> getList(Query query) {
        var userList = dataProvider.selectPaged(query,User.class);
        return Result.success(userList);
    }

    @Override
    public Result<User> addUsers(ArrayList<User> users) {

//执行事务
//        var ret2 = dataProvider.executeInTransaction((tranStatus)->{
//            var deleteUser = new User();
//            deleteUser.setId(8l);
//            var ret = dataProvider.delete(deleteUser,User.class);
//
//            var id = dataProvider.getId();
//            var user = new User();
//            user.setId(id);
//            user.setName("刘德华");
//            user.setStatus(1);
//            var effectRows= dataProvider.insert(user);
//            return effectRows;
//        });

        //批量插入
//        var userList = new ArrayList<User>();
//        var user1 = new User();
//        user1.setId(3L);
//        user1.setName("李四");
//        userList.add(user1);
//
//        var user2 = new User();
//        user2.setId(1L);
//        user2.setName("王五");
//        userList.add(user2);
//        dataProvider.insert(userList);

        var sql = "select * from [User] where Id = :id";
        var userQuery = new User();
        userQuery.setId(1L);

        var sqlResult = dataProvider.select(sql,userQuery,User.class);

        return null;
    }

    @Override
    public Result deleteByNameId(Long id) {
        return null;
    }
}
