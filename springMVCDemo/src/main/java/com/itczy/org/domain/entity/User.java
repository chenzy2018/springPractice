package com.itczy.org.domain.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * 多例
 */
@Repository
@Scope("prototype")
public class User {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
