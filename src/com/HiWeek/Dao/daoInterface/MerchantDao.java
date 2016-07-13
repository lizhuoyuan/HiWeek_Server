package com.HiWeek.Dao.daoInterface;

import java.util.ArrayList;

import com.HiWeek.Bean.Merchant;

/**
 * 商家Dao层
 * 
 * @author XU
 * 
 */
public interface MerchantDao {
	// 增加
	int insertMerchant(String sql);

	// 多条件删除
	int deleteMerchant(String sql);

	// 更新
	int updateMerchant(String sql);

	// 根据条件查询
	ArrayList<Merchant> selectMerchants(String sql);
}
