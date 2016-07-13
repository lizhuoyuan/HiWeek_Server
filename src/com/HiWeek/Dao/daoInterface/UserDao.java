package com.HiWeek.Dao.daoInterface;

import java.util.ArrayList;

import com.HiWeek.Bean.User;

/**
 * 用户Dao层
 * 
 * @author XU
 * 
 */
public interface UserDao {
	// 增
	/**
	 * 
	 * @param sql
	 * @return 插入失败返回-1；插入成功返回自增ID,
	 */
	int insertUser(String sql);

	// 删
	/**
	 * 
	 * @param sql
	 * @return 删除失败返回 -1;插入成功返回影响行数
	 */
	int deleteUser(String sql);

	// 改
	/**
	 * 
	 * @param sql
	 * @return 更新失败返回-1；更新成功返回影响行数
	 */
	int updateUser(String sql);

	// 查
	/**
	 * 
	 * @param sql
	 * @return 查询成功返回结果集，查询失败返回null
	 */
	ArrayList<User> selectUsers(String sql);
}
