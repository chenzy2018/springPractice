package com.itczy.org.server;

import com.itczy.org.bean.Hello;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * 用于暴露MBean
 */
public class HelloMBeanServer {

    public static void main(String[] args) throws Exception {

        //暴露bean的Server
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        //定义对象信息，用于在Jconsole或者Jmap中找到该Mbean
        ObjectName objectName = new ObjectName("com.itczy.org.server:type=Hello");

        mBeanServer.registerMBean(new Hello(), objectName);

        System.out.println("HelloMBeanServer is starting......");

        Thread.sleep(Long.MAX_VALUE);
    }
}
