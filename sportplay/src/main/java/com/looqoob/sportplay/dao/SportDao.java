package com.looqoob.sportplay.dao;

import com.looqoob.sportplay.bean.Sport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportDao {
    public List<Sport> getAllSport();
    public int setSport(Sport sport);
    public int editSport(Sport sport);
}
