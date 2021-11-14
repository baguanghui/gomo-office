package com.gmfiot.office.service.definition;

import com.gmfiot.core.data.Query;
import com.gmfiot.core.data.Result;
import com.gmfiot.office.model.Menu;


import java.util.List;

public interface MenuService {
    Result<Menu> getById(Long id);
    Result<List<Menu>> getList(Query query);
}
