package com.deco.controller.action;

import java.io.IOException; 
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.ReviewDao;
import com.deco.dao.ShowsDao;
import com.deco.dto.Review;
import com.deco.dto.SessionDto;
import com.deco.dto.Shows;

public class ShowsAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ShowsDao dao= ShowsDao.getInstance();
		int pageNo;
		
		HttpSession session = request.getSession();
	    ActionForward forward =new ActionForward();
	    SessionDto sdto = (SessionDto)session.getAttribute("user");
	    if(sdto==null) {
	       request.setAttribute("message", "세션이 만료되었습니다, 로그인화면으로 이동합니다.");
	       request.setAttribute("url", "home_login.deco");
	       forward.isRedirect = false;
	       forward.url="error/alert.jsp";
	       return forward;
	    }
		
	    String frontman="frontman";
	    
		int idx = Integer.parseInt(request.getParameter("sidx"));
		
		if(request.getParameter("page")==null) pageNo=1;
	      else pageNo = Integer.parseInt(request.getParameter("page"));
		
		Shows sh=dao.getOne(idx);

		ReviewDao rdao = ReviewDao.getInstance();
		List<Review> reList = rdao.showsgetReview(idx);
		request.setAttribute("review", reList);
		int reviewCnt =  rdao.showsCount(idx);
		
		request.setAttribute("frontman", frontman);
		request.setAttribute("reviewCnt", reviewCnt);
		request.setAttribute("shows", sh);    
		request.setAttribute("page", pageNo);
		
		forward.isRedirect = false;
		forward.url="deco/shows.jsp";
		return forward;
	}

}