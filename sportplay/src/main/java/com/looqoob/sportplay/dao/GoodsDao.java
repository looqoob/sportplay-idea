package com.looqoob.sportplay.dao;

import com.looqoob.sportplay.bean.Goods;
import com.looqoob.sportplay.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {
    public Goods getUserByMassage(@Param("name") String name);
    public List<Goods> getGoods(@Param("name") String name ,@Param("pageStart") int PageSart, @Param("pageSize")int pageSize);
    public int getGoodsCounts(@Param("name") String name);
    public int updateGoodsState(Integer id,boolean state);
    public int addGoods(Goods goods);
    public int deleteGoods(int id);
    public Goods getUpdateGoods(int id);
    public int editGoods(Goods goods);
}
