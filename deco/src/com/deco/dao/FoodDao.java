package com.deco.dao;

import java.util.List;  
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.deco.dto.Food;
import com.deco.mybatis.SqlSessionBean;

public class FoodDao {

	private static FoodDao dao = new FoodDao();
	private FoodDao() {}
	public static FoodDao getInstance() {
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
	public List<Food> getList(Map<String, Object> map) {
		List<Food> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("food.getList",map);
		mapper.close();
		return list;
	}
	
	public List<Food> getFoodBest() {
		List<Food> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("food.foodBest");
		mapper.close();
		return list;
	}
	
	
	public Food getOne(int fidx) {
		SqlSession mapper = factory.openSession();
		Food c = mapper.selectOne("food.getOne",fidx);
		mapper.close();
		return c;
	}
	
	public List<Food> getLocation(Map<String,Object> map) {
		List<Food> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("food.getLocation", map);
		mapper.close();
		return list;
	}
	
	public void insert(Food food) {
		SqlSession mapper = factory.openSession();
		mapper.insert("food.insert", food);
		mapper.commit();
		mapper.close();
	}
	
	public void update(Food dto) {
		SqlSession mapper = factory.openSession();
		mapper.update("food.update",dto);
		mapper.commit();
		mapper.close();
		
	}
	
	public void gradeup(Food food) {
		SqlSession mapper = factory.openSession();
		mapper.update("food.gradeup",food);
		mapper.commit();
		mapper.close();
		
	}
	
	public int getCount() {
		SqlSession mapper = factory.openSession();
		int cnt = mapper.selectOne("food.getCount");  
		mapper.close();     
		return cnt;
	
	
	}
	
	public List<Food> getRan(){
		List<Food> list = null;
		SqlSession mapper = factory.openSession();
		list = mapper.selectList("food.getRan");
		mapper.close();
		return list;
	}
	
	
	
	
	
	
	
	
}
