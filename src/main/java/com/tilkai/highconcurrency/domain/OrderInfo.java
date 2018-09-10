package com.tilkai.highconcurrency.domain;

import java.util.Date;

/**
 * Note: 订单
 *
 * @author tilkai
 * @date 2018-09-07 下午12:12
 */
public class OrderInfo {
    private Long id;
    private Long userId;
    private Long goodsId;
    private Long  deliveryAddrId;
    private String goodsName;
    private Integer goodsCount;
    private Double goodsPrice;
    private Integer orderChannel;
    private Integer status;
    private Date createDate;
    private Date payDate;
}
