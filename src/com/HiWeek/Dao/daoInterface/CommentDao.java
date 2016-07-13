package com.HiWeek.Dao.daoInterface;

import java.util.ArrayList;

import com.HiWeek.Bean.Discuss;

/**
 * 
 * @ClassName: CommentDao
 * @Description: 评论的Dao层
 * @author: XU
 * @date: 2015年10月26日 上午11:07:16
 */
public interface CommentDao {
    int insertComment(Discuss discuss);

    int deleteComment(String sqlstr);

    int updateComment(String sqlstr);

    

    ArrayList<Discuss> SelectComments(String sqlstr);
}
