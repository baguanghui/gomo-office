package com.gmfiot.office.service;

import com.gmfiot.core.data.Query;
import com.gmfiot.core.data.Result;
import com.gmfiot.office.dao.MenuMapper;
import com.gmfiot.office.model.Menu;
import com.gmfiot.office.service.definition.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public Result<Menu> getById(Long id) {
        return Result.success(menuMapper.selectById(id,Menu.class));
    }

    @Override
    public Result<List<Menu>> getList(Query query) {
        var menuList = menuMapper.selectList(query);
        return Result.success(menuList);
    }
}
