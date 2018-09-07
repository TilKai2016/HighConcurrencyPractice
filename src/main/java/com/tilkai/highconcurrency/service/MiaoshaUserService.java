package com.tilkai.highconcurrency.service;

import com.tilkai.highconcurrency.dao.MiaoshaUserDao;
import com.tilkai.highconcurrency.domain.MiaoshaUser;
import com.tilkai.highconcurrency.result.CodeMsg;
import com.tilkai.highconcurrency.util.MD5Utils;
import com.tilkai.highconcurrency.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-07 下午4:36
 */
@Service
public class MiaoshaUserService {

    @Autowired
    private MiaoshaUserDao miaoshaUserDao;

    public CodeMsg login(LoginVo loginVo) {
        if (loginVo == null) {
            return CodeMsg.SERVER_ERROR;
        }
        MiaoshaUser user = getUserById(loginVo.getMobile());
        if (user == null) {
            return CodeMsg.MOBILE_NOT_EXIST;
        }
        String dbPassword = user.getPassword();
        String dbSalt = user.getSalt();
        String formPassword = MD5Utils.formPassToDbPass(loginVo.getPassword(), dbSalt);

        if (!formPassword.equals(dbPassword)) {

            return CodeMsg.PASSWORD_ERROR;
        }

        return CodeMsg.SUCCESS;

    }
    public MiaoshaUser getUserById(String mobile) {
        long id = Long.parseLong(mobile);
        return miaoshaUserDao.getById(id);
    }
}
