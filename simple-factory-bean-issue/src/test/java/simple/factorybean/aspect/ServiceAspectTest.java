package simple.factorybean.aspect;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import simple.factorybean.service.HelloService;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceAspectTest {
    @SpyBean
    private ServiceAspect serviceAspect;
    @Autowired
    private HelloService helloService;

    @Test
    public void testService() {
        helloService.hello();
        Mockito.verify(serviceAspect).afterPointCut();
    }
}
