package com.cy.tinyIOC.Beans.factory;

import com.cy.tinyIOC.Beans.BeanDefinition;
import com.cy.tinyIOC.Beans.HelloWorldService;
import org.junit.Test;
import org.omg.Messaging.SyncScopeHelper;

public class BeanFactoryTest {

    @Test
    public void test() {
        // 1.初始化beanfactory    BeanFactory作为一个容器
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.注入bean   BeanDefinition封装bean对象
        BeanDefinition beanDefinition = new BeanDefinition();

        // 根据包路径，获取bean
        beanDefinition.setBeanClassName("com.cy.tinyIOC.Beans.HelloWorldService");

        // 将bean初始化放入BeanFactory（容器）中,为了保证扩展性，我们使用Extract Interface的方法，
        // 将`BeanFactory`替换成接口，而使用`AbstractBeanFactory`和`AutowireCapableBeanFactory`作为其实现
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.从容器种获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();



    }
}
