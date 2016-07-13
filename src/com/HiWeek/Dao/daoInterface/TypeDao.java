package com.HiWeek.Dao.daoInterface;

import java.util.ArrayList;

import com.HiWeek.Bean.Type;

public interface TypeDao {
	int insertType(Type type);

	int deleteType(String sqlstr);

	int updateType(Type type);

	ArrayList<Type> selectTypes(String sqlstr);
}
