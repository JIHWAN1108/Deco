package com.deco.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.controller.action.Action;
import com.deco.controller.action.ActionForward;
import com.deco.controller.action.CafeAction;
import com.deco.controller.action.CafeInsertAction;
import com.deco.controller.action.CafeUpdateAction;
import com.deco.controller.action.DibsListAction;
import com.deco.controller.action.ListAction;
import com.deco.controller.action.LoginAction;
import com.deco.controller.action.LogoutAction;
import com.deco.controller.action.MemberAction;
import com.deco.controller.action.ModifyAction;
import com.deco.controller.action.ReviewListAction;

@WebServlet("*.deco")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward = null;
//		ActionForward forward = new ActionForward();
		
		String spath = request.getServletPath();
		System.out.println(spath);
//		forward.setRedirect(false);
//		forward.setUrl("./");
		String url="./";
		
		if(spath.equals("/list.deco")) {
			Action action = new ListAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/loginAction.deco")) {
			Action action = new LoginAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/logout.deco")) {
			Action action = new LogoutAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/cafe.deco")) {
			Action action = new CafeAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/member.deco")) {
			forward = new ActionForward(false, "deco/memberView.jsp");
		}else if(spath.equals("/memberAction.deco")) {
			Action action = new MemberAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/dibsList.deco")) {
			Action action = new DibsListAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/cafeUpdate.deco")) {
			Action action = new CafeUpdateAction();
			forward = action.execute(request, response);
		}else if(spath.contentEquals("/edit.deco")){
			Action action = new ModifyAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/cafeInsert.deco")) {
			forward = new ActionForward(false,"deco/cafeInsert.jsp");
		}else if(spath.equals("/cafeInsertAction.deco")) {
			Action action = new CafeInsertAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/reviewList.deco")) {
			Action action = new ReviewListAction();
			forward = action.execute(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
		// 이 시점에서 forward 에 isREdirct 와 url 값이 저장되어있으면 OK!
				if(!forward.isRedirect()) {
					RequestDispatcher rd = request.getRequestDispatcher(forward.getUrl());
					rd.forward(request, response);
				}else {
					response.sendRedirect(forward.getUrl());
				} 
		
		}
}
