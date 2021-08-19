package simple.factorybean.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServiceAspect {
    @Pointcut("execution(public void simple.factorybean.service.HelloService.hello())")
    private void  pointCut(){}

    @Before("pointCut()")
    public void beforePointCut() {
        log.info("before service");
    }

    @After("pointCut()")
    public void afterPointCut() {
        log.info("after service");
    }

}
