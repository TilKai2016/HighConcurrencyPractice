package com.tilkai.highconcurrency.service;

import com.tilkai.highconcurrency.dao.MiaoshaUserDao;
import com.tilkai.highconcurrency.domain.MiaoshaUser;
import com.tilkai.highconcurrency.exception.GlobalException;
import com.tilkai.highconcurrency.redis.MiaoshaUserKey;
import com.tilkai.highconcurrency.redis.RedisService;
import com.tilkai.highconcurrency.result.CodeMsg;
import com.tilkai.highconcurrency.util.MD5Utils;
import com.tilkai.highconcurrency.util.UUIDUtils;
import com.tilkai.highconcurrency.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-07 下午4:36
 */
@Service
public class MiaoshaUserService {

    public static final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    private MiaoshaUserDao miaoshaUserDao;

    @Autowired
    private RedisService redisService;

    /**
     * note 秒杀用户登录功能
     * @param response
     * @param loginVo
     * @return
     * @author tilkai
     * @date 2018/9/10
     */
    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        MiaoshaUser user = getUserById(loginVo.getMobile());
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        String dbPassword = user.getPassword();
        String dbSalt = user.getSalt();
        String formPassword = MD5Utils.formPassToDbPass(loginVo.getPassword(), dbSalt);

        if (!formPassword.equals(dbPassword)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }

        addCookie(response, user);
        return true;
    }
    public MiaoshaUser getUserById(String mobile) {
        long id = Long.parseLong(mobile);
        return miaoshaUserDao.getById(id);
    }

    public MiaoshaUser getUserByToken(HttpServletResponse response, String token) {

        if (StringUtils.isEmpty(token)) {
            return null;
        }
        MiaoshaUser miaoshaUser = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
        if (miaoshaUser != null) {
            addCookie(response, miaoshaUser);
        }
        return miaoshaUser;
    }

    /**
     * note 添加cookie到response中, 添加cookie大redis中.(也可用于延长session有效期)
     * @param response
     * @param user
     * @return
     * @author tilkai
     * @date 2018/9/10
     */
    private void addCookie(HttpServletResponse response, MiaoshaUser user) {
        // 生成cookie
        String token = UUIDUtils.uuid();

        // 将token写入到第三方缓存, 标识该token属于哪个用户, 之后可通过get方法获取token绑定的用户
        redisService.set(MiaoshaUserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        // cookie有效期, 与session保持一致.
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        cookie.setPath("/");

        response.addCookie(cookie);
    }
}
