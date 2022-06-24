package com.looqoob.sportplay.controller;

import com.looqoob.sportplay.bean.Goods;
import com.looqoob.sportplay.dao.HomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    HomeDao homeDao;

    @RequestMapping("/four")
    public Map<String,Integer> four (){
        HashMap<String,Integer> res = new HashMap<>();
        int sum = homeDao.userNum();
        res.put("userNum",sum);
        res.put("daySales",131);
        res.put("monthSales",1033);
        res.put("sum",12414);
        return res;
    }

    @RequestMapping("/getGoodsName")
    public Map<String,Object> getGoodsName (){
        HashMap<String,Object> res = new HashMap<>();
        List<String> goodsName = homeDao.GoodsName();
        res.put("goodsName",goodsName);
        return res;
    }
}
