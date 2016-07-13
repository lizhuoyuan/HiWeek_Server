package com.HiWeek.Dao.daoHelper;

import java.util.ArrayList;

import com.HiWeek.Bean.Action;
import com.HiWeek.Dao.daoImpl.ActionImpl;
import com.HiWeek.Dao.daoInterface.ActionDao;

public class ActionDaoHelper {
	private ActionDao actionDao;

	public ActionDaoHelper() {
		actionDao = new ActionImpl();
	}

	public int insertAction(Action action) {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("(a_itemname,a_price,a_introduce,a_consult,a_FAQ,a_joinex,a_charge,a_stime,a_etime,a_address,mer_id,t_id) ");
		sBuilder.append("values(");
		sBuilder.append("'" + action.getA_itemname() + "',");
		sBuilder.append(action.getA_price() + ",");
		sBuilder.append("'" + action.getA_introduce() + "',");
		sBuilder.append("'" + action.getA_consult() + "',");
		sBuilder.append("'" + action.getA_FAQ() + "',");
		sBuilder.append("'" + action.getA_joinex() + "',");
		sBuilder.append("'" + action.getA_charge() + "',");
		sBuilder.append("'" + action.getA_stime() + "',");
		sBuilder.append("'" + action.getA_etime() + "',");
		sBuilder.append("'" + action.getA_address() + "',");
		sBuilder.append(action.getMerchant().getMer_id() + ",");
		sBuilder.append(action.getType().getT_id());

		sBuilder.append(")");
		int i = actionDao.insertAction(sBuilder.toString());
		if (i > 0) {
			action.setA_id(i);
			return i;
		} else {

			return i;
		}
	}

	public int updateforImage(int mer_id, String fileName) {
		// TODO Auto-generated method stub
		String sqlstr = "set a_photo = '" + fileName + "' where mer_id="
				+ mer_id;
		return actionDao.updateAction(sqlstr);
	}

	public ArrayList<Action> selectActionsByMechant(int mer_id) {
		String sqlstr = " where mer_id=" + mer_id;
		// TODO Auto-generated method stub
		return actionDao.selectActions(sqlstr);
	}

	public Action selectActionByID(String a_id) {
		// TODO Auto-generated method stub
		String sqlstr = "where a_id=" + a_id;
		if (actionDao.selectActions(sqlstr).size() == 0) {
			return null;
		} else {
			return actionDao.selectActions(sqlstr).get(0);
		}
	}

	public ArrayList<Action> selectActionByType(int t_id) {
		String sqlstr = "where t_id=" + t_id + " limit 0,5";
		if (actionDao.selectActions(sqlstr).size() == 0) {
			return null;
		} else {
			return actionDao.selectActions(sqlstr);
		}
	}
	
	public ArrayList<Action> selectByPage(int page){
		String sqlstr="ORDER BY a_id DESC "+" limit "+ (page - 1) * 4 + ",4";
		return actionDao.selectActions(sqlstr);
		
	}
	
	public ArrayList<Action> selectActionByweek() {
		String sqlstr =" limit 1,5";
		if (actionDao.selectActions(sqlstr).size() == 0) {
			return null;
		} else {
			return actionDao.selectActions(sqlstr);
		}
	}
	
	public ArrayList<Action> selectActionByhost() {
		String sqlstr ="ORDER BY a_id DESC "+" limit 1,5";
		if (actionDao.selectActions(sqlstr).size() == 0) {
			return null;
		} else {
			return actionDao.selectActions(sqlstr);
		}
	}
}
