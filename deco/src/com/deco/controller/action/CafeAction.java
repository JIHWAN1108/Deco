package com.deco.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.CafeDao;
import com.deco.dao.ReviewDao;
import com.deco.dto.Cafe;
import com.deco.dto.Review;
import com.deco.dto.SessionDto;

public class CafeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CafeDao dao= CafeDao.getInstance();
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
		
	    //메뉴 리스트 만들기
	    
	    
	    
	    
	    
	    
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		if(request.getParameter("page")==null) pageNo=1;
	      else pageNo = Integer.parseInt(request.getParameter("page"));
		
		Cafe ca=dao.getOne(idx);
		
		
		
		
		
		// 메뉴 list 만들기
	      String menu = ca.getMenu();
	      List<String> menuList = new ArrayList<String>();
	      StringTokenizer menuToken = new StringTokenizer(menu,"/");
	      while(menuToken.hasMoreTokens()) {
	         String s = menuToken.nextToken();
	         menuList.add(s);
	      }

		ReviewDao rdao = ReviewDao.getInstance();
		List<Review> reList = rdao.getReview(idx);
		request.setAttribute("menuList", menuList);
		request.setAttribute("review", reList);
		request.setAttribute("cafe", ca);    
		request.setAttribute("page", pageNo);
		int reviewCnt =  rdao.cafeCount(idx);
		request.setAttribute("reviewCnt", reviewCnt);
		
		
		forward.isRedirect = false;
		forward.url="deco/cafe.jsp";
		return forward;
	}

}