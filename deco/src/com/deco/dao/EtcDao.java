package com.deco.dao;

import java.util.List;  
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.deco.dto.Etc;
import com.deco.mybatis.SqlSessionBean;

public class EtcDao {

	private static EtcDao dao = new EtcDao();
	private EtcDao() {}
	public static EtcDao getInstance() {
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
	public List<Etc> getList(Map<String, Object> map) {
		List<Etc> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("etc.getList",map);
		mapper.close();
		return list;
	}
	public List<Etc> getEtcBest() {
		List<Etc> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("etc.etcBest");
		mapper.close();
		return list;
	}
	
	
	public Etc getOne(int eidx) {
		SqlSession mapper = factory.openSession();
		Etc c = mapper.selectOne("etc.getOne",eidx);
		mapper.close();
		return c;
	}
	
	public List<Etc> getLocation(Map<String,Object> map) {
		List<Etc> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("etc.getLocation", map);
		mapper.close();
		return list;
	}
	
	public void insert(Etc etc) {
		SqlSession mapper = factory.openSession();
		mapper.insert("etc.insert", etc);
		mapper.commit();
		mapper.close();
	}
	
	public void update(Etc etc) {
		SqlSession mapper = factory.openSession();
		mapper.update("etc.update",etc);
		mapper.commit();
		mapper.close();
		
	}
	
	public void gradeup(Etc etc) {
		SqlSession mapper = factory.openSession();
		mapper.update("etc.gradeup",etc);
		mapper.commit();
		mapper.close();
		
	}
	
	public int getCount() {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("etc.getCount");  
		mapper.close();     
		return cnt;
	
	
	}
	
	public List<Etc> getRan(){
		List<Etc> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("etc.getRan");
		mapper.close();
		return list;
	}
	
	
	
	
	
	
	
	
}
