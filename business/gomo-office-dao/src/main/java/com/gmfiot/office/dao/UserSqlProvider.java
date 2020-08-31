package com.gmfiot.office.dao;

import com.gmfiot.core.util.StringUtil;
import com.gmfiot.office.model.User;
import com.gmfiot.office.model.query.UserQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 利用@Provider实现动态SQL
 */
public class UserSqlProvider {

    public String insert(User user) {
        StringBuffer sql = new StringBuffer("insert into users(Id,Name,CreatedAt) values(#{id}, #{name}, #{createdAt})");
        return sql.toString();
    }

    public String update(@Param("U") User user) {
        SQL sql = new SQL(){{
            UPDATE("users");
            if (!StringUtil.isEmpty(user.getName())){
                SET("name = #{U.name}");
            }
            WHERE("id = #{U.id}");
        }};
        return sql.toString();
    }

    public String batchInsert(Map map) {
        List<User> userList = (List<User>)map.get("userList");
        StringBuffer sql = new StringBuffer("insert into users (id,name) values ");

        for(User user : userList) {
            sql.append(String.format("('%s', '%s'),",user.getId(), user.getName()));
        }
        sql = sql.deleteCharAt(sql.length() -1);
        System.out.println(sql.toString());
        return sql.toString();
    }

    public String selectByQuery(UserQuery query) {
        StringBuffer sql = new StringBuffer("select * from users where 1=1 ");
        if(!query.getName().isBlank()) {
            sql.append(String.format("and username like '%s'", "%"+query.getName()+"%"));
        }
        return sql.toString();
    }


}
