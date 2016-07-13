package com.HiWeek.Dao.daoInterface;

import java.util.ArrayList;

import com.HiWeek.Bean.Action;

/**
 * 长知识DAO
 * 
 * @author XU
 */
public interface ActionDao {
	// 增加活动
	int insertAction(String sqlstr);

	// 根据条件删除活动
	int deleteAction(String sqlstr);

	// 修改活动内容
	int updateAction(String sqlstr);

	// 多条件查询活动
	ArrayList<Action> selectActions(String sqlstr);
	
	//查询所有活动
	ArrayList<Action> findAction(String sqlstr);
	
	//搜索活动
	ArrayList<Action> search(String sqlstr);
}
