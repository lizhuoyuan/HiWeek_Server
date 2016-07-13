package com.HiWeek.Dao.daoHelper;

import java.util.ArrayList;

import com.HiWeek.Bean.Action_order;
import com.HiWeek.Dao.daoImpl.Action_orderImpl;

public class Action_orderDaoHelper {
	Action_orderImpl a_orderImpl;

	public Action_orderDaoHelper() {
		a_orderImpl = new Action_orderImpl();
	}

	public Action_orderDaoHelper(Action_orderImpl a_orderImpl) {

	}

	public Action_order selectById(int ao_id) {
		String sqrlt = "where ao_id=" + ao_id;
		if (a_orderImpl.selectAction_order(sqrlt).size() == 0) {
			return null;
		} else {
			return a_orderImpl.selectAction_order(sqrlt).get(0);
		}
	}

	/**
	 * 根据u_id查询活动订单
	 * 
	 * @param u_id
	 * @return
	 */
	public ArrayList<Action_order> selsetByUID(int u_id) {
		String sqrlt = "where u_id=" + u_id;
		if (a_orderImpl.selectAction_order(sqrlt).size() == 0) {
			return null;
		} else {
			return a_orderImpl.selectAction_order(sqrlt);
		}

	}

	/**
	 * 分页按u_id 来查询
	 * 
	 * @param u_id
	 * @param page
	 * @return
	 */
	public ArrayList<Action_order> selectBypage(int u_id, int page) {
		String sqrlt = "WHERE u_id=" + u_id + " ORDER BY ao_id DESC "
				+ "limit " + (page - 1) * 4 + ",4";
		return a_orderImpl.selectAction_order(sqrlt);

	}
}
