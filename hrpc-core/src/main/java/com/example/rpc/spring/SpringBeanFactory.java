package com.example.rpc.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

@Component
public class SpringBeanFactory implements ApplicationContextAware {
    // ioc container
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     *  get bean via class
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    /**
     * get bean via beanName
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    /**
     * get bean with specified annotation
     * @param annotationClass
     * @return
     */
    public static Map<String, Object> getBeanListByAnnotationClass(Class<? extends Annotation> annotationClass) {
        return context.getBeansWithAnnotation(annotationClass);
    }

    /**
     * register bean to container
     * @param bean
     */
    public static void registerSingleton(Object bean) {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
        // spring initial check, just not create bean
        beanFactory.applyBeanPostProcessorsAfterInitialization(bean, bean.getClass().getName());
        // singleton inject into container
        beanFactory.registerSingleton(bean.getClass().getName(), bean);
    }
}
