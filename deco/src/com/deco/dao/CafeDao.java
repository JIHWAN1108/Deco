package com.deco.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.deco.dto.Cafe;
import com.deco.mybatis.SqlSessionBean;

public class CafeDao {

	private static CafeDao dao = new CafeDao();
	private CafeDao() {}
	public static CafeDao getInstance() {
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
	public List<Cafe> getList(Map<String, Object> map) {
		List<Cafe> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("cafe.getList",map);
		mapper.close();
		return list;
	}
	public List<Cafe> getCafeBest() {
		List<Cafe> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("cafe.cafeBest");
		mapper.close();
		return list;
	}
	
	
	
	public Cafe getOne(int idx) {
		SqlSession mapper = factory.openSession();
		Cafe c = mapper.selectOne("cafe.getOne", idx);
		mapper.close();
		return c;
	}
	
	public List<Cafe> getLocation(Map<String,Object> map) {
		List<Cafe> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("cafe.getLocation", map);
		mapper.close();
		return list;
	}
	
	public void insert(Cafe cafe) {
		SqlSession mapper = factory.openSession();
		mapper.insert("cafe.insert", cafe);
		mapper.commit();
		mapper.close();
	}
	
	public void update(Cafe dto) {
		SqlSession mapper = factory.openSession();
		mapper.update("cafe.update",dto);
		mapper.commit();
		mapper.close();
		
	}
	
	public void gradeup(Cafe cafe) {
		SqlSession mapper = factory.openSession();
		mapper.update("cafe.gradeup",cafe);
		mapper.commit();
		mapper.close();
		
	}
	
	public int getCount() {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("cafe.getCount");  
		mapper.close();     
		return cnt;
	
	
	}
	
	public List<Cafe> getRan(){
		List<Cafe> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("cafe.getRan");
		mapper.close();
		return list;
	}
	
	
	
	
	
	
	
	
}
