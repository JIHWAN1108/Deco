package com.deco.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.deco.dao.ReviewDao;
import com.deco.dto.Review;

public class ReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ReviewDao dao = ReviewDao.getInstance();
		
		List<Review> list = dao.getList();
		request.setAttribute("ReviewList", list);
		
		forward.isRedirect = false;
		forward.url="deco/reviewList.jsp";
		return forward;
	}

}