package com.itczy.org.controller;

import com.itczy.org.domain.entity.User;
import com.itczy.org.service.ConnectService;
import com.itczy.org.service.MainSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller("mainController")
public class MainController {

    /**
     * spring通过注解方式，就不用配置xml了
     */

    @Autowired
    private MainSerive mainSerive;

    //对于指定了名字的类，使用@Autowired注入时需要配合@Qualifier使用
    @Autowired
    @Qualifier("mysqlConnect")
    private ConnectService connectService;

    public User list(String name){

        System.out.println("当前连接："+connectService.getConnect());
        return mainSerive.getUesr(name);
    }

    /**
     * 传统方式就需要生成get/set方法或者是增加带参构造函数
     * 然后通过xml配置bean的属性，注入mainSerive
     */
    /*public MainSerive getMainSerive() {
        return mainSerive;
    }

    public void setMainSerive(MainSerive mainSerive) {
        this.mainSerive = mainSerive;
    }*/
}
