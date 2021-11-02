package com.deco.controller.action;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.FoodDao;
import com.deco.dto.Food;
import com.deco.dto.SessionDto;

public class FoodUpdateAction implements Action {

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
		 //  변경 시작위치
		int fidx = Integer.parseInt(request.getParameter("fidx"));
		int pageNo =  Integer.parseInt(request.getParameter("page"));
		FoodDao dao = FoodDao.getInstance();
		
		System.out.println(fidx);
		Food dto= dao.getOne(fidx);
		System.out.println(dto);
		request.setAttribute("food", dto);
		request.setAttribute("page", pageNo);
		
		
		forward.isRedirect = false;
		forward.url="deco/foodUpdate.jsp";
		return forward;
	}

}