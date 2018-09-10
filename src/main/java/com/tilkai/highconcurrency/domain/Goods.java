package com.tilkai.highconcurrency.domain;

import lombok.Data;

/**
 * Note: 商品
 *
 * @author tilkai
 * @date 2018-09-07 下午12:12
 */
@Data
public class Goods {

    /**
     * 商品id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品标题
     */
    private String goodsTitle;

    /**
     * 商品图片
     */
    private String goodsImg;

    /**
     * 商品详细
     */
    private String goodsDetail;

    /**
     * 商品价格
     */
    private Double goodsPrice;

    /**
     * 商品库存
     */
    private Integer goodsStock;
}
