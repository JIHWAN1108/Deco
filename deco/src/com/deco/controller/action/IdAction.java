package com.deco.controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.dao.UsersDao;
import com.deco.dto.Users;

public class IdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UsersDao dao = UsersDao.getInstance();
		Users dto = new Users();
		ActionForward forward = new ActionForward();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
	
	
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", name);
		map.put("phone", phone);
		
		
		dto = dao.emailCheck(map);
		System.out.println(dto);
		/*String password = request.getParameter("password");
		
		dto.setName(name);
		dto.setPassword(password);
		
		dto.setPhone(phone);*/
		if(dto==null) {
			request.setAttribute("message","등록된 회원이 아닙니다.");
			request.setAttribute("url", "password.deco");
			forward.isRedirect = false;
			forward.url="error/alert.jsp";
			return forward;
		}else {
			
			String email = dto.getEmail();
			System.out.println(email);
			request.setAttribute("message","회원님의 이메일은"+ email + "입니다.");
			request.setAttribute("url", "./");
			forward.isRedirect = false;
			forward.url="error/alert.jsp";
			return forward;
		}
		
	}
}