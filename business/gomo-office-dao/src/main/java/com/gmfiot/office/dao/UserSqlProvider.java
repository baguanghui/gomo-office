package com.gmfiot.office.dao;

import com.gmfiot.data.sql.SqlServerSqlBuilder;
import com.gmfiot.data.sql.SqlTypeEnum;
import com.gmfiot.office.model.User;
import com.gmfiot.office.model.query.UserQuery;

import java.util.List;
import java.util.Map;

/**
 * 利用@Provider实现动态SQL
 */
public class UserSqlProvider {

    public String insert(User user) {
        var sql = SqlServerSqlBuilder.getBuilder(user).build(SqlTypeEnum.INSERT).toString();
        return sql;
    }

    public String updateById(User user) {
        var sql = SqlServerSqlBuilder.getBuilder(user).build(SqlTypeEnum.UPDATE).toString();
        return  sql;
    }

    public String deleteById(long id,Class<?> modelClass) {
        var sql = SqlServerSqlBuilder.getBuilder(modelClass).build(SqlTypeEnum.DELETE).toString();
        return  sql;
    }

    public String selectById(Long id,Class<?> modelClass) {
        var sql = SqlServerSqlBuilder.getBuilder(modelClass).build(SqlTypeEnum.SELECT).toString();
        return sql;
    }

    public String selectByQuery(UserQuery query) {
        var sql = SqlServerSqlBuilder.getBuilder(User.class,query)
                .build(SqlTypeEnum.SELECT)
                .build(SqlTypeEnum.WHERE)
                .build(SqlTypeEnum.ORDERBY)
                .build(SqlTypeEnum.OFFSET_FETCH)
                .toString();
        return sql;
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
}
