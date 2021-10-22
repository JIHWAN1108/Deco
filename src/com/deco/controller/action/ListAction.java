package com.deco.controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.dao.CafeDao;
import com.deco.dto.Cafe;
import com.deco.dto.PageDto;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		CafeDao dao = CafeDao.getInstance();
		 int pageNo;
			if(request.getParameter("page")==null) pageNo=1;
			else pageNo = Integer.parseInt(request.getParameter("page"));
			int pageSize =6;

			PageDto pageDto = new PageDto(pageNo,dao.getCount(),pageSize);

			Map<String,Integer> map = new HashMap<>();
			map.put("pageSize",pageSize);
			map.put("startNo",pageDto.getStartNo());
			request.setAttribute("pageDto", pageDto);


		List<Cafe> list = dao.getList(map);
		request.setAttribute("CafeList", list);
		System.out.println(list);
		System.out.println(list.size());
		forward.isRedirect = false;
		forward.url="deco/list.jsp";
		return forward;
	}

}
