package com.deco.controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.UsersDao;
import com.deco.dto.SessionDto;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("userId");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();		// session 객체 생성
		
		Map<String,String> map = new HashMap<>();
		map.put("email", id);
		map.put("password", password);
		System.out.println(map);
		UsersDao dao = UsersDao.getInstance();
		SessionDto user = dao.login(map);
		System.out.println(user);
		if(user != null){
			//로그인 정보 일치
			session.setAttribute("user", user);
			request.setAttribute("message", "로그인 되었습니다.");
			request.setAttribute("url", "home.jsp");
//			pageContext.forward("error/alert.jsp");		//pagecontext.forward 페이지 이동, include 해당페이지 포함.
		} else{
			//로그인 정보 불일치
			request.setAttribute("message", "로그인 정보가 올바르지 않습니다.");
			request.setAttribute("url", "home_login.jsp");
//			pageContext.forward("error/alert.jsp");		//pagecontext.forward 페이지 이동, include 해당페이지 포함.
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setUrl("error/alert.jsp");
		return forward;
	}

}
