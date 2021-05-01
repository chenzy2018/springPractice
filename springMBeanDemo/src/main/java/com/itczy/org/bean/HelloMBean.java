package com.itczy.org.bean;

/**
 * 静态MBean，必须以MBean为结尾
 *
 * 不灵活
 */
public interface HelloMBean {

    public  String greeting();

    public void setValue(String value);

    public String getValue();
}
