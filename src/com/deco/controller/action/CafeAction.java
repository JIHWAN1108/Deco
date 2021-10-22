package com.deco.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.dao.CafeDao;
import com.deco.dao.ReviewDao;
import com.deco.dto.Cafe;
import com.deco.dto.Review;

public class CafeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CafeDao dao= CafeDao.getInstance();
		int pageNo;
		int idx = Integer.parseInt(request.getParameter("idx"));
		if(request.getParameter("page")==null) pageNo=1;
		else pageNo = Integer.parseInt(request.getParameter("page"));


		Cafe ca=dao.getOne(idx);

		ReviewDao rdao = ReviewDao.getInstance();
		List<Review> reList = rdao.getReview(idx);
		request.setAttribute("review", reList);

		request.setAttribute("cafe", ca); 
		request.setAttribute("page", pageNo);

		ActionForward foward =new ActionForward();
		foward.isRedirect = false;
		foward.url="deco/cafe.jsp";
		return foward;
	}

}