package com.HiWeek.Dao.daoHelper;

import java.util.ArrayList;

import com.HiWeek.Bean.Merchant;
import com.HiWeek.Bean.Type;
import com.HiWeek.Dao.daoImpl.MerchantImpl;
import com.HiWeek.Dao.daoInterface.MerchantDao;

public class MerchantDaoHelper {
	private MerchantDao merchantDao;
	private Merchant merchant2;

	public MerchantDaoHelper() {
		merchantDao = new MerchantImpl();
		merchant2 = new Merchant();
	}

	// 根据ID查找Merchant对象
	public Merchant selectMerchantByID(int ID) {
		Merchant merchant = new Merchant();
		merchant.setMer_id(ID);
		if (selectMerchants(merchant).size() == 0) {
			return null;
		} else {
			return selectMerchants(merchant).get(0);
		}
	}

	//
	public ArrayList<Merchant> selectMerchants(Merchant merchant) {
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append(" where 1=1 ");

		// 进行判断 拼接字符串int mer_id; String mer_name; String mer_address; String
		// mer_tel;
		// String mer_password;String mer_introduce;
		String mer_tel = merchant.getMer_tel();
		int mer_id = merchant.getMer_id();
		String mer_address = merchant.getMer_address();
		if (mer_tel != null) {
			sbBuilder.append(" and mer_tel = '" + mer_tel + "'");
		}
		if (mer_id != 0) {
			sbBuilder.append(" and mer_id = " + mer_id);
		}
		if (mer_address != null) {
			sbBuilder.append(" and met_address = '" + mer_address + "'");
		}
		return merchantDao.selectMerchants(sbBuilder.toString());
	}

	public Merchant selectMerchantByTel(String tel) {
		Merchant merchant = new Merchant();
		merchant.setMer_tel(tel);
		if (selectMerchants(merchant).size() == 0) {
			return null;
		} else {
			return selectMerchants(merchant).get(0);
		}

	}

	public int updateMerchant(Merchant merchant) {
		StringBuilder sBuilder = new StringBuilder();
		String mer_name = merchant.getMer_name();
		sBuilder.append(" mer_name = '" + mer_name + "'");
		String mer_tel = merchant.getMer_tel();
		sBuilder.append(",mer_tel = '" + mer_tel + "'");
		String mer_address = merchant.getMer_address();
		sBuilder.append(",mer_address = '" + mer_address + "'");
		String mer_introduce = merchant.getMer_introduce();
		sBuilder.append(",mer_introduce = '" + mer_introduce + "'");
		Type type = merchant.getType();
		sBuilder.append(",t_id = " + type.getT_id() + " where mer_id = "
				+ merchant.getMer_id());
		return merchantDao.updateMerchant(sBuilder.toString());
	}

	public int updatePwd(int mer_id, String pwd) {
		String sqlstr = "mer_password='" + pwd + "' where mer_id =" + mer_id;
		return merchantDao.updateMerchant(sqlstr);

	}

	public int insertMerchant(Merchant merchant) {
		// TODO Auto-generated method stub
		StringBuilder vBuilder = new StringBuilder();
		StringBuilder Builder = new StringBuilder();
		Builder.append("(mer_name,mer_tel,mer_password,mer_address,mer_introduce,t_id)");
		vBuilder.append(" values(");
		vBuilder.append("'" + merchant.getMer_name() + "',");
		vBuilder.append("'" + merchant.getMer_tel() + "',");
		vBuilder.append("'" + merchant.getMer_password() + "',");
		vBuilder.append("'" + merchant.getMer_address() + "',");
		vBuilder.append("'" + merchant.getMer_introduce() + "',");
		vBuilder.append(merchant.getType().getT_id());
		vBuilder.append(")");
		Builder.append(vBuilder);
		int i = merchantDao.insertMerchant(Builder.toString());
		if (i > 0) {
			merchant.setMer_id(i);
		}
		return i;
	}
}
