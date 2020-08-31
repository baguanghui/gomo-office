package com.gmfiot.office.service.definition;

import com.gmfiot.core.data.Query;
import com.gmfiot.core.data.Result;
import com.gmfiot.office.model.Menu;
import com.gmfiot.office.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Result<User> getById(Long id);
    Result<List<User>> getList(Query query);
    Result<User> addUser(User user);
}
