package com.deco.controller.action;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.dao.UsersDao;
import com.deco.dto.SessionDto;
import com.deco.dto.Users;

public class UserInfoUpdateAction implements Action {
 // 수정 
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
	   
	   
		UsersDao dao = UsersDao.getInstance();
	   
	      System.out.println(sdto.getIdx());
	      Users user = dao.getUser(sdto.getIdx());
	      
	      dao.update(user);
	      
	      request.setAttribute("dto", user);
	      forward.isRedirect = false;
	      forward.url="deco/userInfoUpdate.jsp";
	      return forward;   
	   }
	}