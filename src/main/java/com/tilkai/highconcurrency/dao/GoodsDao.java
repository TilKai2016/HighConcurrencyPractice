package com.tilkai.highconcurrency.dao;

import com.tilkai.highconcurrency.domain.MiaoshaGoods;
import com.tilkai.highconcurrency.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-10 下午4:23
 */
@Mapper
public interface GoodsDao {

    @Select("SELECT g.*, mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date FROM miaosha_goods mg LEFT JOIN goods g ON mg.goods_id = g.id")
    List<GoodsVo> listGoodsVo();

    @Select("SELECT g.*, mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date FROM miaosha_goods mg LEFT JOIN goods g ON mg.goods_id = g.id WHERE mg.goods_id = #{id}")
    GoodsVo getGoodsVoById(@Param("id") long id);

    @Update("UPDATE miaosha_goods SET stock_count = stock_count - 1 WHERE goods_id = #{id}")
    void reduceStock(MiaoshaGoods g);
}
