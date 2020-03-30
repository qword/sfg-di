package qword.spring.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import qword.spring.di.controllers.MyController;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        final MyController controller = (MyController)ctx.getBean("myController");
        final String greeting = controller.sayHello();
        System.out.println(greeting);
    }

}
