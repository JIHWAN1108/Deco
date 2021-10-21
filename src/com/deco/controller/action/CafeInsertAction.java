package com.deco.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.dao.CafeDao;
import com.deco.dto.Cafe;

public class CafeInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String location = request.getParameter("location");
		String menu = request.getParameter("menu");
		int grade= Integer.parseInt(request.getParameter("grade"));
		String phone = request.getParameter("phone");
		String opentime = request.getParameter("opentime");
		String closetime = request.getParameter("closetime");
		String content = request.getParameter("content");
		
		Cafe dto= new Cafe();
		dto.setName(name);
		dto.setAddr(addr);
		dto.setLocation(location);
		dto.setMenu(menu);
		dto.setGrade(grade);
		dto.setPhone(phone);
		dto.setOpentime(opentime);
		dto.setClosetime(closetime);
		dto.setContent(content);
		
		System.out.println(dto);
		CafeDao dao= CafeDao.getInstance();
		dao.insert(dto);
		
		
		ActionForward foward =new ActionForward();
		foward.isRedirect = false;
		foward.url="list.deco";
		return foward;
	}

}
