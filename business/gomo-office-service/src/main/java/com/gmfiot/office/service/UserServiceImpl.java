package com.gmfiot.office.service;

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
import javax.annotation.Resource;
import java.util.*;

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
}
