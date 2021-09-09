package simple.factorybean.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import simple.factorybean.po.User;
import simple.factorybean.po.mapper.UserMapper;

@Slf4j
@Service
public class HelloService {
    @Autowired
    private UserMapper userMapper;

    public void hello(){
        log.info("hello world");
    }

    @Transactional
    public void insertHistory() {
        userMapper.insert(new User(1, "xcz"));
        userMapper.insert(new User(2, "xuchenzhi"));
    }
}
