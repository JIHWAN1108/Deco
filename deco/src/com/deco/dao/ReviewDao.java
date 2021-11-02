package com.deco.dao;

import java.util.List;
import java.util.Map;

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

	public List<Review> getList10(Map<String, Integer> map) {
		List<Review> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("review.getList10", map);
		mapper.close();
		return list;
	}
	
	public List<Review> getReview(int refidx){   
		//key(변수명처럼 이해) String, value  는 int
		List<Review> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("review.cafegetReview",refidx);
		mapper.close();
		return list;
	}
	public List<Review> foodgetReview(int fidx){   
		//key(변수명처럼 이해) String, value  는 int
		List<Review> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("review.foodgetReview",fidx);
		mapper.close();
		return list;
	}
	public List<Review> showsgetReview(int sidx){   
		//key(변수명처럼 이해) String, value  는 int
		List<Review> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("review.showsgetReview",sidx);
		mapper.close();
		return list;
	}
	public List<Review> etcgetReview(int eidx){   
		//key(변수명처럼 이해) String, value  는 int
		List<Review> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("review.etcgetReview",eidx);
		mapper.close();
		return list;
	}
	public List<Review> reviewList(String nickname){   
		//key(변수명처럼 이해) String, value  는 int
		List<Review> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("review.reviewList",nickname);
		mapper.close();
		return list;
	}
	
	public Cafe getOne(int idx) {
		SqlSession mapper = factory.openSession();
		Cafe dto= mapper.selectOne("review.getOne",idx);
		mapper.close();
		return dto;
	}
	
	public void cafeInsert(Review review) {
		SqlSession mapper = factory.openSession();
		mapper.insert("review.cafeInsert",review);
		mapper.commit();
		mapper.close();
	}
	public void foodInsert(Review review) {
		SqlSession mapper = factory.openSession();
		mapper.insert("review.foodInsert",review);
		mapper.commit();
		mapper.close();
	}
	public void showsInsert(Review review) {
		SqlSession mapper = factory.openSession();
		mapper.insert("review.showsInsert",review);
		mapper.commit();
		mapper.close();
	}
	public void etcInsert(Review review) {
		SqlSession mapper = factory.openSession();
		mapper.insert("review.etcInsert",review);
		mapper.commit();
		mapper.close();
	}
	
	public void delete(int idx) {
		SqlSession mapper = factory.openSession();
		mapper.delete("review.delete",idx);
		mapper.commit();
		mapper.close();
	}
	
	
	
	
	public int getCount(String nickname) {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("review.getCount",nickname);  //여기문제인데요.
		mapper.close();     
		return cnt;
	}

	public int cafeCount(int refidx) {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("review.cafeCount",refidx);  //여기문제인데요.
		mapper.close();     
		return cnt;
	}
	public int foodCount(int fidx) {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("review.foodCount",fidx);  
		mapper.close();     
		return cnt;
	}
	public int showsCount(int sidx) {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("review.showsCount",sidx);  
		mapper.close();     
		return cnt;
	}
	public int etcCount(int eidx) {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("review.etcCount",eidx);  
		mapper.close();     
		return cnt;
	}
	
}