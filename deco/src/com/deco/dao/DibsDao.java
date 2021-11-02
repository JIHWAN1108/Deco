package com.deco.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.deco.dto.Cafe;
import com.deco.dto.Dibs;
import com.deco.dto.Etc;
import com.deco.dto.Food;
import com.deco.dto.Shows;
import com.deco.mybatis.SqlSessionBean;

public class DibsDao {
	private static DibsDao dao = new DibsDao();
	private DibsDao() {}
	public static DibsDao getInstance() {
		return dao;
	}
	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	
	public Dibs getDibs(String nickname) {
		SqlSession mapper = factory.openSession();
		Dibs dibs = mapper.selectOne("getDibs", nickname);
		mapper.close();
		return dibs;
	}
	
	// idx 토크나이저로 쪼갠다음 하나씩 해당 idx의 cafe정보 가져오는 메소드
	public Cafe getCafeDibs(String idx) {
		int idxCafe = Integer.parseInt(idx);
		SqlSession mapper = factory.openSession();
		Cafe cafe = mapper.selectOne("getCafeDibs", idxCafe);
		mapper.close();
		return cafe;
	}
	public Food getFoodDibs(String fidx) {
		int fidxFood = Integer.parseInt(fidx);
		SqlSession mapper = factory.openSession();
		Food food = mapper.selectOne("getFoodDibs", fidxFood);
		mapper.close();
		return food;
	}
	public Shows getShowsDibs(String sidx) {
		int sidxShows = Integer.parseInt(sidx);
		SqlSession mapper = factory.openSession();
		Shows shows = mapper.selectOne("getShowsDibs", sidxShows);
		mapper.close();
		return shows;
	}
	public Etc getEtcDibs(String eidx) {
		int eidxEtc = Integer.parseInt(eidx);
		SqlSession mapper = factory.openSession();
		Etc etc = mapper.selectOne("getEtcDibs", eidxEtc);
		mapper.close();
		return etc;
	}
	
	public void updateCafeDibs(Map<String,String> map) {
		SqlSession mapper = factory.openSession();
		mapper.update("updateCafeDibs", map);
		mapper.commit();
		mapper.close();
	}
	public void updateFoodDibs(Map<String,String> map) {
		SqlSession mapper = factory.openSession();
		mapper.update("updateFoodDibs", map);
		mapper.commit();
		mapper.close();
	}
	public void updateShowsDibs(Map<String,String> map) {
		SqlSession mapper = factory.openSession();
		mapper.update("updateShowsDibs", map);
		mapper.commit();
		mapper.close();
	}
	public void updateEtcDibs(Map<String,String> map) {
		SqlSession mapper = factory.openSession();
		mapper.update("updateEtcDibs", map);
		mapper.commit();
		mapper.close();
	}
	public void delete(String nickname) {
		SqlSession mapper = factory.openSession();
		mapper.delete("dibsDelete", nickname);
		mapper.commit();
		mapper.close();
	}
	
	
	
}
