package shiro.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shiro.spring.dao.po.User;
import shiro.spring.dao.po.mapper.UserMapper;

/**
 * @author chenzhi.xu
 * @date 2021/09/15
 */
@Slf4j
@Service
public class NormalService {
    @Autowired
    private UserMapper userMapper;

    public void login() {
        log.info("login");
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertHistory() {
        userMapper.insert(new User(1, "xcz"));
        userMapper.insert(new User(2, "xuchenzhi"));
    }
}
