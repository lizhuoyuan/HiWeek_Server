package com.HiWeek.Dao.daoInterface;

import java.util.ArrayList;

import com.HiWeek.Bean.Cinema;

public interface CinemaDao {
    // 增加
    int insertCinema(Cinema cinema);

    // 删除
    int deleteCinema();

    // 修改电影院分数
    int updategrade(int c_id, double c_grade);

    // 根据条件查询
    ArrayList<Cinema> selectCinemas(String sql);
}
