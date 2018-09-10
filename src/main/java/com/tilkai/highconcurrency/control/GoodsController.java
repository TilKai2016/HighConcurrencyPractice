package com.tilkai.highconcurrency.control;

import com.tilkai.highconcurrency.domain.MiaoshaUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-08 下午8:27
 */
@RequestMapping("goods")
@Controller
public class GoodsController {

    @ResponseBody
    @RequestMapping("to_list")
    String toGoodsList(Model model, MiaoshaUser miaoshaUser) {
        model.addAttribute(miaoshaUser);
        return "goods_list";
    }
}
