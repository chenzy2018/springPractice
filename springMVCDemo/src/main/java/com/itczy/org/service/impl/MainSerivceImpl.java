package com.itczy.org.service.impl;

import com.itczy.org.domain.entity.User;
import com.itczy.org.service.MainSerive;
import org.springframework.stereotype.Component;

@Component
public class MainSerivceImpl implements MainSerive {
    @Override
    public User getUesr(String name) {
        User user = new User();
        user.setName(name);
        user.setAge(18);
        return user;
    }
}
