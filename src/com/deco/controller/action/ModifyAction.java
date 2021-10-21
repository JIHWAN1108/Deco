package com.deco.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.dao.CafeDao;
import com.deco.dto.Cafe;

public class ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int idx=Integer.parseInt(request.getParameter("idx"));
		String location= request.getParameter("location");
		String name= request.getParameter("name");
		double grade= Double.parseDouble(request.getParameter("grade"));
		String content= request.getParameter("content");
		String menu= request.getParameter("menu");
		String opentime= request.getParameter("opentime");
		String closetime= request.getParameter("closetime");
		String addr= request.getParameter("addr");
		String phone= request.getParameter("phone");
		
		Cafe dto = new Cafe();
		dto.setIdx(idx);
		dto.setLocation(location);
		dto.setName(name);
		dto.setGrade(grade);
		dto.setContent(content);
		dto.setMenu(menu);
		dto.setOpentime(opentime);
		dto.setClosetime(closetime);
		dto.setAddr(addr);
		dto.setPhone(phone);
		
		CafeDao dao = CafeDao.getInstance();
		dao.update(dto);
		
		ActionForward foward =new ActionForward();
		foward.isRedirect = false;
		foward.url="cafe.deco";
		return foward;
		
	}

}
