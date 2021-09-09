package simple.factorybean.support;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import simple.factorybean.service.HelloService;

@AllArgsConstructor
public class ShiroFilterFactoryBean implements FactoryBean, BeanPostProcessor {
    private final HelloService helloService;

    @Override
    public Object getObject() throws Exception {
        return new HelloServiceHolder(helloService);
    }

    @Override
    public Class<?> getObjectType() {
        return HelloServiceHolder.class;
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
