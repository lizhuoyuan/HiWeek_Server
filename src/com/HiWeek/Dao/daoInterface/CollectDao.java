package com.HiWeek.Dao.daoInterface;

import java.util.ArrayList;

import com.HiWeek.Bean.Action;
import com.HiWeek.Bean.Collect;

/**
 * @author 李卓原
 * 创建时间：2015-10-27 下午7:04:48 
 * 
 */
public interface CollectDao {
		// 增加收藏
		int insertCollect(int a_id,String ce_time,String a_itemname,int u_id);

		// 根据条件删除收藏
		int deleteCollect(int a_id,int u_id);
		
		//查询所有收藏
		ArrayList<Collect> findCollect(int u_id);
		
		//根据id(用户+活动)查询收藏
		int FindCollect(int u_id,int a_id);
}
