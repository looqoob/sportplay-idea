package com.looqoob.sportplay.controller;

import com.looqoob.sportplay.bean.Sport;
import com.looqoob.sportplay.bean.User;
import com.looqoob.sportplay.dao.SportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SportController {

    @Autowired
    SportDao sportDao;

    @RequestMapping("/allSport")
    public Map<String,Object> getAllSport(){
        HashMap<String,Object> data = new HashMap<>();
        List<Sport> sports = sportDao.getAllSport();
        if(sports!=null){
            data.put("sport",sports);
            data.put("flag",200);
        }else{
            data.put("flag",404);
        }
        return data;
    }

    @RequestMapping("/setSport")
    public String setSport(@RequestBody Sport sport){
        int i = sportDao.setSport(sport);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/editSport")
    public Map<String,Object> editSport(@RequestBody Sport sport){
        Map<String,Object> res = new HashMap<>();
        int i = sportDao.editSport(sport);
        res.put("res",i > 0 ? "success" : "error");
        return res;
    }
}
