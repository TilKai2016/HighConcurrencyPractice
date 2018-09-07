package com.tilkai.highconcurrency.control;

import com.tilkai.highconcurrency.model.Result;
import com.tilkai.highconcurrency.redis.UserKey;
import com.tilkai.highconcurrency.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private RedisService redisService;

    @ResponseBody
    @RequestMapping("redis/get")
    Result redisGet() {
        Long a = redisService.get(UserKey.getById, "1", Long.class);
        return Result.success(a);
    }

    @ResponseBody
    @RequestMapping("redis/set")
    Result redisSet() {
        boolean a = redisService.set(UserKey.getById, "1", 1L);
        return Result.success(a);
    }
}
