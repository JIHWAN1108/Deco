package com.deco.controller.action;

import java.io.IOException; 
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.FoodDao;
import com.deco.dao.ReviewDao;
import com.deco.dto.Food;
import com.deco.dto.Review;
import com.deco.dto.SessionDto;

public class FoodAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodDao dao= FoodDao.getInstance();
		int pageNo;                                //변경 안함
		
		HttpSession session = request.getSession();      //변경 안함
	    ActionForward forward =new ActionForward();      //변경 안함
	    SessionDto sdto = (SessionDto)session.getAttribute("user");      //변경 안함
	    if(sdto==null) {                              //변경 안함
	       request.setAttribute("message", "세션이 만료되었습니다, 로그인화면으로 이동합니다.");
	       request.setAttribute("url", "home_login.deco");
	       forward.isRedirect = false;
	       forward.url="error/alert.jsp";
	       return forward;
	    }            //변경 안함
		
	
		int idx = Integer.parseInt(request.getParameter("fidx"));       //변경 안함
		 System.out.println(idx);
		if(request.getParameter("page")==null) pageNo=1;              //변경 안함
	      else pageNo = Integer.parseInt(request.getParameter("page"));     //변경 안함
		
		Food fo=dao.getOne(idx);

		ReviewDao rdao = ReviewDao.getInstance();      //변경 안함
		List<Review> reList = rdao.foodgetReview(idx);		//변경 안함
		request.setAttribute("review", reList);			//변경 안함
		int reviewCnt =  rdao.foodCount(idx);
		request.setAttribute("reviewCnt", reviewCnt);
		request.setAttribute("food", fo);    
		request.setAttribute("page", pageNo);
		
		forward.isRedirect = false;
		forward.url="deco/food.jsp";
		return forward;
	}

}