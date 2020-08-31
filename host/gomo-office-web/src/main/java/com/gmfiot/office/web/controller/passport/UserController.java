package com.gmfiot.office.web.controller.passport;

import com.gmfiot.core.data.Result;
import com.gmfiot.office.model.User;
import com.gmfiot.office.service.definition.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ThinkPad
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/one")
    public Result<User> getOne(){
        var user = userService.getById(36L);
        return user;
    }

}
