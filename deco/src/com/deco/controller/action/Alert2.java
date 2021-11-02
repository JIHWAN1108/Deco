package com.deco.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Alert2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward =new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		String name = (String) request.getAttribute("name");
		String phone = (String) request.getAttribute("phone");
		String email = (String) request.getAttribute("email");
		
		String message = (String) request.getAttribute("message");
		String url = (String) request.getAttribute("url");
		
		
		request.setAttribute("name",name);
		request.setAttribute("phone",phone);
		request.setAttribute("email",email);
		request.setAttribute("message",message);
		request.setAttribute("url",url);
		forward.isRedirect=false;
		forward.url="error/alert.jsp";
		
		return forward;
	}

}