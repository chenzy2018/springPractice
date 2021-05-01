package com.itczy.org.bean;

/**
 * JMS规定类名必须是HelloMbean的前面一部分
 */
public class Hello implements HelloMBean {

    private String value;

    public String greeting() {
        return "Hello  world" + this.value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
