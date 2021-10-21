package com.deco.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.deco.dto.Cafe;
import com.deco.dto.Review;
import com.deco.mybatis.SqlSessionBean;

public class ReviewDao {
	private static ReviewDao dao = new ReviewDao();
	private ReviewDao() {}
	public static ReviewDao getInstance() {
		return dao;
	}
	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	
	public List<Review> getList() {
		List<Review> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("review.getList");
		mapper.close();
		return list;
	}

}