package simple.factorybean.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloService {
    public void hello(){
        log.info("hello world");
    }
}
