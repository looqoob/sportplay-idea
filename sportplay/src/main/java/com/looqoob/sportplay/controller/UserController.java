package com.looqoob.sportplay.controller;

import com.looqoob.sportplay.bean.QueryInfo;
import com.looqoob.sportplay.bean.User;
import com.looqoob.sportplay.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/alluser")
    public Map<String,Object> getUserList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
        int numbers = userDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> users = userDao.getAllUser("%" + queryInfo.getQuery() + "%",pageStart,queryInfo.getPageSize());
        Map<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        return res;
    }

    @RequestMapping("/userstate")
    public String updateUserState(@RequestParam("id") Integer id, @RequestParam("state") boolean state){
        int i = userDao.updateState(id,state);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);
        return i > 0?"success":"error";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        int i = userDao.deleteUser(id);
        return i > 0? "success" : "error";
    }

    @RequestMapping("/getUpdateUser")
    public User getUpdateUser(int id){
        User user = userDao.getUpdateUser(id);
        return user;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        int i = userDao.editUser(user);
        return i > 0 ? "success" : "error";
    }
}
