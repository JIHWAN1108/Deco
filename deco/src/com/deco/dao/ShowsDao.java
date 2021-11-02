package com.deco.dao;

import java.util.List; 
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.deco.dto.Shows;
import com.deco.mybatis.SqlSessionBean;

public class ShowsDao {

	private static ShowsDao dao = new ShowsDao();
	private ShowsDao() {}
	public static ShowsDao getInstance() {
		return dao;
	}
	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	
//	public List<Cafe> getList() {
//		List<Cafe> list = null;
//		SqlSession mapper = factory.openSession();
//		list = mapper.selectList("cafe.getList");
//		mapper.close();
//		return list;
//	}
	
	//명진님 getList
	public List<Shows> getList(Map<String, Integer> map) {
		List<Shows> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("shows.getList",map);
		mapper.close();
		return list;
	}
	public List<Shows> getShowsBest() {
		List<Shows> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("shows.showsBest");
		mapper.close();
		return list;
	}
	
	public Shows getOne(int sidx) {
		SqlSession mapper = factory.openSession();
		Shows c = mapper.selectOne("shows.getOne",sidx);
		mapper.close();
		return c;
	}
	
	
	
	public void insert(Shows shows) {
		SqlSession mapper = factory.openSession();
		mapper.insert("shows.insert", shows);
		mapper.commit();
		mapper.close();
	}
	
	public void update(Shows shows) {
		SqlSession mapper = factory.openSession();
		mapper.update("shows.update",shows);
		mapper.commit();
		mapper.close();
		
	}
	
	public void gradeup(Shows shows) {
		SqlSession mapper = factory.openSession();
		mapper.update("shows.gradeup",shows);
		mapper.commit();
		mapper.close();
		
	}
	
	public int getCount() {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("shows.getCount");  
		mapper.close();     
		return cnt;
	
	
	}
	
	public List<Shows> getRan(){
		List<Shows> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("shows.getRan");
		mapper.close();
		return list;
	}
	
	
	
	
	
	
	
	
}
