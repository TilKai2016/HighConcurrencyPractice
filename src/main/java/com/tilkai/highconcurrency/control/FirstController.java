package com.tilkai.highconcurrency.control;

import com.tilkai.highconcurrency.model.CodeMsg;
import com.tilkai.highconcurrency.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-05 下午9:56
 */
@RequestMapping("/first")
@Controller
public class FirstController {

    @RequestMapping("/success")
    @ResponseBody
    Result helloSuccess() {
        return Result.success("hello success");
    }

    @RequestMapping("/error")
    @ResponseBody
    Result helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/thymeleaf")
    String thymeleaf(Model model) {
        model.addAttribute("name", "TilKai.");
        return "hello";
    }
}
