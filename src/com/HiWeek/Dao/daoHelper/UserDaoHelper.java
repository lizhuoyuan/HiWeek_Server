package com.HiWeek.Dao.daoHelper;

import java.util.ArrayList;

import com.HiWeek.Bean.User;
import com.HiWeek.Dao.daoImpl.UserImpl;
import com.HiWeek.Dao.daoInterface.UserDao;

/**
 * 
 * @ClassName UserDaoHelper
 * @Description TODO
 * @author XU 下午9:23:35
 * @date 2015年10月15日
 */
public class UserDaoHelper {

	private UserDao userDao;

	public UserDaoHelper() {
		userDao = new UserImpl();
	}

	/**
	 * 注册用户，即插入用户
	 * 
	 * @TODO 注册用户，
	 * @return -1 注册失败 0 用户已存在 >0注册成功
	 * @author Administrator
	 */
	public int registerUser(User user) {
		if (selectUserByU_tel(user.getU_tel()) != null) {
			return 0;
		}
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("(u_tel,u_name,u_pwd,r_name,u_pic,u_sex,u_credit,u_paynum,u_yue) ");
		sBuilder.append("values(");
		sBuilder.append("'" + user.getU_tel() + "',");
		sBuilder.append("'" + user.getU_name() + "',");
		sBuilder.append("'" + user.getU_pwd() + "',");
		sBuilder.append("'" + user.getR_name() + "',");
		sBuilder.append("'" + user.getU_pic() + "',");
		sBuilder.append("'" + user.getU_sex() + "',");
		sBuilder.append("'" + user.getU_credit() + "',");
		sBuilder.append(user.getU_paynum() + ",");
		sBuilder.append(user.getU_yue() + ")");
		int result = userDao.insertUser(sBuilder.toString());
		if (result > 0) {
			user.setU_id(result);
		}
		return result;

	}

	/**
	 * 
	 * @TODO 根据用户tel查询用户，来判断用户是否已经存在
	 * @return 返回User表示用户已存在，返回null表示用户不存在
	 * @author Administrator
	 */

	public User selectUserByU_tel(String u_tel) {
		String sqlstr = "where u_tel = '" + u_tel + "'";
		ArrayList<User> users;
		if ((users = userDao.selectUsers(sqlstr)) != null) {
			return users.get(0);
		} else {
			return null;
		}

	}

	/**
	 * 
	 * @Title: checkUserLogin
	 * @Description: 用户登陆检测
	 * @param u_tel
	 *            用户登陆所用tel
	 * @param u_pwd
	 *            用户登录所用pwd
	 * @return -1密码不正确，1 登陆成功，0 用户不存在
	 * @return: int
	 */
	public int checkUserLogin(String u_tel, String u_pwd) {
		User user;
		// 判断用户是否存在
		if ((user = selectUserByU_tel(u_tel)) != null) {
			// 用户存在则验证密码
			if (user.getU_pwd().equals(u_pwd)) {
				return 1;
			} else {
				return -1;
			}
		}
		// 不 存在
		else {
			return 0;
		}
	}

	public User selectUserByID(int u_id) {
		String sqlster = "where u_id=" + u_id;
		if (userDao.selectUsers(sqlster).size() == 0) {
			return null;
		} else {
			return userDao.selectUsers(sqlster).get(0);
		}
	}

	/**
	 * 李卓原 活动的修改余额和积分
	 */
	public int updateUserByID(int u_id, int u_credit, double u_yue) {
		String sqlstr = "set u_credit = " + u_credit + "," + "u_yue =" + u_yue
				+ " where u_id = " + u_id;
		if (userDao.updateUser(sqlstr) == -1) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * 李卓原 用户信息修改
	 */
	public int updateUser(int u_id, String u_sex, String u_name, String u_pic,
			int u_paynum) {
		String sqlstr = "set u_sex = '" + u_sex + "',u_name='" + u_name
				+ "',u_pic='" + u_pic + "',u_paynum=" + u_paynum
				+ " where u_id = " + u_id;
		System.out.println(sqlstr);
		if (userDao.updateUser(sqlstr) == -1) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * 郑雅倩 更新user剩余积分
	 */
	public int updateuesrcredit(int u_id, int u_credit) {
		String sqlstr = "set u_credit = " + u_credit + " where u_id = " + u_id;
		if (userDao.updateUser(sqlstr) == -1) {
			return -1;
		} else {
			return 1;
		}

	}

	public int updateUser(String u_pic, int u_id) {
		String sqlstr = "set u_pic = " + u_pic + " where u_id = " + u_id;
		if (userDao.updateUser(sqlstr) == -1) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * 更新余额
	 * 
	 * @param u_id
	 * @param u_yue
	 * @return
	 */
	public int updateuesryue(int u_id, double u_yue) {
		String sqlstr = "set u_yue = " + u_yue + " where u_id = " + u_id;
		if (userDao.updateUser(sqlstr) == -1) {
			return -1;
		} else {
			return 1;
		}

	}

}
