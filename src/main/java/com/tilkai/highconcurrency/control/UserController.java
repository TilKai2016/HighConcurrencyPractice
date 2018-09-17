package com.tilkai.highconcurrency.control;

import com.tilkai.highconcurrency.domain.MiaoshaUser;
import com.tilkai.highconcurrency.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-12 下午10:10
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping("/info")
    @ResponseBody
    public Result info(Model model, MiaoshaUser user) {
        return Result.success(user);
    }
}
