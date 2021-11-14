package com.gmfiot.office.mapper;

import com.gmfiot.data.BaseMapper;
import com.gmfiot.data.sql.SqlPlaceholderEnum;
import com.gmfiot.data.sql.SqlServerSqlBuilder;
import com.gmfiot.data.sql.SqlTypeEnum;
import com.gmfiot.office.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ThinkPad
 */
public interface UserMapper extends BaseMapper<User> {

    @InsertProvider(type = UserSqlProvider.class,method = "insert")
    @Override
    Integer insert(User user);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateById")
    @Override
    Integer updateById(User entity);

    @DeleteProvider(type = UserSqlProvider.class, method = "deleteById")
    @Override
    Integer deleteById(long id);

    @SelectProvider(type = UserSqlProvider.class, method = "selectById")
    @Override
    User selectById(Long id);

    @SelectProvider(type = UserSqlProvider.class, method = "selectByQuery")
    @Override
    List<User> selectList(Object query);

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

}



