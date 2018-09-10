package com.tilkai.highconcurrency.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-10 下午2:00
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MiaoshaUserArgumentResolver miaoshaUserArgumentResolver;

    /**
     * note Spring框架回调该方法, 向Controller方法中的参数赋值.
     * @param resolvers
     * @return
     * @author tilkai
     * @date 2018/9/10
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

        resolvers.add(miaoshaUserArgumentResolver);

    }
}
