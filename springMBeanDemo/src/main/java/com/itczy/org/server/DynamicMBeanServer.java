package com.itczy.org.server;

import com.itczy.org.dynamicMBean.Data;
import com.itczy.org.dynamicMBean.DataManageMBean;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * 动态beanServer
 */
public class DynamicMBeanServer {

    public static void main(String[] args) throws Exception{

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        ObjectName objectName = new ObjectName("com.itczy.org.server:type=Data");

        Data data = new DataManageMBean();

        //StandardMBean是java对DynamicMBean的一种实现，通过这种方式会更加灵活，只需要定义接口和实现类即可，而且命名不需要有任何关系
        DynamicMBean dynamicMBean = new StandardMBean(data, Data.class);

        mBeanServer.registerMBean(dynamicMBean, objectName);

        System.out.println("DynamicMBeanServer is starting......");

        Thread.sleep(Long.MAX_VALUE);
    }
}
