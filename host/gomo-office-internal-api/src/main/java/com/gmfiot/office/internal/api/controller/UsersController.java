package com.gmfiot.office.internal.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmfiot.core.data.Result;
import com.gmfiot.core.util.JsonUtil;
import com.gmfiot.office.model.User;
import com.gmfiot.office.model.query.UserQuery;
import com.gmfiot.office.service.definition.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ThinkPad
 */
@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    /**
     * 新建用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/users",method = RequestMethod.POST,produces = {"application/json"})
    public Result saveUser(@RequestBody User user){
        System.out.println(JsonUtil.toJson(user));
        var result = userService.addUser(user);
        return  result;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE,produces = "application/json")
    public Result deleteUser(@PathVariable long id){
        var result = userService.getById(id);
        return result;
    }

    /**
     * 修改用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/{id}",method = RequestMethod.PUT,produces = "application/json")
    public Result updateUser(@PathVariable long id){
        var result = userService.getById(id);
        return result;
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public Result getUser(@PathVariable long id){

        var result = userService.getById(id);
        return result;
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public Result getAll(){
        Map<String, Object> map = new HashMap<String, Object>();
        var query = new UserQuery();
        var result = userService.getList(query);
        return  result;
    }


}
