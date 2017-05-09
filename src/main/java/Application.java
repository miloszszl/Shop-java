import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by przemek on 2017-03-19.
 */

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@ComponentScan({"service", "controller", "security"}) // If class in your package doesn't work add such package here.
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
