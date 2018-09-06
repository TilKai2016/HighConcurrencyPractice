package com.tilkai.highconcurrency.dao;

import com.tilkai.highconcurrency.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-06 上午10:36
 */
@Mapper
public interface UserDao {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getById(@Param("id") Integer id);

    @Insert("INSERT INTO user (id, name) values (#{id}, #{name})")
    int insert(User user);
}
