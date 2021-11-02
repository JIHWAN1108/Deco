package com.deco.controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.dao.UsersDao;
import com.deco.dto.Users;

public class PassWordAction2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UsersDao dao = UsersDao.getInstance();
		Users dto = new Users();
		ActionForward forward = new ActionForward();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
	
	
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", name);
		map.put("phone", phone);
		map.put("email",email);
		
		dto = dao.passwordCheck(map);
		System.out.println(dto);
		/*String password = request.getParameter("password");
		
		dto.setName(name);
		dto.setPassword(password);
		
		dto.setPhone(phone);*/
		if(dto==null) {
			request.setAttribute("message","정보가 일치하지 않습니다.");
			request.setAttribute("url", "password2.deco");
			forward.isRedirect = false;
			forward.url="error/alert.jsp";
			return forward;
		}else {
//			request.setAttribute("name" , name);
//			request.setAttribute("phone" , phone);
//			request.setAttribute("email" , email);
			request.setAttribute("message","정보가 일치합니다. 비밀번호를 변경해주세요.");
			request.setAttribute("url", "change.deco?name="+name+"&phone="+phone+"&email="+email);
			forward.isRedirect = false;
			forward.url="error/alert.jsp";
			return forward;
		}
		
	}
}