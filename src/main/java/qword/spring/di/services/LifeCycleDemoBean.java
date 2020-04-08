package qword.spring.di.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("\t## Bean Factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("\t## My Bean name is: " + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("\t## The life cycle of this bean has reached to an end");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("\t## The LifeCycleBean has its properties set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("\t## Application context has been set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("\t## The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("\t## The Pre Destroy annotated method has been called");
    }

    public void beforeInit() {
        System.out.println("\t## Before Init, called by Bean Post Processor");
    }

    public void afterInit() {
        System.out.println("\t## After Init, called by Bean Post Processor");
    }
}
