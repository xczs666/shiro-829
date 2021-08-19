package shiro.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import shiro.spring.service.SsoService;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceAspcetTest {
    @SpyBean
    private ServiceAspect serviceAspect;
    @Autowired
    private SsoService ssoService;

    @Test
    public void testService() {
        ssoService.login();
        Mockito.verify(serviceAspect).afterPointCut();
    }
}
