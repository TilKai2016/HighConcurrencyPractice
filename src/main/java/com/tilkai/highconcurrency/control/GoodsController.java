package com.tilkai.highconcurrency.control;

import com.tilkai.highconcurrency.domain.MiaoshaUser;
import com.tilkai.highconcurrency.service.GoodsService;
import com.tilkai.highconcurrency.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-08 下午8:27
 */
@RequestMapping("/goods")
@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/to_list")
    String toGoodsList(Model model, MiaoshaUser miaoshaUser) {
        model.addAttribute("user", miaoshaUser);
        List<GoodsVo> goodsVoList = goodsService.listGoodsVo();
        model.addAttribute("goodList", goodsVoList);


//        model.addAttribute("goodsList", goodsService.listGoodsVo());
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    String toGoodsDetail(Model model, @PathVariable("goodsId") long goodsId, MiaoshaUser miaoshaUser) {
        model.addAttribute("user", miaoshaUser);
        GoodsVo goods = goodsService.getGoodsVoById(goodsId);
        model.addAttribute("goods", goods);

        long startAt = goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int miaoshaState = 0;
        long remainSeconds = 0;
        // 秒杀未开始
        if (now < startAt) {
            miaoshaState = 0;
            remainSeconds = (startAt - now) / 1000;
        } else if (now > endAt) {
            // 秒杀已经结束
            miaoshaState = 2;
            remainSeconds = -1;
        } else {
            // 秒杀进行中
            miaoshaState = 1;
        }
        model.addAttribute("miaoshaStatus", miaoshaState);
        model.addAttribute("remainSeconds", remainSeconds);

        return "goods_detail";
    }
}
