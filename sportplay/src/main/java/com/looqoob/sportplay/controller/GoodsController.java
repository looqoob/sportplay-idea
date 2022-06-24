package com.looqoob.sportplay.controller;

import com.looqoob.sportplay.bean.Goods;
import com.looqoob.sportplay.bean.GoodsQueryInfo;
import com.looqoob.sportplay.bean.User;
import com.looqoob.sportplay.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GoodsController {
    @Autowired
    private GoodsDao goodsDao;

    @RequestMapping("/getGoods")
    public Map<String,Object> getGoods(GoodsQueryInfo goodsQueryInfo){
        int numbers = goodsDao.getGoodsCounts("%" + goodsQueryInfo.getQuery() + "%");
        int pageStart = (goodsQueryInfo.getPageNum() - 1) * goodsQueryInfo.getPageSize();
        List<Goods> goods = goodsDao.getGoods("%" + goodsQueryInfo.getQuery() + "%",pageStart,goodsQueryInfo.getPageSize());
        Map<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",goods);
        return res;
    }

    @RequestMapping("/GoodsState")
    public String updateGoodsState(@RequestParam("id") Integer id, @RequestParam("state") boolean state){
        int i = goodsDao.updateGoodsState(id,state);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/addGoods")
    public String addGoods(@RequestBody Goods goods){
        goods.setState(false);
        int i = goodsDao.addGoods(goods);
        return i > 0?"success":"error";
    }
    @RequestMapping("/deleteGoods")
    public String deleteGoods(int id){
        int i = goodsDao.deleteGoods(id);
        return i > 0? "success" : "error";
    }

    @RequestMapping("/getUpdateGoods")
    public Goods getUpdateGoods(int id){
        Goods goods = goodsDao.getUpdateGoods(id);
        return goods;
    }

    @RequestMapping("/editGoods")
    public String editGoods(@RequestBody Goods goods){
        int i = goodsDao.editGoods(goods);
        return i > 0 ? "success" : "error";
    }
}
