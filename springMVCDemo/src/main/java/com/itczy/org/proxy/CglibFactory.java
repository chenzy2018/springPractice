package com.itczy.org.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGlib代理工程
 */
public class CglibFactory implements MethodInterceptor {

    private Object targrt;

    public CglibFactory() {
        super();
    }

    public CglibFactory(Object targrt) {
        super();
        this.targrt = targrt;
    }

    public Object createProxy(Class clazz){
        //增强器
        Enhancer enchancer = new Enhancer();
        //这里应该反射的方式获取class，更加灵活
        enchancer.setSuperclass(clazz);
        //就是指intercept方法
        enchancer.setCallback(this);
        return enchancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().endsWith("eat")){
            System.out.println("cglib前");
            Object result = method.invoke(targrt, objects);
            System.out.println("cglib后");
            return result;
        }else{
            System.out.println("hello cglib");
            //此处省略一万行
            System.out.println("bey cglib");
            return null;
        }

    }
}
