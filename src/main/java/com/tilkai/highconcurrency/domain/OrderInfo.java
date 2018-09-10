package com.tilkai.highconcurrency.domain;

import lombok.Data;

import java.util.Date;

/**
 * Note: 订单
 *
 * @author tilkai
 * @date 2018-09-07 下午12:12
 */
@Data
public class OrderInfo {

    /**
     * 订单id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 交付地址id
     */
    private Long  deliveryAddrId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品单价
     */
    private Double goodsPrice;

    /**
     * 订单渠道
     */
    private Integer orderChannel;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 订单创建时间
     */
    private Date createDate;

    /**
     * 订单支付状态
     */
    private Date payDate;
}
