package com.tilkai.highconcurrency.dao;

import com.tilkai.highconcurrency.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
