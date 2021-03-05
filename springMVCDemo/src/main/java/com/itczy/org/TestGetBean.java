package com.itczy.org;

import com.itczy.org.controller.MainController;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        MainController mainController = ctx.getBean("mainController", MainController.class);

        System.out.println("结果是：" + ToStringBuilder.reflectionToString(mainController.list("aaa")));
    }
}
