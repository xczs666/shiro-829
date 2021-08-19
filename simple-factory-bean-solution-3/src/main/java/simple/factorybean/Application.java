package simple.factorybean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "simple.factorybean")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
