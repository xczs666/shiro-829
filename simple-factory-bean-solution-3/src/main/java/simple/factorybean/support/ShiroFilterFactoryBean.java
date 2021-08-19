package simple.factorybean.support;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.FactoryBean;
import simple.factorybean.service.HelloService;

@AllArgsConstructor
public class ShiroFilterFactoryBean implements FactoryBean<HelloServiceHolder> {
    private final HelloService helloService;

    @Override
    public HelloServiceHolder getObject() throws Exception {
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
