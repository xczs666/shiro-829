package shiro.spring.service.factorybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import shiro.spring.dao.po.mapper.UserMapper;
import shiro.spring.service.NormalService;

/**
 * @author chenzhi.xu
 * @date 2021/09/15
 */
public class NormalServiceFactoryBean implements FactoryBean<NormalService>, BeanPostProcessor {
    private final NormalService instance;

    public NormalServiceFactoryBean(UserMapper userMapper) {
        this.instance = new NormalService(userMapper);
    }

    @Override
    public NormalService getObject() throws Exception {
        return instance;
    }

    @Override
    public Class<?> getObjectType() {
        return NormalService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
