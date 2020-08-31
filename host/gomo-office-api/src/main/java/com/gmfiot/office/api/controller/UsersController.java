package com.gmfiot.office.api.controller;

import com.gmfiot.core.data.Result;
import com.gmfiot.office.service.definition.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public Result getById(@PathVariable long id){
        var user = userService.getById(id);
        return Result.success(user);
    }
}