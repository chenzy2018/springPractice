package com.itczy.org.reflect;

/**
 * 配合TestReflect注解中的1、2、3方法开闭注释
 *
 * 比如测试方法1，打开private ReflectService reflectService;，注释标记了2、3的代码
 */
public class ReflectContorller {

    //1、2.引入一个属性，通过反射给他赋值
    //private ReflectService reflectService;

    //3.使用注解方式
    @MyAutowired
    private ReflectService reflectService;

    //用于测试属性是否注入成功了
    public ReflectService getReflectService(){
        return reflectService;
    }

    //2、3.用于调用set属性
    public void setReflectService(ReflectService reflectService){
        this.reflectService = reflectService;
    }
}
