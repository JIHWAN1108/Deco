package com.deco.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.UsersDao;
import com.deco.dto.SessionDto;
import com.deco.dto.Users;

public class UserInfoAction implements Action {
 //회원정보 불러오기 (쓰기는 불가능하고 읽기만 가능)
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();

		HttpSession session = request.getSession();
		SessionDto sdto = (SessionDto)session.getAttribute("user");
		if(sdto==null) {
			request.setAttribute("message", "세션이 만료되었습니다. 로그인 화면으로 이동합니다.");
			request.setAttribute("url", "home_login.deco");
			forward.isRedirect = false;
			forward.url="error/alert.jsp";
			return forward;
		}
		
		
		UsersDao dao = UsersDao.getInstance();
		int idx = sdto.getIdx();
		System.out.println(idx);
		Users user = dao.getUser(idx);
		System.out.println(user);
		
		request.setAttribute("dto", user);
		forward.isRedirect = false;
		forward.url="deco/userInfo.jsp";
		return forward;
		
	}
}