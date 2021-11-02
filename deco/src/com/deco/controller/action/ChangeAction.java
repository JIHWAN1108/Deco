package com.deco.controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.UsersDao;
import com.deco.dto.SessionDto;
import com.deco.dto.Users;

public class ChangeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//HttpSession session = request.getSession();
		Map<String, String> map = new HashMap<String, String>();
	      UsersDao dao = UsersDao.getInstance();
	      
	      Users user = new Users();
	      
	      Users dto = new Users();
	      
	      
	      
	      //dto = dao.getUser2(user);
	     

	      dto = dao.getUser2(user);
	      System.out.println(dto);
	      request.setAttribute("dto", user);
	      ActionForward forward = new ActionForward();
	      forward.isRedirect = false;
	      forward.url="deco/home_login.deco";
	      return forward;   
	   }
	}
