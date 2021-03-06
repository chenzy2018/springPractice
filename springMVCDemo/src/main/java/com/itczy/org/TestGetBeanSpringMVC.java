package com.itczy.org;

import com.itczy.org.controller.MainController;
import com.itczy.org.proxy.CglibFactory;
import com.itczy.org.proxy.Girl;
import com.itczy.org.proxy.GirlProxy;
import com.itczy.org.proxy.Human;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestGetBeanSpringMVC {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MainController mainController = ctx.getBean("mainController", MainController.class);
        System.out.println("结果是：" + ToStringBuilder.reflectionToString(mainController.list("aaa")));

        System.out.println("----------------------------------------------");

        //静态代理
        Girl girl = new Girl();
        GirlProxy girlProxy = new GirlProxy(girl);
        girlProxy.eat();

        System.out.println("----------------------------------------------");

        //动态代理
        //jdk代理方式
        Girl girl1 = new Girl();
        Human human = (Human) Proxy.newProxyInstance(
            Girl.class.getClassLoader(),
            Girl.class.getInterfaces(),
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println(method.getName()+ "被执行了");
                    if(method.getName().endsWith("eat")){
                        System.out.println("饭前");
                        Object invoke = method.invoke(girl1, args);
                        System.out.println("饭后");
                        return invoke;
                    }else{
                        System.out.println("hello");
                        //此处省略一万行
                        System.out.println("bey");
                        return null;
                    }
                }
            }
        );
        human.eat();

        System.out.println("----------------------------------------------");

        //cglib
        Girl proxy = (Girl) new CglibFactory(girl1).createProxy(Girl.class);
        proxy.eat();
    }
}
