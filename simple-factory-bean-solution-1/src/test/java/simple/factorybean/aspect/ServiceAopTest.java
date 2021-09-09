package simple.factorybean.aspect;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import simple.factorybean.po.User;
import simple.factorybean.po.mapper.UserMapper;
import simple.factorybean.service.HelloService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceAopTest {
    @SpyBean
    private ServiceAspect serviceAspect;
    @Autowired
    private HelloService ssoService;
    @SpyBean
    private UserMapper userMapper;

    @Test
    public void testAspect() {
        ssoService.hello();
        Mockito.verify(serviceAspect).afterPointCut();
    }

    @Test
    public void testTransactional() {
        doThrow(NullPointerException.class).when(userMapper).insert(refEq(new User(2, null), "name"));
        try {
            ssoService.insertHistory();
            fail("should Exception");
        } catch (NullPointerException e) {
        }
        verify(userMapper, times(2)).insert(any());
        assertEquals(0, userMapper.selectList(null).size());
    }
}
