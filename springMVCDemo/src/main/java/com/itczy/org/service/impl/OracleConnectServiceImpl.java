package com.itczy.org.service.impl;

import com.itczy.org.service.ConnectService;
import org.springframework.stereotype.Service;

@Service("oracleConnect")
public class OracleConnectServiceImpl implements ConnectService {
    @Override
    public String getConnect() {
        return "oracle";
    }
}
