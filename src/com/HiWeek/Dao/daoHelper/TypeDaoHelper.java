package com.HiWeek.Dao.daoHelper;

import java.util.ArrayList;

import com.HiWeek.Bean.Type;
import com.HiWeek.Dao.daoImpl.TypeImpl;
import com.HiWeek.Dao.daoInterface.TypeDao;

public class TypeDaoHelper {
	TypeDao typeDao;

	public TypeDaoHelper() {
		typeDao = new TypeImpl();
	}

	// 根据ID查找Type
	public Type selectTypeByID(int ID) {
		Type type = new Type();
		type.setT_id(ID);
		if (selectTypes(type).size() == 0) {
			return null;
		} else {
			return selectTypes(type).get(0);
		}
	}

	public ArrayList<Type> selectTypes(Type type) {
		StringBuilder sBuilder = new StringBuilder();

		return typeDao.selectTypes(sBuilder.toString());
	}
}
