package com.itczy.org.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//指定运行时
@Target(ElementType.FIELD)//指定作用于field
public @interface MyAutowired {
}
