package com.deco.controller.action;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.DibsDao;
import com.deco.dao.UsersDao;
import com.deco.dto.SessionDto;

public class UserInfoDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 세션 만료시 home_hogin.deco로 이동
		HttpSession session = request.getSession();
		SessionDto sdto = (SessionDto)session.getAttribute("user");
		ActionForward forward = new ActionForward();
		if(sdto==null) {
			request.setAttribute("message", "세션이 만료되었습니다. 로그인 화면으로 이동합니다.");
			request.setAttribute("url", "home_login.deco");
			forward.isRedirect = false;
			forward.url="error/alert.jsp";
			return forward;
		}
		
		request.setCharacterEncoding("UTF-8");
		
	      UsersDao dao = UsersDao.getInstance();
	      DibsDao ddao = DibsDao.getInstance();
	      ddao.delete(sdto.getNickname());
	      	int idx = sdto.getIdx();
	      	ddao.delete(sdto.getNickname());
	      	dao.reviesDelete(sdto.getNickname());
	  		dao.delete(idx);
 		
	      System.out.println(idx);
	      
	      request.setAttribute("message", "회원탈퇴 되셨습니다 홈으로 이동합니다.");
	      request.setAttribute("url","./" );
		forward.isRedirect = false;
		forward.url="error/alert.jsp";
		return forward;
	}
}