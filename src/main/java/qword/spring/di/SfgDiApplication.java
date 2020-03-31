package qword.spring.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import qword.spring.di.controllers.ConstructorInjectedController;
import qword.spring.di.controllers.MyController;
import qword.spring.di.controllers.PropertyInjectedController;
import qword.spring.di.controllers.SetterInjectedController;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        final MyController controller = (MyController)ctx.getBean("myController");
        final String greeting = controller.sayHello();
        System.out.println(greeting);

        System.out.println();

        System.out.println("--- property injected");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController)ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("--- setter injected");
        SetterInjectedController setterInjectedController = (SetterInjectedController)ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("--- constructor injected");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());
    }

}
