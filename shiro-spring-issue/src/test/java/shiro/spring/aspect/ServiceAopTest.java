package shiro.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import shiro.spring.dao.po.User;
import shiro.spring.dao.po.mapper.UserMapper;
import shiro.spring.service.NormalService;
import shiro.spring.service.SsoService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceAopTest {
    @SpyBean
    private ServiceAspect serviceAspect;
    @Autowired
    private SsoService ssoService;
    @Autowired
    private NormalService normalService;
    @SpyBean
    private UserMapper userMapper;

    @Test
    public void testSsoAspect() {
        reset(serviceAspect);
        ssoService.login();
        Mockito.verify(serviceAspect).afterPointCut();
    }

    @Test
    public void testNormalAspect() {
        reset(serviceAspect);
        normalService.login();
        Mockito.verify(serviceAspect).afterPointCut();
    }

    @Test
    @Rollback
    public void testSsoTransactional() {
        userMapper.deleteById(1);
        reset(userMapper);
        doThrow(NullPointerException.class).when(userMapper).insert(refEq(new User(2, null), "name"));
        try {
            ssoService.insertHistory();
            fail("should Exception");
        } catch (NullPointerException e) {
        }
        verify(userMapper, times(2)).insert(any());
        assertEquals(0, userMapper.selectList(null).size());
    }

    @Test
    public void testNormalTransactional() {
        userMapper.deleteById(1);
        reset(userMapper);
        doThrow(NullPointerException.class).when(userMapper).insert(refEq(new User(2, null), "name"));
        try {
            normalService.insertHistory();
            fail("should Exception");
        } catch (NullPointerException e) {
        }
        verify(userMapper, times(2)).insert(any());
        assertEquals(0, userMapper.selectList(null).size());
    }
}
