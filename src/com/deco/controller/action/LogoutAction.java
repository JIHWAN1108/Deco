package com.deco.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
//		PrintWriter out = response.getWriter();			// out 객체 생성 !!!
		
		request.setAttribute("message", "로그아웃 되었습니다.");
	    request.setAttribute("url", "./");

		session.invalidate();		//세션 무효화(끊기)
		//response.sendRedirect("home.jsp");
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setUrl("error/alert.jsp");
		return forward;
	}


}
