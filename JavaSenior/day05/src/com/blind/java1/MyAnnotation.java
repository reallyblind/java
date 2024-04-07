package com.blind.java1;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author blind
 * @create 2022-08-25-15:11
 */

@Repeatable(MyAnnotations.class)
@Target({TYPE,FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE,TYPE_PARAMETER,TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";
}
