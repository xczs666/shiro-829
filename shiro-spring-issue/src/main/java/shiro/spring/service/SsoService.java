package shiro.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * In production,this service will depend on the database,and @Transaction is used to manage transactions.
 * For the convenience of demonstration, replace with Aspect
 */
@Slf4j
@Service
public class SsoService {
    public void login() {
        log.info("login");
    }
}
