package com.deco.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.ReviewDao;
import com.deco.dao.ShowsDao;
import com.deco.dto.PageDto;
import com.deco.dto.SessionDto;
import com.deco.dto.Shows;

public class ShowsListAction implements Action {

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
		
		
		ShowsDao dao = ShowsDao.getInstance();
		
		 int pageNo;
			if(request.getParameter("page")==null) pageNo=1;
			else pageNo = Integer.parseInt(request.getParameter("page"));
			int pageSize =10;
		
			PageDto pageDto = new PageDto(pageNo,dao.getCount(),pageSize);
		
			Map<String,Integer> map = new HashMap<>();
			map.put("pageSize",pageSize);
			map.put("startNo",pageDto.getStartNo());
			request.setAttribute("pageDto", pageDto);
			
		
		List<Shows> list = dao.getList(map);
		
		ReviewDao rdao = ReviewDao.getInstance();


		List<Integer> reviewcnts = new ArrayList<>();
		for(int i=0;i<list.size();i++) {  
			int reviewCount=rdao.showsCount(list.get(i).getSidx());
			reviewcnts.add(reviewCount);
		}

		System.out.println(reviewcnts);
		request.setAttribute("reviewcnts",reviewcnts);
		request.setAttribute("pageDto", pageDto);
		
		
		
		request.setAttribute("ShowsList", list);
		
		forward.isRedirect = false;
		forward.url="deco/showsList.jsp";
		return forward;
	}

}
