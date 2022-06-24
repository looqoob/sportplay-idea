package com.looqoob.sportplay.dao;

import com.looqoob.sportplay.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}
