package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by przemek on 2017-03-19.
 */

@SpringBootApplication
@ComponentScan({"service", "hello"}) // If class in your package doesn't work add such package here.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
