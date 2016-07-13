package com.HiWeek.Dao.daoHelper;

import java.util.ArrayList;

import com.HiWeek.Bean.Discuss;
import com.HiWeek.Dao.daoImpl.CommentDaoImpl;

public class CommentDaoHelper {
    private CommentDaoImpl commentDaoImpl;

    public CommentDaoHelper() {
	commentDaoImpl = new CommentDaoImpl();
    }

    /**
     * 
     * @Title: selectComments
     * @Description: 查询对电影的评论，page为-1时，显示前两条，其他为显示10条
     * @param m_id
     * @param page
     * @return
     * @Author XU
     */
    public ArrayList<Discuss> selectComments(int m_id, int page) {
	StringBuilder sb = new StringBuilder();
	sb.append("where m_id = ").append(m_id);
	sb.append(" ORDER BY d_id DESC");
	if (page < 0) {
	    sb.append(" limit 0,2");
	} else {
	    sb.append(" limit " + page * 10 + ",10");
	}
	System.out.println(sb.toString());
	return commentDaoImpl.SelectComments(sb.toString());
    }

    public ArrayList<Discuss> selectComments(int m_id) {
	return selectComments(m_id, -1);
    }

}
