package com.deco.controller.action;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.ShowsDao;
import com.deco.dto.SessionDto;
import com.deco.dto.Shows;

public class ShowsUpdateAction implements Action {

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
		
		request.setCharacterEncoding("UTF-8");	
		
		int idx = Integer.parseInt(request.getParameter("sidx"));
		int pageNo =  Integer.parseInt(request.getParameter("page"));
		ShowsDao dao = ShowsDao.getInstance();
		
		System.out.println(idx);
		Shows dto= dao.getOne(idx);
		System.out.println(dto);
		request.setAttribute("shows", dto);
		request.setAttribute("page", pageNo);
		
		
		forward.isRedirect = false;
		forward.url="deco/showsUpdate.jsp";
		return forward;
	}

}