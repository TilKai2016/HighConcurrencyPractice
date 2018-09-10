package com.tilkai.highconcurrency.service;

import com.tilkai.highconcurrency.dao.GoodsDao;
import com.tilkai.highconcurrency.domain.Goods;
import com.tilkai.highconcurrency.domain.MiaoshaUser;
import com.tilkai.highconcurrency.domain.OrderInfo;
import com.tilkai.highconcurrency.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-10 下午9:56
 */
@Service
public class MiaoshaService {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Transactional
    public OrderInfo miaosha(MiaoshaUser miaoshaUser, GoodsVo goods) {

        // 减库存
        goodsService.reduceStock(goods);
        // 下订单
        OrderInfo orderInfo = orderService.createOrder(miaoshaUser, goods);


        // 写入秒杀订单

        return orderInfo;
    }
}
