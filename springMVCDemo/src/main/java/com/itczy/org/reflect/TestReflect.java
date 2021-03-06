package com.itczy.org.reflect;

import org.springframework.beans.factory.BeanFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

/**
 * 自己使用反射实现spring
 *
 * spring底层也就是使用的反射
 */
public class TestReflect {

    public static void main(String[] args) throws Exception {
        ReflectContorller reflectContorller = new ReflectContorller();
        ReflectService reflectService = new ReflectService();
        Class<? extends ReflectContorller> reflectClazz = reflectContorller.getClass();

        //不知道属性的情况需要这样循环去获取
        //Field[] declaredFields = reflectClazz.getDeclaredFields();
        //Arrays.asList(declaredFields).stream().forEach(System.out::println);

        //这里简化直接获取
        Field reflectField = reflectClazz.getDeclaredField("reflectService");

        //1.直接给属性设置值
        // reflectField.setAccessible(true);//由于属性是private的，因此需要设置这个属性为ture，否者会报非法访问的异常
        // reflectField.set(reflectContorller,reflectService);

        //2.调用set方法设置属性的值
        // String name = reflectField.getName();
        // //由于set和get方法严格遵守驼峰，因此可以这样直接构造，老外的严谨之处，也是约定大于配置，配置大于编码的重要体现
        // String methodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1,name.length());
        // System.out.println("需要调用的方法名："+methodName);
        // Method declaredMethod = reflectClazz.getDeclaredMethod(methodName, ReflectService.class);//获取该名称的方法
        // declaredMethod.invoke(reflectContorller, reflectService);//invoke调用

        //3,结合注解实现属性值的注入
        Stream.of(reflectClazz.getDeclaredFields()).forEach(
                field -> {
                    MyAutowired annotation = field.getAnnotation(MyAutowired.class);
                    if(annotation != null){//表示该属性有@MyAutowired注解
                        field.setAccessible(true);//由于属性是private的，因此需要设置这个属性为ture，否者会报非法访问的异常
                        Class<?> type = field.getType();//获取属性的类型
                        try {
                            /**
                           * 这是使用了newInstance，但是spring中bean都是单例，肯定不允许每次都new
                           * 在spring中要怎么找到此类型的单例bean？
                           * bean被保存在beanFactory中，下面这行代码换成从beanFactory中获取，就是spring的实现逻辑
                           */
                            Object instance = type.getConstructor().newInstance();//jdk11之后推荐的写法，9以前可以写成type.newInstance()
                            field.set(reflectContorller, instance);
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        System.out.println(reflectContorller.getReflectService());


    }
}
