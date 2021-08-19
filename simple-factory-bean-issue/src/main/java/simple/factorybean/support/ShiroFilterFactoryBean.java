package simple.factorybean.support;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.FactoryBean;
import simple.factorybean.service.HelloService;
import simple.factorybean.support.HelloServiceHolder;

@AllArgsConstructor
public class ShiroFilterFactoryBean implements FactoryBean {
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
}
