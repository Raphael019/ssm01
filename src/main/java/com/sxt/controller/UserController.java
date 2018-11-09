package com.sxt.controller;

import com.sxt.po.User;
import com.sxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("queryById/{id}")
    @ResponseBody
    public User queryById(@PathVariable Integer id) throws Exception {
        return userService.queryById(id);
    }

    @RequestMapping(value = "queryByName/{username}", method =RequestMethod.GET)
    @ResponseBody
    public List<User> queryByName(@PathVariable String username){
        List<User> userslist = userService.queryByName(username);
        return userslist;
    }

}
