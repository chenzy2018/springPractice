package com.itczy.org;

import com.itczy.org.domain.dto.Person;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean {
    public static void main(String[] args) {
        //从spring容器中获取bean，原始方式
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        System.out.println(ToStringBuilder.reflectionToString(person));

        //使用name属性获取bean，那么可以多个，且获取到的bean是一个bean，和使用id获取的也是一个bean，多一种选择而已
        Person humen = ctx.getBean("humen", Person.class);
        Person star = ctx.getBean("star", Person.class);
        //三个的hashcode是一样的，说明是同一个对象
        System.out.println(person.hashCode());
        System.out.println(humen.hashCode());
        System.out.println(star.hashCode());
    }
}
