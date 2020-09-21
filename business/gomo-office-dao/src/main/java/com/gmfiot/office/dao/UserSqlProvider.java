package com.gmfiot.office.dao;

import com.gmfiot.data.sql.SqlPlaceholderEnum;
import com.gmfiot.data.sql.SqlServerSqlBuilder;
import com.gmfiot.data.sql.SqlTypeEnum;
import com.gmfiot.office.model.User;
import com.gmfiot.office.model.query.UserQuery;

/**
 * 利用@Provider实现动态SQL
 */
public class UserSqlProvider {


    public String insert(User user) {
        var sql = SqlServerSqlBuilder.getBuilder(user)
                .setSqlPlaceholder(SqlPlaceholderEnum.HASH_SIGN)
                .build(SqlTypeEnum.INSERT).toString();
        return sql;
    }

    public String updateById(User user) {
        var sql = SqlServerSqlBuilder.getBuilder(user)
                .setSqlPlaceholder(SqlPlaceholderEnum.HASH_SIGN)
                .build(SqlTypeEnum.UPDATE).toString();
        return  sql;
    }

    public String deleteById(long id) {
        var sql = SqlServerSqlBuilder.getBuilder(User.class)
                .setSqlPlaceholder(SqlPlaceholderEnum.HASH_SIGN)
                .build(SqlTypeEnum.DELETE)
                .toString();
        return  sql;
    }

    public String selectById(Long id) {
        var sql = SqlServerSqlBuilder.getBuilder(User.class)
                .setSqlPlaceholder(SqlPlaceholderEnum.HASH_SIGN)
                .build(SqlTypeEnum.SELECT).toString();
        return sql;
    }

    public String selectByQuery(Object query) {
        var sql = SqlServerSqlBuilder.getBuilder(User.class,query)
                .setSqlPlaceholder(SqlPlaceholderEnum.HASH_SIGN)
                .build(SqlTypeEnum.SELECT)
                .build(SqlTypeEnum.WHERE)
                .build(SqlTypeEnum.ORDER_BY)
                .build(SqlTypeEnum.OFFSET_FETCH)
                .toString();
        return sql;
    }
}
