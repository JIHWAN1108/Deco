package com.deco.controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.ReviewDao;
import com.deco.dto.PageDto;
import com.deco.dto.Review;
import com.deco.dto.SessionDto;

public class ReviewListAction implements Action {

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
		
		ReviewDao dao = ReviewDao.getInstance();
		
		Map<String,Integer> map = new HashMap<>();
		
		int pageNo;
		if(request.getParameter("page")==null) pageNo=1;
		else pageNo = Integer.parseInt(request.getParameter("page"));
		int pageSize =8;
		
		PageDto pageDto = new PageDto(pageNo,dao.getCount(sdto.getNickname()),pageSize);
		
		map.put("pageSize",pageSize);
		map.put("startNo",pageDto.getStartNo());
		List<Review> list = dao.getList10(map);
		System.out.println(list);
		
		request.setAttribute("ReviewList", list);
		request.setAttribute("pageDto", pageDto);
		
		forward.isRedirect = false;
		forward.url="deco/reviewList.jsp";
		return forward;
	}

}