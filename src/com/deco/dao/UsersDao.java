package com.deco.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.deco.dto.SessionDto;
import com.deco.dto.Users;
import com.deco.mybatis.SqlSessionBean;

public class UsersDao {

	private static UsersDao dao = new UsersDao();
	private UsersDao() {}
	public static UsersDao getInstance() {
		return dao;
	}
	
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	
	
	public Users getUser(int idx) {
		SqlSession mapper = factory.openSession();
		Users users = mapper.selectOne("getUser");
		mapper.close();
		return users;
	}
	
	public void insert(Users users) {
		SqlSession mapper = factory.openSession();
		mapper.insert("users.insert", users);
		mapper.commit();
		mapper.close();
	}
	
	public void update(Users users) {
		SqlSession mapper = factory.openSession();
		mapper.update("users.update", users);
		mapper.commit();
		mapper.close();
	}
	
	// SesstionDto 이용해서 로그인 정보 가져오기
	public SessionDto login(Map<String, String> map) {
		SessionDto dto = null;
		SqlSession mapper = factory.openSession();
		dto = mapper.selectOne("loginCheck", map);
		mapper.close();
		return dto;
	}
	
	
	
	
}
