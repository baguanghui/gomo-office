package com.gmfiot.office.internal.api.controllers;

import com.gmfiot.core.data.Result;
import com.gmfiot.core.util.JsonUtil;
import com.gmfiot.office.mapper.UserMapper;
import com.gmfiot.office.model.User;
import com.gmfiot.office.model.query.UserQuery;
import com.gmfiot.office.service.definition.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ThinkPad
 */
@RequestMapping(value = "/users")
@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 新建用户
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,produces = {"application/json"})
    public Result saveUser(@RequestBody User user){
        System.out.println(JsonUtil.toJson(user));
        var result = userService.addUser(user);
        return  result;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result getUser(@PathVariable long id){
        var result = userService.getById(id);
        var result2 = userMapper.selectById(id);
        return result;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE,produces = "application/json")
    public Result deleteUser(@PathVariable long id){
        var result = userService.deleteById(id);
        return result;
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT,produces = "application/json")
    public Result updateUser(@RequestBody User user){
        var result = userService.updateById(user);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public Result getUserList(UserQuery query){
        var result = userService.getList(query);
        return  result;
    }

    @RequestMapping(path = "myTest",method = RequestMethod.GET,produces = "application/json")
    public Result testTransaction(UserQuery query){
        var result = userService.getList(query);
        var aa = userService.addUsers(null);
        return  result;
    }

}
