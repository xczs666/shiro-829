package simple.factorybean.support;

import lombok.AllArgsConstructor;
import simple.factorybean.service.HelloService;

@AllArgsConstructor
public class HelloServiceHolder {
    private final HelloService helloService;
}
