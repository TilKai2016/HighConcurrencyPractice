package com.tilkai.highconcurrency.domain;

import lombok.Data;

import java.util.Date;

/**
 * Note: 秒杀商品
 *
 * @author tilkai
 * @date 2018-09-07 下午12:12
 */
@Data
public class MiaoshaGoods {

    /**
     * 秒杀商品id
     */
    private Long id;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 秒杀价格
     */
    private Double miaoshaPrice;

    /**
     * 库存量
     */
    private Integer stockCount;

    /**
     * 秒杀开始时间
     */
    private Date startDate;

    /**
     * 秒杀结束时间
     */
    private Date endDate;
}
