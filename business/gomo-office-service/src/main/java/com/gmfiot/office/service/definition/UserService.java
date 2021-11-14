package com.gmfiot.office.service.definition;

import com.gmfiot.core.data.Paged;
import com.gmfiot.core.data.Query;
import com.gmfiot.core.data.Result;
import com.gmfiot.office.model.Menu;
import com.gmfiot.office.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserService {
    Result<User> addUser(User user);
    Result<User> getById(Long id);
    Result deleteById(Long id);
    Result<User> updateById(User user);
    Result<Paged<User>> getList(Query query);

    Result<User> addUsers(ArrayList<User> users);
    Result deleteByNameId(Long id);
}
