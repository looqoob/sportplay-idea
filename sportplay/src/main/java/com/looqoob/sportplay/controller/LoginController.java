package com.looqoob.sportplay.controller;

import com.looqoob.sportplay.bean.User;
import com.looqoob.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public HashMap<String, Object> login(@RequestBody User user){
        String flag = "error";
        User us = userDao.getUserByMassage(user.getUsername(),user.getPassword());
        HashMap<String,Object> res = new HashMap<>();
        if(us != null){
            flag = "ok";
        }
        res.put("flag",flag);
        res.put("user",us);
        return res;
    }

}
