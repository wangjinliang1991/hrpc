package com.example.rpc.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Component
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HrpcService {

    /**
     *  equal to @Component
     * @return
     */
    @AliasFor(annotation = Component.class)
    String value() default "";

    /**
     * interface class
     * @return
     */
    Class<?> interfaceClass() default void.class;

    /**
     * interface name
     * @return
     */
    String interfaceName() default "";

    /**
     *  service version
     * @return
     */
    String version() default "";

    /**
     * service group
     * @return
     */
    String group() default "";
}
