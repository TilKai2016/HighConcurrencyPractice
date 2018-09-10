package com.tilkai.highconcurrency.control;

import com.tilkai.highconcurrency.domain.MiaoshaUser;
import com.tilkai.highconcurrency.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-08 下午8:27
 */
@RequestMapping("goods")
@Controller
public class GoodsController {

    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @ResponseBody
    @RequestMapping("to_list")
    String toGoodsList(HttpServletResponse response,
                       @CookieValue(value = MiaoshaUserService.COOKIE_NAME_TOKEN, required = false) String cookieToken,
                       @RequestParam(value = MiaoshaUserService.COOKIE_NAME_TOKEN, required = false) String paramToken) {

        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            return "login";
        }

        String token = !StringUtils.isEmpty(paramToken) ? paramToken : cookieToken;

        MiaoshaUser user = miaoshaUserService.getUserByToken(response, token);
        return "goods_list";
    }
}
