package com.tilkai.highconcurrency.control;

import com.tilkai.highconcurrency.domain.User;
import com.tilkai.highconcurrency.model.CodeMsg;
import com.tilkai.highconcurrency.model.Result;
import com.tilkai.highconcurrency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private UserService userService;

    @RequestMapping("/thymeleaf")
    String thymeleaf(Model model) {
        model.addAttribute("name", "TilKai.");
        return "hello";
    }

    @RequestMapping(value = "/db/get")
    @ResponseBody
    Result dbGet(@RequestParam("id") Integer id) {
        User user = userService.gerUserById(id);

        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/db/tx")
    @ResponseBody
    Result dbTx() {
        int size = userService.insertuser();

        if (size == 2) {
            return Result.success("插入成功");
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
