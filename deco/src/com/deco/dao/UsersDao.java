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
		Users users = mapper.selectOne("getUser", idx);
		mapper.close();
		return users;
	}
	
	
	public Users getUser2(Users user) {
		SqlSession mapper = factory.openSession();
		mapper.update("users.passwordCheck", user);
		mapper.close();
		return user;
	}
	
	
	
	
	public void insert(Users users) {
		SqlSession mapper = factory.openSession();
		mapper.insert("users.insert", users);
		mapper.commit();
		mapper.close();
	}
	public void dibsinsert(String nickname ) {
		SqlSession mapper = factory.openSession();
		mapper.insert("users.dibsinsert", nickname);
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
	
	public void delete(int idx) {
		SqlSession mapper = factory.openSession();
		mapper.delete("users.delete", idx);
		mapper.commit();
		mapper.close();
	}
	public void dibsDelete2(String nickname) {
		SqlSession mapper = factory.openSession();
		mapper.delete("users.dibsDelete2", nickname);
		mapper.commit();
		mapper.close();
	}
	public void reviesDelete(String nickname) {
		SqlSession mapper = factory.openSession();
		mapper.delete("users.reivewDelete", nickname);
		mapper.commit();
		mapper.close();
	}
	public Users emailCheck(Map<String, String> map) {
		SqlSession mapper = factory.openSession();
		Users users = new Users();
		users = mapper.selectOne("users.emailCheck", map);
		mapper.close();
		return users;
	}
	public Users passwordCheck(Map<String, String> map) {
		SqlSession mapper = factory.openSession();
		Users users = new Users();
		users = mapper.selectOne("users.passwordCheck", map);
		mapper.close();
		return users;
	}
	
	public Users changeCheck(Map<String, String> map) {
		SqlSession mapper = factory.openSession();
		Users user = new Users();
		user = mapper.selectOne("users.passwordupdate",user);
		mapper.close();
		return user;
	}
	
}
