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
	
	public List<Review> getReview(int refidx){   
		//key(변수명처럼 이해) String, value  는 int
		List<Review> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("review.getReview",refidx);
		mapper.close();
		return list;
		}
	
	public List<Review> getList() {
		List<Review> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("review.getList");
		mapper.close();
		return list;
	}
	
	public Cafe getOne(int idx) {
		SqlSession mapper = factory.openSession();
		Cafe dto= mapper.selectOne("review.getOne",idx);
		mapper.close();
		return dto;
	}
	
	public void insert(Review review) {
		SqlSession mapper = factory.openSession();
		mapper.insert("review.insert",review);
		mapper.commit();
		mapper.close();
	}
	public void delete(int idx) {
		SqlSession mapper = factory.openSession();
		mapper.delete("review.delete",idx);
		mapper.commit();
		mapper.close();
	}

}