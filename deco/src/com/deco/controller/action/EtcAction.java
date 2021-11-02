package com.deco.controller.action;

import java.io.IOException; 
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.EtcDao;
import com.deco.dao.ReviewDao;
import com.deco.dto.Etc;
import com.deco.dto.Review;
import com.deco.dto.SessionDto;

public class EtcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EtcDao dao= EtcDao.getInstance();
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
		
	
		int idx = Integer.parseInt(request.getParameter("eidx"));
		
		if(request.getParameter("page")==null) pageNo=1;
	      else pageNo = Integer.parseInt(request.getParameter("page"));
		
		Etc et =dao.getOne(idx);

		ReviewDao rdao = ReviewDao.getInstance();
		List<Review> etList = rdao.etcgetReview(idx);
		request.setAttribute("review", etList);
		int reviewCnt =  rdao.etcCount(idx);
		request.setAttribute("reviewCnt", reviewCnt);
		request.setAttribute("etc", et);    
		request.setAttribute("page", pageNo);
		
		forward.isRedirect = false;
		forward.url="deco/etc.jsp";
		return forward;
	}

}