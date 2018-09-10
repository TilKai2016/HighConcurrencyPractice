package com.tilkai.highconcurrency.control;

import com.tilkai.highconcurrency.domain.MiaoshaOrder;
import com.tilkai.highconcurrency.domain.MiaoshaUser;
import com.tilkai.highconcurrency.domain.OrderInfo;
import com.tilkai.highconcurrency.result.CodeMsg;
import com.tilkai.highconcurrency.service.GoodsService;
import com.tilkai.highconcurrency.service.MiaoshaService;
import com.tilkai.highconcurrency.service.OrderService;
import com.tilkai.highconcurrency.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-10 下午9:22
 */
@RequestMapping("/miaosha")
@Controller
public class MiaoshaController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MiaoshaService miaoshaService;

    @RequestMapping("/do_miaosha")
    public String list(Model model, MiaoshaUser miaoshaUser,
    @RequestParam("goodsId") long goodsId) {

        model.addAttribute("user", miaoshaUser);

        if (miaoshaUser == null) {
            return "login";
        }

        // 判断库存
        GoodsVo goods = goodsService.getGoodsVoById(goodsId);
        if (goods.getStockCount() <= 0) {
            model.addAttribute("errmsg", CodeMsg.MIAOSHA_OVER.getMsg());
            return "miaosha_fail";
        }

        // 判断是否已经秒杀到
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(miaoshaUser.getId(), goodsId);

        if (order != null) {
            model.addAttribute("errmsg", CodeMsg.MIAOSHA_REPEATER_ERROR.getMsg());
            return "miaosha_fail";
        }

        // 减库存 下订单 写入秒杀订单 必须事务处理
        OrderInfo orderInfo = miaoshaService.miaosha(miaoshaUser, goods);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("goods", goods);

        return "order_detail";

    }
}
