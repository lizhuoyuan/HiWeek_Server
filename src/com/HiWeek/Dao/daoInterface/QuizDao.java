package com.HiWeek.Dao.daoInterface;

import java.util.ArrayList;

import com.HiWeek.Bean.Quiz;

/**
 * @author 李卓原 创建时间：2015-10-21 下午7:12:24 提问表
 */
public interface QuizDao {
	// 添加提问信息
	int insertQuiz(String sqlstr);

	// 查询某个活动的提问信息
	ArrayList<Quiz> findQuiz(Integer a_id);

	// 查询自己对某个活动的提问信息
	ArrayList<Quiz> SelectMyQuestion(Integer a_id);
}
