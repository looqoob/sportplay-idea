package com.looqoob.sportplay.dao;

import com.looqoob.sportplay.bean.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeDao {
    public int userNum();
    public List<String> GoodsName();
}
