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
    private Long id;
    private String goodsName;
    private String goodsTitle;
    private String goodsImg;
    private String goodsDetail;
    private Double goodsPrice;
    private Integer goodsStock;
}
