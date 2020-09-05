package com.gmfiot.office.dao;

import com.gmfiot.core.util.ReflectionUtil;
import com.gmfiot.core.util.StringUtil;
import com.gmfiot.data.SqlServerSqlGenerator;
import com.gmfiot.office.model.User;
import com.gmfiot.office.model.query.UserQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 利用@Provider实现动态SQL
 */
public class UserSqlProvider {

    public String insert(User user) {
        var tableInfo = SqlServerSqlGenerator.getTableInfo(user.getClass());
        StringBuffer sql = new StringBuffer(String.format("insert into %s(",tableInfo.getTableName()));
        var columnList = SqlServerSqlGenerator.getNotNullColumns(user);
        var columnStr = String.join(",",columnList);
        sql.append(columnStr);
        sql.append(") values (");
        List<String> values = columnList.stream().map(field -> String.format("#{%s}",field)).collect(Collectors.toList());
        var valueStr = String.join(",",values);
        sql.append(valueStr);
        sql.append(")");
        return sql.toString();
    }

    public String updateById(User user) {
//        SQL sql = new SQL(){{
//            UPDATE("users");
//            if (!StringUtil.isEmpty(user.getName())){
//                SET("name = #{U.name}");
//            }
//            WHERE("id = #{U.id}");
//        }};
//        return sql.toString();
        var tableInfo = SqlServerSqlGenerator.getTableInfo(user.getClass());
        StringBuffer sql = new StringBuffer(String.format("UPDATE %s SET ",tableInfo.getTableName()));
        List<String> values = SqlServerSqlGenerator.getNotNullColumns(user).stream().filter(p -> !p.equals("id")).map(field -> String.format("%s = #{%s}",field,field)).collect(Collectors.toList());
        var valueStr = String.join(",",values);
        sql.append(valueStr);
        sql.append(" WHERE Id = #{id}");
        return  sql.toString();
    }

    public String deleteById(long id,Class<?> clazz) {
        var tableInfo = SqlServerSqlGenerator.getTableInfo(clazz);
        var sql = String.format("DELETE %s WHERE Id = #{id}",tableInfo.getTableName());
        return  sql;
    }

    public String selectById(Long id,Class<?> clazz) {
        var tableInfo = SqlServerSqlGenerator.getTableInfo(clazz);
        var columnStr = String.join(",",tableInfo.getColumns());
        var sql = String.format("SELECT %s FROM %s WHERE id = #{id}",columnStr,tableInfo.getTableName());
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

    public String selectByQuery(UserQuery query) {
        StringBuffer sql = new StringBuffer("select * from users where 1=1 ");
        if(!query.getName().isBlank()) {
            sql.append(String.format("and username like '%s'", "%"+query.getName()+"%"));
        }
        return sql.toString();
    }


}
