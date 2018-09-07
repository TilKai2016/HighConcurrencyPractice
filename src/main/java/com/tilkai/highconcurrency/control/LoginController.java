package com.tilkai.highconcurrency.control;

import com.tilkai.highconcurrency.result.CodeMsg;
import com.tilkai.highconcurrency.result.Result;
import com.tilkai.highconcurrency.service.MiaoshaUserService;
import com.tilkai.highconcurrency.util.ValidatorUtils;
import com.tilkai.highconcurrency.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @RequestMapping("/to_login")
    public String gotoLogin() {
        return "login";
    }

    @RequestMapping(value = "/do_login", method = RequestMethod.POST)
    @ResponseBody
    public Result doLogin(@Valid LoginVo loginVo) {


//        String mobile = loginVo.getMobile();
//        String password = loginVo.getPassword();
//
//        if (StringUtils.isEmpty(password)) {
//            return Result.error(CodeMsg.PASSWORD_EMPTY);
//        }
//        if (StringUtils.isEmpty(mobile)) {
//            return Result.error(CodeMsg.MOBILE_EMPTY);
//        }
//        if (!ValidatorUtils.isMobile(mobile)) {
//            return Result.error(CodeMsg.MOBILE_ERROR);
//        }

        CodeMsg codeMsg = miaoshaUserService.login(loginVo);

        if (codeMsg.getCode() == 0) {
            return Result.success(true);
        } else {
            return Result.error(codeMsg);
        }
    }
}
