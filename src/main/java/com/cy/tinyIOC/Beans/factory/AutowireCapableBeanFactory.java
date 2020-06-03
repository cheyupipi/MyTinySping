package com.cy.tinyIOC.Beans.factory;

import com.cy.tinyIOC.Beans.BeanDefinition;
import com.cy.tinyIOC.Beans.PropertyValue;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        //将bean实例化
        Object bean = createBeanInstance(beanDefinition);

        //设置bean的属性值
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {

        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            //获取bean 属性，name参数指定了属性的名称
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            //告诉安全机制，这个变量可以访问即可解决
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }
}
