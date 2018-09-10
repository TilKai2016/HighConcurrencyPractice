package com.tilkai.highconcurrency.dao;

import com.tilkai.highconcurrency.domain.MiaoshaOrder;
import com.tilkai.highconcurrency.domain.OrderInfo;
import org.apache.ibatis.annotations.*;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-10 下午10:05
 */
@Mapper
public interface OrderDao {

    @Select("SELECT * FROM miaosha_order WHERE user_id = #{miaoshaUserId} AND goods_id = #{goodsId}")
    MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(@Param("miaoshaUserId") Long miaoshaUserId, @Param("goodsId") Long goodsId);

    @Insert("INSERT INTO order_info ( id, goods_id, goods_name, goods_count, goods_price, order_channel, status, create_date) " +
            "values (#{userId}, #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel}, #{status}, #{createDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = long.class, before = false, statement = "SELECT last_insert_id()")
    long insertOrderInfo(OrderInfo orderInfo);

    @Insert("insert into miaosha_order (user_id, goods_id, order_id)values(#{userId}, #{goodsId}, #{orderId})")
    void insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);
}
