package com.HiWeek.Dao.daoInterface;

import java.util.ArrayList;

import com.HiWeek.Bean.Movie_order;

/**
 * 电影订单Dao层
 * @author 郑雅倩
 *
 */
public interface Movie_orderDao {
	//增加
    int insertMovie_order(Movie_order movie_order);
    
    //删除
    int deleteMovie_order(int mo_id);
    
    //查询
    ArrayList<Movie_order> selectMovie_order(String sqlstr);
    
    //更新状态为2
    int updataMovie_orderState(int mo_id);
    
    //更新新状态为3
    int updataMovie_orderState3(int mo_id);
    
}
