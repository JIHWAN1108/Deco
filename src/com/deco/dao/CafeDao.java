package com.deco.dao;

import java.util.List;

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
	
	public List<Cafe> getList() {
		List<Cafe> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("cafe.getList");
		mapper.close();
		return list;
	}
	
	public Cafe getOne(int idx) {
		SqlSession mapper = factory.openSession();
		Cafe c = mapper.selectOne("cafe.getOne", idx);
		mapper.close();
		return c;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
