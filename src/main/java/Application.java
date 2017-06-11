import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by przemek on 2017-03-19.
 */

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@EnableJpaRepositories("dao")
@EntityScan("POJO")
@ComponentScan({"service", "controller", "security","dao",}) // If class in your package doesn't work add such package here.
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
