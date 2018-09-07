package com.tilkai.highconcurrency.dao;

import com.tilkai.highconcurrency.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-07 下午4:33
 */
@Mapper
public interface MiaoshaUserDao {

    /**
     * note 根据id获取秒杀用户
     * @param id
     * @return
     * @author tilkai
     * @date 2018/9/7
     */
    @Select("SELECT * FROM miaosha_user WHERE id = #{id}")
    MiaoshaUser getById(@Param("id") long id);
}
