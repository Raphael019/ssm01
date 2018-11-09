package com.sxt.service;

import com.sxt.base.BaseService;
import com.sxt.dao.UserMapper;
import com.sxt.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;
}
