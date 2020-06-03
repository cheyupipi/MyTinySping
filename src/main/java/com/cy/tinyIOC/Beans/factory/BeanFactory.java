package com.cy.tinyIOC.Beans.factory;

import com.cy.tinyIOC.Beans.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {

    public Object getBean(String name) ;

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
