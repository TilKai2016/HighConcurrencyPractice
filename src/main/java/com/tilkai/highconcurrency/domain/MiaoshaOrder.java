package com.tilkai.highconcurrency.domain;

import lombok.Data;

/**
 * Note: 秒杀订单
 *
 * @author tilkai
 * @date 2018-09-07 下午12:12
 */
@Data
public class MiaoshaOrder {
    private Long id;
    private Long userId;
    private Long  orderId;
    private Long goodsId;
}
