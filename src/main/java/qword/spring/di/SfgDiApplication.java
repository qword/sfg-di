package qword.spring.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import qword.spring.di.controllers.*;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        final I18NController i18NController = (I18NController)ctx.getBean("i18NController");
        System.out.println("--- primary bean");
        System.out.println(i18NController.sayHello());

        final MyController myController = (MyController)ctx.getBean("myController");

        System.out.println("--- primary bean");
        System.out.println(myController.sayHello());

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
