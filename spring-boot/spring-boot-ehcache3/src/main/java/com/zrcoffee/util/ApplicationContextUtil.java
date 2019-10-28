package com.zrcoffee.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring ApplicationContext 工具
 *
 * @author Terry
 * @version 2019-10-27
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * Set the ApplicationContext that this object runs in.
     * Normally this call will be used to initialize the object.
     *
     * @param applicationContext the ApplicationContext object to be used by this object
     * @throws BeansException if thrown by application context methods
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationContextUtil.applicationContext == null) {
            ApplicationContextUtil.applicationContext = applicationContext;
        }
    }

    /**
     * Get the ApplicationContext that this object runs in.
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * Return an instance, which may be shared or independent, of the specified bean.
     *
     * @param name the name of the bean to retrieve
     * @return an instance of the bean
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * Return the bean instance that uniquely matches the given object type, if any.
     *
     * @param clazz type the bean must match; can be an interface or superclass
     * @return an instance of the single bean matching the clazz type
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * Return an instance, which may be shared or independent, of the specified bean.
     *
     * @param name  the name of the bean to retrieve
     * @param clazz type the bean must match; can be an interface or superclass
     * @return an instance of the bean
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

}
