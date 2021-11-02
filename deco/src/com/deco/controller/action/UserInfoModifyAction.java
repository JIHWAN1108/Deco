package com.deco.controller.action;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.UsersDao;
import com.deco.dto.SessionDto;
import com.deco.dto.Users;

public class UserInfoModifyAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		SessionDto sdto = (SessionDto)session.getAttribute("user");
		if(sdto==null) {
			request.setAttribute("message", "세션이 만료되었습니다. 로그인 화면으로 이동합니다.");
			request.setAttribute("url", "home_login.deco");
			forward.isRedirect = false;
			forward.url="error/alert.jsp";
			return forward;
		}
		
	      
	    UsersDao dao = UsersDao.getInstance();
	    	
    	int idx = Integer.parseInt(request.getParameter("idx"));
		int age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		
		Users dto = new Users();
		
		dto.setIdx(idx);
		dto.setAge(age);
		dto.setPhone(phone);
		dto.setAddr(addr);
	      	
	    dao.update(dto);		// 수정 메소드
	    
	    //알람뜨기
	    request.setAttribute("message", "회원정보 수정이 완료되었습니다.");
	    request.setAttribute("url", "userInfo.deco");
	    
		forward.isRedirect = false;
		forward.url="error/alert.jsp";
		return forward;
	}
}