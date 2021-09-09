package shiro.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shiro.spring.dao.po.User;
import shiro.spring.dao.po.mapper.UserMapper;

/**
 * In production,this service will depend on the database,and @Transaction is used to manage transactions.
 * For the convenience of demonstration, replace with Aspect
 */
@Slf4j
@Service
public class SsoService {
    @Autowired
    private UserMapper userMapper;

    public void login() {
        log.info("login");
    }

    @Transactional
    public void insertHistory() {
        userMapper.insert(new User(1, "xcz"));
        userMapper.insert(new User(2, "xuchenzhi"));
    }
}
