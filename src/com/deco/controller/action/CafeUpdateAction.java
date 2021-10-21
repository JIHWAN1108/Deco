package com.deco.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.dao.CafeDao;
import com.deco.dto.Cafe;

public class CafeUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		CafeDao dao = CafeDao.getInstance();
		Cafe dto= dao.getOne(idx);
		
		request.setAttribute("cafe", dto);
		
		
		ActionForward foward =new ActionForward();
		foward.isRedirect = false;
		foward.url="deco/cafeUpdate.jsp";
		return foward;
	}

}
