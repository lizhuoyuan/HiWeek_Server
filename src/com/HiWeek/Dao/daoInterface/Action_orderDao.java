package com.HiWeek.Dao.daoInterface;

import java.util.ArrayList;

import com.HiWeek.Bean.Action_order;

public interface Action_orderDao {
    //插入
	int insertAction_orderDao(Action_order action_order);
	
	//删除
	int deleteAction_orderDao(int ao_id);
	
	//查询
	ArrayList<Action_order> selectAction_order(String sqlstr);
	
	//更新状态
	int updateAction_orderState(int ao_id);
}
