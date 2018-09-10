package com.tilkai.highconcurrency.control;

import com.tilkai.highconcurrency.result.Result;
import com.tilkai.highconcurrency.service.MiaoshaUserService;
import com.tilkai.highconcurrency.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-07 下午3:18
 */
@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @RequestMapping("/to_login")
    public String gotoLogin() {
        return "login";
    }

    @RequestMapping(value = "/do_login", method = RequestMethod.POST)
    @ResponseBody
    public Result doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        miaoshaUserService.login(response, loginVo);
        return Result.success(true);
    }
}
