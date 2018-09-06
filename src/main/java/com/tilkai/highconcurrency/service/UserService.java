package com.tilkai.highconcurrency.service;

import com.tilkai.highconcurrency.dao.UserDao;
import com.tilkai.highconcurrency.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-06 上午10:38
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User gerUserById(Integer id) {
        return userDao.getById(id);
    }

    @Transactional
    public int insertuser() {
        User user1 = new User();
        user1.setId(2);
        user1.setName("李四");
        User user2 = new User();
        user2.setId(1);
        user2.setName("王五");

        userDao.insert(user1);
        userDao.insert(user2);

        return 2;
    }
}
