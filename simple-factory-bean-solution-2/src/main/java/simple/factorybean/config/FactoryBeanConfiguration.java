package simple.factorybean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import simple.factorybean.service.HelloService;
import simple.factorybean.support.IdentityBeanPostProcessor;
import simple.factorybean.support.ShiroFilterFactoryBean;

@Configuration
public class FactoryBeanConfiguration {
    @Bean
    public ShiroFilterFactoryBean objectFactoryBean(HelloService helloService) {
        return new ShiroFilterFactoryBean(helloService);
    }

    @Bean
    public IdentityBeanPostProcessor identityBeanPostProcessor() {
        return new IdentityBeanPostProcessor();
    }
}
