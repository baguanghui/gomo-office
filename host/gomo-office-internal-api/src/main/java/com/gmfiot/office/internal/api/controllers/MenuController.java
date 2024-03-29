package com.gmfiot.office.internal.api.controllers;

import com.gmfiot.core.data.Result;
import com.gmfiot.office.service.definition.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "menus",method = RequestMethod.GET)
    public Result getAll(){
        return menuService.getList(null);
    }


    @RequestMapping(value = "menus/{id}",method = RequestMethod.GET)
    public Result getOne(@PathVariable Long id,int a){
        System.out.println(id);
        return menuService.getById(id);
    }
}
