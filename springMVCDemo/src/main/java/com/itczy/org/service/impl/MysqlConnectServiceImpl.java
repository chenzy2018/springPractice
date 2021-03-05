package com.itczy.org.service.impl;

import com.itczy.org.service.ConnectService;
import org.springframework.stereotype.Service;

/**
 * 一个接口，多个实现类的时候，必须指定名字，否则注入会报错
 */
@Service("mysqlConnect")
public class MysqlConnectServiceImpl implements ConnectService {
    @Override
    public String getConnect() {
        return "mysql";
    }
}
