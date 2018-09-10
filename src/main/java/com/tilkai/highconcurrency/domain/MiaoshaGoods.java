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
    private Long id;
    private Long goodsId;
    private Double miaoshaPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}
